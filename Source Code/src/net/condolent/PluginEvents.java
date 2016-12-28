package net.condolent;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PluginEvents implements Listener {

	PluginMain plugin;
	
	public void PluginMain(PluginMain instance) {
		plugin = instance;
	}
	
	@SuppressWarnings("unused")
	@EventHandler
	public void onMsgSound(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String pName = p.getName().toString();
		Location location = p.getLocation();
		Player allPlayers = (Player) Bukkit.getServer().getOnlinePlayers();
		Location allLocation = allPlayers.getLocation();
		
		if(plugin.getConfig().getInt("chatSound") == 1) {
			p.getWorld().playSound(allLocation, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
		} else {
			// Do nothing
		}
	}
	
	// Play sound on player join
	@SuppressWarnings("unused")
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		String pName = p.getName().toString();
		Location location = p.getLocation();
		Player allPlayers = (Player) Bukkit.getServer().getOnlinePlayers();
		Location allLocation = allPlayers.getLocation();
		
		if(plugin.getConfig().getInt("playerJoinSound") == 1) {
			p.getWorld().playSound(allLocation, Sound.BLOCK_ANVIL_HIT, 1, 0);
		} else {
			// Do nothing
		}
		
		if(plugin.getConfig().getInt("playerJoinMsg") == 1) {
			e.setJoinMessage(ChatColor.BOLD + "* " + ChatColor.GREEN + p.getName() + ChatColor.RESET + "" + ChatColor.GREEN + " has joined the server!");
		} else {
			// Do nothing
		}
	}
}
