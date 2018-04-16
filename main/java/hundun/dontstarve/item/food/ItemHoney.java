package hundun.dontstarve.item.food;

import hundun.dontstarve.MyTool;
import hundun.dontstarve.IModName;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemHoney extends ItemFood implements IModName
{
    public ItemHoney()
    {
        super(0, 0, false);
        MyTool.generalSet(this);
        setPotionEffect(new PotionEffect(Potion.getPotionById(6), 30, 0), 1.0F);
        setAlwaysEdible();
        
    }

	@Override
	public String getName() {
		return "honey";
	}
    
    
}
