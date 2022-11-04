package agnya.sirius.api;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Loader implements ModInitializer {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("sirius-api");

	@Override
	public void onInitialize() {
		LOGGER.info("Sirius API loaded!");
	}
}
