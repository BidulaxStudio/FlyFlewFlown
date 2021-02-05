package eu.bidulaxstudio.flyflewflown.management;

import eu.bidulaxstudio.flyflewflown.Main;
import org.bukkit.entity.Player;

public class PlayerLocation {

    private final Main main;

    public PlayerLocation(Main main) {
        this.main = main;
    }

    public void teleportWaitingSpawn(Player player) {
        player.teleport(main.waitingSpawnLocation);
    }
    public void teleportGreenWaiting(Player player) {
        player.teleport(main.greenWaitingLocation);
    }
    public void teleportRedWaiting(Player player) {
        player.teleport(main.redWaitingLocation);
    }
    public void teleportGreen(Player player) {
        player.teleport(main.greenLocation);
    }
    public void teleportRed(Player player) {
        player.teleport(main.redLocation);
    }

}
