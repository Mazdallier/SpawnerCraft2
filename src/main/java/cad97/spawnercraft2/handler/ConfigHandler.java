package cad97.spawnercraft2.handler;

import cad97.spawnercraft2.reference.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ConfigHandler
{
	public static Configuration config;

	public static boolean spawnerCraftable;
	public static boolean spawnerDropRequireSilk;

	public static void init(File configFile)
	{
		// Create configuration object from given file
		if (config == null)
		{
			config = new Configuration(configFile);
			loadConfiguration();
		}
	}

	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
		{
			loadConfiguration();
		}
	}

	private static void loadConfiguration()
	{
		spawnerCraftable = config.get(Configuration.CATEGORY_GENERAL, "spawnerCraftable", false, "Whether you can craft an Empty Spawner from iron bars").setRequiresMcRestart(true).getBoolean();
		spawnerDropRequireSilk = config.get(Configuration.CATEGORY_GENERAL,"spawnerDropRequireSilk",  false, "Whether Empty Spawner drop requires Silk Touch").getBoolean();

		if (config.hasChanged())
		{
			config.save();
		}
	}
}
