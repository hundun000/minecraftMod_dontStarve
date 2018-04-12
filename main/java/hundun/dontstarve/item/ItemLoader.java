package hundun.dontstarve.item;

import hundun.dontstarve.DontStarve;
import hundun.dontstarve.IModName;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLoader {
	
	public static Item cutGrass = new ItemCutGrass();
	public static Item rope = new ItemRope();
	public static Item berries = new ItemBerries();
	public static Item roastedBerries = new ItemRoastedBerries();
	public static Item razor = new ItemRazor();
	public static Item spiderGland = new ItemSpiderGland();
	public static Item honey = new ItemHoney();
	public static Item butterflyWings = new ItemButterflyWings();
	
	
	//注册item们
	public ItemLoader(FMLPreInitializationEvent event)
    {
        registerByItem(cutGrass);
        registerByItem(rope);
        registerByItem(berries);
        registerByItem(roastedBerries);
        registerByItem(razor);
        registerByItem(spiderGland);
        registerByItem(honey);
        registerByItem(butterflyWings);
        
        
    }
	
	
	
	//渲染item们
    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
    	RendersByItem(cutGrass);
    	RendersByItem(rope);
    	RendersByItem(berries);
    	RendersByItem(roastedBerries);
    	RendersByItem(razor);
    	RendersByItem(spiderGland);
    	RendersByItem(honey);
    	RendersByItem(butterflyWings);
    	
    }
	
    
    
    
    //注册助手
    private static void registerByItem(Item item)
    {
        GameRegistry.register(item);
    }

    
    //渲染助手
    @SideOnly(Side.CLIENT)
	public static void RendersByItem(Item itemIn) {
		   ModelLoader.setCustomModelResourceLocation(itemIn, 0, new ModelResourceLocation(DontStarve.MODID + ":" + ((IModName) itemIn).getName(), "inventory"));
	}
}
