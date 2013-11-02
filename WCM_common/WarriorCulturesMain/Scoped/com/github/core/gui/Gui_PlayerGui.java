package WarriorCulturesMain.Scoped.com.github.core.gui;

import java.util.Collection;
import java.util.Iterator;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import WarriorCulturesMain.Scoped.com.github.core.container.Container_PlayerGui;
import WarriorCulturesMain.Scoped.com.github.lib.Reference;
import WarriorCulturesMain.Scoped.com.github.tileEntity.TileEntity_PlayerGui;

public class Gui_PlayerGui extends GuiContainer
{
	public static final ResourceLocation texture = new ResourceLocation(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), "textures/gui/PlayerGui.png"));
    private boolean field_74222_o;
	TileEntity_PlayerGui tileEntity;
	
	public Gui_PlayerGui(InventoryPlayer inventoryPlayer, TileEntity_PlayerGui tileEntity, EntityPlayer entityPlayer, boolean par3, World world, int x, int y, int z)
	{
		super(new Container_PlayerGui(inventoryPlayer, tileEntity, entityPlayer, par3, world, x, y, z));
		
		this.tileEntity = tileEntity;
		
		this.xSize = 174;
		this.ySize = 244;
	}
	
	public void drawGuiContainerForegroundLayer(int i, int j)
	{
		
	}
	
	public void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		
		/*Drawing the player*/
		GuiInventory.func_110423_a(k + 131, l + 115, 40, (float)(k + 51) - this.xSize, (float)(l + 75 - 50) - this.ySize, this.mc.thePlayer);
	}
	
    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        super.initGui();

        if (!this.mc.thePlayer.getActivePotionEffects().isEmpty())
        {
            this.guiLeft = 160 + (this.width - this.xSize - 200) / 2;
            this.field_74222_o = true;
        }
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
        super.drawScreen(par1, par2, par3);

        if (this.field_74222_o)
        {
            this.displayDebuffEffects();
        }
    }
    
    /**
     * Displays debuff/potion effects that are currently being applied to the player
     */
    private void displayDebuffEffects()
    {
		int i = ((this.width - this.xSize) / 2) - 124;
		int j = (this.height - this.ySize) / 2;
        boolean flag = true;
        Collection collection = this.mc.thePlayer.getActivePotionEffects();

        if (!collection.isEmpty())
        {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(GL11.GL_LIGHTING);
            int k = 33;

            if (collection.size() > 5)
            {
                k = 132 / (collection.size() - 1);
            }

            for (Iterator iterator = this.mc.thePlayer.getActivePotionEffects().iterator(); iterator.hasNext(); j += k)
            {
                PotionEffect potioneffect = (PotionEffect)iterator.next();
                Potion potion = Potion.potionTypes[potioneffect.getPotionID()];
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                this.mc.getTextureManager().bindTexture(field_110408_a);
                this.drawTexturedModalRect(i, j, 0, 166, 140, 32);

                if (potion.hasStatusIcon())
                {
                    int l = potion.getStatusIconIndex();
                    this.drawTexturedModalRect(i + 6, j + 7, 0 + l % 8 * 18, 198 + l / 8 * 18, 18, 18);
                }

                String s = I18n.getString(potion.getName());

                if (potioneffect.getAmplifier() == 1)
                {
                    s = s + " II";
                }
                else if (potioneffect.getAmplifier() == 2)
                {
                    s = s + " III";
                }
                else if (potioneffect.getAmplifier() == 3)
                {
                    s = s + " IV";
                }

                this.fontRenderer.drawStringWithShadow(s, i + 10 + 18, j + 6, 16777215);
                String s1 = Potion.getDurationString(potioneffect);
                this.fontRenderer.drawStringWithShadow(s1, i + 10 + 18, j + 6 + 10, 8355711);
            }
        }
    }
}
