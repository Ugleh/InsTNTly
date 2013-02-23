package com.ugleh.instntly;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockRedstoneEvent;

public class InsTNTlyListener implements Listener{
	private static final InsTNTly instance = new InsTNTly();
	
	public static final InsTNTly getPlugin() {
		return instance;
		}
	
	 
	@EventHandler
	public void BlockRedstone(BlockRedstoneEvent event){
		if(event.getNewCurrent() >= 1){ //If the current of the block, be it a lever or redstone wire is ON
			Block blk = event.getBlock(); //Set the events block to the variable 'blk', because we are going to be using this alot.
			Block tntBlk = null; //This will be the TNT Block when we find it.
			Boolean tntExists = false;
			if(blk.getRelative(BlockFace.NORTH).getType().equals(Material.TNT)){
				tntBlk = blk.getRelative(BlockFace.NORTH);
				tntExists = true;
			}else if(blk.getRelative(BlockFace.EAST).getType().equals(Material.TNT)){
				tntBlk = blk.getRelative(BlockFace.EAST);
				tntExists = true;
			}else if(blk.getRelative(BlockFace.SOUTH).getType().equals(Material.TNT)){
				tntBlk = blk.getRelative(BlockFace.SOUTH);
				tntExists = true;
			}else if(blk.getRelative(BlockFace.WEST).getType().equals(Material.TNT)){
				tntBlk = blk.getRelative(BlockFace.WEST);
				tntExists = true;
			}
			if(tntExists){ //If tntExists is set to true, then there is a TNT Block in the area.
				tntBlk.setType(Material.AIR); //Sets the tntBlk to air so it does not trigger 2 explosions
				tntBlk.getWorld().createExplosion(tntBlk.getLocation(), 5); //Create an explosion, same area, same radius.
			}
			}
			
		}
		
}


