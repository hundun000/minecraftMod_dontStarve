package hundun.dontstarve.tileEntity;

import hundun.dontstarve.DontStarve;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityLoader {
	
	public TileEntityLoader(FMLPreInitializationEvent event)
    {
        registerTileEntity(TileEntityMetalFurnace.class, "MetalFurnace");
    }
	
	
	
    public void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String id)
    {
        GameRegistry.registerTileEntity(tileEntityClass, DontStarve.MODID + ":" + id);
    }

}
