package com.swaycore.swayCoreAC.core;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class AlertManager {

    private final Object plugin;

    public AlertManager(Object plugin) {
        this.plugin = plugin;
    }

    public void alert(Player player, String check, int vl) {
        Bukkit.getOnlinePlayers().stream()
                .filter(p -> p.hasPermission("swaycore.alerts"))
                .forEach(p -> p.sendMessage("§c[SwayCoreAC] §f" + player.getName() + " failed §e" + check + " §7[VL: " + vl + "]"));
    }
}
