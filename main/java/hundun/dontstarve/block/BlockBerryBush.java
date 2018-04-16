package hundun.dontstarve.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import hundun.dontstarve.MyTool;
import hundun.dontstarve.IModName;
import hundun.dontstarve.item.ItemLoader;
import hundun.dontstarve.material.MaterialLoader;
import hundun.dontstarve.myIProperty.EnumFertility;
import hundun.dontstarve.myIProperty.EnumMaterial;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBerryBush extends BlockBush implements IModName,IGrowable{

	public BlockBerryBush(){
		super(MaterialLoader.barrenableMaterial);
		MyTool.generalSet(this);
		setHardness(0.8F);
		setHarvestLevel("shovel",1);
		
		//目前harvest的浆果丛为默认
        this.setDefaultState(this.blockState.getBaseState().withProperty(EnumFertility.FERTILITY, EnumFertility.HARVEST));
	}
	

    
    @Override
    public List getDrops(IBlockAccess world, BlockPos pos, IBlockState blockstate, int fortune) {
    	EnumFertility currentState=blockstate.getValue(EnumFertility.FERTILITY);
    	List<ItemStack> drops= new ArrayList<ItemStack>();
    	switch (currentState) {
			case UNRIPE:		
		        drops.add(new ItemStack(this,1,1));//get barren state   
		        break;
			case BARREN:		
		        drops.add(new ItemStack(Items.STICK,2));//get sticks
		        break;
			default:
		}
    	return drops;
    }
    
	@Override
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
	{
		 EnumFertility currentState=worldIn.getBlockState(pos).getValue(EnumFertility.FERTILITY);
		 if(currentState==EnumFertility.HARVEST){
			System.out.println("触发了浆果丛点击事件,state="+currentState);	        	    	
	    	if (!worldIn.isRemote) {
	            EntityItem entity = new EntityItem(worldIn, pos.getX(), pos.getY(),pos.getZ(), new ItemStack(ItemLoader.berries, 1));
	            worldIn.spawnEntityInWorld(entity); // 放置实体
	            worldIn.setBlockState(pos, this.blockState.getBaseState().withProperty(EnumFertility.FERTILITY, EnumFertility.UNRIPE));
	        }
		 }
	} 
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            super.updateTick(worldIn, pos, state, rand);
            
            EnumFertility currentState=worldIn.getBlockState(pos).getValue(EnumFertility.FERTILITY);
            
            switch (currentState) {
		        case HARVEST:
		        	//可收获下，任何光照下 1/1000概率自然枯萎
					if(rand.nextInt(1000) == 0)
		        		worldIn.setBlockState(pos,this.blockState.getBaseState().withProperty(EnumFertility.FERTILITY, EnumFertility.BARREN));
		        	break;
		        case UNRIPE:
					//未成熟下，任何光照下 1/200概率自然枯萎,阳光下1/20概率成熟
					if(rand.nextInt(200) == 0)
		        		worldIn.setBlockState(pos,this.blockState.getBaseState().withProperty(EnumFertility.FERTILITY, EnumFertility.BARREN));
					else if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(20) == 0)
		            	worldIn.setBlockState(pos,this.blockState.getBaseState().withProperty(EnumFertility.FERTILITY, EnumFertility.HARVEST));	
					break;
		
				default:
					break;
			}
        }
    }
	
	@Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
		return true;
    }
	
	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		EnumFertility currentState=worldIn.getBlockState(pos).getValue(EnumFertility.FERTILITY);
		if(currentState==EnumFertility.BARREN)
			return true;
		else
			return false;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		//called only when using bonemeal
		worldIn.setBlockState(pos,this.blockState.getBaseState().withProperty(EnumFertility.FERTILITY, EnumFertility.UNRIPE));	
	}
    
	
	@Override
	public String getName() {
		return "berry_bush";
	}
	
	//告知我们的方块使用了这三种IProperty
	@Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, EnumFertility.FERTILITY);
    }
	
	//设置BlockState和Metadata映射关系
	 @Override
    public IBlockState getStateFromMeta(int meta)
    {
		EnumFertility fertility = EnumFertility.values()[meta];
        return this.getDefaultState().withProperty(EnumFertility.FERTILITY, fertility);
    }
	 
	//让metadata负责业务逻辑
	@Override
    public int getMetaFromState(IBlockState state)
    {
        int fertility = state.getValue(EnumFertility.FERTILITY).ordinal();
        return fertility;
    }
	
	//注册subBlock
	@Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        list.add(new ItemStack(itemIn, 1, 0));
        list.add(new ItemStack(itemIn, 1, 1));
        list.add(new ItemStack(itemIn, 1, 2));
    }





}
