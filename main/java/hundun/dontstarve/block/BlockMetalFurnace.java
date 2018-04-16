package hundun.dontstarve.block;

import java.util.List;

import hundun.dontstarve.IModName;
import hundun.dontstarve.MyTool;
import hundun.dontstarve.creativetab.CreativeTabsLoader;
import hundun.dontstarve.myIProperty.EnumMaterial;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMetalFurnace extends Block implements IModName
{
    public BlockMetalFurnace()
    {
        super(Material.IRON);
        
        MyTool.generalSet(this);
        
        setHardness(2.5f);
        setSoundType(SoundType.METAL); 
        
        //目前面向北未工作的铁炉子，占据了方块的默认BlockState
        this.setDefaultState(this.blockState.getBaseState().withProperty(EnumMaterial.FACING, EnumFacing.NORTH)
                .withProperty(EnumMaterial.BURNING, Boolean.FALSE).withProperty(EnumMaterial.MATERIAL, EnumMaterial.IRON));
    }

	@Override
	public String getName() {
		return "metal_furnace";
	}
	
	//告知我们的方块使用了这三种IProperty
	@Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, EnumMaterial.FACING, EnumMaterial.BURNING, EnumMaterial.MATERIAL);
    }
	
	//设置BlockState和Metadata映射关系
	 @Override
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing facing = EnumFacing.getHorizontal(meta & 3);
        Boolean burning = Boolean.valueOf((meta & 4) != 0);
        EnumMaterial material = EnumMaterial.values()[meta >> 3];
        return this.getDefaultState().withProperty(EnumMaterial.FACING, facing).withProperty(EnumMaterial.BURNING, burning).withProperty(EnumMaterial.MATERIAL,
                material);
    }
	 
	//让metadata负责业务逻辑
	@Override
    public int getMetaFromState(IBlockState state)
    {
        int facing = state.getValue(EnumMaterial.FACING).getHorizontalIndex();
        int burning = state.getValue(EnumMaterial.BURNING).booleanValue() ? 4 : 0;
        int material = state.getValue(EnumMaterial.MATERIAL).ordinal() << 3;
        return facing | burning | material;
    }
	
	//注册subBlock
	@Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        list.add(new ItemStack(itemIn, 1, 0));
        list.add(new ItemStack(itemIn, 1, 8));
    }
	
	//放置时设置正确的朝向
	@Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ,
            int meta, EntityLivingBase placer)
    {
        IBlockState origin = super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
        return origin.withProperty(EnumMaterial.FACING, placer.getHorizontalFacing().getOpposite());
    }
	
	//中键取得时设置正确的朝向
	@Override
    public int damageDropped(IBlockState state)
    {
        return state.getValue(EnumMaterial.MATERIAL).ordinal() << 3;
    }
	
	
	
}
