package hundun.dontstarve.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import org.apache.commons.io.filefilter.FalseFileFilter;

import com.sun.swing.internal.plaf.metal.resources.metal;

import hundun.dontstarve.DontStarve;
import hundun.dontstarve.MyTool;
import hundun.dontstarve.IModName;
import hundun.dontstarve.creativetab.CreativeTabsLoader;
import hundun.dontstarve.item.ItemLoader;
import hundun.dontstarve.material.MaterialBarrenable;
import hundun.dontstarve.material.MaterialLoader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBerryBush extends BlockBush implements IModName{

	public BlockBerryBush(){
		super(MaterialLoader.barrenableMaterial);
		MyTool.generalSet(this);
		setHardness(0.8F);
		//setDefaultState(this.blockState.getBaseState().withProperty(TYPE_RIPE,EnumRipe.RIPE));
		
	}
	
	/**
     * Get the Item that this Block should drop when harvested.
     */
    @Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return BlockLoader.unripeBerryBush.getItemDropped(state, rand, fortune);
    }
    
    /*
    @Override
    public List getDrops(IBlockAccess world, BlockPos pos, IBlockState blockstate, int fortune) {
        List drops = super.getDrops(world,pos,  blockstate, fortune);       		
        drops.add(new ItemStack(ItemLoader.berries, 1,ItemLoader.berries.getMaxDamage()));
        return drops;
    }
    */
    
	@Override
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
	{
		System.out.println("触发了浆果丛点击事件");	        	    	
	    	if (!worldIn.isRemote) {
	            EntityItem entity = new EntityItem(worldIn, pos.getX(), pos.getY(),pos.getZ(), new ItemStack(ItemLoader.berries, 1));
	            worldIn.spawnEntityInWorld(entity); // 放置实体
	            worldIn.setBlockState(pos,BlockLoader.unripeBerryBush.getDefaultState());
	        }
	} 
    
	
	@Override
	public String getName() {
		return "berry_bush";
	}

}
