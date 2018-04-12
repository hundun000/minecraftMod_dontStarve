package hundun.dontstarve.entity;

import hundun.dontstarve.IModName;
import hundun.dontstarve.item.ItemLoader;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityButterfly extends EntityBat{

	public EntityButterfly(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
    }
	
	
	@Override
    protected void dropFewItems(boolean arg1, int arg2)
    {
        if (this.rand.nextInt(10) == 0)
        {
            this.dropItem(ItemLoader.butterflyWings, 1);
        }
        super.dropFewItems(arg1, arg2);
    }
	
	


}
