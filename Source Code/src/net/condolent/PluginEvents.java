package net.condolent;

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
	
	public PluginEvents(PluginMain instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onMsgSound(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		Location location = p.getLocation();

		p.getWorld().playSound(location, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
		if(plugin.getConfig().getInt("chatSound") == 1) {
		} else {
			// Do nothing
		}
	}
	
	// Play sound on player join
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		Location location = p.getLocation();
		
		if(plugin.getConfig().getBoolean("playerJoinSound")) {
			p.getWorld().playSound(location, Sound.BLOCK_ANVIL_HIT, 1, 0);
		} else {
			// Do nothing
		}
		
		if(plugin.getConfig().getBoolean("playerJoinMsg")) {
			if(plugin.getConfig().getBoolean("adminJoinMsg")) {
				if(p.isOp() || p.hasPermission(plugin.admin)) {
					e.setJoinMessage(ChatColor.BOLD + "* [Admin] " + ChatColor.GREEN + p.getName() + ChatColor.RESET + "" + ChatColor.GREEN + " has joined the server!");
				} else {
					// If player is not an admin
					e.setJoinMessage(ChatColor.BOLD + "* " + ChatColor.GREEN + p.getName() + ChatColor.RESET + "" + ChatColor.GREEN + " has joined the server!");
				}
			} else {
				e.setJoinMessage(ChatColor.BOLD + "* " + ChatColor.GREEN + p.getName() + ChatColor.RESET + "" + ChatColor.GREEN + " has joined the server!");
			}
		} else {
			// Do nothing
		}
	}
}
