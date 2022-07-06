package fr.napotwiixe.banpl;

import fr.napotwiixe.banpl.commands.ban;
import fr.napotwiixe.banpl.commands.mute;
import fr.napotwiixe.banpl.listener.BanEvents;
import fr.napotwiixe.banpl.listener.KickEvents;
import fr.napotwiixe.banpl.listener.MuteEvents;
import fr.napotwiixe.banpl.manager.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Main extends JavaPlugin implements Listener {

    private static Main Instance;

    public ArrayList<UUID> moderateurs = new ArrayList<UUID>();
    public HashMap<UUID, PlayerManager> players = new HashMap<>();

    @Override
    public void onEnable() {
        Instance = this;
        registerEvents();
        getCommand("gban").setExecutor(new ban());
        getCommand("gmute").setExecutor(new mute());

    }
    public static Main getInstance() {
        return Instance;
    }

    @Override
    public void onDisable() {

        super.onDisable();
    }

    private void registerEvents(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new BanEvents(), this);
        pm.registerEvents(new MuteEvents(), this);
        pm.registerEvents(new KickEvents(), this);

    }
}
