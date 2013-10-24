package WarriorCulturesMain.Scoped.com.github.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import WarriorCulturesMain.Scoped.com.github.lib.Strings;

public class Block_LargeCraftingTable extends BlockWCMain_Block
{
	
	boolean isFormationComplete = false;
	
	public Block_LargeCraftingTable(int id)
	{
		super(id, Material.wood);
		this.setUnlocalizedName(Strings.BLOCK_LARGECRAFTINGTABLE_NAME);
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack)
	{
		/**
		 * When facing north:
		 * X = left and right
		 * y = forwards and backwards
		 */
		int r = world.getBlockId(x + 1, y, z); // Check right
		int l = world.getBlockId(x - 1, y, z); // Check left
		int f = world.getBlockId(x, y, z + 1); // Check front
		int b = world.getBlockId(x, y, z - 1); // Check back
		int fr = world.getBlockId(x + 1, y, z + 1); // Check block to the front right
		int fl = world.getBlockId(x - 1, y, z + 1); // Check block to the front left
		int br = world.getBlockId(x + 1, y, z - 1); // Check block to the behind right
		int bl = world.getBlockId(x - 1, y, z - 1); // Check block to the behind left
		
		int workBenchID = Block.workbench.blockID;
		
		if (world.getBlockId(x, y, z) == workBenchID)
		{
			// Top right
			if (f == workBenchID && r == workBenchID && fr == workBenchID)
			{
				world.setBlock(x, y, z, ModBlocks.largeCraftingTable.blockID);
				world.setBlock(x + 1, y, z, ModBlocks.largeCraftingTable.blockID);
				world.setBlock(x, y, z + 1, ModBlocks.largeCraftingTable.blockID);
				world.setBlock(x + 1, y, z + 1, ModBlocks.largeCraftingTable.blockID);
			}
			// Top left
			else if (f == workBenchID && l == workBenchID && fl == workBenchID)
			{
				world.setBlock(x, y, z, ModBlocks.largeCraftingTable.blockID);
				world.setBlock(x - 1, y, z, ModBlocks.largeCraftingTable.blockID);
				world.setBlock(x, y, z + 1, ModBlocks.largeCraftingTable.blockID);
				world.setBlock(x - 1, y, z + 1, ModBlocks.largeCraftingTable.blockID);
			}
			// Bottom right
			else if (b == workBenchID && r == workBenchID && br == workBenchID)
			{
				world.setBlock(x, y, z, ModBlocks.largeCraftingTable.blockID);
				world.setBlock(x + 1, y, z, ModBlocks.largeCraftingTable.blockID);
				world.setBlock(x, y, z - 1, ModBlocks.largeCraftingTable.blockID);
				world.setBlock(x + 1, y, z - 1, ModBlocks.largeCraftingTable.blockID);
			}
			// Bottom left
			else if (b == workBenchID && l == workBenchID && bl == workBenchID)
			{
				world.setBlock(x, y, z, ModBlocks.largeCraftingTable.blockID);
				world.setBlock(x - 1, y, z, ModBlocks.largeCraftingTable.blockID);
				world.setBlock(x, y, z - 1, ModBlocks.largeCraftingTable.blockID);
				world.setBlock(x - 1, y, z - 1, ModBlocks.largeCraftingTable.blockID);
			}
		}
	}
}
