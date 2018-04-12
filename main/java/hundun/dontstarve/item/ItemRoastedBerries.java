package hundun.dontstarve.item;

import hundun.dontstarve.DontStarve;
import hundun.dontstarve.MyTool;
import hundun.dontstarve.IModName;
import hundun.dontstarve.creativetab.CreativeTabsLoader;
import net.minecraft.item.ItemFood;

public class ItemRoastedBerries extends ItemFood implements IModName
{
    public ItemRoastedBerries()
    {
        super(8, 0.6F, false);
        MyTool.generalSet(this);
        
        setAlwaysEdible();

    }

	@Override
	public String getName() {
		return "roasted_berries";
	}
    
    
}