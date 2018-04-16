package hundun.dontstarve.itemBlock;

import com.google.common.base.Function;

import hundun.dontstarve.DontStarve;
import hundun.dontstarve.IModName;
import hundun.dontstarve.block.BlockLoader;
import hundun.dontstarve.myIProperty.EnumFertility;
import hundun.dontstarve.myIProperty.EnumMaterial;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;

public class ItemBlockBerryBush extends ItemMultiTexture{
	
	public ItemBlockBerryBush() {
		super(BlockLoader.berryBush,BlockLoader.berryBush,new Function<ItemStack, String>(){
			@Override
			public String apply(ItemStack input) {
				return EnumFertility.values()[input.getMetadata()].getName();
			}
		}
		);
		
		setRegistryName(DontStarve.MODID, ((IModName) BlockLoader.berryBush).getName());
	}

}
