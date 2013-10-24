package WarriorCulturesMain.Scoped.com.github.core.slot;

import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class Slot_WeaponForge extends Slot
{
	public Slot_WeaponForge(EntityPlayer entityPlayer, IInventory inventory, int i, int j, int k)
	{
		super(inventory, i, j, k);
	}
	
	public boolean isItemValid(ItemStack itemStack)
	{
		return false;
	}
	
	public void onPickupFromSlot(EntityPlayer entityPlayer, ItemStack itemStack)
	{
		this.onCrafting(itemStack);
		super.onPickupFromSlot(entityPlayer, itemStack);
	}
}
