package WarriorCulturesMain.Scoped.com.github.core.handler.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class WeaponForgeInputRecipeSorter implements Comparator
{
	final WeaponForgeInputRecipe weaponForgeInputRecipe;
	
	public WeaponForgeInputRecipeSorter(WeaponForgeInputRecipe weaponForgeInputRecipe)
	{
		this.weaponForgeInputRecipe = weaponForgeInputRecipe;
	}
	
	public int compareRecipes(IRecipe iRecipe, IRecipe iRecipe1)
	{
        return iRecipe1 instanceof WeaponForgeShapedRecipes ? 1 : (iRecipe instanceof WeaponForgeShapedInputRecipe ? -1 : (iRecipe1.getRecipeSize() < iRecipe.getRecipeSize() ? -1 : (iRecipe1.getRecipeSize() > iRecipe.getRecipeSize() ? 1 : 0)));
	}
	
	public int compare(Object object, Object object1)
	{
		return this.compareRecipes((IRecipe)object, (IRecipe)object1);
	}
}
