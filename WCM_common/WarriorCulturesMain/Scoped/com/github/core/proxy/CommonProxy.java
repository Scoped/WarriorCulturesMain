package WarriorCulturesMain.Scoped.com.github.core.proxy;

import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import WarriorCulturesMain.Scoped.com.github.item.ModItems;
import WarriorCulturesMain.Scoped.com.github.lib.ItemIDs;
import WarriorCulturesMain.Scoped.com.github.models.itemRenderer_WeaponForge;
import WarriorCulturesMain.Scoped.com.github.tileEntity.TileEntity_2_WeaponForge;
import WarriorCulturesMain.Scoped.com.github.tileEntity.TileEntity_WeaponForge;
import WarriorCulturesMain.Scoped.com.github.tileEntitySpecialRenderer.TESR_2_WeaponForge;
import WarriorCulturesMain.Scoped.com.github.tileEntitySpecialRenderer.TESR_WeaponForge;
import cpw.mods.fml.client.registry.ClientRegistry;

public class CommonProxy
{
	public void registerRenderers()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntity_WeaponForge.class, new TESR_WeaponForge());
		ClientRegistry.registerTileEntity(TileEntity_WeaponForge.class, "WeaponForge1", new TESR_WeaponForge());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntity_2_WeaponForge.class, new TESR_2_WeaponForge());
		ClientRegistry.registerTileEntity(TileEntity_2_WeaponForge.class, "WeaponForge3", new TESR_2_WeaponForge());
		
		MinecraftForgeClient.registerItemRenderer(ModItems.WeaponForge.itemID, (IItemRenderer)new itemRenderer_WeaponForge());
		
	}
}
