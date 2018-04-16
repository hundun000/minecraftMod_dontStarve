package hundun.dontstarve.item;

import hundun.dontstarve.DontStarve;
import hundun.dontstarve.IModName;
import hundun.dontstarve.item.food.ItemBerries;
import hundun.dontstarve.item.food.ItemBigMeat;
import hundun.dontstarve.item.food.ItemButterflyWings;
import hundun.dontstarve.item.food.ItemHoney;
import hundun.dontstarve.item.food.ItemMonsterMeat;
import hundun.dontstarve.item.food.ItemRoastedBerries;
import hundun.dontstarve.item.food.ItemTallBirdEgg;
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
	public static Item razor = new ItemRazor();
	public static Item spiderGland = new ItemSpiderGland();
	public static Item butterflyWings = new ItemButterflyWings();
	public static Item monsterMeat=new ItemMonsterMeat();
	
	//food
	public static Item tallBirdEgg=new ItemTallBirdEgg();
	public static Item berries = new ItemBerries();
	public static Item roastedBerries = new ItemRoastedBerries();
	public static Item honey = new ItemHoney();
	public static Item bigMeat= new ItemBigMeat();
	
	
	//注册item们
	public ItemLoader(FMLPreInitializationEvent event)
    {
        registerByItem(cutGrass);
        registerByItem(rope);
        registerByItem(razor);
        registerByItem(spiderGland); 
        
        
        //food
        registerByItem(butterflyWings);
        registerByItem(monsterMeat);
        registerByItem(bigMeat);        
        registerByItem(berries);
        registerByItem(roastedBerries);
        registerByItem(honey);
        registerByItem(tallBirdEgg);
    }
	
	
	//渲染item们
    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
    	RendersByItem(cutGrass);
    	RendersByItem(rope);
    	
    	RendersByItem(razor);
    	RendersByItem(spiderGland);
    	
    	
    	
    	//food
    	RendersByItem(monsterMeat);
    	RendersByItem(bigMeat);
    	RendersByItem(berries);
    	RendersByItem(roastedBerries);
    	RendersByItem(honey);
    	RendersByItem(butterflyWings);
    	RendersByItem(tallBirdEgg);
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
