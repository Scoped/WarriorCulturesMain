package WarriorCulturesMain.Scoped.com.github.block;

import net.minecraft.block.Block;
import WarriorCulturesMain.Scoped.com.github.WarriorCultures_Main;
import WarriorCulturesMain.Scoped.com.github.lib.BlockIDs;
import WarriorCulturesMain.Scoped.com.github.lib.Resources;
import WarriorCulturesMain.Scoped.com.github.lib.Strings;


public class ModBlocks
{
	public static Block MetaMineralBlocks;
	public static Block MetaOreBlocks;
	
	public static Block largeCraftingTable;
	
	public static Block WeaponForge_Idle;
	public static Block WeaponForge_Active;
	
	public static Block WeaponForge_2_Idle;
	public static Block WeaponForge_2_Active;
	
	public static void BlocksInit()
	{
		MetaOreBlocks = new Block_Meta_OreBlocks(BlockIDs.BLOCK_META_OREBLOCKS_ID);
		MetaMineralBlocks = new Block_Meta_MineralBlocks(BlockIDs.BLOCK_META_MINERALBLOCKS_ID);
		
		WeaponForge_Idle = new Block_WeaponForge(BlockIDs.BLOCK_WEAPONFORGE_IDLE_ID, false, Resources.textureLocation_WeaponForge_Idle).setUnlocalizedName(Strings.BLOCK_WEAPONFORGE_IDLE_NAME).setHardness(3.5F).setCreativeTab(WarriorCultures_Main.TabWCC);
		WeaponForge_Active = new Block_WeaponForge(BlockIDs.BLOCK_WEAPONFORGE_ACTIVE_ID, true, Resources.textureLocation_WeaponForge_Active).setUnlocalizedName(Strings.BLOCK_WEAPONFORGE_ACTIVE_NAME).setHardness(3.5F).setLightValue(0.9F);
		
		WeaponForge_2_Idle = new Block_2_WeaponForge(BlockIDs.BLOCK_WEAPONFORGE_2_IDLE_ID, false).setUnlocalizedName(Strings.BLOCK_WEAPONFORGE_2_IDLE_NAME).setHardness(3.5F).setCreativeTab(WarriorCultures_Main.TabWCC);
		WeaponForge_2_Active = new Block_2_WeaponForge(BlockIDs.BLOCK_WEAPONFORGE_2_ACTIVE_ID, true).setUnlocalizedName(Strings.BLOCK_WEAPONFORGE_2_ACTIVE_NAME).setHardness(3.5F).setLightValue(0.9F);
		
		largeCraftingTable = new Block_LargeCraftingTable(BlockIDs.BLOCK_LARGECRAFTINGTABLE_ID);
		
	}
}
