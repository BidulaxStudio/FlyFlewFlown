package eu.bidulaxstudio.flyflewflown.management;

import eu.bidulaxstudio.flyflewflown.Main;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteract implements Listener {

    private final Main main;

    public PlayerInteract(Main main) {
        this.main = main;
        main.getServer().getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        if (event.getItem() == null) return;

        if (event.getItem().getType() == Material.SCUTE) {
            main.playerTeam.resetTeam(event.getPlayer());
        }
    }

}
