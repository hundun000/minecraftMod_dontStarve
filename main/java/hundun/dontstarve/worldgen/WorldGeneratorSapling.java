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
import net.minecraftforge.event.terraingen.BiomeEvent;

public class WorldGeneratorSapling extends WorldGenerator
{
	private final WorldGenMinable saplingGenerator = new WorldGenMinable(BlockLoader.berryBush.getDefaultState(), 1);
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position){
    	Biome b = worldIn.getBiomeGenForCoords(position);
        if(true){//b.getBiomeName().equals("Plains")) { // || b.biomeName.equals("Extreme Hills") || b.biomeName.equals("Forest")) {
        	for (int l = 0; l < 2; ++l){          
        		int i1 = position.getX() + rand.nextInt(4) - rand.nextInt(4);            
        		int j1 = position.getY() + rand.nextInt(4) - rand.nextInt(4);          
        		int k1 = position.getZ() + rand.nextInt(4) - rand.nextInt(4);            
        		BlockPos blockpos = new BlockPos(i1, j1, k1);                       
        		if (worldIn.isAirBlock(blockpos) && BlockLoader.berryBush.canPlaceBlockAt(worldIn,blockpos)){                   
        			worldIn.setBlockState(blockpos,BlockLoader.berryBush.getDefaultState());           
        		}
        		
        	}   		
        }
        return true;
  }
	
	
	
}

	
			

