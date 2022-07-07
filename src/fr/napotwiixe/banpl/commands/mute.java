package fr.napotwiixe.banpl.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class mute implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("Seul un joueur peut executer cette commande !, vous ne pouvez pas l'executer depuis la console");
            return false;
        }

        Player player = (Player) sender;

        if(label.equalsIgnoreCase("gban")) {
            if (!player.hasPermission("moderation.gban")) {
                player.sendMessage("§cVous n'avez pas la permission d'éxecuter cette commande !, vous devez être OP!!!");
                return false;
            }
        }

        if(label.equalsIgnoreCase("gmute")){
            if(args.length != 1){
                player.sendMessage("§cVeuilliez saisir le pseudo d'un joueur svp !");
                return false;
            }

            String tagetName = args[0];

            if(Bukkit.getPlayer(tagetName) == null){
                player.sendMessage("§cCe Joueur n'est pas connecté ou n'existe pas !");
                return false;
            }

            Player target = Bukkit.getPlayer(tagetName);

            Inventory inv = Bukkit.createInventory(null, 54, "§bMute de : §c" + target.getName());

            player.openInventory(inv);
        }

        return false;
    }
}
