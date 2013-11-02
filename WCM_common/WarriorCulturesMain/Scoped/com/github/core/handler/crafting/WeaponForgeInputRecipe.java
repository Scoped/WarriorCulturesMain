package WarriorCulturesMain.Scoped.com.github.core.handler.crafting;

import java.util.HashMap;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WeaponForgeInputRecipe
{
	public WeaponForgeInputRecipe()
	{
		
	}
	
	public static ItemStack getSmeltingResult(int slot1, int slot2, int slot3, int slot4, int slot5, int slot6, int slot7, int slot8, int slot9, int slot10, int slot11, int slot12, int slot13, int slot14, int slot15, int slot16, int slot17, int slot18, int slot19, int slot20, int slot21, int slot22, int slot23, int slot24, int slot25, int slot26, int slot27, int slot28, int slot29, int slot30, int slot31, int slot32, int slot33, int slot34, int slot35, int slot36)
	{
		return getOutput(slot1, slot2, slot3, slot4, slot5, slot6, slot7, slot8, slot9, slot10, slot11, slot12, slot13, slot14, slot15, slot16, slot17, slot18, slot19, slot20, slot21, slot22, slot23, slot24, slot25, slot26, slot27, slot28, slot29, slot30, slot31, slot32, slot33, slot34, slot35, slot36);
	}
	
	private static ItemStack getOutput(int slot1, int slot2, int slot3, int slot4, int slot5, int slot6, int slot7, int slot8, int slot9, int slot10, int slot11, int slot12, int slot13, int slot14, int slot15, int slot16, int slot17, int slot18, int slot19, int slot20, int slot21, int slot22, int slot23, int slot24, int slot25, int slot26, int slot27, int slot28, int slot29, int slot30, int slot31, int slot32, int slot33, int slot34, int slot35, int slot36)
	{
		if (
				slot1 == Item.coal.itemID && slot2 == Item.ingotIron.itemID && slot3 == 0 && slot4 == 0 && slot5 == 0 && slot6 == 0 && 
				slot7 == 0 && slot8 == 0 && slot9 == 0 && slot10 == 0 && slot11 == 0 && slot12 == 0 && 
				slot13 == 0 && slot14 == 0 && slot15 == 0 && slot16 == 0 && slot17 == 0 && slot18 == 0 && 
				slot19 == 0 && slot20 == 0 && slot21 == 0 && slot22 == 0 && slot23 == 0 && slot24 == 0 && 
				slot25 == 0 && slot26 == 0 && slot27 == 0 && slot28 == 0 && slot29 == 0 && slot30 == 0 &&
				slot31 == 0 && slot32 == 0 && slot33 == 0 && slot34 == 0 && slot35 == 0 && slot36 == 0)
		{
			return new ItemStack(Item.ingotGold, 1);
		}
		if (slot1 == Item.ingotIron.itemID && slot2 == Item.coal.itemID && slot3 == 0 && slot4 == 0 && slot5 == 0 && slot6 == 0 && slot7 == 0 && slot8 == 0 && slot9 == 0 && slot10 == 0 && slot11 == 0 && slot12 == 0 && slot13 == 0 && slot14 == 0 && slot15 == 0 && slot16 == 0 && slot17 == 0 && slot18 == 0 && slot19 == 0 && slot20 == 0 && slot21 == 0 && slot22 == 0 && slot23 == 0 && slot24 == 0 && slot25 == 0 && slot26 == 0 && slot27 == 0 && slot28 == 0 && slot29 == 0 && slot30 == 0 && slot31 == 0 && slot32 == 0 && slot33 == 0 && slot34 == 0 && slot35 == 0 && slot36 == 0)
		{
			return new ItemStack(Item.ingotGold, 1);
		}
		
		return null;
	}
}
