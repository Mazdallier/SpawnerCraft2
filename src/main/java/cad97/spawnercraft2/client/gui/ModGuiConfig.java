package cad97.spawnercraft2.client.gui;

import cad97.spawnercraft2.handler.ConfigHandler;
import cad97.spawnercraft2.reference.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;

public class ModGuiConfig extends GuiConfig
{
	public ModGuiConfig(GuiScreen guiScreen)
	{
		super(guiScreen,
				new ConfigElement(ConfigHandler.config.getCategory(net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL)).getChildElements(),
				Reference.MOD_ID,
				false,
				false,
				GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString())
		);
	}
}
