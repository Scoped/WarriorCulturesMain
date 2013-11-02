package WarriorCulturesMain.Scoped.com.github.models;

import org.lwjgl.opengl.GL11;

import WarriorCulturesMain.Scoped.com.github.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class itemRenderer_WeaponForge implements IItemRenderer
{
	
	protected Model_WeaponForge weaponForgeModel;
	private static final ResourceLocation textureLocation = new ResourceLocation(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), "textures/entity/WeaponForge.png"));

	public itemRenderer_WeaponForge()
	{
		weaponForgeModel = new Model_WeaponForge();
	}
	
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		switch(type)
		{
			case EQUIPPED:
				{
					return true;
				}
			default:
				{
					return false;
				}
		}
	}
	
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return false;
	}
	
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		float scale= 1.0F;
		
		switch(type)
		{
			case EQUIPPED: 
			{
				GL11.glPushMatrix();
				
				Minecraft.getMinecraft().renderEngine.bindTexture(textureLocation);
				
				GL11.glScalef(scale, scale, scale);
				GL11.glRotatef(1.0F, 1.0F, 1.0F, 1.0F);
				
				boolean isFirstPerson = false;
				
				weaponForgeModel.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				
				GL11.glPopMatrix();
			}
			default:
				break;
		}
	}
	
}
