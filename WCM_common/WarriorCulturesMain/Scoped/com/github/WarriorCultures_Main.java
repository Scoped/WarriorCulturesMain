package WarriorCulturesMain.Scoped.com.github;

import java.io.File;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.common.EnumHelper;

import org.lwjgl.input.Keyboard;

import WarriorCulturesMain.Scoped.com.github.block.Block_WeaponForge;
import WarriorCulturesMain.Scoped.com.github.block.ModBlocks;
import WarriorCulturesMain.Scoped.com.github.core.handler.BlockRegistry;
import WarriorCulturesMain.Scoped.com.github.core.handler.ConfigurationHandler;
import WarriorCulturesMain.Scoped.com.github.core.handler.GuiHandler;
import WarriorCulturesMain.Scoped.com.github.core.handler.LocalizationHandler;
import WarriorCulturesMain.Scoped.com.github.core.handler.ModRecipes;
import WarriorCulturesMain.Scoped.com.github.core.handler.WCMain_keyBind;
import WarriorCulturesMain.Scoped.com.github.core.handler.WeaponForgeCraftingManager;
import WarriorCulturesMain.Scoped.com.github.core.proxy.CommonProxy;
import WarriorCulturesMain.Scoped.com.github.creativeTab.TabWCM;
import WarriorCulturesMain.Scoped.com.github.item.ModItems;
import WarriorCulturesMain.Scoped.com.github.lib.Reference;
import WarriorCulturesMain.Scoped.com.github.lib.Strings;
import WarriorCulturesMain.Scoped.com.github.tileEntity.TileEntity_WeaponForge;
import WarriorCulturesMain.Scoped.com.github.tileEntitySpecialRenderer.TESR_WeaponForge;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

	@Mod(
		modid = Reference.MOD_ID ,
		name = Reference.MOD_NAME,
		version = Reference.VERSION)
	
	@NetworkMod(
		channels = (Reference.CHANNEL_NAME),
		serverSideRequired = false,
		clientSideRequired = true)

public class WarriorCultures_Main
{
	@Instance(Reference.MOD_ID)
		public static WarriorCultures_Main instance;
	
	@SidedProxy(
		clientSide = Reference.CLIENT_PROXY_LOCATION,
		serverSide = Reference.COMMON_PROXY_LOCATION)
	
	public static CommonProxy proxy;
	
	private GuiHandler guiHandler = new GuiHandler();
	
	/**
	 * CreativeTab
	 */
	public static CreativeTabs TabWCC = new TabWCM(CreativeTabs.getNextID(), Strings.TAB_WCM_NAME);
	
	/**
	 * EnumToolMaterial
	 * String: name (WOOD, STONE, IRON, GOLD, DIAMOND)
	 * First int: harvest level (0 = WOOD/GOLD, 1 = STONE, 2 = IRON, 3 = DIAMOND)
	 * Second int: number of uses (wood = 59, gold = 32, stone = 131, iron = 250, diamond = 1561)
	 * First float: block breaking speed (2.0F, 12.0F, 4.0F, 6.0F, 8.0F)
	 * Second float: damage vs entities (0.0F, 0.0F, 1.0F, 2.0F, 3.0F,)
	 * Third int: enchantability (15, 22, 5, 14, 10)
	 */
	public static EnumToolMaterial WCM_Steel = EnumHelper.addToolMaterial("STEEL", 2, 500, 7.0F, 3.0F, 12);
	
	@EventHandler //@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		LocalizationHandler.loadLanguages();
		
		ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsoluteFile() + File.separator + Reference.MOD_ID + File.separator + Reference.MOD_ID + ".cfg"));
		
		ModBlocks.BlocksInit();
		
		BlockRegistry.blockRegistry();
		
		ModItems.ItemInit();
		
		GuiHandler guiHandler = new GuiHandler();
		
		ModRecipes.recipesInit();
		
		GameRegistry.registerCraftingHandler(new WeaponForgeCraftingManager());
		
		//ForgeHooksClient.renderEquippedItem(-1, TESR_WeaponForge.class, Block_WeaponForge.class, TileEntity_WeaponForge.class, item);
		
		LanguageRegistry.instance().addStringLocalization("container.weaponForge", "Weapon Forge");
		LanguageRegistry.instance().addStringLocalization("container.weaponForge2", "Weapon Forge");
		
	}
	
	@EventHandler //@Init
	public void init(FMLInitializationEvent event)
	{
		  proxy.registerRenderers();
		  NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
		  
		  KeyBinding[] key = {new KeyBinding("Player GUI", Keyboard.KEY_R)};
		  boolean[] repeat = {false};
		  KeyBindingRegistry.registerKeyBinding(new WCMain_keyBind(key, repeat));
	}
	
	@EventHandler //@PostInit
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
