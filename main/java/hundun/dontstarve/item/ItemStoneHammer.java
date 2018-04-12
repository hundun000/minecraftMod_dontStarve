package hundun.dontstarve.item;

import java.util.HashSet;
import java.util.Set;

import hundun.dontstarve.MyTool;
import hundun.dontstarve.IModName;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ItemStoneHammer extends ItemTool implements IModName{
	
	public ItemStoneHammer() {
		//调用基类的构造函数,参数分别是攻击实体(Entity)造成的伤害加成,
        //                 挥动时的冷却加成(正数减小冷却,负数增加冷却,但建议不要小于或等于-4),
        //                 工具材质(ToolMaterial),能被这种工具加速挖掘的砖块.
        //其中,第四个参数是原版MC用的,使用Forge的可以无视.
		super(4.0F, -1.0F, ToolMaterial.STONE, new HashSet());
		MyTool.generalSet(this);
				
        setHarvestLevel("hammer", 1);
        setMaxDamage(64); //设置最大耐久度,0的话即为永不损坏
	}

		
		@Override
		public String getName() {
			return "stone_hammer";
		}

}
