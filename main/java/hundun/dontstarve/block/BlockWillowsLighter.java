package hundun.dontstarve.block;

import hundun.dontstarve.DontStarve;
import hundun.dontstarve.MyTool;
import hundun.dontstarve.IModName;
import hundun.dontstarve.creativetab.CreativeTabsLoader;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockWillowsLighter extends BlockTorch implements IModName{
	
	public BlockWillowsLighter()
    {
        super();
        
		MyTool.generalSet(this);
		
        setLightLevel(8.0f);
    }

	@Override
	public String getName() {
		return "Willows_Lighter";
	}
	
	@Override
	public boolean canPlaceBlockAt(World world, BlockPos pos){
		return false;
	}
}
