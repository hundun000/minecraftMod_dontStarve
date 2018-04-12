package hundun.dontstarve.worldgen;

import java.util.Random;

import hundun.dontstarve.block.BlockLoader;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.event.terraingen.OreGenEvent;

public class WorldGeneratorBoulder extends WorldGenerator
{
	private final WorldGenMinable boulderGenerator = new WorldGenMinable(BlockLoader.boulder.getDefaultState(), 16);
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position){
		if (TerrainGen.generateOre(worldIn, rand, this, position, OreGenEvent.GenerateMinable.EventType.CUSTOM)){
	            
			for (int i = 0; i < 4; ++i){
	                int posX = position.getX() + rand.nextInt(16);
	                int posY = 16 + rand.nextInt(16);
	                int posZ = position.getZ() + rand.nextInt(16);
	                BlockPos blockpos = new BlockPos(posX, posY, posZ);
	                Biome biomeGenBase = worldIn.getBiomeGenForCoords(blockpos);
	                if (biomeGenBase.getRainfall() < rand.nextInt(65536)){
	                	boulderGenerator.generate(worldIn, rand, blockpos);
	                }
	            
			}
	        
		}
	       
		return true;
		
	}
	
			

}
