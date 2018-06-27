package hundun.dontstarve.capability;

import net.minecraft.util.math.Vec3d;

public interface IPositionHistory {

	public Vec3d[] getHistories();
	
	public void setHistories(Vec3d[] position);

    public void pushHistory(Vec3d position);
	

}
