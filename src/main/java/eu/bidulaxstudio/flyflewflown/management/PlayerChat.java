package eu.bidulaxstudio.flyflewflown.management;

import eu.bidulaxstudio.flyflewflown.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scoreboard.Team;

public class PlayerChat implements Listener {

    private final Main main;
    private final String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_PURPLE + "FlyFlewFlown" + ChatColor.DARK_GRAY + "] ";
    private final ConsoleCommandSender console = Bukkit.getConsoleSender();

    public PlayerChat(Main main) {
        this.main = main;
        main.getServer().getPluginManager().registerEvents(this, main);
    }

    public void broadcastMessage(String message) {
        Bukkit.broadcastMessage(prefix + message);
    }

    public void sendMessage(CommandSender sender, String message) {
        sender.sendMessage(prefix + message);
    }

    public void sendTitle(Player player, String titleColor, String title, String subtitleColor, String subtitle) {
        Bukkit.dispatchCommand(console, "title " + player.getName() + " subtitle {\"text\": \"" + subtitle + "\", \"color\": \"" + subtitleColor + "\"}");
        Bukkit.dispatchCommand(console, "title " + player.getName() + " title {\"text\": \"" + title + "\", \"color\": \"" + titleColor + "\"}");
    }

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent event) {
        event.setCancelled(true);
        switch (main.gameState) {
            case STARTED:
                Team team = Bukkit.getScoreboardManager().getMainScoreboard().getPlayerTeam(event.getPlayer());
                if (team != null) Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + team.getColor() + event.getPlayer().getDisplayName() + ChatColor.DARK_GRAY + "] " + ChatColor.GOLD + event.getMessage());
                else Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.LIGHT_PURPLE + event.getPlayer().getDisplayName() + ChatColor.DARK_GRAY + "] " + ChatColor.GOLD + event.getMessage());
                break;
            default:
                Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.LIGHT_PURPLE + event.getPlayer().getDisplayName() + ChatColor.DARK_GRAY + "] " + ChatColor.GOLD + event.getMessage());
                break;
        }
    }

}

