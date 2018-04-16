package hundun.dontstarve.item.food;

import hundun.dontstarve.IModName;
import hundun.dontstarve.MyTool;
import net.minecraft.item.ItemFood;

public class ItemTallBirdEgg extends ItemFood implements IModName{
	
	public ItemTallBirdEgg()
    {
        super(4, 0.6F, false);
        
		MyTool.generalSet(this);
		
		setAlwaysEdible();

    }

	@Override
	public String getName() {
		return "tall_bird_egg";
	}

}
