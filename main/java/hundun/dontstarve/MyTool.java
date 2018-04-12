package hundun.dontstarve;

import hundun.dontstarve.creativetab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class MyTool {

	public static void  generalSet(Block in){
		in.setUnlocalizedName(DontStarve.MODID+"."+((IModName)in).getName());
		in.setRegistryName(DontStarve.MODID,((IModName) in).getName());
		in.setCreativeTab(CreativeTabsLoader.tabDontStarve);
	}
	
	public static void generalSet(Item in){
		in.setUnlocalizedName(DontStarve.MODID+"."+((IModName)in).getName());
		in.setRegistryName(DontStarve.MODID,((IModName) in).getName());
		in.setCreativeTab(CreativeTabsLoader.tabDontStarve);
	}
}
