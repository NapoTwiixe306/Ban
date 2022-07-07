package fr.napotwiixe.banpl.commands;

import fr.napotwiixe.banpl.Main;
import fr.napotwiixe.banpl.manager.PlayerManager;
import fr.napotwiixe.banpl.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class kick implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage("Seul un joueur peut executer cette commande !, vous ne pouvez pas l'executer depuis la console");
            return false;
        }

        Player player = (Player) sender;

        if(label.equalsIgnoreCase("gkick")){
            if(!player.hasPermission("moderation.gkick")){
                player.sendMessage("§cVous n'avez pas la permission d'éxecuter cette commande !, vous devez être OP!!!");
                return false;
            }

            if(label.equalsIgnoreCase("gkick")){
                if(args.length != 1){
                    player.sendMessage("§cVeuillez saisir le pseudo d'un joueur svp !");
                    return false;
                }

                String targetName = args[0];

                if(Bukkit.getPlayer(targetName) == null){
                    player.sendMessage("§cCe joueur n'est pas connecté ou n'existe pas !");
                    return false;
                }

                Player target = Bukkit.getPlayer(targetName);

                Inventory inv = Bukkit.createInventory(null, 54, "§bBan de : §c" + target.getName());


                inv.setItem(11, new ItemBuilder(Material.BOOKSHELF).setName("§cTrash-Talk").toItemStack());
                inv.setItem(12, new ItemBuilder(Material.BARRIER).setName("§cInsulte-Server").toItemStack());
                inv.setItem(13, new ItemBuilder(Material.BOOK).setName("§cPub").toItemStack());

                player.openInventory(inv);

            }


        }


        return false;
    }
}
