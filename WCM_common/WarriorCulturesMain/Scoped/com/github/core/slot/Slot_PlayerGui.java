package WarriorCulturesMain.Scoped.com.github.core.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import WarriorCulturesMain.Scoped.com.github.core.container.Container_PlayerGui;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Slot_PlayerGui extends Slot
{
	final int armorType;
	
	final Container_PlayerGui container;
    
    public Slot_PlayerGui(Container_PlayerGui playerGui, IInventory inventory, int ID, int x, int y, int armorSlot)
    {
        super(inventory, ID, x, y);
        this.container = playerGui;
        this.armorType = armorSlot;
	}

	/**
     * Returns the maximum stack size for a given slot (usually the same as getInventoryStackLimit(), but 1 in the case
     * of armor slots)
     */
    public int getSlotStackLimit()
    {
        return 1;
    }

    /**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
    public boolean isItemValid(ItemStack itemStack)
    {
        Item item = (itemStack == null ? null : itemStack.getItem());
        return item != null && item.isValidArmor(itemStack, armorType, container.thePlayer);
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns the icon index on items.png that is used as background image of the slot.
     */
    public Icon getBackgroundIconIndex()
    {
        return ItemArmor.func_94602_b(this.armorType);
    }
}
