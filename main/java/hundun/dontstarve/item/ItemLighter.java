package hundun.dontstarve.item;

import hundun.dontstarve.IModName;
import hundun.dontstarve.MyTool;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFlintAndSteel;

public class ItemLighter extends ItemFlintAndSteel implements IModName{
	public ItemLighter() {
		//not call super
		
		MyTool.generalSet(this);
		
		this.maxStackSize = 1;
        //this.setMaxDamage(64);
	}

	@Override
	public String getName() {
		return "lighter";
	}
	
	
	
}
