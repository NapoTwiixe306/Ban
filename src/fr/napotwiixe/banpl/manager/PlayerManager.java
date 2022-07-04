package fr.napotwiixe.banpl.manager;

import fr.napotwiixe.banpl.Main;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlayerManager {

    private Player player;
    private ItemStack[] items = new ItemStack[40];

    public PlayerManager(Player player){
        this.player = player;
    }

    public void init(){
        Main.getInstance().players.put(player.getUniqueId(), this);
    }

    public void destroy(){
        Main.getInstance().players.get(player.getUniqueId());
    }

    public static PlayerManager getFromPlayer(Player player){
        return Main.getInstance().players.get(player.getUniqueId());
    }

    public static boolean isInModerationMod(Player player){
        return Main.getInstance().moderateurs.contains(player.getUniqueId());
    }

    public ItemStack[] getItems() {
        return items;
    }

}
