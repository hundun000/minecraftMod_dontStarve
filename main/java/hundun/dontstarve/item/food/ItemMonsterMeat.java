package hundun.dontstarve.item.food;

import hundun.dontstarve.IModName;
import hundun.dontstarve.MyTool;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemMonsterMeat extends ItemFood implements IModName{
	public ItemMonsterMeat()
    {
        super(2, 0.6F, true);
        
		MyTool.generalSet(this);
		setPotionEffect(new PotionEffect(Potion.getPotionById(9), 60, 0), 1.0F);//恶心药水效果
		setAlwaysEdible();
		

    }

	@Override
	public String getName() {
		return "monster_meat";
	}

}
