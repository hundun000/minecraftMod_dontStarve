package hundun.dontstarve.entity;

import java.awt.Color;

import hundun.dontstarve.DontStarve;
import hundun.dontstarve.client.entity.EntityRenderFactory;
import hundun.dontstarve.client.entity.render.RenderButterfly;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
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
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
    	registerEntityRender(EntityButterfly.class, RenderButterfly.class);
    }
    
    @SideOnly(Side.CLIENT)
    private static <T extends Entity> void registerEntityRender(Class<T> entityClass, Class<? extends Render<T>> render)
    {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, new EntityRenderFactory<T>(render));
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


