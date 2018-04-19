package hundun.dontstarve.tileEntity;

import hundun.dontstarve.block.BlockMetalFurnace;
import hundun.dontstarve.myIProperty.EnumMaterial;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityMetalFurnace extends TileEntity implements ITickable{
	
	protected int burnTime = 0;

    protected ItemStackHandler upInventory = new ItemStackHandler();
    protected ItemStackHandler downInventory = new ItemStackHandler();
	
    //------------ handler define ---------------
	@Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        if (CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.equals(capability))
        {
            return true;
        }
        return super.hasCapability(capability, facing);
    }
	
	@Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        if (CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.equals(capability))
        {
        	 @SuppressWarnings("unchecked")
             T result = (T) (facing == EnumFacing.DOWN ? downInventory : upInventory);
             return result;
        }
        return super.getCapability(capability, facing);
    }
	
	//-------- data R/W -------------
	@Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.upInventory.deserializeNBT(compound.getCompoundTag("UpInventory"));
        this.downInventory.deserializeNBT(compound.getCompoundTag("DownInventory"));
        this.burnTime = compound.getInteger("BurnTime");
    }
	
	@Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
		NBTTagCompound ans=super.writeToNBT(compound);
        compound.setTag("UpInventory", this.upInventory.serializeNBT());
        compound.setTag("DownInventory", this.downInventory.serializeNBT());
        compound.setInteger("BurnTime", this.burnTime);
        return ans;
    }
	
	@Override
    public void update()
    {
		if (!this.worldObj.isRemote)
        {
            ItemStack itemStack = upInventory.extractItem(0, 1, true);
            IBlockState state = this.worldObj.getBlockState(pos);

            if (itemStack != null && downInventory.insertItem(0, itemStack, true) == null)
            {
                this.worldObj.setBlockState(pos, state.withProperty(EnumMaterial.BURNING, Boolean.TRUE));

                int burnTotalTime = 200;
                switch (state.getValue(EnumMaterial.MATERIAL))
                {
                case IRON:
                    burnTotalTime = 150;
                    break;
                case GOLD:
                    burnTotalTime = 100;
                    break;
                }

                if (++this.burnTime >= burnTotalTime)
                {
                    this.burnTime = 0;
                    itemStack = upInventory.extractItem(0, 1, false);
                    downInventory.insertItem(0, itemStack, false);
                    this.markDirty();
                }
            }
            else
            {
                this.worldObj.setBlockState(pos, state.withProperty(EnumMaterial.BURNING, Boolean.FALSE));
            }
        }
    }
	
	 @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
    {
        return oldState.getBlock() != newState.getBlock();
    }
	


}
