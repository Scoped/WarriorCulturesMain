package WarriorCulturesMain.Scoped.com.github.core.slot;

import WarriorCulturesMain.Scoped.com.github.tileEntity.TileEntity_WeaponForge;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class Slot_WeaponForgeCrafting extends Slot
{
	private final IInventory craftMatrix;
	private EntityPlayer thePlayer;
	private int amountCrafted;
	TileEntity_WeaponForge weaponForge;
	
	public Slot_WeaponForgeCrafting(EntityPlayer entityPlayer, IInventory par1IInventory, IInventory craftResult, int par2, int par3, int par4)
	{
		super(craftResult, par2, par3, par4);
		this.thePlayer = entityPlayer;
		this.craftMatrix = par1IInventory;
	}
	
	public boolean isItemValid(ItemStack itemStack)
	{
		return false;
	}
	
	public ItemStack decrStackSize(int i)
	{
		if (this.getHasStack())
		{
			this.amountCrafted += Math.min(i, this.getStack().stackSize);
		}
		
		return super.decrStackSize(i);
	}
	
	protected void onCrafting(ItemStack itemStack, int i)
	{
        if (weaponForge.cookTime == 100)
        {
			this.amountCrafted += i;
			this.onCrafting(itemStack);
        }
	}
	
	protected void onCrafting(ItemStack itemStack)
	{
        if (weaponForge.cookTime == 100)
        {
    		itemStack.onCrafting(this.thePlayer.worldObj, this.thePlayer, this.amountCrafted);
    		this.amountCrafted = 0;
        }
		
		/**
		 * maybe add Achievements here
		 */
	}
	
	public void onPickupFromSlot(EntityPlayer entityPlayer, ItemStack itemStack)
	{
		GameRegistry.onItemCrafted(entityPlayer, itemStack, craftMatrix);
		this.onCrafting(itemStack);
		
		for (int i = 0; i < this.craftMatrix.getSizeInventory(); ++i)
		{
			ItemStack itemStack1 = this.craftMatrix.getStackInSlot(i);
			
			if (itemStack1 != null)
			{
				this.craftMatrix.decrStackSize(i, 1);
				
				if (itemStack1.getItem().hasContainerItem())
				{
					ItemStack itemStack2 = itemStack1.getItem().getContainerItemStack(itemStack1);
					
					if (itemStack2.isItemStackDamageable() && itemStack2.getItemDamage() > itemStack2.getMaxDamage())
					{
						MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(thePlayer, itemStack2));
						itemStack2 = null;
					}
					
					if (itemStack2 != null && (!itemStack1.getItem().doesContainerItemLeaveCraftingGrid(itemStack1) || !this.thePlayer.inventory.addItemStackToInventory(itemStack2)))
					{
						if (this.craftMatrix.getStackInSlot(i) == null && weaponForge.cookTime == 100)
						{
							this.craftMatrix.setInventorySlotContents(i, itemStack2);
						}
						else
						{
							this.thePlayer.dropPlayerItem(itemStack2);
						}
					}
				}
			}
		}
	}
}
