package hundun.dontstarve.block;

import com.google.common.base.Function;

import hundun.dontstarve.DontStarve;
import hundun.dontstarve.IModName;
import hundun.dontstarve.itemBlock.ItemBlockBerryBush;
import hundun.dontstarve.itemBlock.ItemBlockMetalFurnace;
import hundun.dontstarve.myIProperty.EnumMaterial;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLoader
{
    public static Block boulder = new BlockBoulder();
    public static Block berryBush = new BlockBerryBush();

    public static Block metalFurnace = new BlockMetalFurnace();

    

    
    
    public BlockLoader(FMLPreInitializationEvent event)
    {//registerByBlock();
    	
        registerByBlock(boulder);
        
        registerMulMeta(metalFurnace,new ItemBlockMetalFurnace());
        registerMulMeta(berryBush,new ItemBlockBerryBush());
       // registerByBlock(saplingDS);
        

        
        
        
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {// registerRender();
        registerRender(boulder);
        
        registerMulMetaRender(metalFurnace, 0, "iron_furnace");
        registerMulMetaRender(metalFurnace, 8, "gold_furnace");
        
        registerMulMetaRender(berryBush, 0, "berry_bush_harvest");
        registerMulMetaRender(berryBush, 1, "berry_bush_barren");
        registerMulMetaRender(berryBush, 2, "berry_bush_unripe");
        
        registerStateMapper(metalFurnace,
                new StateMap.Builder().withName(EnumMaterial.MATERIAL).withSuffix("_furnace").build());
        
    }
    
    

    //渲染助手常用型
    @SideOnly(Side.CLIENT)
    private static void registerRender(Block blockIn)
    {
    	//加载item的模型,无meta值则默认为0
    	registerMulMetaRender(blockIn,0,((IModName) blockIn).getName());
    }
    
    //渲染助手一般型
    @SideOnly(Side.CLIENT)
    private static void registerMulMetaRender(Block blockIn, int meta,String name)
    {
    	ResourceLocation location = new ResourceLocation(DontStarve.MODID, name);
    	ModelResourceLocation model = new ModelResourceLocation(location, "inventory");
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(blockIn), meta, model);
       // ModelLoader.registerItemVariants(Item.getItemFromBlock(blockIn), location);
    }
    
    
    
    
    //注册助手常用型
    private static void registerByBlock(Block blockIn)
    {
    	//注册block
        GameRegistry.register(blockIn);
        //注册item
        GameRegistry.register(new ItemBlock(blockIn).setRegistryName(DontStarve.MODID, ((IModName) blockIn).getName()));
    }
    
    //注册助手非默认ItemBlock型
    private static void registerMulMeta(Block block, ItemBlock itemBlock){
    	//注册block
    	GameRegistry.register(block);
    	//注册item
        GameRegistry.register(itemBlock);
        GameData.getBlockItemMap().put(block, itemBlock);
    }
    
    //模型简化映射注册
    @SideOnly(Side.CLIENT)
    private static void registerStateMapper(Block block, IStateMapper mapper)
    {
        ModelLoader.setCustomStateMapper(block, mapper);
    }
}
