package uk.co.jacekk.bukkit.infiniteplots;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class treePopulator extends BlockPopulator{

	@Override
	public void populate(World world, Random random, Chunk source) {
		for(int x = 0; x < 16; x++){
			for(int z = 0; z < 16; z++){
				if(random.nextInt(1000) < 1){
					world.generateTree(world.getHighestBlockAt(source.getX()*16 + x, source.getZ() * 16 + z).getLocation(), TreeType.TREE);
				}
			}
		}
		
	}

}
