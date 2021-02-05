package eu.bidulaxstudio.flyflewflown;

import eu.bidulaxstudio.flyflewflown.enums.GameState;
import eu.bidulaxstudio.flyflewflown.management.*;
import eu.bidulaxstudio.flyflewflown.mechanics.PlayerFly;
import eu.bidulaxstudio.flyflewflown.mechanics.PlayerMove;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;
import java.util.Map;

public final class Main extends JavaPlugin {

    public Location greenLocation = new Location(Bukkit.getWorlds().get(0), 50.5, 8, 50.5);
    public Location redLocation = new Location(Bukkit.getWorlds().get(0), -50.5, 8, -50.5);

    public Location waitingSpawnLocation = new Location(Bukkit.getWorlds().get(0), -5.5, 3.5, -0.5);
    public Location greenWaitingLocation = new Location(Bukkit.getWorlds().get(0), 1.5, 3.5, 6.5);
    public Location redWaitingLocation = new Location(Bukkit.getWorlds().get(0), -12.5, 3.5, -7.5);

    public Map<String, Double> numberOfFuel = new HashMap<>();

    public GameState gameState = GameState.NOT_STARTED;
    public PlayerTeam playerTeam;
    public PlayerChat playerChat;
    public PlayerStuff playerStuff;
    public PlayerLocation playerLocation;
    public PlayerInteract playerInteract;
    public PlayerFly playerFly;

    public GameManager gameManager;

    @Override
    public void onEnable() {
        playerTeam = new PlayerTeam(this);
        playerChat = new PlayerChat(this);
        playerStuff = new PlayerStuff(this);
        playerLocation = new PlayerLocation(this);
        playerInteract = new PlayerInteract(this);

        gameManager = new GameManager(this);

        getCommand("fff").setExecutor(new FffCommand(this));

        playerFly = new PlayerFly(this);
        PlayerMove playerMove = new PlayerMove(this);

        createTeam("Green", ChatColor.GREEN, "Verte");
        createTeam("Red", ChatColor.RED, "Rouge");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void createTeam(String name, ChatColor color, String displayName) {
        Scoreboard mainScoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        if (mainScoreboard.getTeam(name) == null) {
            Team team = Bukkit.getScoreboardManager().getMainScoreboard().registerNewTeam(name);
            team.setColor(color);
            team.setDisplayName(displayName);
        } else {
            Team team = mainScoreboard.getTeam(name);
            if (team.getColor() != color)
                team.setColor(color);
            if (!team.getDisplayName().equals(displayName))
                team.setDisplayName(displayName);
        }
    }
}
