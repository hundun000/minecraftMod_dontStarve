package hundun.dontstarve.myIProperty;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;

public enum EnumMaterial implements IStringSerializable{
	//member enum
	IRON("iron"), GOLD("gold");
	
	private String materialName;
	
    private EnumMaterial(String materialName)
    {
        this.materialName = materialName;
    }
    
	@Override
	public String getName() {
		return this.materialName;
	}
	
	//同时通过PropertyBool完成了property们在mc中的注册
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool BURNING = PropertyBool.create("burning");
    public static final PropertyEnum<EnumMaterial> MATERIAL = PropertyEnum.create("material", EnumMaterial.class);

}
