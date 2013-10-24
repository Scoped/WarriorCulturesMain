package WarriorCulturesMain.Scoped.com.github.core.handler.crafting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class WeaponForgeShapelessRecipes implements IRecipe
{
	/**
	 * Is the ItemStack that you get when crafting the recipe.
	 */
	private final ItemStack recipeOutput;
	
	/**
	 * Is the List ofItemStack that composes the recipe.
	 */
	public final List recipeItems;
	
	public WeaponForgeShapelessRecipes(ItemStack itemStack, List list)
	{
		this.recipeOutput = itemStack;
		this.recipeItems = list;
	}
	
	public ItemStack getRecipeOutput()
	{
		return this.recipeOutput;
	}
	
	public boolean matches(InventoryCrafting inventoryCrafting, World world)
	{
		ArrayList arrayList = new ArrayList(this.recipeItems);
		
		for (int i = 0; i < 6; ++i)
		{
			for (int j = 0; j < 6; ++j)
			{
				ItemStack itemStack = inventoryCrafting.getStackInRowAndColumn(j, i);
				
				if (itemStack != null)
				{
					boolean flag = false;
					Iterator iterator = arrayList.iterator();
					
					while (iterator.hasNext())
					{
						ItemStack itemStack1 = (ItemStack)iterator.next();
						
						if (itemStack.itemID == itemStack1.itemID && (itemStack1.getItemDamage() == 32767 || itemStack.getItemDamage() == itemStack1.getItemDamage()))
						{
							flag = true;
							arrayList.remove(itemStack1);
							break;
						}
					}
					
					if (!flag)
					{
						return false;
					}
				}
			}
		}
		
		return arrayList.isEmpty();
	}
	
	public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting)
	{
		return this.recipeOutput.copy();
	}
	
	public int getRecipeSize()
	{
		return this.recipeItems.size();
	}
	
}
