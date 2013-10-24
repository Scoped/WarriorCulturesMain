package WarriorCulturesMain.Scoped.com.github.core.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WeaponForgeRecipeManager
{
	private static final WeaponForgeRecipeManager smeltingBase = new WeaponForgeRecipeManager();
	private List recipes = new ArrayList();
	
    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private HashMap<List<Integer>, ItemStack> metaSmeltingList = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, Float> metaExperience = new HashMap<List<Integer>, Float>();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final WeaponForgeRecipeManager smelting()
    {
        return smeltingBase;
    }

    private WeaponForgeRecipeManager()
    {
		recipes = new ArrayList();
    	
    	//this.addSmelting(Block.oreIron.blockID, new ItemStack(Item.ingotIron), 0.7F);
    }
    
    /**
     * Adds a smelting recipe.
     */
    public void addSmelting(int slot1, int slot2, int slot3, int slot4, int slot5, int slot6, int slot7, int slot8, int slot9, int slot10, int slot11, int slot12, int slot13, int slot14, int slot15, int slot16, int slot17, int slot18, int slot19, int slot20, int slot21, int slot22, int slot23, int slot24, int slot25, int slot26, int slot27, int slot28, int slot29, int slot30, int slot31, int slot32, int slot33, int slot34, int slot35, int slot36, ItemStack par2ItemStack, float par3)
    {
        
    	
    	/*this.smeltingList.put(Integer.valueOf(slot1), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot2), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot3), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot4), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot5), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot6), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot7), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot8), par2ItemStack);
        this.smeltingList.put(Integer.valueOf( slot9), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot10), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot11), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot12), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot13), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot14), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot15), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot16), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot17), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot18), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot19), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot20), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot21), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot22), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot23), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot24), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot25), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot26), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot27), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot28), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot29), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot30), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot31), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot32), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot33), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot34), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot35), par2ItemStack);
        this.smeltingList.put(Integer.valueOf(slot36), par2ItemStack);*/
        
        this.experienceList.put(Integer.valueOf(par2ItemStack.itemID), Float.valueOf(par3));
    }

    /**
     * Returns the smelting result of an item.
     * Deprecated in favor of a metadata sensitive version
     */
    @Deprecated
    public ItemStack getSmeltingResult(int slot1, int slot2, int slot3, int slot4, int slot5, int slot6, int slot7, int slot8, int slot9, int slot10, int slot11, int slot12, int slot13, int slot14, int slot15, int slot16, int slot17, int slot18, int slot19, int slot20, int slot21, int slot22, int slot23, int slot24, int slot25, int slot26, int slot27, int slot28, int slot29, int slot30, int slot31, int slot32, int slot33, int slot34, int slot35, int slot36)
    {
    	return (ItemStack)this.smeltingList.get(Integer.valueOf(slot1));
    }

    public Map getSmeltingList()
    {
        return this.smeltingList;
    }

    @Deprecated //In favor of ItemStack sensitive version
    public float getExperience(int par1)
    {
        return this.experienceList.containsKey(Integer.valueOf(par1)) ? ((Float)this.experienceList.get(Integer.valueOf(par1))).floatValue() : 0.0F;
    }

    /**
     * A metadata sensitive version of adding a furnace recipe.
     */
    public void addSmelting(int itemID, int metadata, ItemStack itemstack, float experience)
    {
        metaSmeltingList.put(Arrays.asList(itemID, metadata), itemstack);
        metaExperience.put(Arrays.asList(itemstack.itemID, itemstack.getItemDamage()), experience);
    }

    /**
     * Used to get the resulting ItemStack form a source ItemStack
     * @param item The Source ItemStack
     * @return The result ItemStack
     */
    public ItemStack getSmeltingResult(ItemStack item) 
    {
        if (item == null)
        {
            return null;
        }
        
        ItemStack ret = (ItemStack)metaSmeltingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
        
        if (ret != null) 
        {
            return ret;
        }
        return (ItemStack)smeltingList.get(Integer.valueOf(item.itemID));
    }

    /**
     * Grabs the amount of base experience for this item to give when pulled from the furnace slot.
     */
    public float getExperience(ItemStack item)
    {
        if (item == null || item.getItem() == null)
        {
            return 0;
        }
        float ret = item.getItem().getSmeltingExperience(item);
        if (ret < 0 && metaExperience.containsKey(Arrays.asList(item.itemID, item.getItemDamage())))
        {
            ret = metaExperience.get(Arrays.asList(item.itemID, item.getItemDamage()));
        }
        if (ret < 0 && experienceList.containsKey(item.itemID))
        {
            ret = ((Float)experienceList.get(item.itemID)).floatValue();
        }
        return (ret < 0 ? 0 : ret);
    }

    public Map<List<Integer>, ItemStack> getMetaSmeltingList()
    {
        return metaSmeltingList;
    }
}
