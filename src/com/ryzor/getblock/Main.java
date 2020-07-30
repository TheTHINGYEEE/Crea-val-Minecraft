package com.ryzor.getblock;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(PlayerInteractEvent event) {
		Action action = event.getAction();
		Player player = event.getPlayer();
		Block block = event.getClickedBlock();
		Material material = block.getType();
		EquipmentSlot hand = event.getHand();
		ItemStack item = new ItemStack(material);
		
		if(player.getGameMode().equals(GameMode.SURVIVAL)) {
			if(action.equals(Action.RIGHT_CLICK_BLOCK)) {
				if(hand == EquipmentSlot.HAND) {
					if(player.getInventory().contains(material)) {
						player.sendMessage("You have this on your inventory!");
						return;
					} else {
						player.getInventory().setItemInHand(item);
						return;
					}
				}
			}
		}
	}
}
