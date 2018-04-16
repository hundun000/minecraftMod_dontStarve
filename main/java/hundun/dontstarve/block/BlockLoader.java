package hundun.dontstarve.block;

import com.google.common.base.Function;

import hundun.dontstarve.DontStarve;
import hundun.dontstarve.IModName;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
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
    public static Block willowsLighter = new BlockWillowsLighter();
    public static Block berryBush = new BlockBerryBush();
    
    public static Block unripeBerryBush = new BlockUnripeBerryBush();
    public static Block barrenBerryBush = new BlockBarrenBerryBush();


    

    
    
    public BlockLoader(FMLPreInitializationEvent event)
    {//registerByBlock();
    	
        registerByBlock(boulder);
        registerByBlock(willowsLighter);
        registerByBlock(berryBush);
        registerByBlock(unripeBerryBush);
        registerByBlock(barrenBerryBush);
       // registerByBlock(saplingDS);
        

        
        
        
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {// registerRender();
        registerRender(boulder);
        registerRender(willowsLighter);
        registerRender(berryBush);
        registerRender(unripeBerryBush);
        registerRender(barrenBerryBush);

        
    }
    
    

    
    
    
    //渲染助手
    @SideOnly(Side.CLIENT)
    private static void registerRender(Block blockIn)
    {
    	//加载item的模型,无meta值则默认为0
    	registerRender(blockIn,0,((IModName) blockIn).getName());
    }
    
    @SideOnly(Side.CLIENT)
    private static void registerRender(Block blockIn, int meta,String name)
    {
    	ResourceLocation location = new ResourceLocation(DontStarve.MODID, name);
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(blockIn), meta, new ModelResourceLocation(location, "inventory"));
        ModelLoader.registerItemVariants(Item.getItemFromBlock(blockIn), location);
    }
    
    
    
    
    //注册助手
    private static void registerByBlock(Block blockIn)
    {
    	//注册block
        GameRegistry.register(blockIn);
        //注册item
        GameRegistry.register(new ItemBlock(blockIn).setRegistryName(DontStarve.MODID, ((IModName) blockIn).getName()));
    }
    
    
    private static void registerMulMeta(Block block, ItemBlock itemBlock)
    {
    	registerByBlock(block);
        GameData.getBlockItemMap().put(block, itemBlock);
    }
}
