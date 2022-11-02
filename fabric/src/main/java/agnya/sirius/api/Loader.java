package agnya.sirius.api;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import agnya.sirius.api.management.config.ConfigMaker;

public class Loader implements ModInitializer {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("sirius-api");

	@Override
	public void onInitialize() {
		LOGGER.info("Sirius API loaded!");

		ConfigMaker.setup("phantasm");
		ConfigMaker.create("phantasm", "config", "cfg");

		ConfigMaker.readLines("phantasm", "config", "cfg");
	}
}
