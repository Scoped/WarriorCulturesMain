package WarriorCulturesMain.Scoped.com.github.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import WarriorCulturesMain.Scoped.com.github.WarriorCultures_Main;
import WarriorCulturesMain.Scoped.com.github.tileEntity.TileEntity_2_WeaponForge;

public class Block_2_WeaponForge extends BlockContainer
{
	private final boolean isActive;
	private final Random weaponForgeRandom = new Random();
	private static boolean keepInventory;
	
	public Block_2_WeaponForge(int par1, boolean isActive)
	{
		super(par1, Material.rock);
		this.isActive = isActive;
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
	}
	
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
	   return false;
	}
	
	public boolean isOpaqueCube()
	{
	   return false;
	}
	
	public int getRenderType()
	{
		return -1;
	}
	
	public int idDropped(int par1, Random random, int par3)
	{
		return ModBlocks.WeaponForge_2_Idle.blockID;
	}
	
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntity_2_WeaponForge();
	}
	
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		if (this.isActive)
		{
			int l = world.getBlockMetadata(x, y,z);
			float fx = (float)x + 0.5F;
			float fy = (float)y + 0.4F + random.nextFloat() * 2.0F / 20.0F;
			float fz = (float)z + 0.5F;
			float f3 = 0.52F;
			float f4 = random.nextFloat() * 0.6F - 0.3F;
			
			if (l == 4)
			{
				world.spawnParticle("smoke", (double)(fx - f3), (double)fy, (double)(fz + f4), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", (double)(fx - f3), (double)fy, (double)(fz + f4), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("largesmoke", (double)(fx + f4), (double)fy + 1.7, (double)((fz - 0.6) + f3), 0.0D, 0.1D, 0.0D);
			}
			else if (l == 5)
			{
				world.spawnParticle("smoke", (double)(fx + f3), (double)fy, (double)(fz + f4), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", (double)(fx + f3), (double)fy, (double)(fz + f4), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("largesmoke", (double)(fx + f4), (double)fy + 1.7, (double)((fz - 0.6) + f3), 0.0D, 0.1D, 0.0D);
			}
			else if (l == 2)
			{
				world.spawnParticle("smoke", (double)(fx + f4), (double)fy, (double)(fz - f3), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", (double)(fx + f4), (double)fy, (double)(fz - f3), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("largesmoke", (double)(fx + f4), (double)fy + 1.7, (double)((fz - 0.6) + f3), 0.0D, 0.1D, 0.0D);
			}
			else if (l == 3)
			{
				world.spawnParticle("smoke", (double)(fx + f4), (double)fy, (double)(fz + f3), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", (double)(fx + f4), (double)fy, (double)(fz + f3), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("largesmoke", (double)(fx+ f4), (double)fy + 1.7, (double)((fz - 0.6) + f3), 0.0D, 0.1D, 0.0D);
			}
		}
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			player.openGui(WarriorCultures_Main.instance, 1, world, x, y, z);
		}
		
		return true;
	}
	
	public static void updateWeaponForgeBlockState(boolean active, World worldObj, int xCoord, int yCoord, int zCoord)
	{
		int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		
		TileEntity tileEntity = worldObj.getBlockTileEntity(xCoord, yCoord, zCoord);
		keepInventory = true;
		
		if (active)
		{
			worldObj.setBlock(xCoord, yCoord, zCoord, ModBlocks.WeaponForge_2_Active.blockID);
		}
		else
		{
			worldObj.setBlock(xCoord, yCoord, zCoord, ModBlocks.WeaponForge_2_Idle.blockID);
		}
		
		keepInventory = false;
		
		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);
		
		if (tileEntity != null)
		{
			tileEntity.validate();
			worldObj.setBlockTileEntity(xCoord, yCoord, zCoord, tileEntity);
		}
	}
	
	public void breakBlock(World world, int x, int y, int z, int par5, int par6)
	{
		if (!keepInventory)
		{
			TileEntity_2_WeaponForge tileEntity = (TileEntity_2_WeaponForge)world.getBlockTileEntity(x, y, z);
			
			if (tileEntity != null)
			{
				for (int i = 0; i < tileEntity.getSizeInventory(); ++i)
				{
					ItemStack itemStack = tileEntity.getStackInSlot(i);
					
					if (itemStack != null)
					{
						float f = this.weaponForgeRandom.nextFloat() * 0.8F + 0.1F;
						float f1 = this.weaponForgeRandom.nextFloat() * 0.8F + 0.1F;
						float f2 = this.weaponForgeRandom.nextFloat() * 0.8F + 0.1F;
						
						while (itemStack.stackSize > 0)
						{
							int k1 = this.weaponForgeRandom.nextInt(21) + 10;
							
							if (k1 > itemStack.stackSize)
							{
								k1 = itemStack.stackSize;
							}
							
							itemStack.stackSize -= k1;
							EntityItem entityItem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemStack.itemID, k1, itemStack.getItemDamage()));
							
							if (itemStack.hasTagCompound())
							{
								entityItem.getEntityItem().setTagCompound((NBTTagCompound)itemStack.getTagCompound().copy());
							}
							
							float f3 = 0.05F;
							entityItem.motionX = (double)((float)this.weaponForgeRandom.nextGaussian() * f3);
							entityItem.motionY = (double)((float)this.weaponForgeRandom.nextGaussian() * f3 + 0.2F);
							entityItem.motionZ = (double)((float)this.weaponForgeRandom.nextGaussian() * f3);
							world.spawnEntityInWorld(entityItem);
						}
					}
				}
				
				world.func_96440_m(x, y, z, par5);
			}
		}
		
		super.breakBlock(world, x, y, z, par5, par6);
	}
	
	public boolean hasComparatorInputOverride()
	{
		return true;
	}
	
	public int getComparatorInputOverride(World world, int x, int y, int z, int i)
	{
		return Container.calcRedstoneFromInventory((IInventory)world.getBlockTileEntity(x, y, z));
	}
	
	public int idPicked(World world, int x, int y, int z)
	{
		return ModBlocks.WeaponForge_2_Idle.blockID;
	}
	
	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}
	
	private void setDefaultDirection(World world, int x, int y, int z)
	{
		if (world.isRemote)
		{
			int l = world.getBlockId(x, y, z - 1); // Block Behind
			int il = world.getBlockId(x, y, z + 1); // Block Front
			int jl = world.getBlockId(x - 1, y, z); // Block Left
			int kl = world.getBlockId(x + 1, y, z); // Block Right
			byte b0 = 3;
			
			if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[il])
			{
				b0 = 3;
			}
			if (Block.opaqueCubeLookup[il] && !Block.opaqueCubeLookup[l])
			{
				b0 = 2;
			}
			if (Block.opaqueCubeLookup[kl] && !Block.opaqueCubeLookup[jl])
			{
				b0 = 5;
			}
			if (Block.opaqueCubeLookup[jl] && !Block.opaqueCubeLookup[kl])
			{
				b0 = 4;
			}
			
			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		}
	}
	
    /**
     * Called when the block is placed in the world.
     */
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack)
	{
		int l = MathHelper.floor_double((double)(entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		
		if (l == 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		if (l == 1)
		{
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
		if (l == 2)
		{
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		if (l == 3)
		{
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
		if (itemStack.hasDisplayName())
		{
			((TileEntity_2_WeaponForge)world.getBlockTileEntity(x, y, z)).setCustomName(itemStack.getDisplayName());
		}
	}
}
