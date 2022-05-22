package dev.norska.dwaddon.lsc.ndev;

import dev.norska.dwaddon.lsc.ndev.handlers.CacheHandler;
import dev.norska.dwaddon.lsc.ndev.handlers.ConfigHandler;
import lombok.Getter;

public class NorskaHandler {
	
	@Getter private CacheHandler cacheHandler = new CacheHandler();
	@Getter private ConfigHandler configurationHandler = new ConfigHandler();

}
