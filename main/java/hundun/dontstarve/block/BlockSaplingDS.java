package hundun.dontstarve.block;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import hundun.dontstarve.MyTool;
import hundun.dontstarve.IModName;
import hundun.dontstarve.item.ItemLoader;
import hundun.dontstarve.material.MaterialLoader;
import net.minecraft.block.BlockBush;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
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
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSaplingDS extends BlockBush implements IModName,IMetaBlockName{

	public static final PropertyEnum TYPERIPE = PropertyEnum.create("type",EnumTypeRipe.class);
	
	public BlockSaplingDS(){
		super(MaterialLoader.barrenableMaterial);
		MyTool.generalSet(this);
		setHardness(0.8F);
		setDefaultState(this.blockState.getBaseState().withProperty(TYPERIPE, EnumTypeRipe.RIPE));
		
		
		
	}
	 
	@Override
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
	{
		System.out.println("触发了灌木丛点击事件");	        	    	
	    	if (!worldIn.isRemote) {
	            EntityItem entity = new EntityItem(worldIn, pos.getX(), pos.getY(),pos.getZ(), new ItemStack(Items.APPLE, 1));
	            EntityItem entity2 = new EntityItem(worldIn, pos.getX(), pos.getY(),pos.getZ(), new ItemStack(Items.BREAD, 1));
	            if(this.getMetaFromState(worldIn.getBlockState(pos))==0)
	                worldIn.spawnEntityInWorld(entity); // 放置实体
	            else
	            	worldIn.spawnEntityInWorld(entity2); // 放置实体
	            //worldIn.setBlockState(pos,BlockLoader.unripeBerryBush.getDefaultState());
	        }
	} 
	
	
	

	public enum EnumTypeRipe implements IStringSerializable {
	    RIPE(0, "ripe"),
	    UNRIPE(1, "unripe");

	    private int ID;
	    private String name;
	    
	    private EnumTypeRipe(int ID, String name) {
	        this.ID = ID;
	        this.name = name;
	    }
	    
	    @Override
	    public String getName() {
	        return name;
	    }
	    
	    @Override
	    public String toString() {
	        return getName();
	    }

	    public int getID() {
	        return ID;
	    }
	    

	}
	
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] { TYPERIPE });
    }
    
    
	@Override
	public String getName() {
		return "saplingDS";
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
	    return getDefaultState().withProperty(TYPERIPE, meta == 0 ? EnumTypeRipe.RIPE : EnumTypeRipe.UNRIPE);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
	    EnumTypeRipe type = (EnumTypeRipe) state.getValue(TYPERIPE);
	    return type.getID();
	}
	
	@Override
	public int damageDropped(IBlockState state) {
	    return getMetaFromState(state);
	}
	
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
	    list.add(new ItemStack(itemIn, 1, 0)); //Meta 0
	    list.add(new ItemStack(itemIn, 1, 1)); //Meta 1
	}

	@Override
	public String getSpecialName(ItemStack stack) {
	    return stack.getItemDamage() == 0 ? "ripe" : "unripe";
	}
	

	
    /**
     * Called when a user uses the creative pick block button on this block
     *
     * @param target The full target the player is looking at
     * @return A ItemStack to add to the player's inventory, Null if nothing should be added.
     */
	@Override	
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
    }
}
