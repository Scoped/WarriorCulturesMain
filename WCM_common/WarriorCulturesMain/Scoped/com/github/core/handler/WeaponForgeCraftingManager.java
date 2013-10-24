package WarriorCulturesMain.Scoped.com.github.core.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import cpw.mods.fml.common.ICraftingHandler;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import WarriorCulturesMain.Scoped.com.github.core.handler.crafting.WeaponForgeRecipeSorter;
import WarriorCulturesMain.Scoped.com.github.core.handler.crafting.WeaponForgeShapedRecipes;
import WarriorCulturesMain.Scoped.com.github.core.handler.crafting.WeaponForgeShapelessRecipes;
import WarriorCulturesMain.Scoped.com.github.item.ModItems;
import WarriorCulturesMain.Scoped.com.github.lib.BlockIDs;
import WarriorCulturesMain.Scoped.com.github.tileEntity.TileEntity_WeaponForge;

public class WeaponForgeCraftingManager implements ICraftingHandler
{
	public static final int WILDCARD_VALUE = Short.MAX_VALUE;
	private static final WeaponForgeCraftingManager instance = new WeaponForgeCraftingManager();
	private List recipes = new ArrayList();
	
	public static final WeaponForgeCraftingManager getInstance()
	{
		return instance;
	}
	
	public WeaponForgeCraftingManager()
	{
		recipes = new ArrayList();
		
		//Hatchet Head
		this.addRecipe(new ItemStack(ModItems.WCCTool_Heads, 0), new Object[] {
			"      ",
			"  II  ",
			" III  ",
			" IIII ",
			"   II ",
			"      ",
			Character.valueOf('I'), new ItemStack(ModItems.IngotValuables, 1, 3)});
		
		//Pickaxe Head
		this.addRecipe(new ItemStack(ModItems.WCCTool_Heads, 1, 1), new Object[] {
			"      ",
			" II   ",
			"   I  ",
			"  I II",
			"    I ",
			"      ",
			Character.valueOf('I'), new ItemStack(ModItems.IngotValuables, 1, 3)});
		
		//Scythe Head
		this.addRecipe(new ItemStack(ModItems.WCCTool_Heads, 1, 2), new Object[] {
			"      ",
			" II   ",
			"   I  ",
			"    I ",
			"   I  ",
			"  I   ",
			Character.valueOf('I'), new ItemStack(ModItems.IngotValuables, 1, 3)});
		
		//Shovel Head
		this.addRecipe(new ItemStack(ModItems.WCCTool_Heads, 1, 3), new Object[] {
			"      ",
			"      ",
			" II   ",
			"IIII  ",
			" III  ",
			"I I   ",
			Character.valueOf('I'), new ItemStack(ModItems.IngotValuables, 1, 3)});
		
		Collections.sort(this.recipes, new WeaponForgeRecipeSorter(this));
		System.out.println(this.recipes.size() + " recipes");
	}
	
    public WeaponForgeShapedRecipes addRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (par2ArrayOfObj[i] instanceof String[])
        {
            String[] astring = (String[])((String[])par2ArrayOfObj[i++]);

            for (int l = 0; l < astring.length; ++l)
            {
                String s1 = astring[l];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        else
        {
            while (par2ArrayOfObj[i] instanceof String)
            {
                String s2 = (String)par2ArrayOfObj[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap hashmap;

        for (hashmap = new HashMap(); i < par2ArrayOfObj.length; i += 2)
        {
            Character character = (Character)par2ArrayOfObj[i];
            ItemStack itemstack1 = null;

            if (par2ArrayOfObj[i + 1] instanceof Item)
            {
                itemstack1 = new ItemStack((Item)par2ArrayOfObj[i + 1]);
            }
            else if (par2ArrayOfObj[i + 1] instanceof Block)
            {
                itemstack1 = new ItemStack((Block)par2ArrayOfObj[i + 1], 1, 32767);
            }
            else if (par2ArrayOfObj[i + 1] instanceof ItemStack)
            {
                itemstack1 = (ItemStack)par2ArrayOfObj[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack[] itemStack2 = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1)
        {
            char c0 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c0)))
            {
            	itemStack2[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
            }
            else
            {
            	itemStack2[i1] = null;
            }
        }

        WeaponForgeShapedRecipes weaponForgeShapedRecipes = new WeaponForgeShapedRecipes(j, k, itemStack2, par1ItemStack);
        this.recipes.add(weaponForgeShapedRecipes);
        return weaponForgeShapedRecipes;
    }

    public void addShapelessRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
    {
        ArrayList arraylist = new ArrayList();
        Object[] aobject = par2ArrayOfObj;
        int i = par2ArrayOfObj.length;

        for (int j = 0; j < i; ++j)
        {
            Object object1 = aobject[j];

            if (object1 instanceof ItemStack)
            {
                arraylist.add(((ItemStack)object1).copy());
            }
            else if (object1 instanceof Item)
            {
                arraylist.add(new ItemStack((Item)object1));
            }
            else
            {
                if (!(object1 instanceof Block))
                {
                    throw new RuntimeException("[ERROR] [WeaponForgeCraftingManager] Invalid shapeless recipy!");
                }

                arraylist.add(new ItemStack((Block)object1));
            }
        }

        this.recipes.add(new WeaponForgeShapelessRecipes(par1ItemStack, arraylist));
    }
    
    public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World)
    {
        int i = 0;
        ItemStack itemstack = null;
        ItemStack itemstack1 = null;
        int j;

        for (j = 0; j < par1InventoryCrafting.getSizeInventory(); ++j)
        {
            ItemStack itemstack2 = par1InventoryCrafting.getStackInSlot(j);

            if (itemstack2 != null)
            {
                if (i == 0)
                {
                    itemstack = itemstack2;
                }

                if (i == 1)
                {
                    itemstack1 = itemstack2;
                }

                ++i;
            }
        }

        if (i == 2 && itemstack.itemID == itemstack1.itemID && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && Item.itemsList[itemstack.itemID].isRepairable())
        {
            Item item = Item.itemsList[itemstack.itemID];
            int k = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
            int l = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
            int i1 = k + l + item.getMaxDamage() * 5 / 100;
            int j1 = item.getMaxDamage() - i1;

            if (j1 < 0)
            {
                j1 = 0;
            }

            return new ItemStack(itemstack.itemID, 1, j1);
        }
        else
        {
            for (j = 0; j < this.recipes.size(); ++j)
            {
                IRecipe irecipe = (IRecipe)this.recipes.get(j);

                if (irecipe.matches(par1InventoryCrafting, par2World))
                {
                    return irecipe.getCraftingResult(par1InventoryCrafting);
                }
            }

            return null;
        }
    }
	
	public List getRecipeList()
	{
		return this.recipes;
	}
	
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix)
	{
		
	}
	
	public void onSmelting(EntityPlayer player, ItemStack item)
	{
		
	}
}
