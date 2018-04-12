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
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBarrenBerryBush  extends BlockBush implements IModName,IGrowable{

	public BlockBarrenBerryBush(){
		super(MaterialLoader.barrenableMaterial);
		MyTool.generalSet(this);
		setHarvestLevel("shovel",1);
		setHardness(3.0F);
	}
		
	
	@Override
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
    {
		System.out.println("触发了打坏枯萎浆果丛事件");	        	    	
    	if (!worldIn.isRemote) {
    		breaken(worldIn, pos, state);
        }
    }
	
	
	private void breaken(World worldIn, BlockPos pos, IBlockState state) {
        EntityItem entity = new EntityItem(worldIn, pos.getX(), pos.getY(),pos.getZ(), new ItemStack(Items.STICK, 2));	            
        worldIn.spawnEntityInWorld(entity); // 放置实体
        worldIn.destroyBlock(pos, false);	
	}
	
	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}


	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return  (double)worldIn.rand.nextFloat() < 0.8D;  //   0.8概率施肥成功
	}


	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		worldIn.setBlockState(pos,BlockLoader.unripeBerryBush.getDefaultState());		
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            super.updateTick(worldIn, pos, state, rand);


            if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(30) == 0)
            {
            	grow(worldIn, rand, pos, state);	// 阳光下1/30概率成长
            }
        }
    }
	
    protected void checkAndDropBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!this.canBlockStay(worldIn, pos, state))
        {
        	breaken(worldIn, pos, state);
        }
    }
	
	@Override
	public String getName() {
		return "barren_berry_bush";
	}
}

