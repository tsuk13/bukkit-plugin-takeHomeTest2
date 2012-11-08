package uk.co.jacekk.bukkit.infiniteplots;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

public class sineGenerator extends ChunkGenerator {
	
	public void setBlock(byte[][] result, int x, int y, int z, int blkid) {
        if (result[y >> 4] == null) {
            result[y >> 4] = new byte[4096];
        }
        result[y >> 4][((y & 0xF) << 8) | (z << 4) | x] = (byte) blkid;
    }
	
	public List<BlockPopulator> getDefaultPopulators(World world){
		ArrayList<BlockPopulator> list = new ArrayList<BlockPopulator>();
		list.add(new treePopulator());
		return list;
		
	}
	
	@Override
	public byte[][] generateBlockSections(World world, Random random, int chunkX, int chunkZ, BiomeGrid biomes){
		byte[][] result = new byte[16][];
		for(int x = 0; x < 16; x++){
			for(int z = 0; z < 16; z++){
				setBlock(result, x, 0, z, Material.BEDROCK.getId());
				int y = 1;
				for(y = 1; y < (Math.sin((chunkX * 16 + x)*(Math.PI / 64)) * 12 + 12); y++ ){
					setBlock(result, x, y, z, Material.DIRT.getId());
				}
				setBlock(result, x, y, z, Material.GRASS.getId());
			}
		}
		return result;
		
	}
}