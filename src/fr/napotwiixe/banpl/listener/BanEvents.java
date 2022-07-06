package fr.napotwiixe.banpl.listener;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BanEvents implements Listener {


    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(e.getCurrentItem() == null) return;

        Player player = (Player) e.getWhoClicked();

        switch(e.getCurrentItem().getType()){

            case DIAMOND_SWORD:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cReach")){
                    e.setCancelled(true);
                    player.closeInventory();
                    sendToMods(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory().getName().substring(11));
                    Bukkit.getBanList(BanList.Type.NAME).addBan(player.getName(), "§cReach", null, player.getName());
                    player.kickPlayer("Vous avez été ban pour : §cReach");

                }
                break;
            case WOOD_AXE:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cKillAura")) {
                    e.setCancelled(true);
                    player.closeInventory();
                    sendToMods(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory().getName().substring(11));
                    Bukkit.getBanList(BanList.Type.NAME).addBan(player.getName(), "§cKillAura", null, player.getName());
                    player.kickPlayer("Vous avez été ban pour : §cKillAura");

                }
                break;
            case PAPER:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cRacisme")) {
                    e.setCancelled(true);
                    player.closeInventory();
                    sendToMods(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory().getName().substring(11));
                    Bukkit.getBanList(BanList.Type.NAME).addBan(player.getName(), "§cRacisme", null, player.getName());
                    player.kickPlayer("Vous avez été ban pour :  §cRacisme");
                }
                break;
            case BOW:
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cAutoBow")){
                    e.setCancelled(true);
                    player.closeInventory();
                sendToMods(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory().getName().substring(11));
                Bukkit.getBanList(BanList.Type.NAME).addBan(player.getName(), "§cAutoBow", null, player.getName());
                player.kickPlayer("Vous avez été ban pour : §cAutoBow");
                }
            default: break;
        }
    }
    private void sendToMods(String reason, String targetName) {
        for(Player players : Bukkit.getOnlinePlayers()){
            if(players.hasPermission("gban.receive")){
                players.sendMessage(targetName + " §ba été ban pour : " + reason);
            }
        }
    }
}


