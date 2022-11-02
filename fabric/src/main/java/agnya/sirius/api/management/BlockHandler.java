package agnya.sirius.api.management;

import agnya.sirius.api.registry.BRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item.Settings;

public class BlockHandler {
    public static void register(String[] lines, String MODID, Block block, Settings settings) {
    /* Registers blocks from an array of lines. */
    
    for (int i = 0; i < lines.length; i++) {
        if (lines[i] != "$comment") {
            // Register block here.

            BRegistry.regFullBlock(MODID, lines[i], block, settings);
        }
    }
    }
}
