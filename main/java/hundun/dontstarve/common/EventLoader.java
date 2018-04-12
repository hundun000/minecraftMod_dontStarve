package hundun.dontstarve.common;


import java.util.Random;

import com.sun.xml.internal.ws.dump.LoggingDumpTube.Position;

import hundun.dontstarve.block.BlockBerryBush;
import hundun.dontstarve.block.BlockLoader;
import hundun.dontstarve.entity.EntityButterfly;
import hundun.dontstarve.item.ItemLoader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class EventLoader {
	
	public static int ticks;
	public static int secends;
	
	public EventLoader()
    {
        MinecraftForge.EVENT_BUS.register(this);
        ticks=0;
        secends=0;
    }

	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void spiderDrop(LivingDropsEvent event)
	{
	    if (event.getEntity() instanceof EntitySpider)
	    {
	        int radomint=getRadomInt(3);
	        if(radomint==0){
	        ItemStack itemStackToDrop = new ItemStack(ItemLoader.spiderGland, 1);
	        event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, 
	              event.getEntity().posY, event.getEntity().posZ, itemStackToDrop));
	        }
	    }
	} 

	//改为点击浆果丛即可收货浆果
	/*
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void berriesBushclick(BlockEvent event)
	{
		System.out.println("触发了方块破坏事件");
	    if (event.getState().getBlock() == BlockLoader.berryBush)
	    {	        	    	
	    	if (!event.getWorld().isRemote) {
	    		System.out.println("被破坏的方块为浆果丛");
	    		BlockPos pos=event.getPos();
	            EntityItem entity = new EntityItem(event.getWorld(), pos.getX(), pos.getY(),pos.getZ(), new ItemStack(ItemLoader.berries, 1));	            
	            event.getWorld().spawnEntityInWorld(entity); // 放置实体
	            event.getWorld().setBlockState(pos,Blocks.DEADBUSH.getDefaultState());
	            event.setCanceled(true);
	        }
	        	        
	    }
	} 
    */
	
	@SubscribeEvent
    public void onPlayerClickGrassBlock(BonemealEvent event)
    {
        if (!event.getWorld().isRemote)
        {
        	
            if (event.getBlock()==Blocks.GRASS.getDefaultState())
            {
            	System.out.println("触发了骨粉对草方块施肥事件");
                EntityLiving entityLiving = new EntityButterfly(event.getWorld());
                BlockPos pos = event.getPos();
                entityLiving.setPositionAndUpdate(pos.getX() , pos.getY()+1, pos.getZ());
                event.getWorld().spawnEntityInWorld(entityLiving);
                return;
            }
        }
    }
	
	@SubscribeEvent
	public void onServerTick(TickEvent.ServerTickEvent event)
	{
	    if(!Minecraft.getMinecraft().isGamePaused() && Minecraft.getMinecraft().theWorld != null)
	    {
	        ticks++;
	        
	        if(ticks>20){
	        	ticks=0;
	        	secends++;
	        	System.out.println("Sever:+1S");
	        }
	        	
	    }
	}
	
	
	//get [0,max] radom int
	private int getRadomInt(int max){
		Random random = new Random();
		return random.nextInt(max);
	}

}
