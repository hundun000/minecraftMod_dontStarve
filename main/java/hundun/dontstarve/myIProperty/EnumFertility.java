package hundun.dontstarve.myIProperty;


import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.IStringSerializable;

public enum EnumFertility implements IStringSerializable{
	//member enum
	HARVEST("harvest"), BARREN("barren"),UNRIPE("unripe");
	
	private String fertilityName;
	
	private EnumFertility(String fertilityName)
    {
        this.fertilityName = fertilityName;
    }
	
	@Override
	public String getName() {
		return this.fertilityName;
	}
	
	public static final PropertyEnum<EnumFertility> FERTILITY = PropertyEnum.create("fertility", EnumFertility.class);

}
