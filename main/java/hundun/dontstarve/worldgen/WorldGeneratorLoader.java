package hundun.dontstarve.worldgen;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.BiomeEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class WorldGeneratorLoader
{
	private static WorldGenerator generatorBoulder = new WorldGeneratorBoulder();
	
	private BlockPos posFirstTime;
	
    public WorldGeneratorLoader()
    {
        MinecraftForge.ORE_GEN_BUS.register(this);
    }

    @SubscribeEvent
    public void onOreGenPost(OreGenEvent.Post event)
    {
        if (!event.getPos().equals(this.posFirstTime))
        {
            posFirstTime = event.getPos();
            generatorBoulder.generate(event.getWorld(), event.getRand(), event.getPos());
        }
    }
    

}