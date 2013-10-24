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
	
	public static void ItemInit()
	{
		IngotValuables = new Item_Items_OreValuables(ItemIDs.ITEM_ITEMS_OREVALUABLES_ID).setUnlocalizedName("Ingot").func_111206_d("Ignot");
		RockValuables = new Item_Items_RockValuables(ItemIDs.ITEM_ITEMS_ROCKVALUABLES_ID).setUnlocalizedName("Rock").func_111206_d("");
		WCCTool_Heads = new Item_Tools_WCMToolHeads(ItemIDs.ITEM_TOOLS_WCMTOOLHEADS_ID).setUnlocalizedName("Steel").func_111206_d("Steel");
		
		SteelPickAxe = new Item_Tool_SteelPickAxe(ItemIDs.ITEM_TOOL_STEELPICKAXE_ID, WarriorCultures_Main.WCM_Steel);
		SteelHatchet = new Item_Tool_SteelHatchet(ItemIDs.ITEM_TOOL_STEELHATCHET_ID, WarriorCultures_Main.WCM_Steel);
		SteelScyth = new Item_Tool_SteelScyth(ItemIDs.ITEM_TOOL_STEELSCYTHE_ID, WarriorCultures_Main.WCM_Steel);
		SteelShovel = new Item_Tool_SteelShovel(ItemIDs.ITEM_TOOL_STEELSHOVEL_ID, WarriorCultures_Main.WCM_Steel);
		
		ForgeTools = new Item_Tools_ForgeTools(ItemIDs.ITEM_TOOLS_FORGETOOLS_ID).setUnlocalizedName("Forge").func_111206_d("Forge");
	};
}
