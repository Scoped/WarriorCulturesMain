package WarriorCulturesMain.Scoped.com.github.tileEntitySpecialRenderer;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import WarriorCulturesMain.Scoped.com.github.block.Block_WeaponForge;
import WarriorCulturesMain.Scoped.com.github.lib.Reference;
import WarriorCulturesMain.Scoped.com.github.models.Model_WeaponForge;
import WarriorCulturesMain.Scoped.com.github.tileEntity.TileEntity_2_WeaponForge;

public class TESR_2_WeaponForge extends TileEntitySpecialRenderer
{
	private static final float pixelSize = 0.0625f;
	public Model_WeaponForge model = new Model_WeaponForge();
	
	TileEntity_2_WeaponForge weaponForgeTileEntity;
	static Block_WeaponForge weaponForgeBlock;
	
	private static final ResourceLocation textureLocation = new ResourceLocation(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), "textures/entity/WeaponForge.png"));
	private static final ResourceLocation textureLocation1 = new ResourceLocation(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), "textures/entity/WeaponForge_Active.png"));
	
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float partialTickTime)
	{
		renderWeaponForgeAt((TileEntity_2_WeaponForge)tileEntity, x, y, z, partialTickTime);
	}
	
	public void renderWeaponForgeAt(TileEntity_2_WeaponForge tileEntity, double x, double y, double z, float partialTickTime)
	{
		int i = 0;
		
		if (tileEntity.worldObj != null)
		{
			i = (tileEntity.worldObj.getBlockMetadata(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord));
		}
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 8 * pixelSize, (float)y + 24 * pixelSize, (float)z + 8 * pixelSize);
		
		GL11.glRotatef(180, 1, 0, 0);
		
		this.func_110628_a(textureLocation);
		
		this.model.Shape1.render(pixelSize);
		this.model.Shape2.render(pixelSize);
		this.model.Shape3.render(pixelSize);
		this.model.Shape4.render(pixelSize);
		this.model.Shape5.render(pixelSize);
		this.model.Shape6.render(pixelSize);
		this.model.Shape7.render(pixelSize);
		
		GL11.glPopMatrix();
	}
}
