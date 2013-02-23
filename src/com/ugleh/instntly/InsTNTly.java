package com.ugleh.instntly;

import org.bukkit.plugin.java.JavaPlugin;

public class InsTNTly extends JavaPlugin{

	public void onEnable(){
		getServer().getPluginManager().registerEvents(new InsTNTlyListener(), this);
		
	}
}