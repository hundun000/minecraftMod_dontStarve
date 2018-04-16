package hundun.dontstarve.item;


import hundun.dontstarve.DontStarve;
import hundun.dontstarve.MyTool;
import hundun.dontstarve.IModName;
import hundun.dontstarve.creativetab.CreativeTabsLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;
import net.minecraftforge.common.util.EnumHelper;

public class ItemRazor extends ItemShears implements IModName{
	

    public ItemRazor()
    {
        MyTool.generalSet(this);
        
        /* 
         * 剪刀并不拥有“工具材质”属性，所以“石质剪刀”不能通过修改材质实现。但可以直接改小其耐久度模拟石质效果。
         */
        setMaxStackSize(1);
        setMaxDamage(7);
    }

	@Override
	public String getName() {
		return "razor";
	}

}
