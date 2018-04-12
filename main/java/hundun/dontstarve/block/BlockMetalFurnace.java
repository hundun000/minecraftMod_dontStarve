package hundun.dontstarve.block;

import hundun.dontstarve.MyTool;
import hundun.dontstarve.IModName;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.functions.SetDamage;

public class BlockMetalFurnace extends Block implements IModName{
	
    public BlockMetalFurnace()
    {
        super(Material.IRON);
        MyTool.generalSet(this);
        setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH)
                .withProperty(BURNING, Boolean.FALSE).withProperty(MATERIAL, EnumMaterial.IRON));
       
        
    }

    public static enum EnumMaterial implements IStringSerializable
    {
        IRON("iron"), GOLD("gold");

        private String name;

        private EnumMaterial(String material)
        {
            this.name = material;
        }

        @Override
        public String getName()
        {
            return this.name;
        }

        @Override
        public String toString()
        {
            return this.name;
        }
    }

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    public static final PropertyBool BURNING = PropertyBool.create("burning");
    public static final PropertyEnum<EnumMaterial> MATERIAL = PropertyEnum.create("material", EnumMaterial.class);
    
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, FACING, BURNING, MATERIAL);
    }
    
    
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing facing = EnumFacing.getHorizontal(meta & 3);
        Boolean burning = Boolean.valueOf((meta & 4) != 0);
        EnumMaterial material = EnumMaterial.values()[meta >> 3];
        return this.getDefaultState().withProperty(FACING, facing).withProperty(BURNING, burning).withProperty(MATERIAL,
                material);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        int facing = state.getValue(FACING).getHorizontalIndex();
        int burning = state.getValue(BURNING).booleanValue() ? 4 : 0;
        int material = state.getValue(MATERIAL).ordinal() << 3;
        return facing | burning | material;
    }
    
    @Override
    public int damageDropped(IBlockState state)
    {
        return state.getValue(MATERIAL).ordinal() << 3;
    }
    
    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ,
            int meta, EntityLivingBase placer)
    {
        IBlockState origin = super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
        return origin.withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }
    
    public int getMetadata(int damage)
    {
        return damage;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
	@Override
	public String getName() {
		return "metal_furnace";
	}
}
