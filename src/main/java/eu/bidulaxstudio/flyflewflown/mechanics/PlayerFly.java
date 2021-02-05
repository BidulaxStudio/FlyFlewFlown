package eu.bidulaxstudio.flyflewflown.mechanics;

import eu.bidulaxstudio.flyflewflown.Main;
import eu.bidulaxstudio.flyflewflown.enums.GameState;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerFly extends BukkitRunnable implements Listener {

    private final Main main;
    private final ConsoleCommandSender console = Bukkit.getConsoleSender();

    public PlayerFly(Main main) {
        this.main = main;
        main.getServer().getPluginManager().registerEvents(this, main);
        this.runTaskTimer(main, 0, 1);
    }

    public double getFuel(Player player) {
        if (main.numberOfFuel.containsKey(player.getName())) {
            return main.numberOfFuel.get(player.getName());
        } else {
            main.numberOfFuel.put(player.getName(), 800.0d);
            return 800.0d;
        }
    }

    private void setFuel(Player player, double fuel) {
        if (fuel > 800.0d) fuel = 800.0d;
        if (main.numberOfFuel.containsKey(player.getName())) {
            main.numberOfFuel.replace(player.getName(), fuel);
        } else {
            main.numberOfFuel.put(player.getName(), fuel);
        }
    }

    private void addFuel(Player player, double fuel) {
        double oldFuel = getFuel(player);
        if (fuel + oldFuel > 800) {
            setFuel(player, 800);
            return;
        }
        if (main.numberOfFuel.containsKey(player.getName())) {
            main.numberOfFuel.replace(player.getName(), oldFuel + fuel);
        } else {
            main.numberOfFuel.put(player.getName(), 800.0d);
        }
    }

    private void removeFuel(Player player, double fuel) {
        double oldFuel = getFuel(player);
        if (oldFuel - fuel < 0) {
            setFuel(player, 0);
            return;
        }
        if (main.numberOfFuel.containsKey(player.getName())) {
            main.numberOfFuel.replace(player.getName(), oldFuel - fuel);
        } else {
            main.numberOfFuel.put(player.getName(), 800.0d - fuel);
        }
    }

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (main.gameState != GameState.STARTED) continue;
            if (player.getInventory().getChestplate() == null || getFuel(player) == 0) continue;
            if (player.getInventory().getChestplate().getType() == Material.LEATHER_CHESTPLATE && player.isSneaking() && !player.isFlying()) {
                player.getWorld().playSound(player.getLocation(), Sound.BLOCK_BAMBOO_PLACE, 500, 1);
                player.getWorld().spawnParticle(Particle.CLOUD, player.getLocation(), 1);
                player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 2, 6, false, false, false));
                removeFuel(player, 1);
            }

            Bukkit.dispatchCommand(console, "title " + player.getName() + " actionbar [{\"text\": \"[\", \"color\": \"red\"}, {\"text\": \"Vous avez " + getFuel(player) + " de fuel\", \"color\": \"red\"}, {\"text\": \"]\", \"color\": \"red\"}]");

        }
    }

    @EventHandler
    public void onItemPickup(PlayerPickupItemEvent event) {
        if (event.getItem().getItemStack().getType() == Material.COAL) {
            ItemStack pickupItem = event.getItem().getItemStack();

            for (int i = 0; i < 10; i++) {
                if (pickupItem.getAmount() != 0 && (getFuel(event.getPlayer())) + 5 < 800d) {
                    addFuel(event.getPlayer(), 5);
                    pickupItem.setAmount(pickupItem.getAmount() - 1);
                }
            }
        }
    }

}
