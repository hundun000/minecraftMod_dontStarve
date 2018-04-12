package hundun.dontstarve;

import hundun.dontstarve.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = DontStarve.MODID, name = DontStarve.NAME, version = DontStarve.VERSION, acceptedMinecraftVersions = "1.9.4")
public class DontStarve {
	
	public static final String MODID = "dontstarve";
    public static final String NAME = "Don't Starve";
    public static final String VERSION = "1.0.0";
    
    
    @Instance(DontStarve.MODID)
    public static DontStarve instance;

    @SidedProxy(clientSide = "hundun.dontstarve.client.ClientProxy", serverSide = "hundun.dontstarve.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }

}
