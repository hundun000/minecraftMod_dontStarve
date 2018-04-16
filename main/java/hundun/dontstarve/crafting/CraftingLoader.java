package hundun.dontstarve.crafting;

import java.util.ArrayList;
import java.util.List;

import hundun.dontstarve.block.BlockLoader;
import hundun.dontstarve.common.ConfigLoader;
import hundun.dontstarve.item.ItemLoader;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingLoader
{
    public CraftingLoader(){
        registerRecipe();
        registerSmelting();
        registerFuel();
    }

    private static void registerRecipe(){
    	GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.rope), ItemLoader.cutGrass,ItemLoader.cutGrass,ItemLoader.cutGrass); 	 
    	GameRegistry.addRecipe(new ItemStack(ItemLoader.razor), " x", "x ", 
    	        'x',new ItemStack(Blocks.COBBLESTONE));
    }

    private static void registerSmelting(){
    	GameRegistry.addSmelting(ItemLoader.berries, new ItemStack(ItemLoader.roastedBerries), 0.1F);
    }

    private static void registerFuel()
    {
    	GameRegistry.registerFuelHandler(new IFuelHandler()
        {
            @Override
            public int getBurnTime(ItemStack fuel)
            {
                return ItemLoader.cutGrass != fuel.getItem() ? 0 : ConfigLoader.cutGrass_BurnTime;
            }
        });

    }
}
