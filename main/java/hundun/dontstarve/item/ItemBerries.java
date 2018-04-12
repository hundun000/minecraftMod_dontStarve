package hundun.dontstarve.item;

import hundun.dontstarve.DontStarve;
import hundun.dontstarve.MyTool;
import hundun.dontstarve.IModName;
import hundun.dontstarve.common.EventLoader;
import hundun.dontstarve.creativetab.CreativeTabsLoader;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class ItemBerries extends ItemFood implements IModName
{

	
    public ItemBerries()
    {
        super(4, 0.6F, false);
        
		MyTool.generalSet(this);
		
		setAlwaysEdible();
		setMaxDamage(100);
		setMaxStackSize(20);
		

    }

	@Override
	public String getName() {
		return "berries";
	}
    
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		if(EventLoader.ticks==0)
			rot(stack,1);
    }
	
	protected void rot(ItemStack stack,int rotQuantity){
		int damage=getDamage(stack);
		setDamage(stack,damage+rotQuantity);
		System.out.println("发生腐败，腐败度+"+rotQuantity+"，目前腐败度"+damage+rotQuantity);
	}




	
    
}