package hundun.dontstarve.item;

import hundun.dontstarve.DontStarve;
import hundun.dontstarve.MyTool;
import hundun.dontstarve.IModName;
import hundun.dontstarve.creativetab.CreativeTabsLoader;
import net.minecraft.item.Item;

public class ItemRope extends Item implements IModName{
	
	public ItemRope()
    {
        super();
        MyTool.generalSet(this);
    }
	
	@Override
	public String getName() {
		return "rope";
	}

}
