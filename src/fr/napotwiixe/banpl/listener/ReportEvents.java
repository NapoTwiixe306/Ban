package fr.napotwiixe.banpl.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ReportEvents implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(e.getCurrentItem() == null) return;

        Player player = (Player) e.getWhoClicked();

        switch(e.getCurrentItem().getType()){

            case DIAMOND_SWORD:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cReach")){
                    e.setCancelled(true);
                    player.closeInventory();
                    sendToMods(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory().getName().substring(12));
                    player.sendMessage("§aVous avez bien ban ce joueur !");
                }
                break;
            default: break;
        }
    }
    private void sendToMods(String reason, String targetName) {
        for(Player players : Bukkit.getOnlinePlayers()){
            if(players.hasPermission("mod.receive")){
                players.sendMessage("§bLe joueur §a" + targetName + " §ba été ban pour : " + reason);
            }
        }
    }
}


