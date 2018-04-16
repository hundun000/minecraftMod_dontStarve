package hundun.dontstarve.entity;

import java.awt.Color;

import hundun.dontstarve.DontStarve;
import hundun.dontstarve.client.entity.EntityRenderFactory;
import hundun.dontstarve.client.entity.render.RenderButterfly;
import hundun.dontstarve.client.entity.render.RenderTallBird;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityLoader {
	private static int nextID = 0;

    public EntityLoader()
    {
    	registerEntity(EntityButterfly.class, "Butterfly", 80, 3, true);
    	registerEntityEgg(EntityButterfly.class, Color.red.getRGB(), 0x660000);
    	
    	
    	registerEntity(EntityTallBird.class, "TallBird", 80, 3, true);
    	registerEntityEgg(EntityTallBird.class, Color.red.getRGB(), 0x660000);
    	registerEntitySpawn(EntityTallBird.class, 8, 2, 4, EnumCreatureType.CREATURE, 
    			Biome.getBiome(1),Biome.getBiome(2),Biome.getBiome(4));//2--desert,4--forest,1--plains
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
    	registerEntityRender(EntityButterfly.class, RenderButterfly.class);
    	registerEntityRender(EntityTallBird.class, RenderTallBird.class);

    }
    
    @SideOnly(Side.CLIENT)
    private static <T extends Entity> void registerEntityRender(Class<T> entityClass, Class<? extends Render<T>> render)
    {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, new EntityRenderFactory<T>(render));
    }
    
    private static void registerEntitySpawn(Class<? extends Entity> entityClass, int spawnWeight, int min,
            int max, EnumCreatureType typeOfCreature, Biome... biomes)
    {
        if (EntityLiving.class.isAssignableFrom(entityClass))
        {
            Class<? extends EntityLiving> entityLivingClass = entityClass.asSubclass(EntityLiving.class);
            EntityRegistry.addSpawn(entityLivingClass, spawnWeight, min, max, typeOfCreature, biomes);
        }
    }
    
    //实体刷怪蛋注册助手
    private static void registerEntityEgg(Class<? extends Entity> entityClass, int eggPrimary, int eggSecondary)
    {
        EntityRegistry.registerEgg(entityClass, eggPrimary, eggSecondary);
    }

    //实体注册助手
    private static void registerEntity(Class<? extends Entity> entityClass, String name, int trackingRange,
            int updateFrequency, boolean sendsVelocityUpdates)
    {
        EntityRegistry.registerModEntity(entityClass, name, nextID++, DontStarve.instance, trackingRange, updateFrequency,
                sendsVelocityUpdates);
    }
}


