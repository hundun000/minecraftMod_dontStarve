package hundun.dontstarve.creativetab;

import hundun.dontstarve.DontStarve;
import hundun.dontstarve.item.ItemLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsDontStarve extends CreativeTabs{
	
	public CreativeTabsDontStarve()
    {
        super(DontStarve.MODID);
        setBackgroundImageName("DontStarve.png");
    }

    @Override
    public Item getTabIconItem()
    {
        return ItemLoader.cutGrass;
    }
    
    @Override
    public boolean hasSearchBar()
    {
        return true;
    }

}
