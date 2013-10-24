package WarriorCulturesMain.Scoped.com.github.core.handler.crafting;

import java.util.Comparator;

import WarriorCulturesMain.Scoped.com.github.core.handler.WeaponForgeCraftingManager;
import net.minecraft.item.crafting.IRecipe;

public class WeaponForgeRecipeSorter implements Comparator
{
	final WeaponForgeCraftingManager weaponForgeCraftingManager;
	
	public WeaponForgeRecipeSorter(WeaponForgeCraftingManager weaponForgeCraftingManager)
	{
		this.weaponForgeCraftingManager = weaponForgeCraftingManager;
	}
	
	public int compareRecipes(IRecipe iRecipe, IRecipe iRecipe1)
	{
        return iRecipe instanceof WeaponForgeShapelessRecipes && iRecipe1 instanceof WeaponForgeShapedRecipes ? 1 : (iRecipe1 instanceof WeaponForgeShapelessRecipes && iRecipe instanceof WeaponForgeShapedRecipes ? -1 : (iRecipe1.getRecipeSize() < iRecipe.getRecipeSize() ? -1 : (iRecipe1.getRecipeSize() > iRecipe.getRecipeSize() ? 1 : 0)));
	}
	
	public int compare(Object object, Object object1)
	{
		return this.compareRecipes((IRecipe)object, (IRecipe)object1);
	}
}
