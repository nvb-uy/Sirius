package agnya.sirius.api.registry;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item.Settings;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BRegistry {
    /* Registers a block and its item
     *  Simplest approach is to add one of these methods inside your block's class
     *  And add the arguments to the constructor of your block, avoiding using the Registry
     */

    public static void regFullBlock(String modid, String blockid, Block block, Settings settings) {
        Registry.register(Registry.BLOCK, new Identifier(modid, blockid), block);
        Registry.register(Registry.ITEM, new Identifier(modid, blockid), new BlockItem(block, settings));
    }
}