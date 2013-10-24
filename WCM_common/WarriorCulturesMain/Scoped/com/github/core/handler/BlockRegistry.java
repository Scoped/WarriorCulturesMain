package WarriorCulturesMain.Scoped.com.github.core.handler;

import net.minecraftforge.common.MinecraftForge;
import WarriorCulturesMain.Scoped.com.github.block.ModBlocks;
import WarriorCulturesMain.Scoped.com.github.item.Item_Mineral_MetaMinerals;
import WarriorCulturesMain.Scoped.com.github.item.Item_Ore_MetaOres;
import WarriorCulturesMain.Scoped.com.github.lib.Strings;
import WarriorCulturesMain.Scoped.com.github.tileEntity.TileEntity_2_WeaponForge;
import WarriorCulturesMain.Scoped.com.github.tileEntity.TileEntity_WeaponForge;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegistry
{
	public static void blockRegistry()
	{
		/**
		 * Block Registration
		 */
		GameRegistry.registerBlock(ModBlocks.WeaponForge_Idle, Strings.BLOCK_WEAPONFORGE_IDLE_NAME);
		GameRegistry.registerBlock(ModBlocks.WeaponForge_Active, Strings.BLOCK_WEAPONFORGE_ACTIVE_NAME);
		GameRegistry.registerBlock(ModBlocks.WeaponForge_2_Idle, Strings.BLOCK_WEAPONFORGE_2_IDLE_NAME);
		GameRegistry.registerBlock(ModBlocks.WeaponForge_2_Active, Strings.BLOCK_WEAPONFORGE_2_ACTIVE_NAME);
		
		/**
		 * TileEntity Registration
		 */
		GameRegistry.registerTileEntity(TileEntity_WeaponForge.class, Strings.TILEENTITY_WEAPONFORGE_NAME);
		GameRegistry.registerTileEntity(TileEntity_2_WeaponForge.class, Strings.TILEENTITY_WEAPONFORGE_NAME_2);
		
		/**
		 * ItemBlock Registration
		 */
		GameRegistry.registerBlock(ModBlocks.MetaOreBlocks, Item_Ore_MetaOres.class, Strings.BLOCK_META_ORE_METAORES_NAME);
		GameRegistry.registerBlock(ModBlocks.MetaMineralBlocks, Item_Mineral_MetaMinerals.class, Strings.BLOCK_META_MINERAL_METAMINERALS_NAME);
		
		/**
		 * Block Harvest Level
		 */
		MinecraftForge.setBlockHarvestLevel(ModBlocks.MetaOreBlocks, 0, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(ModBlocks.MetaOreBlocks, 1, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(ModBlocks.MetaOreBlocks, 2, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(ModBlocks.MetaOreBlocks, 3, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(ModBlocks.MetaOreBlocks, 4, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(ModBlocks.MetaOreBlocks, 5, "pickaxe", 2);
	}
}
