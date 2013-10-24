package WarriorCulturesMain.Scoped.com.github.core.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import WarriorCulturesMain.Scoped.com.github.core.slot.Slot_WeaponForge;
import WarriorCulturesMain.Scoped.com.github.tileEntity.TileEntity_2_WeaponForge;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Container_2_WeaponForge extends Container
{
	private TileEntity_2_WeaponForge furnace;
	private int cookTime;
	
	private int itemBurnTime1;
	private int itemBurnTime2;
	private int itemBurnTime3;
	private int itemBurnTime4;
	private int itemBurnTime5;
	private int itemBurnTime6;
	
	private int burnTime1;
	private int burnTime2;
	private int burnTime3;
	private int burnTime4;
	private int burnTime5;
	private int burnTime6;
	
	public InventoryCrafting craftMatrix;
	public IInventory craftResult;
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;
	
	public Container_2_WeaponForge(InventoryPlayer inventoryPlayer, TileEntity_2_WeaponForge tileEntity_2_WeaponForge, World world, int x, int y, int z)
	{
		this.craftMatrix = new InventoryCrafting(this, 6, 6);
		this.craftResult = new InventoryCraftResult();
		this.worldObj = world;
		this.posX = x;
		this.posY = y;
		this.posZ = z;
		
		int i;
		int j;
		
		this.furnace = tileEntity_2_WeaponForge;
		
		/**
		 * Plaiers slot
		 */
		this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 0, 163, 46));
		
		/**
		 * Hammer slot
		 */
		this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 1, 163, 64));
		
		/**
		 * Fuel slots
		 */
		this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 2, 15, 136));
		this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 3, 33, 136));
		this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 4, 51, 136));
		this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 5, 69, 136));
		this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 6, 87, 136));
		this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 7, 105, 136));
		
		/**
		 * Finished product slot
		 */
		this.addSlotToContainer(new Slot_WeaponForge(inventoryPlayer.player, tileEntity_2_WeaponForge, 8, 163, 96));
		
		/**
		 * Crafting Grid
		 */
			/**
			 * X-line 1
			 */
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 9, 15, 10));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 10, 33, 10));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 11, 51, 10));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 12, 69, 10));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 13, 87, 10));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 14, 105, 10));
			
			/**
			 * X-line 2
			 */
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 15, 15, 28));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 16, 33, 28));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 17, 51, 28));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 18, 69, 28));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 19, 87, 28));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 20, 105, 28));
			
			/**
			 * X-line 3
			 */
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 21, 15, 46));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 22, 33, 46));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 23, 51, 46));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 24, 69, 46));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 25, 87, 46));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 26, 105, 46));
			
			/**
			 * X-line 4
			 */
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 27, 15, 64));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 28, 33, 64));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 29, 51, 64));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 30, 69, 64));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 31, 87, 64));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 32, 105, 64));
			
			/**
			 * X-line 5
			 */
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 33, 15, 82));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 34, 33, 82));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 35, 51, 82));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 36, 69, 82));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 37, 87, 82));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 38, 105, 82));
			
			/**
			 * X-line 6
			 */
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 39, 15, 100));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 40, 33, 100));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 41, 51, 100));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 42, 69, 100));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 43, 87, 100));
			this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, 44, 105, 100));
			
		/*for (i = 0; i < 6; ++i)
		{
			for (j = 0; j < 6; ++j)
			{
				this.addSlotToContainer(new Slot(tileEntity_2_WeaponForge, j + i * 6, 15 + j * 18, 10 + i * 18));
			}
		}*/
		
		/**
		 * Inventory
		 */
		for (i = 0; i < 3; ++i)
		{
			for (j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 13 + j * 18, 173 + i * 18));
			}
		}
		
		/**
		 * Inventory hotbar
		 */
		for (i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(inventoryPlayer, i, 13 + i * 18, 231));
		}
		
		this.onCraftMatrixChanged(craftMatrix);
	}
	
	public void addCraftingToCrafters(ICrafting crafting)
	{
		super.addCraftingToCrafters(crafting);
		crafting.sendProgressBarUpdate(this, 0, this.furnace.cookTime);
		crafting.sendProgressBarUpdate(this, 2, this.furnace.burnTime1);
		crafting.sendProgressBarUpdate(this, 3, this.furnace.burnTime2);
		crafting.sendProgressBarUpdate(this, 4, this.furnace.burnTime3);
		crafting.sendProgressBarUpdate(this, 5, this.furnace.burnTime4);
		crafting.sendProgressBarUpdate(this, 6, this.furnace.burnTime5);
		crafting.sendProgressBarUpdate(this, 7, this.furnace.burnTime6);
		crafting.sendProgressBarUpdate(this, 8, this.furnace.itemBurnTime1);
	}
	
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
		
		for (int i = 0; i < this.crafters.size(); ++i)
		{
			ICrafting crafting = (ICrafting)this.crafters.get(i);
			
			if (this.cookTime != this.furnace.cookTime)
			{
				crafting.sendProgressBarUpdate(this, 0, this.furnace.cookTime);
			}
			if (this.burnTime1 != this.furnace.burnTime1)
			{
				crafting.sendProgressBarUpdate(this, 2, this.furnace.burnTime1);
			}
			if (this.burnTime2 != this.furnace.burnTime2)
			{
				crafting.sendProgressBarUpdate(this, 3, this.furnace.burnTime2);
			}
			if (this.burnTime3 != this.furnace.burnTime3)
			{
				crafting.sendProgressBarUpdate(this, 4, this.furnace.burnTime3);
			}
			if (this.burnTime4 != this.furnace.burnTime4)
			{
				crafting.sendProgressBarUpdate(this, 5, this.furnace.burnTime4);
			}
			if (this.burnTime5 != this.furnace.burnTime5)
			{
				crafting.sendProgressBarUpdate(this, 6, this.furnace.burnTime5);
			}
			if (this.burnTime6 != this.furnace.burnTime6)
			{
				crafting.sendProgressBarUpdate(this, 7, this.furnace.burnTime6);
			}
			if (this.itemBurnTime1 != this.furnace.itemBurnTime1)
			{
				crafting.sendProgressBarUpdate(this, 8, this.furnace.itemBurnTime1);
			}
			if (this.itemBurnTime2 != this.furnace.itemBurnTime2)
			{
				crafting.sendProgressBarUpdate(this, 8, this.furnace.itemBurnTime2);
			}
			if (this.itemBurnTime3 != this.furnace.itemBurnTime3)
			{
				crafting.sendProgressBarUpdate(this, 8, this.furnace.itemBurnTime3);
			}
			if (this.itemBurnTime4 != this.furnace.itemBurnTime4)
			{
				crafting.sendProgressBarUpdate(this, 8, this.furnace.itemBurnTime4);
			}
			if (this.itemBurnTime5 != this.furnace.itemBurnTime5)
			{
				crafting.sendProgressBarUpdate(this, 8, this.furnace.itemBurnTime5);
			}
			if (this.itemBurnTime6 != this.furnace.itemBurnTime6)
			{
				crafting.sendProgressBarUpdate(this, 8, this.furnace.itemBurnTime6);
			}
			
		}
		
		this.cookTime = this.furnace.cookTime;
		this.burnTime1 = this.furnace.burnTime1;
		this.burnTime2 = this.furnace.burnTime2;
		this.burnTime3 = this.furnace.burnTime3;
		this.burnTime4 = this.furnace.burnTime4;
		this.burnTime5 = this.furnace.burnTime5;
		this.burnTime6 = this.furnace.burnTime6;
		this.itemBurnTime1 = this.furnace.itemBurnTime1;
		this.itemBurnTime2 = this.furnace.itemBurnTime2;
		this.itemBurnTime3 = this.furnace.itemBurnTime3;
		this.itemBurnTime4 = this.furnace.itemBurnTime4;
		this.itemBurnTime5 = this.furnace.itemBurnTime5;
		this.itemBurnTime6 = this.furnace.itemBurnTime6;
		
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int slot, int nextValue)
	{
		if (slot == 0)
		{
			this.furnace.cookTime = nextValue;
		}
		if (slot == 2)
		{
			this.furnace.burnTime1 = nextValue;
		}
		if (slot == 3)
		{
			this.furnace.burnTime2 = nextValue;
		}
		if (slot == 4)
		{
			this.furnace.burnTime3 = nextValue;
		}
		if (slot == 5)
		{
			this.furnace.burnTime4 = nextValue;
		}
		if (slot == 6)
		{
			this.furnace.burnTime5 = nextValue;
		}
		if (slot == 7)
		{
			this.furnace.burnTime6 = nextValue;
		}
		if (slot == 8)
		{
			this.furnace.itemBurnTime1 = nextValue;
		}
	}
	
	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int i)
	{
		ItemStack itemStack = null;
		Slot slot = (Slot)inventorySlots.get(i);
		if (slot != null && slot.getHasStack())
		{
			ItemStack itemStack1 = slot.getStack();
			itemStack = itemStack1.copy();
			
			if (i == 2)
			{
				if (!mergeItemStack(itemStack1, 3, 39, true))
				{
					return null;
				}
			}
			else if (i >= 3 && i < 30)
			{
				if (!mergeItemStack(itemStack1, 3, 39, false))
				{
					return null;
				}
			}
			else if (i >= 30 && i < 39)
			{
				if (!mergeItemStack(itemStack1, 3, 30, false))
				{
					return null;
				}
			}
			else if (!mergeItemStack(itemStack1, 3, 39, false))
			{
				return null;
			}
			if (itemStack1.stackSize == 0)
			{
				slot.putStack(null);
			}
			else
			{
				slot.onSlotChanged();
			}
			if (itemStack1.stackSize != itemStack.stackSize)
			{
				slot.onPickupFromSlot(entityPlayer, itemStack1);
			}
			else
			{
				return null;
			}
		}
		
		return itemStack;
	}
	
	public boolean canInteractWith(EntityPlayer entityPlayer)
	{
		return this.furnace.isUseableByPlayer(entityPlayer);
	}
}
