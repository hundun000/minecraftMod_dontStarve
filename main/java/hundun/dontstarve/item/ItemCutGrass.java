package hundun.dontstarve.item;

import hundun.dontstarve.DontStarve;
import hundun.dontstarve.MyTool;
import hundun.dontstarve.IModName;
import hundun.dontstarve.creativetab.CreativeTabsLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;


public class ItemCutGrass extends Item implements IModName{
	
	public ItemCutGrass()
    {
        super();
        MyTool.generalSet(this);
    }
	
	@Override
	public String getName() {
		return "cut_grass";
	}

}
