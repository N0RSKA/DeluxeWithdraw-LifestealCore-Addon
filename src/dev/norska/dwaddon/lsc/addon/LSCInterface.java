package dev.norska.dwaddon.lsc.addon;

import java.util.List;

import org.bukkit.entity.Player;

import dev.norska.dw.api.DWAddonInterface;
import dev.norska.dwaddon.lsc.LSCAddon;
import dev.norska.lsc.LifestealCore;
import dev.norska.lsc.api.LifestealCoreAPI;

public class LSCInterface implements DWAddonInterface {
	
	LifestealCoreAPI LSCAPI = LifestealCore.getInstance().getAPI();

	@Override
	public void add(Player p, Double amount) {
		
		if(LSCAPI.getPlayerHearts(p.getUniqueId()) == LSCAPI.getPlayerMaxHearts(p.getUniqueId())) return;
		
		LSCAPI.addPlayerHearts(p.getUniqueId(), amount.intValue());
	}

	@Override
	public void add(Player p, Integer amount) {
		
		if(LSCAPI.getPlayerHearts(p.getUniqueId()) == LSCAPI.getPlayerMaxHearts(p.getUniqueId())) return;
		
		LSCAPI.addPlayerHearts(p.getUniqueId(), amount.intValue());
	}

	@Override
	public String adminCreator() {
		return LSCAddon.getInstance().getNHandler().getCacheHandler().getCreatorForAdminItems();
	}

	@Override
	public int currencyFormat() {
		return LSCAddon.getInstance().getNHandler().getCacheHandler().getCurrencyFormat();
	}

	@Override
	public String currencyString() {
		return LSCAddon.getInstance().getNHandler().getCacheHandler().getCurrencyName();
	}

	@Override
	public Double getCurrent(Player p) {
		return (double) LSCAPI.getPlayerHearts(p.getUniqueId());
	}

	@Override
	public Boolean has(Player p, Double amount) {
		return LSCAPI.getPlayerHearts(p.getUniqueId()) >= amount;
	}

	@Override
	public Boolean has(Player p, Integer amount) {
		return LSCAPI.getPlayerHearts(p.getUniqueId()) >= amount;
	}

	@Override
	public String layout() {
		return LSCAddon.getInstance().getNHandler().getCacheHandler().getItemLayout();
	}

	@Override
	public Double maxWithdraw() {
		return LSCAddon.getInstance().getNHandler().getCacheHandler().getMaxWithdraw();
	}

	@Override
	public Double minWithdraw() {
		return LSCAddon.getInstance().getNHandler().getCacheHandler().getMinWithdraw();
	}

	@Override
	public void set(Player p, Double arg1) {
		
		
	}

	@Override
	public void set(Player p, Integer amount) {
		
	}

	@Override
	public void take(Player p, Double amount) {
		LSCAPI.removePlayerHearts(p.getUniqueId(), amount.intValue(), true);
	}

	@Override
	public void take(Player p, Integer amount) {
		LSCAPI.removePlayerHearts(p.getUniqueId(), amount, true);

	}

	@Override
	public List<String> withdrawCommands() {
		return LSCAddon.getInstance().getNHandler().getCacheHandler().getCommands();
	}

	@Override
	public void reloadConfiguration() {
		LSCAddon.getInstance().generateFiles();
		LSCAddon.getInstance().cache();
	}

	@Override
	public Boolean useInt() {
		return true;
	}

}
