package hundun.dontstarve.item;

import hundun.dontstarve.MyTool;
import hundun.dontstarve.IModName;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ItemButterflyWings extends ItemFood implements IModName
{
    public ItemButterflyWings()
    {
        super(0, 4.0F, false);
        MyTool.generalSet(this);
        setPotionEffect(new PotionEffect(Potion.getPotionById(6), 1, 1), 1.0F);
        setAlwaysEdible();
        
    }

	@Override
	public String getName() {
		return "butterfly_wings";
	}
    
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack par1ItemStack, World par2World,
	        EntityPlayer par3EntityPlayer, EnumHand hand) {
	    if (!par2World.isRemote) {
	        EntityTNTPrimed entity = new EntityTNTPrimed(par2World, par3EntityPlayer.posX,
	                par3EntityPlayer.posY + par3EntityPlayer.getEyeHeight(), par3EntityPlayer.posZ, par3EntityPlayer);// getEyeHeight方法是获取物体的"眼高",即头部到脚底的距离

	        par2World.spawnEntityInWorld(entity); // 放置实体咯
	    }
	    return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, par1ItemStack);
	}
	
    
}
