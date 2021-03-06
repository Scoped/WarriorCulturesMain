package WarriorCulturesMain.Scoped.com.github.block;

import WarriorCulturesMain.Scoped.com.github.lib.Reference;
import WarriorCulturesMain.Scoped.com.github.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockWCMain_Block extends Block
{
	public BlockWCMain_Block (int id, Material material)
	{
		super(id, material);
		this.setUnlocalizedName(Strings.CORE_BLOCKWCM_NAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	
    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
	
	public void registerIcons(IconRegister register)
	{
		blockIcon = register.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
	}
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	{
		return unlocalizedName.substring(unlocalizedName.indexOf(".")+1);
	}
}
