package eu.bidulaxstudio.flyflewflown.mechanics;

import eu.bidulaxstudio.flyflewflown.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {

    private final Main main;

    public PlayerMove(Main main) {
        this.main = main;
        main.getServer().getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {

        if (event.getTo() == null) return;

        // event.getPlayer().sendMessage((int) event.getTo().getX() + " / " + (int) event.getTo().getY() + " / " + (int) event.getTo().getZ());

        if ((int) event.getTo().getX() == -1 && (int) event.getTo().getY() == 3 && (int) event.getTo().getZ() == 3) {
            main.playerTeam.setGreen(event.getPlayer());
        }
        else if ((int) event.getTo().getX() == -9 && (int) event.getTo().getY() == 3 && (int) event.getTo().getZ() == -4) {
            main.playerTeam.setRed(event.getPlayer());
        }
        else if ((int) event.getTo().getX() == 3 && (int) event.getTo().getY() == 3 && (int) event.getTo().getZ() == 8) {
            main.playerTeam.resetTeam(event.getPlayer());
        }
        else if ((int) event.getTo().getX() == -14 && (int) event.getTo().getY() == 3 && (int) event.getTo().getZ() == -9) {
            main.playerTeam.resetTeam(event.getPlayer());
        }
    }

}
