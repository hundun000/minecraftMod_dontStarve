package hundun.dontstarve.itemBlock;

import java.util.List;

import com.google.common.base.Function;

import hundun.dontstarve.DontStarve;
import hundun.dontstarve.IModName;
import hundun.dontstarve.block.BlockLoader;
import hundun.dontstarve.block.BlockMetalFurnace;
import hundun.dontstarve.myIProperty.EnumMaterial;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBlockMetalFurnace extends ItemMultiTexture{

	public ItemBlockMetalFurnace() {
		super(BlockLoader.metalFurnace,BlockLoader.metalFurnace,new Function<ItemStack, String>(){
			@Override
			public String apply(ItemStack input) {
				// TODO Auto-generated method stub
				return EnumMaterial.values()[input.getMetadata() >> 3].getName();
			}
		}
		);
		
		setRegistryName(DontStarve.MODID, ((IModName) BlockLoader.metalFurnace).getName());
	}

}
