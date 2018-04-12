package hundun.dontstarve.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CreativeTabsLoader {
	
	public static CreativeTabs tabDontStarve;
	
    public CreativeTabsLoader(FMLPreInitializationEvent event)
    {
    	tabDontStarve = new CreativeTabsDontStarve();
    }

}
