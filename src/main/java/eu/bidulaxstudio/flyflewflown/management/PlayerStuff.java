package eu.bidulaxstudio.flyflewflown.management;

import eu.bidulaxstudio.flyflewflown.Main;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class PlayerStuff {

    private final Main main;

    private final ItemStack flyBow = new ItemStack(Material.BOW);
    private final ItemStack flyArrow = new ItemStack(Material.ARROW);

    private final ItemStack greenHelmet = new ItemStack(Material.LEATHER_HELMET);
    private final ItemStack greenChestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
    private final ItemStack greenLeggings = new ItemStack(Material.LEATHER_LEGGINGS);
    private final ItemStack greenBoots = new ItemStack(Material.LEATHER_BOOTS);

    private final ItemStack redHelmet = new ItemStack(Material.LEATHER_HELMET);
    private final ItemStack redChestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
    private final ItemStack redLeggings = new ItemStack(Material.LEATHER_LEGGINGS);
    private final ItemStack redBoots = new ItemStack(Material.LEATHER_BOOTS);

    public PlayerStuff(Main main) {

        this.main = main;

        // Setup common stuff

        ItemMeta flyBowMeta = flyBow.getItemMeta();
        flyBowMeta.setDisplayName("Fly Bow");
        flyBowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        flyBowMeta.addEnchant(Enchantment.DURABILITY, 100, true);
        flyBowMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        flyBow.setItemMeta(flyBowMeta);

        ItemMeta flyArrowMeta = flyArrow.getItemMeta();
        flyArrowMeta.setDisplayName("Fly Arrow");
        flyArrowMeta.addEnchant(Enchantment.DURABILITY, 100, true);
        flyArrowMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        flyArrow.setItemMeta(flyArrowMeta);

        // Setup Green armor

        LeatherArmorMeta greenHelmetMeta = (LeatherArmorMeta) greenHelmet.getItemMeta();
        greenHelmetMeta.addEnchant(Enchantment.DURABILITY, 100, true);
        greenHelmetMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        greenHelmetMeta.setColor(Color.LIME);
        greenHelmetMeta.setDisplayName("Fly Armor");
        greenHelmet.setItemMeta(greenHelmetMeta);

        LeatherArmorMeta greenChestplateMeta = (LeatherArmorMeta) greenChestplate.getItemMeta();
        greenChestplateMeta.addEnchant(Enchantment.DURABILITY, 100, true);
        greenChestplateMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        greenChestplateMeta.setColor(Color.LIME);
        greenChestplateMeta.setDisplayName("Fly Armor");
        greenChestplate.setItemMeta(greenChestplateMeta);

        LeatherArmorMeta greenLeggingsMeta = (LeatherArmorMeta) greenLeggings.getItemMeta();
        greenLeggingsMeta.addEnchant(Enchantment.DURABILITY, 100, true);
        greenLeggingsMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        greenLeggingsMeta.setColor(Color.LIME);
        greenLeggingsMeta.setDisplayName("Fly Armor");
        greenLeggings.setItemMeta(greenLeggingsMeta);

        LeatherArmorMeta greenBootsMeta = (LeatherArmorMeta) greenBoots.getItemMeta();
        greenBootsMeta.addEnchant(Enchantment.DURABILITY, 100, true);
        greenBootsMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        greenBootsMeta.setColor(Color.LIME);
        greenBootsMeta.setDisplayName("Fly Armor");
        greenBoots.setItemMeta(greenBootsMeta);

        // Setup Red armor

        LeatherArmorMeta redHelmetMeta = (LeatherArmorMeta) redHelmet.getItemMeta();
        redHelmetMeta.addEnchant(Enchantment.DURABILITY, 100, true);
        redHelmetMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        redHelmetMeta.setColor(Color.RED);
        redHelmetMeta.setDisplayName("Fly Armor");
        redHelmet.setItemMeta(redHelmetMeta);

        LeatherArmorMeta redChestplateMeta = (LeatherArmorMeta) redChestplate.getItemMeta();
        redChestplateMeta.addEnchant(Enchantment.DURABILITY, 100, true);
        redChestplateMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        redChestplateMeta.setColor(Color.RED);
        redChestplateMeta.setDisplayName("Fly Armor");
        redChestplate.setItemMeta(redChestplateMeta);

        LeatherArmorMeta redLeggingsMeta = (LeatherArmorMeta) redLeggings.getItemMeta();
        redLeggingsMeta.addEnchant(Enchantment.DURABILITY, 100, true);
        redLeggingsMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        redLeggingsMeta.setColor(Color.RED);
        redLeggingsMeta.setDisplayName("Fly Armor");
        redLeggings.setItemMeta(redLeggingsMeta);

        LeatherArmorMeta redBootsMeta = (LeatherArmorMeta) redBoots.getItemMeta();
        redBootsMeta.addEnchant(Enchantment.DURABILITY, 100, true);
        redBootsMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        redBootsMeta.setColor(Color.RED);
        redBootsMeta.setDisplayName("Fly Armor");
        redBoots.setItemMeta(redBootsMeta);
    }

    private void giveCommonKit(Player player) {
        player.getInventory().setItem(0, flyBow);
        player.getInventory().setItem(9, flyArrow);
    }

    public void giveGreenKit(Player player) {
        player.getInventory().clear();
        player.getInventory().setHelmet(greenHelmet);
        player.getInventory().setChestplate(greenChestplate);
        player.getInventory().setLeggings(greenLeggings);
        player.getInventory().setBoots(greenBoots);
        giveCommonKit(player);
        player.updateInventory();

    }

    public void giveRedKit(Player player) {
        player.getInventory().clear();
        player.getInventory().setHelmet(redHelmet);
        player.getInventory().setChestplate(redChestplate);
        player.getInventory().setLeggings(redLeggings);
        player.getInventory().setBoots(redBoots);
        giveCommonKit(player);
        player.updateInventory();
    }

}
