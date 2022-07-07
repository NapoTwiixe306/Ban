package fr.napotwiixe.banpl.listener;


import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class KickEvents implements Listener {


    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(e.getCurrentItem() == null) return;

        Player player = (Player) e.getWhoClicked();

        switch(e.getCurrentItem().getType()){

            case BOOKSHELF:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cTrash-Talk")){
                    e.setCancelled(true);
                    player.closeInventory();
                    sendToMods(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory().getName().substring(11));
                    player.kickPlayer("Vous avez été kick pour : §cTrash-Talk");

                }
                break;
            case BARRIER:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cInsulte-Server")){
                    e.setCancelled(true);
                    player.closeInventory();
                    sendToMods(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory().getName().substring(11));
                    player.kickPlayer("Vous avez été kick pour : §cInsulte-Server");

                }
                break;
            case BOOK:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cPub")){
                    e.setCancelled(true);
                    player.closeInventory();
                    sendToMods(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory().getName().substring(11));
                    player.kickPlayer("Vous avez été kick pour : §cPub");

                }
                break;

            default: break;
        }
    }
    private void sendToMods(String reason, String targetName) {
        for(Player players : Bukkit.getOnlinePlayers()){
            if(players.hasPermission("gkick.receive")){
                players.sendMessage(targetName + " §ba été kick pour : " + reason);
            }
        }
    }
}


