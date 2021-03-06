package WarriorCulturesMain.Scoped.com.github.core.handler;

import WarriorCulturesMain.Scoped.com.github.core.helper.LocalizationHelper;
import WarriorCulturesMain.Scoped.com.github.lib.Localizations;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class LocalizationHandler
{
	public static void loadLanguages()
	{
		for(String LocalizationFile : Localizations.localFiles)
		{
			LanguageRegistry.instance().loadLocalization(LocalizationFile, LocalizationHelper.getLocalFromFileName(LocalizationFile), LocalizationHelper.isXMLFile(LocalizationFile));
		}
	}
}
