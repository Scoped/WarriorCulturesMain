package WarriorCulturesMain.Scoped.com.github.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import WarriorCulturesMain.Scoped.com.github.WarriorCultures_Main;
import WarriorCulturesMain.Scoped.com.github.core.handler.WCMain_keyBind;
import WarriorCulturesMain.Scoped.com.github.lib.Strings;

public class Item_Tool_SteelScyth extends Super_Item_Hoe
{
	
	public Item_Tool_SteelScyth(int par1, EnumToolMaterial par3EnumToolMaterial)
	{
		super(par1, par3EnumToolMaterial);
        this.maxStackSize = 1;
		this.setUnlocalizedName(Strings.ITEM_TOOL_STEELSCYTHE_NAME);
	}
	
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int i, boolean par1)
	{
		EntityPlayer player = (EntityPlayer)entity;
		
		if (WCMain_keyBind.keyPressed)
		{
			player.openGui(WarriorCultures_Main.instance, 2, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
		}
	}
}
