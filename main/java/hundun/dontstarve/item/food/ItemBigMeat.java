package hundun.dontstarve.item.food;

import hundun.dontstarve.IModName;
import hundun.dontstarve.MyTool;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemBigMeat extends ItemFood implements IModName{
	public ItemBigMeat()
    {
        super(4, 0.6F, true);
        
		MyTool.generalSet(this);
		setAlwaysEdible();
    }

	@Override
	public String getName() {
		return "big_meat";
	}

}
