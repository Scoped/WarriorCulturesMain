package WarriorCulturesMain.Scoped.com.github.core.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.world.World;
import WarriorCulturesMain.Scoped.com.github.core.slot.Slot_PlayerGui;
import WarriorCulturesMain.Scoped.com.github.tileEntity.TileEntity_PlayerGui;

public class Container_PlayerGui extends Container
{
    /** Determines if inventory manipulation should be handled. */
    public boolean isLocalWorld;
    public final EntityPlayer thePlayer;
    TileEntity_PlayerGui tileEntity;
    
	public Container_PlayerGui(InventoryPlayer inventoryPlayer, TileEntity_PlayerGui tileEntity, EntityPlayer entityPlayer, boolean par3, World world, int x, int y, int z)
	{
        this.isLocalWorld = par3;
        this.thePlayer = entityPlayer;
        this.tileEntity = tileEntity;
		int i;
		int j;
		
		/**
		 * 
		 * @Int slot ID
		 * @Int xPos
		 * @Int yPos
		 * @Int armorSlot
		 */
		this.addSlotToContainer(new Slot_PlayerGui(this, tileEntity, 0, 8, 18, 0));
		this.addSlotToContainer(new Slot_PlayerGui(this, tileEntity, 1, 8, 18, 0));
		this.addSlotToContainer(new Slot_PlayerGui(this, tileEntity, 2, 8, 18, 0));
		this.addSlotToContainer(new Slot_PlayerGui(this, tileEntity, 3, 8, 18, 0));
		this.addSlotToContainer(new Slot_PlayerGui(this, tileEntity, 4, 8, 18, 0));
		this.addSlotToContainer(new Slot_PlayerGui(this, tileEntity, 5, 8, 18, 0));
		this.addSlotToContainer(new Slot_PlayerGui(this, tileEntity, 6, 8, 18, 0));
		this.addSlotToContainer(new Slot_PlayerGui(this, tileEntity, 7, 8, 18, 0));
		this.addSlotToContainer(new Slot_PlayerGui(this, tileEntity, 8, 8, 18, 0));
		this.addSlotToContainer(new Slot_PlayerGui(this, tileEntity, 9, 8, 18, 0));
		this.addSlotToContainer(new Slot_PlayerGui(this, tileEntity, 10, 8, 18, 0));
		this.addSlotToContainer(new Slot_PlayerGui(this, tileEntity, 11, 8, 18, 0));
		this.addSlotToContainer(new Slot_PlayerGui(this, tileEntity, 12, 8, 18, 0));
		this.addSlotToContainer(new Slot_PlayerGui(this, tileEntity, 13, 8, 18, 0));
		this.addSlotToContainer(new Slot_PlayerGui(this, tileEntity, 14, 8, 18, 0));
		
		/**
		 * Inventory
		 */
		for (i = 0; i < 3; ++i)
		{
			for (j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 9 + j * 18, 163 + i * 18));
			}
		}
		
		/**
		 * Inventory hotbar
		 */
		for (i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(inventoryPlayer, i, 9 + i * 18, 221));
		}
	}
	
    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return true;
    }
}
