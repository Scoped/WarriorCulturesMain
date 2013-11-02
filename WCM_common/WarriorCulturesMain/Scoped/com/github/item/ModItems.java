package WarriorCulturesMain.Scoped.com.github.item;

import net.minecraft.item.Item;
import WarriorCulturesMain.Scoped.com.github.WarriorCultures_Main;
import WarriorCulturesMain.Scoped.com.github.lib.ItemIDs;

public class ModItems
{
	
	public static Item IngotValuables;
	public static Item RockValuables;
	
	public static Item WCCTool_Heads;
	
	public static Item SteelHatchet;
	public static Item SteelPickAxe;
	public static Item SteelScyth;
	public static Item SteelShovel;
	
	public static Item ForgeTools;
	
	public static Item WeaponForge;
	
	public static void ItemInit()
	{
		IngotValuables = new Item_Items_OreValuables(ItemIDs.ITEM_ITEMS_OREVALUABLES_ID).setUnlocalizedName("Ingot").setTextureName("Ignot");
		RockValuables = new Item_Items_RockValuables(ItemIDs.ITEM_ITEMS_ROCKVALUABLES_ID).setUnlocalizedName("Rock").setTextureName("");
		WCCTool_Heads = new Item_Tools_WCMToolHeads(ItemIDs.ITEM_TOOLS_WCMTOOLHEADS_ID).setUnlocalizedName("Steel").setTextureName("Steel");
		
		SteelPickAxe = new Item_Tool_SteelPickAxe(ItemIDs.ITEM_TOOL_STEELPICKAXE_ID, WarriorCultures_Main.WCM_Steel);
		SteelHatchet = new Item_Tool_SteelHatchet(ItemIDs.ITEM_TOOL_STEELHATCHET_ID, WarriorCultures_Main.WCM_Steel);
		SteelScyth = new Item_Tool_SteelScyth(ItemIDs.ITEM_TOOL_STEELSCYTHE_ID, WarriorCultures_Main.WCM_Steel);
		SteelShovel = new Item_Tool_SteelShovel(ItemIDs.ITEM_TOOL_STEELSHOVEL_ID, WarriorCultures_Main.WCM_Steel);
		
		ForgeTools = new Item_Tools_ForgeTools(ItemIDs.ITEM_TOOLS_FORGETOOLS_ID).setUnlocalizedName("Forge").setTextureName("Forge");
		
		WeaponForge = new Item_Model_Sword_WeaponForge(ItemIDs.ITEM_MODEL_SWORD_WEAPONFORGE_ID);
	};
}
