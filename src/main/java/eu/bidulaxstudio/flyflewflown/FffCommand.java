package eu.bidulaxstudio.flyflewflown;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.List;

public class FffCommand implements CommandExecutor, TabCompleter {

   private final Main main;

    public FffCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) return false;

        switch (args[0]) {

            case "start":

                if (main.gameManager.startGame()) {
                    main.playerChat.sendMessage(sender, ChatColor.GREEN + "Le jeu est maintenant en train de démarrer...");
                } else {
                    main.playerChat.sendMessage(sender, ChatColor.RED + "Vous ne pouvez pas démarrer le jeu, il est déjà démarré.");
                }

            case "value":
                if (args.length == 1) return false;

                switch (args[1]) {

                    case "gameState":
                        main.playerChat.sendMessage(sender, ChatColor.GREEN + "Value gameState : " + main.gameState);

                    case "fuel":
                        if (args.length == 2) return false;
                        if (Bukkit.getPlayer(args[2]) == null) {
                            main.playerChat.sendMessage(sender, ChatColor.RED + "Le joueur " + args[2] + " n'a pas été trouvé.");
                            return false;
                        }
                        Player target = Bukkit.getPlayer(args[2]);
                        main.playerChat.sendMessage(sender, ChatColor.GREEN + "Value fuel " + target.getName()  + " : " + main.playerFly.getFuel(target));

                }


        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
