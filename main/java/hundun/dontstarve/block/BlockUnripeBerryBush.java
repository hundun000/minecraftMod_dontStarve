package hundun.dontstarve.block;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import hundun.dontstarve.MyTool;
import hundun.dontstarve.IModName;
import hundun.dontstarve.item.ItemLoader;
import hundun.dontstarve.material.MaterialLoader;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockUnripeBerryBush extends BlockBush implements IModName{

	public BlockUnripeBerryBush(){
		super(MaterialLoader.barrenableMaterial);
		MyTool.generalSet(this);
		setHarvestLevel("shovel",1);
		setHardness(3.0F);
	}
	
	/**
     * Get the Item that this Block should drop when harvested.
     */
    @Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return BlockLoader.barrenBerryBush.getItemDropped(state, rand, fortune);
    }
	
	@Override
	public String getName() {
		return "unripe_berry_bush";
	}


	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            super.updateTick(worldIn, pos, state, rand);

            if(rand.nextInt(40) == 0)
        		worldIn.setBlockState(pos,BlockLoader.barrenBerryBush.getDefaultState());// 任何光照下 1/40概率自然枯萎
            else if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(5) == 0)
            {
            	worldIn.setBlockState(pos,BlockLoader.berryBush.getDefaultState());	// 阳光下1/5概率成熟
            }
        }
    }
	
	
	
}
