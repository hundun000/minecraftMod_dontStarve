package hundun.dontstarve.block;

import hundun.dontstarve.DontStarve;
import hundun.dontstarve.MyTool;
import hundun.dontstarve.IModName;
import hundun.dontstarve.creativetab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBoulder extends Block implements IModName{
	
	public BlockBoulder()
    {
        super(Material.GROUND);
        
		MyTool.generalSet(this);
        
        setHardness(1.5f);
        setResistance(10.0f);
        setLightLevel(0.0f);
        setHarvestLevel("pickaxe", 0);
        setSoundType(SoundType.STONE);  
    }

	@Override
	public String getName() {
		return "boulder";
	}
	

}
