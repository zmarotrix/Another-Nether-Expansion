package zmarotrix.anothernetherexpansion;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class OreGeneration implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX, chunkZ);
			break;
		case 0:
			//generateOverworld(world, random, chunkX, chunkZ);
			break;
		case 1:
			//generateEnd(world, random, chunkX, chunkZ);
			break;
		}
	}
	
	public void generateNether(World world, Random rand, int x, int z)
	{
		generateOre(AnotherNetherExpansion.oreLonsdaleiteOre, world, rand, x, z, 10, 16, 10, 0, 255, Blocks.netherrack);
		generateOre(AnotherNetherExpansion.oreCelenegilOre, world, rand, x, z, 6, 10, 10, 0, 255, Blocks.netherrack);
		generateOre(AnotherNetherExpansion.blockFyrestone, world, rand, x, z, 8, 10, 20, 0, 255, Blocks.lava);
		generateOre(AnotherNetherExpansion.oreAdamantineOre, world, rand, x, z, 6, 8, 10 + rand.nextInt(20), 100, 255, Blocks.netherrack);
		generateOre(AnotherNetherExpansion.oreAdamantineOre, world, rand, x, z, 4, 5, 2, 0, 99, Blocks.netherrack);
	}
	
	public void generateOverworld(World world, Random rand, int x, int z) 
	{

	}
	
	public void generateEnd(World world, Random rand, int x, int z) 
	{

	}
	
	public void generateOre(Block block, World world, Random random, int chunkX, int chunkZ, int minVeinSize, int maxVeinSize, 
			int chance, int minY, int maxY, Block generateIn) {
		
		//calculates size of ore vein.
		int veinSize = minVeinSize + random.nextInt(maxVeinSize - minVeinSize);
		//calculates max height.
		int heightRange = maxY-minY;
		
		WorldGenMinable gen= new WorldGenMinable(block, veinSize, generateIn);
		
		for(int i = 0; i < chance; i++)
		{
			int xRand = chunkX * 16 + random.nextInt(16);
			int yRand = random.nextInt(heightRange) + minY;
			int zRand = chunkZ * 16 + random.nextInt(16);
			gen.generate(world, random, xRand, yRand, zRand);
		}
		
		
		
		
	}
	
	
	
	

}
