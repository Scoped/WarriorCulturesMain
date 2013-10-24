package WarriorCulturesMain.Scoped.com.github.tileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntity_PlayerGui extends TileEntity implements ISidedInventory
{
	public ItemStack[] slots = new ItemStack[51];
	private String localizedName;
	
	public void readFromNBT(NBTTagCompound nbtTagCompound)
	{
		super.readFromNBT(nbtTagCompound);
		NBTTagList nbtTagList = nbtTagCompound.getTagList("Items");
		slots = new ItemStack[getSizeInventory()];
		
		for (int i = 0; i <nbtTagList.tagCount(); i++)
		{
			NBTTagCompound nbtTagCompound1 = (NBTTagCompound)nbtTagList.tagAt(i);
			byte byte0 = nbtTagCompound1.getByte("Slot");
			
			if (byte0 >= 0 && byte0 < slots.length)
			{
				slots[byte0] = ItemStack.loadItemStackFromNBT(nbtTagCompound1);
			}
			
			for (int j = 0; j < 6; ++j)
			{
				for (int k = 0; k < 6; ++k)
				{
					byte byte1 = nbtTagCompound1.getByte("Slots" + (i * j));
					System.out.println("Slots" + (i + j));
					
					slots[byte1] = ItemStack.loadItemStackFromNBT(nbtTagCompound1);
				}
			}
		}
	}
	
	public void writeToNBT(NBTTagCompound nbtTagCompound)
	{
		super.writeToNBT(nbtTagCompound);
		NBTTagList nbtTagList = new NBTTagList();
		
		for (int i = 0; i < slots.length; i++)
		{
			if (slots[i] != null)
			{
				NBTTagCompound nbtTagCompound1 = new NBTTagCompound();
				nbtTagCompound1.setByte("Slot", (byte)i);
				slots[i].writeToNBT(nbtTagCompound1);
				nbtTagList.appendTag(nbtTagCompound1);
			}
		}
		
		nbtTagCompound.setTag("Items", nbtTagList);
	}
	
	public int getSizeInventory()
	{
		return this.slots.length;
	}
	
	public ItemStack getStackInSlot(int i)
	{
		return this.slots[i];
	}
	
	public int getInventoryStackLimit()
	{
		return 64;
	}
	
	public ItemStack decrStackSize(int i, int j)
	{
		if (this.slots[i] != null)
		{
			ItemStack itemStack;
			
			if (this.slots[i].stackSize <= j)
			{
				itemStack = this.slots[i];
				this.slots[i] = null;
				return itemStack;
			}
			else
			{
				itemStack = this.slots[i].splitStack(j);
				
				if (this.slots[i].stackSize == 0)
				{
					this.slots[i] = null;
				}
				
				return itemStack;
			}
		}
		else
		{
			return null;
		}
	}
	
	public ItemStack getStackInSlotOnClosing(int i)
	{
        if (i >= 0 && i < this.slots.length)
        {
            ItemStack itemstack = this.slots[i];
            this.slots[i] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
	}
	
	public void setInventorySlotContents(int i, ItemStack itemStack)
	{
		this.slots[i] = itemStack;
		
		if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit())
		{
			itemStack.stackSize = this.getInventoryStackLimit();
		}
	}
	
	public String getInvName()
	{
		return this.isInvNameLocalized() ? this.localizedName : "container.playerGui";
	}
	
	public boolean isInvNameLocalized()
	{
		return this.localizedName != null && this.localizedName.length() > 0;
	}
	
	public void setGuiDisplayName(String displayName)
	{
		this.localizedName = displayName;
	}
	
	public boolean isUseableByPlayer(EntityPlayer entityplayer)
	{
		return true;
	}
	
	public void openChest() {}
	
	public void closeChest() {}
	
	public boolean isItemValidForSlot(int i, ItemStack itemstack)
	{
		return true;
	}
	
	public int[] getAccessibleSlotsFromSide(int var1)
	{
		return null;
	}
	
	public boolean canInsertItem(int i, ItemStack itemstack, int j)
	{
		return false;
	}
	
	public boolean canExtractItem(int i, ItemStack itemstack, int j)
	{
		return false;
	}
}
