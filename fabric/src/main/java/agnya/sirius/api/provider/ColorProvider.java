package agnya.sirius.api.provider;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;

public class ColorProvider {
    
    @Deprecated
    public static int get(String color) {
        /* Turns a string of the provider into an integer usable in the register method
         * 
         * "grass", "foliage", "water"
         */
         
        switch(color) {
            case "grass": return 0;
            case "foliage": return 1;
            case "water": return 2;
        }
        return -1;
    }

    public static final int GRASS_COLOR = 0; public static final int FOLIAGE_COLOR = 1; public static final int WATER_COLOR = 2;
    
    private static int type(int colorid, BlockRenderView view, BlockPos pos) {
        switch(colorid) {
            case 0: return BiomeColors.getGrassColor(view, pos);
            case 1: return BiomeColors.getFoliageColor(view, pos);
            case 2: return BiomeColors.getWaterColor(view, pos);
        }
        return -1;
    }
    public static void Register(Block blocks[], int color) {
        /* Registers a color provider for multiple blocks inside an array
         * This applies for both blocks and blockitems.
         * 
         * Example use to register grass color:
         *  ColorProvider.Register(MyTintedBlocks[], ColorProvider.GRASS_COLOR);
         */
        for (int i = 0; i < blocks.length; i++) {
            ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) 
                -> type(color, view, pos)
                , blocks[i]);
            
            ColorProviderRegistry.ITEM.register((stack, tintIndex) 
                -> 0x72b06a
                , blocks[i]);
        }
    }
}

