package WarriorCulturesMain.Scoped.com.github.tileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import WarriorCulturesMain.Scoped.com.github.block.Block_2_WeaponForge;
import WarriorCulturesMain.Scoped.com.github.core.handler.crafting.WeaponForgeInputRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntity_2_WeaponForge extends TileEntity implements IInventory
{
	private ItemStack[] slots = new ItemStack[45];
	private String customName;
	public int cookTime;
	public int furnaceSpeed = 100;
	
	/**How long the fual will continue burning*/
	public int burnTime1;
	public int burnTime2;
	public int burnTime3;
	public int burnTime4;
	public int burnTime5;
	public int burnTime6;
	
	/**The start time for this item*/
	public int itemBurnTime1;
	public int itemBurnTime2;
	public int itemBurnTime3;
	public int itemBurnTime4;
	public int itemBurnTime5;
	public int itemBurnTime6;
	
	public int getSizeInventory()
	{
		return slots.length;
	}
	
	public ItemStack getStackInSlot(int i)
	{
		return slots[i];
	}
	
	public void setInventorySlotContainers(int i, ItemStack itemStack)
	{
		slots[i] = itemStack;
		
		if (itemStack != null && itemStack.stackSize > getInventoryStackLimit())
		{
			itemStack.stackSize = getInventoryStackLimit();
		}
	}
	
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
			
			burnTime1 = nbtTagCompound.getShort("BurnTime1");
			burnTime2 = nbtTagCompound.getShort("BurnTime2");
			burnTime3 = nbtTagCompound.getShort("BurnTime3");
			burnTime4 = nbtTagCompound.getShort("BurnTime4");
			burnTime5 = nbtTagCompound.getShort("BurnTime5");
			burnTime6 = nbtTagCompound.getShort("BurnTime6");
			cookTime = nbtTagCompound.getShort("CookTime");
			itemBurnTime1 = getItemBurnTime(slots[2]);
			itemBurnTime2 = getItemBurnTime(slots[3]);
			itemBurnTime3 = getItemBurnTime(slots[4]);
			itemBurnTime4 = getItemBurnTime(slots[5]);
			itemBurnTime5 = getItemBurnTime(slots[6]);
			itemBurnTime6 = getItemBurnTime(slots[7]);
		}
	}
	
	public void writeToNBT(NBTTagCompound nbtTagCompound)
	{
		super.writeToNBT(nbtTagCompound);
		nbtTagCompound.setShort("BurnTime1", (short)burnTime1);
		nbtTagCompound.setShort("BurnTime2", (short)burnTime2);
		nbtTagCompound.setShort("BurnTime3", (short)burnTime3);
		nbtTagCompound.setShort("BurnTime4", (short)burnTime4);
		nbtTagCompound.setShort("BurnTime5", (short)burnTime5);
		nbtTagCompound.setShort("BurnTime6", (short)burnTime6);
		nbtTagCompound.setShort("CookTime", (short)cookTime);
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
	
	public int getInventoryStackLimit()
	{
		return 64;
	}
	
	public int getCookProgressScaled(int i)
	{
		return (cookTime * i) / 100;
	}
	
	public int getSlotOneBurnTimeRemainingScaled(int i)
	{
		if (this.itemBurnTime1 == 0)
		{
			this.itemBurnTime1 = 100;
		}
		
		return this.burnTime1 * i / this.itemBurnTime1;
	}
	
	public int getSlotTwoBurnTimeRemainingScaled(int i)
	{
		if (this.itemBurnTime2 == 0)
		{
			this.itemBurnTime2 = 100;
		}
		
		return this.burnTime2 * i / this.itemBurnTime2;
	}
	
	public int getSlotThreeBurnTimeRemainingScaled(int i)
	{
		if (this.itemBurnTime3 == 0)
		{
			this.itemBurnTime3 = 100;
		}
		
		return this.burnTime3 * i / this.itemBurnTime3;
	}
	
	public int getSlotFourBurnTimeRemainingScaled(int i)
	{
		if (this.itemBurnTime4 == 0)
		{
			this.itemBurnTime4 = 100;
		}
		
		return this.burnTime4 * i / this.itemBurnTime4;
	}
	
	public int getSlotFiveBurnTimeRemainingScaled(int i)
	{
		if (this.itemBurnTime5 == 0)
		{
			this.itemBurnTime5 = 100;
		}
		
		return this.burnTime5 * i / this.itemBurnTime5;
	}
	
	public int getSlotSixBurnTimeRemainingScaled(int i)
	{
		if (this.itemBurnTime6 == 0)
		{
			this.itemBurnTime6 = 100;
		}
		
		return this.burnTime6 * i / this.itemBurnTime6;
	}
	
	public boolean isSlotOneBurning()
	{
		if (burnTime1 > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isSlotTwoBurning()
	{
		if (burnTime2 > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isSlotThreeBurning()
	{
		if (burnTime3 > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isSlotFourBurning()
	{
		if (burnTime4 > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isSlotFiveBurning()
	{
		if (burnTime5 > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isSlotSixBurning()
	{
		if (burnTime6 > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void updateEntity()
	{
		boolean flag1 = this.burnTime1 > 0;
		boolean flag2 = this.burnTime2 > 0;
		boolean flag3 = this.burnTime3 > 0;
		boolean flag4 = this.burnTime4 > 0;
		boolean flag5 = this.burnTime5 > 0;
		boolean flag6 = this.burnTime6 > 0;
		
		boolean flag8 = false;
		
		if (this.burnTime1 > 0)
		{
			--this.burnTime1;
		}
		if (this.burnTime2 > 0)
		{
			--this.burnTime2;
		}
		if (this.burnTime3 > 0)
		{
			--this.burnTime3;
		}
		if (this.burnTime4 > 0)
		{
			--this.burnTime4;
		}
		if (this.burnTime5 > 0)
		{
			--this.burnTime5;
		}
		if (this.burnTime6 > 0)
		{
			--this.burnTime6;
		}
		
		if (!this.worldObj.isRemote)
		{
			if (this.burnTime1 == 0/* && this.canSmelt()*/)
			{
				this.itemBurnTime1 = this.burnTime1 = getItemBurnTime(this.slots[2]);
				
				if (this.burnTime1 > 0)
				{
					flag8 = true;
					
					if (this.slots[2] != null)
					{
						--this.slots[2].stackSize;
				
						if (this.slots[2].stackSize == 0)
						{
							this.slots[2] = this.slots[2].getItem().getContainerItemStack(this.slots[2]);
						}
					}
				}
			}
			if (this.burnTime2 == 0/* && this.canSmelt()*/)
			{
				this.itemBurnTime2 = this.burnTime2 = getItemBurnTime(this.slots[3]);
				
				if (this.burnTime2 > 0)
				{
					flag8 = true;
					
					if (this.slots[3] != null)
					{
						--this.slots[3].stackSize;
				
						if (this.slots[3].stackSize == 0)
						{
							this.slots[3] = this.slots[3].getItem().getContainerItemStack(this.slots[3]);
						}
					}
				}
			}
			if (this.burnTime3 == 0/* && this.canSmelt()*/)
			{
				this.itemBurnTime3 = this.burnTime3 = getItemBurnTime(this.slots[4]);
				
				if (this.burnTime3 > 0)
				{
					flag8 = true;
					
					if (this.slots[4] != null)
					{
						--this.slots[4].stackSize;
				
						if (this.slots[4].stackSize == 0)
						{
							this.slots[4] = this.slots[4].getItem().getContainerItemStack(this.slots[4]);
						}
					}
				}
			}
			if (this.burnTime4 == 0/* && this.canSmelt()*/)
			{
				this.itemBurnTime4 = this.burnTime4 = getItemBurnTime(this.slots[5]);
				
				if (this.burnTime4 > 0)
				{
					flag8 = true;
					
					if (this.slots[5] != null)
					{
						--this.slots[5].stackSize;
				
						if (this.slots[5].stackSize == 0)
						{
							this.slots[5] = this.slots[5].getItem().getContainerItemStack(this.slots[5]);
						}
					}
				}
			}
			if (this.burnTime5 == 0/* && this.canSmelt()*/)
			{
				this.itemBurnTime5 = this.burnTime5 = getItemBurnTime(this.slots[6]);
				
				if (this.burnTime5 > 0)
				{
					flag8 = true;
					
					if (this.slots[6] != null)
					{
						--this.slots[6].stackSize;
				
						if (this.slots[6].stackSize == 0)
						{
							this.slots[6] = this.slots[6].getItem().getContainerItemStack(this.slots[6]);
						}
					}
				}
			}
			if (this.burnTime6 == 0/* && this.canSmelt()*/)
			{
				this.itemBurnTime6 = this.burnTime6 = getItemBurnTime(this.slots[7]);
				
				if (this.burnTime6 > 0)
				{
					flag8 = true;
					
					if (this.slots[7] != null)
					{
						--this.slots[7].stackSize;
				
						if (this.slots[7].stackSize == 0)
						{
							this.slots[7] = this.slots[7].getItem().getContainerItemStack(this.slots[7]);
						}
					}
				}
			}
			
			if (this.isSlotOneBurning() && this.isSlotTwoBurning() && this.isSlotThreeBurning() && this.isSlotFourBurning() && this.isSlotFiveBurning() && this.isSlotSixBurning() && this.canSmelt())
			{
				++this.cookTime;
				
				if (this.cookTime == this.furnaceSpeed)
				{
					this.cookTime = 0;
					this.smeltItem();
					flag8 = true;
				}
			}
			else
			{
				this.cookTime = 0;
			}
			/*
			if (this.isSlotTwoBurning() && this.canSmelt())
			{
				++this.cookTime;
				
				if (this.cookTime == this.furnaceSpeed)
				{
					this.cookTime = 0;
					this.smeltItem();
					flag8 = true;
				}
			}
			else
			{
				this.cookTime = 0;
			}
			
			if (this.isSlotThreeBurning() && this.canSmelt())
			{
				++this.cookTime;
				
				if (this.cookTime == this.furnaceSpeed)
				{
					this.cookTime = 0;
					this.smeltItem();
					flag8 = true;
				}
			}
			else
			{
				this.cookTime = 0;
			}
			
			if (this.isSlotFourBurning() && this.canSmelt())
			{
				++this.cookTime;
				
				if (this.cookTime == this.furnaceSpeed)
				{
					this.cookTime = 0;
					this.smeltItem();
					flag8 = true;
				}
			}
			else
			{
				this.cookTime = 0;
			}
			
			if (this.isSlotFiveBurning() && this.canSmelt())
			{
				++this.cookTime;
				
				if (this.cookTime == this.furnaceSpeed)
				{
					this.cookTime = 0;
					this.smeltItem();
					flag8 = true;
				}
			}
			else
			{
				this.cookTime = 0;
			}
			
			if (this.isSlotSixBurning() && this.canSmelt())
			{
				++this.cookTime;
				
				if (this.cookTime == this.furnaceSpeed)
				{
					this.cookTime = 0;
					this.smeltItem();
					flag8 = true;
				}
			}
			else
			{
				this.cookTime = 0;
			}*/
			
			if (flag1 != this.burnTime1 > 0)
			{
				flag8 = true;
				Block_2_WeaponForge.updateWeaponForgeBlockState(this.burnTime1 > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
			else if (flag2 != this.burnTime2 > 0)
			{
				flag8 = true;
				Block_2_WeaponForge.updateWeaponForgeBlockState(this.burnTime2 > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
			else if (flag3 != this.burnTime3 > 0)
			{
				flag8 = true;
				Block_2_WeaponForge.updateWeaponForgeBlockState(this.burnTime3 > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
			else if (flag4 != this.burnTime4 > 0)
			{
				flag8 = true;
				Block_2_WeaponForge.updateWeaponForgeBlockState(this.burnTime4 > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
			else if (flag5 != this.burnTime5 > 0)
			{
				flag8 = true;
				Block_2_WeaponForge.updateWeaponForgeBlockState(this.burnTime5 > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
			else if (flag6 != this.burnTime6 > 0)
			{
				flag8 = true;
				Block_2_WeaponForge.updateWeaponForgeBlockState(this.burnTime6 > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
			
		}
		
		if (flag8)
		{
			this.onInventoryChanged();
		}
	}
	
	
	private boolean canSmelt()
	{
		/*if (slots[0].getItem().itemID != (ModItems.ForgeTools.getMetadata(0)) && slots[1].getItem().itemID != (ModItems.ForgeTools.getMetadata(1)))
		{
			return false;
		}*/
		
		ItemStack itemStack = WeaponForgeInputRecipe.getSmeltingResult(
				slots[9].getItem().itemID, 
				slots[10].getItem().itemID, 
				slots[11].getItem().itemID, 
				slots[12].getItem().itemID, 
				slots[13].getItem().itemID, 
				slots[14].getItem().itemID, 
				slots[15].getItem().itemID, 
				slots[16].getItem().itemID, 
				slots[17].getItem().itemID, 
				slots[18].getItem().itemID, 
				slots[19].getItem().itemID, 
				slots[20].getItem().itemID, 
				slots[21].getItem().itemID, 
				slots[22].getItem().itemID, 
				slots[23].getItem().itemID, 
				slots[24].getItem().itemID, 
				slots[25].getItem().itemID, 
				slots[26].getItem().itemID, 
				slots[27].getItem().itemID, 
				slots[28].getItem().itemID, 
				slots[29].getItem().itemID, 
				slots[30].getItem().itemID, 
				slots[31].getItem().itemID, 
				slots[32].getItem().itemID, 
				slots[33].getItem().itemID, 
				slots[34].getItem().itemID, 
				slots[35].getItem().itemID, 
				slots[36].getItem().itemID, 
				slots[37].getItem().itemID, 
				slots[38].getItem().itemID, 
				slots[39].getItem().itemID, 
				slots[40].getItem().itemID, 
				slots[41].getItem().itemID, 
				slots[42].getItem().itemID, 
				slots[43].getItem().itemID, 
				slots[44].getItem().itemID);
		
		if (slots[8] == null)
		{
			return true;
		}
		if (!slots[8].isItemEqual(itemStack))
		{
			return false;
		}
        if (slots[8].stackSize < getInventoryStackLimit() && slots[8].stackSize < slots[8].getMaxStackSize())
        {
			return true;
		}
        else
        {
        	return slots[8].stackSize < itemStack.getMaxStackSize();
        }
        
	}
	
	public void smeltItem()
	{
		if (!canSmelt())
		{
			return;
		}
		
		ItemStack itemStack = WeaponForgeInputRecipe.getSmeltingResult(
				slots[9].getItem().itemID, 
				slots[10].getItem().itemID, 
				slots[11].getItem().itemID, 
				slots[12].getItem().itemID, 
				slots[13].getItem().itemID, 
				slots[14].getItem().itemID, 
				slots[15].getItem().itemID, 
				slots[16].getItem().itemID, 
				slots[17].getItem().itemID, 
				slots[18].getItem().itemID, 
				slots[19].getItem().itemID, 
				slots[20].getItem().itemID, 
				slots[21].getItem().itemID, 
				slots[22].getItem().itemID, 
				slots[23].getItem().itemID, 
				slots[24].getItem().itemID, 
				slots[25].getItem().itemID, 
				slots[26].getItem().itemID, 
				slots[27].getItem().itemID, 
				slots[28].getItem().itemID, 
				slots[29].getItem().itemID, 
				slots[30].getItem().itemID, 
				slots[31].getItem().itemID, 
				slots[32].getItem().itemID, 
				slots[33].getItem().itemID, 
				slots[34].getItem().itemID, 
				slots[35].getItem().itemID, 
				slots[36].getItem().itemID, 
				slots[37].getItem().itemID, 
				slots[38].getItem().itemID, 
				slots[39].getItem().itemID, 
				slots[40].getItem().itemID, 
				slots[41].getItem().itemID, 
				slots[42].getItem().itemID, 
				slots[43].getItem().itemID, 
				slots[44].getItem().itemID);
		
		if (slots[8] == null)
		{
			slots[8] = itemStack.copy();
		}
        else if (slots[8].itemID == itemStack.itemID)
        {
        	slots[8].stackSize++;
        }
        for (int i = 0; i < 36; i++)
        {
        	if (slots[i].stackSize <= 0)
        	{
        		slots[i] = new ItemStack(slots[i].getItem().setFull3D());
        	}
        	else
        	{
        		slots[i].stackSize--;
        	}
        	if (slots[i].stackSize <= 0)
        	{
        		slots[i] = null;
        	}
        }
	}
	
	public boolean isUseableByPlayer(EntityPlayer entityplayer)
	{
		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityplayer.getDistance((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
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
			
			ItemStack itemStack1 = this.slots[i].splitStack(j);
			
			if (this.slots[i].stackSize == 0)
			{
				this.slots[i] = null;
			}
			
			return itemStack1;
		}
		else
		{
			return null;
		}
	}
	
	public void setInventorySlotContents(int i, ItemStack itemStack)
	{
		slots[i] = itemStack;
		
		if (itemStack != null && itemStack.stackSize > getInventoryStackLimit())
		{
			itemStack.stackSize = getInventoryStackLimit();
		}
	}
	
	public String getInvName()
	{
		return "container.weaponForge2";
	}
	
	public void openChest(){}
	
	public void closeChest(){}
	
	public ItemStack getStackInSlotOnClosing(int i)
	{
		if (slots[i] != null)
		{
			ItemStack itemStack = slots[i];
			slots[i] = null;
					return itemStack;
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public boolean isInvNameLocalized()
	{
		return (this.customName != null) && (this.customName.length() > 0);
	}
	
	public void setCustomName(String name)
	{
		this.customName = name;
	}
	
	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemStack)
	{
		return false;
	}
	
	private int getItemBurnTime(ItemStack itemstack)
	{
		 if (itemstack == null)
		 {
		         return 0;
		 }
		 
		 int i = itemstack.getItem().itemID;
		 Item item = itemstack.getItem();
		 
			if (itemstack.getItem() instanceof ItemBlock && Block.blocksList[i] != null)
			{
				Block block = Block.blocksList[i];
				
				if (block == Block.woodSingleSlab)
				{
					return 150;
				}
				if (block.blockMaterial == Material.wood)
				{
					return 300;
				}
				if (block == Block.coalBlock)
				{
					return 16000;
				}
			}
			
			if (item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD")) return 200;
			if (item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD")) return 200;
			if (item instanceof ItemHoe && ((ItemHoe) item).getMaterialName().equals("WOOD")) return 200;
			
		 
		 if (i < 256 && Block.blocksList[i].blockMaterial == Material.wood)
		 {
		         return 300;
		 }
		 if (i == Item.stick.itemID)
		 {
		         return 100;
		 }
		 if (i == Item.coal.itemID)
		 {
		         return 1600;
		 }
		 if (i == Item.bucketLava.itemID)
		 {
		         return 20000;
		 }
		 if (i == Item.blazeRod.itemID)
		 {
		         return 2400;
		 }
		 if (i == Block.sapling.blockID)
		 {
		         return 100;
		 }
		 else
		 {
			 return GameRegistry.getFuelValue(itemstack);
		 }
	}
}
