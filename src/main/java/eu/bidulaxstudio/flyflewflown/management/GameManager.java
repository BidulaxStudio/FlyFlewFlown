package eu.bidulaxstudio.flyflewflown.management;

import eu.bidulaxstudio.flyflewflown.Main;
import eu.bidulaxstudio.flyflewflown.enums.GameState;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Team;

public class GameManager extends BukkitRunnable {

    private final Main main;
    private int timer = 0;
    private boolean showed = false;
    private final Team greenTeam = Bukkit.getScoreboardManager().getMainScoreboard().getTeam("Green");
    private final Team redTeam = Bukkit.getScoreboardManager().getMainScoreboard().getTeam("Red");

    public GameManager(Main main) {
        this.main = main;
        this.runTaskTimer(main, 0, 20);
    }

    public boolean startGame() {
        if (main.gameState == GameState.NOT_STARTED) {
            timer = 10;
            showed = true;
            main.gameState = GameState.STARTING;
            return true;
        }
        return false;
    }

    private void timerFinished() {
        startTeams();

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            main.playerChat.sendTitle(onlinePlayer, "light_purple", "- PARTEZ -", "gray", "La partie commence !");
        }
        main.gameState = GameState.STARTED;
        showed = false;
    }

    private void startTeams() {
        for (OfflinePlayer offlinePlayer : greenTeam.getPlayers()) {

            if (offlinePlayer.getPlayer() == null) {
                greenTeam.removePlayer(offlinePlayer);
            }

            Player player = offlinePlayer.getPlayer();
            main.playerLocation.teleportGreen(player);
            main.playerStuff.giveGreenKit(player);
        }
        for (OfflinePlayer offlinePlayer : redTeam.getPlayers()) {

            if (offlinePlayer.getPlayer() == null) {
                redTeam.removePlayer(offlinePlayer);
            }

            Player player = offlinePlayer.getPlayer();
            main.playerLocation.teleportRed(player);
            main.playerStuff.giveRedKit(player);
        }
    }

    @Override
    public void run() {
        if (showed) {
            String color = "green";
            if (timer > 5) color = "green";
            else if (timer > 3) color = "gold";
            else if (timer > 0) color = "red";
            if (timer == 0) {
                timerFinished();
            } else {
                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) main.playerChat.sendTitle(onlinePlayer, color, Integer.toString(timer), "yellow", "La partie va commencer !");
                timer--;
            }
        }
    }

}
