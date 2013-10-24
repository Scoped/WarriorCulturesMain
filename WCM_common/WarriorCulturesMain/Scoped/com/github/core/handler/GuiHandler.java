package WarriorCulturesMain.Scoped.com.github.core.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import WarriorCulturesMain.Scoped.com.github.block.ModBlocks;
import WarriorCulturesMain.Scoped.com.github.core.container.Container_2_WeaponForge;
import WarriorCulturesMain.Scoped.com.github.core.container.Container_PlayerGui;
import WarriorCulturesMain.Scoped.com.github.core.container.Container_WeaponForge;
import WarriorCulturesMain.Scoped.com.github.core.gui.Gui_2_WeaponForge;
import WarriorCulturesMain.Scoped.com.github.core.gui.Gui_PlayerGui;
import WarriorCulturesMain.Scoped.com.github.core.gui.Gui_WeaponForge;
import WarriorCulturesMain.Scoped.com.github.tileEntity.TileEntity_2_WeaponForge;
import WarriorCulturesMain.Scoped.com.github.tileEntity.TileEntity_PlayerGui;
import WarriorCulturesMain.Scoped.com.github.tileEntity.TileEntity_WeaponForge;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		
		switch(id)
		{
			case 0: return id == 0 && (world.getBlockId(x, y, z) == ModBlocks.WeaponForge_Idle.blockID || world.getBlockId(x, y, z) == ModBlocks.WeaponForge_Active.blockID) ? new Container_WeaponForge(player.inventory, (TileEntity_WeaponForge)tile_entity, world, x, y, z) : null;
			case 1: return id == 1 && (world.getBlockId(x, y, z) == ModBlocks.WeaponForge_2_Idle.blockID || world.getBlockId(x, y, z) == ModBlocks.WeaponForge_2_Active.blockID) ? new Container_2_WeaponForge(player.inventory, (TileEntity_2_WeaponForge) tile_entity, world, x, y, z) : null;
			case 2: return new Container_PlayerGui(player.inventory, (TileEntity_PlayerGui) tile_entity, player, false, world, x, y, z);
		}
		
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		switch(id)
		{
			case 0: return id == 0 && (world.getBlockId(x, y, z) == ModBlocks.WeaponForge_Idle.blockID || world.getBlockId(x, y, z) == ModBlocks.WeaponForge_Active.blockID) ? new Gui_WeaponForge(player.inventory, (TileEntity_WeaponForge)tile_entity, world, x, y, z) : null;
			case 1: return id == 1 && (world.getBlockId(x, y, z) == ModBlocks.WeaponForge_2_Idle.blockID || world.getBlockId(x, y, z) == ModBlocks.WeaponForge_2_Active.blockID) ? new Gui_2_WeaponForge(player.inventory, (TileEntity_2_WeaponForge) tile_entity, world, x, y, z) : null;
			case 2: return new Gui_PlayerGui(player.inventory, (TileEntity_PlayerGui) tile_entity, player, false, world, z, z, z);
		}
		
		return null;
	}
}
