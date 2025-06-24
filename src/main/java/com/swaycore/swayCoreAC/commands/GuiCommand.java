package com.swaycore.anticheat.commands;

import com.swaycore.anticheat.AdvancedAntiCheat;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiCommand implements CommandExecutor {

    private final AdvancedAntiCheat plugin;

    public GuiCommand(AdvancedAntiCheat plugin) {
        this.plugin = plugin;
        plugin.getCommand("swaygui").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can open the GUI.");
            return true;
        }
        Inventory gui = Bukkit.createInventory(null, 27, "§cSwayCore GUI");
        ItemStack alerts = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta meta = alerts.getItemMeta();
        meta.setDisplayName("§cToggle Alerts");
        alerts.setItemMeta(meta);
        gui.setItem(13, alerts);
        player.openInventory(gui);
        return true;
    }
}
