package hundun.dontstarve.client.entityTool.render;

import hundun.dontstarve.DontStarve;
import hundun.dontstarve.entity.EntityTallBird;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTallBird extends RenderLiving<EntityTallBird>
{
    private static final ResourceLocation TALL_BIRD_TEXTURE = new ResourceLocation(
            DontStarve.MODID + ":" + "textures/entities/tall_bird.png");

    public RenderTallBird(RenderManager renderManager)
    {
        super(renderManager, new ModelChicken(), 0.5F);
    }

    @Override
    protected void preRenderCallback(EntityTallBird entity, float partialTickTime)
    {
        GlStateManager.scale(2.0F, 5.0F, 2.0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityTallBird entity)
    {
        return RenderTallBird.TALL_BIRD_TEXTURE;
    }

    @Override
    public void doRender(EntityTallBird entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    /**
     * copy from net.minecraft.client.renderer.entity.RenderChicken
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(EntityTallBird livingBase, float partialTicks)
    {
        float f = livingBase.oFlap + (livingBase.wingRotation - livingBase.oFlap) * partialTicks;
        float f1 = livingBase.oFlapSpeed + (livingBase.destPos - livingBase.oFlapSpeed) * partialTicks;
        return (MathHelper.sin(f) + 1.0F) * f1;
    }


}