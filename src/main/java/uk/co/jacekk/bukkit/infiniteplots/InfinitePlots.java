package uk.co.jacekk.bukkit.infiniteplots;



import org.bukkit.generator.ChunkGenerator;

import uk.co.jacekk.bukkit.baseplugin.v1.BasePlugin;

public class InfinitePlots extends BasePlugin {
	

	
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id){
		
		return new sineGenerator();
	}
	
}