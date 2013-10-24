package WarriorCulturesMain.Scoped.com.github.core.handler;

import java.util.EnumSet;

import net.minecraft.client.settings.KeyBinding;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class WCMain_keyBind extends KeyHandler
{
	private EnumSet tickTypes = EnumSet.of(TickType.CLIENT);
	public static boolean keyHasBeenPressed = false;
	public static boolean keyPressed = false;
	
	public WCMain_keyBind(KeyBinding[] keyBindings, boolean[] repeatings)
	{
		super(keyBindings, repeatings);
	}
	
	public String getLabel()
	{
		return "TutorialKey";
	}
	
	public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat)
	{
		keyPressed = true;
	}
	
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd)
	{
		keyPressed = false;
	}
	
	public EnumSet<TickType> ticks()
	{
		return tickTypes;
	}
	
}
