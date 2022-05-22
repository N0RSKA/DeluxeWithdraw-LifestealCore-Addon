package dev.norska.dwaddon.lsc.ndev.handlers;

import java.io.File;
import java.io.IOException;

import dev.norska.dwaddon.lsc.LSCAddon;
import dev.norska.dwaddon.lsc.config.CommentedConfiguration;
import lombok.Getter;

public class ConfigHandler {
	
	@Getter private CommentedConfiguration configFile;
	
	private File path = null;
	
	public void generateFiles(LSCAddon main) throws IOException {
		
		if(path == null) path = new File("plugins/DeluxeWithdraw/addons");
		if(!path.exists()) path.mkdirs();
		
		File file = new File(path, "addon-lifestealcore.yml");

        if(!file.exists()) file.createNewFile();

        configFile = CommentedConfiguration.loadConfiguration(file);
        try {
			configFile.syncWithConfig(file, main.getResource("addon-lifestealcore.yml"), "no");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
