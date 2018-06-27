package hundun.dontstarve.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
//import net.minecraft.util.;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class CapabilityPositionHistory {
	
	public static class Storage implements Capability.IStorage<IPositionHistory>{
		
        @Override
        public NBTBase writeNBT(Capability<IPositionHistory> capability, IPositionHistory instance, EnumFacing side){
            NBTTagList list = new NBTTagList();
            for (Vec3d vec3 : instance.getHistories()){
                NBTTagCompound compound = new NBTTagCompound();
                if (vec3 != null){
                    compound.setDouble("x", vec3.xCoord);
                    compound.setDouble("y", vec3.yCoord);
                    compound.setDouble("z", vec3.zCoord);
                }
                list.appendTag(compound);
            }
            return list;
        }

		@Override
		public void readNBT(Capability<IPositionHistory> capability, IPositionHistory instance, EnumFacing side,
				NBTBase nbt) {
			NBTTagList list = (NBTTagList) nbt;
            Vec3d[] histories = new Vec3d[list.tagCount()];
            for (int i = 0; i < histories.length; ++i){
                NBTTagCompound compound = list.getCompoundTagAt(i);
                if (!compound.hasNoTags()){
                    histories[i] = new Vec3d(compound.getDouble("x"), compound.getDouble("y"), compound.getDouble("z"));
                }
            }
            instance.setHistories(histories);
		}
		
    }
	
	public static class Implementation implements IPositionHistory
    {
        private Vec3d[] histories = new Vec3d[5];

        @Override
        public Vec3d[] getHistories()
        {
            return histories.clone();
        }

        @Override
        public void setHistories(Vec3d[] position)
        {
            histories = position.clone();
        }

        @Override
        public void pushHistory(Vec3d position)
        {
            for (int i = 1; i < histories.length; ++i)
            {
                histories[i - 1] = histories[i];
            }
            histories[histories.length - 1] = position;
        }
    }

	public static class ProviderPlayer implements ICapabilitySerializable<NBTTagCompound>{

		private IPositionHistory histories = new Implementation();
        private IStorage<IPositionHistory> storage = CapabilityLoader.positionHistory.getStorage();
		
		@Override
		public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
			return CapabilityLoader.positionHistory.equals(capability);
		}

		@Override
		public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
			if (CapabilityLoader.positionHistory.equals(capability))
            {
                @SuppressWarnings("unchecked")
                T result = (T) histories;
                return result;
            }
            return null;
		}

		@Override
		public NBTTagCompound serializeNBT() {
			NBTTagCompound compound = new NBTTagCompound();
            compound.setTag("histories", storage.writeNBT(CapabilityLoader.positionHistory, histories, null));
            return compound;
		}

		@Override
		public void deserializeNBT(NBTTagCompound compound) {
			NBTTagList list = (NBTTagList) compound.getTag("histories");
            storage.readNBT(CapabilityLoader.positionHistory, histories, null, list);
		}

    }
}
