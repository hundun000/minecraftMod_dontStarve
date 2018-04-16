package hundun.dontstarve.client.entity.render;

import hundun.dontstarve.DontStarve;
import hundun.dontstarve.entity.EntityButterfly;
import net.minecraft.client.model.ModelBat;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderButterfly extends RenderLiving<EntityButterfly>
{
    private static final ResourceLocation BUTTERFLY_TEXTURE = new ResourceLocation(
            DontStarve.MODID + ":" + "textures/entities/butterfly.png");

    public RenderButterfly(RenderManager renderManager)
    {
        super(renderManager, new ModelBat(), 0.5F);
    }

    @Override
    protected void preRenderCallback(EntityButterfly entity, float partialTickTime)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityButterfly entity)
    {
        return RenderButterfly.BUTTERFLY_TEXTURE;
    }

    @Override
    public void doRender(EntityButterfly entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }


}
