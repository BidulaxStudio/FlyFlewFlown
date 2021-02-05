package eu.bidulaxstudio.flyflewflown.management;

import eu.bidulaxstudio.flyflewflown.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class PlayerTeam {

    private final Main main;
    private final ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();

    public PlayerTeam(Main main) {
        this.main = main;
    }

    public void resetTeam(Player player) {
        Scoreboard scoreboard = scoreboardManager.getMainScoreboard();
        if (scoreboard.getPlayerTeam(player) == null) return;
        scoreboard.getPlayerTeam(player).removePlayer(player);
        main.playerChat.sendTitle(player, "white", "- RESET -", "gray", "Vous n'avez plus d'équipe...");
        main.playerLocation.teleportWaitingSpawn(player);
    }

    public void setGreen(Player player) {
        Scoreboard scoreboard = scoreboardManager.getMainScoreboard();
        scoreboard.getTeam("Green").addPlayer(player);
        main.playerChat.sendTitle(player, "green", "- VERT -", "gray", "Vous avez rejoint cette équipe !");
        main.playerLocation.teleportGreenWaiting(player);
    }

    public void setRed(Player player) {
        Scoreboard scoreboard = scoreboardManager.getMainScoreboard();
        scoreboard.getTeam("Red").addPlayer(player);
        main.playerChat.sendTitle(player, "red", "- ROUGE -", "gray", "Vous avez rejoint cette équipe !");
        main.playerLocation.teleportRedWaiting(player);
    }

}
