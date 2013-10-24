package WarriorCulturesMain.Scoped.com.github.creativeTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import WarriorCulturesMain.Scoped.com.github.item.ModItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabWCM extends CreativeTabs
{
	public TabWCM(int id, String name)
	{
		super(id, name);
	}
	
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack()
	{
		return new ItemStack(ModItems.ForgeTools, 1);
	}
}
