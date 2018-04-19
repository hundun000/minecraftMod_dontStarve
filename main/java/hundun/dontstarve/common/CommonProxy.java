package hundun.dontstarve.common;

import hundun.dontstarve.achievement.AchievementLoader;
import hundun.dontstarve.block.BlockLoader;
import hundun.dontstarve.crafting.CraftingLoader;
import hundun.dontstarve.creativetab.CreativeTabsLoader;
import hundun.dontstarve.entity.EntityLoader;
import hundun.dontstarve.item.ItemLoader;
import hundun.dontstarve.material.MaterialBuilding;
import hundun.dontstarve.material.MaterialLoader;
import hundun.dontstarve.tileEntity.TileEntityLoader;
import hundun.dontstarve.worldgen.WorldGeneratorLoader;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
	
	
    public void preInit(FMLPreInitializationEvent event)
    {
    	
    	
    	new CreativeTabsLoader(event);
    	new ConfigLoader(event);
    	new ItemLoader(event);
    	new BlockLoader(event);
    	new MaterialLoader();
    	new CraftingLoader();
    	new EventLoader();
    	new WorldGeneratorLoader();
    	new AchievementLoader();
    	new EntityLoader();
    	new TileEntityLoader(event);

    }

    public void init(FMLInitializationEvent event)
    {

    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
