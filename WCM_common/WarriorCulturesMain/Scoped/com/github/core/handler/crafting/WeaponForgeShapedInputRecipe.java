package WarriorCulturesMain.Scoped.com.github.core.handler.crafting;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class WeaponForgeShapedInputRecipe implements IRecipe
{
	/**
	 * How many horizontal slots this recipe has.
	 */
	public final int recipeWidth;
	
	/**
	 * How many vertical slots this recipe uses.
	 */
	public final int recipeHeight;
	
	/**
	 * Is an array of ItemStack that composes the recipe.
	 */
	public final ItemStack[] recipeItems;
	
	/**
	 * Is the ItemStack that you get when crafting a recipe.
	 */
	private ItemStack recipeOutput;
	
	/**
	 * Is the itemID of the output item that you get when crafting a recipe.
	 */
	public final int recipeOutputItemID;
	private boolean field_92101_f = false;
	
	public WeaponForgeShapedInputRecipe(int i, int j, ItemStack[] arrayOfItemStack, ItemStack itemStack)
	{
		this.recipeOutputItemID = itemStack.itemID;
		this.recipeWidth = i;
		this.recipeHeight = j;
		this.recipeItems = arrayOfItemStack;
		this.recipeOutput = itemStack;
	}
	
	public ItemStack getRecipeOutput()
	{
		return this.recipeOutput;
	}
	
	public boolean matches(InventoryCrafting inventoryCrafting, World world)
	{
		for (int i = 0; i <= 6 - this.recipeWidth; ++i)
		{
			for (int j = 0; j <= 6 - this.recipeHeight; ++j)
			{
				if (this.checkMatch(inventoryCrafting, i, j, true))
				{
					return true;
				}
				
				if (this.checkMatch(inventoryCrafting, i, j, false))
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean checkMatch(InventoryCrafting inventoryCrafting, int i, int j, boolean par1)
	{
		for (int k = 0; k < 6; ++k)
		{
			for (int l = 0; l < 6; ++l)
			{
				int i1 = k - i;
				int j1 = l - j;
				ItemStack itemStack = null;
				
				if (i1 >= 0 && j1 >= 0 && i1 < this.recipeWidth && j1 < this.recipeHeight)
				{
					if (par1)
					{
						itemStack = this.recipeItems[this.recipeWidth - i1 - 1 + j1 * this.recipeWidth];
					}
					else
					{
						itemStack = this.recipeItems[i1 + j1 * this.recipeWidth];
					}
				}
				
				ItemStack itemStack1 = inventoryCrafting.getStackInRowAndColumn(k, l);
				
				if (itemStack1 != null || itemStack != null)
				{
					if (itemStack1 == null && itemStack != null || itemStack1 != null && itemStack == null)
					{
						return false;
					}
					
					if (itemStack.itemID != itemStack1.itemID)
					{
						return false;
					}
					
					if (itemStack.getItemDamage() != 32767 && itemStack.getItemDamage() != itemStack1.getItemDamage())
					{
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting)
	{
		ItemStack itemStack = this.getRecipeOutput().copy();
		
		if (this.field_92101_f)
		{
			for (int i = 0; i < inventoryCrafting.getSizeInventory(); ++i)
			{
				ItemStack itemStack1 = inventoryCrafting.getStackInSlot(i);
				
				if (itemStack1 != null && itemStack1.hasTagCompound());
				{
					itemStack.setTagCompound((NBTTagCompound)itemStack1.stackTagCompound.copy());
				}
			}
		}
		
		return itemStack;
	}
	
	public int getRecipeSize()
	{
		return this.recipeWidth * this.recipeHeight;
	}
	
	public WeaponForgeShapedInputRecipe func_92100_c()
	{
		this.field_92101_f = true;
		return this;
	}
}
