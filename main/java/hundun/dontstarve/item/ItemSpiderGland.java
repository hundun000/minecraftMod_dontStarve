package hundun.dontstarve.item;

import hundun.dontstarve.DontStarve;
import hundun.dontstarve.MyTool;
import hundun.dontstarve.IModName;
import hundun.dontstarve.creativetab.CreativeTabsLoader;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemSpiderGland extends ItemFood implements IModName
{
    public ItemSpiderGland()
    {
        super(0, 0, false);
        MyTool.generalSet(this);
        setPotionEffect(new PotionEffect(Potion.getPotionById(6), 1, 1), 1.0F);
        setAlwaysEdible();
        
    }

	@Override
	public String getName() {
		return "spider_gland";
	}
    
    
}
