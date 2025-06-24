package com.swaycore.swayCoreAC.core;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BanManager {

    private final Object plugin;

    public BanManager(Object plugin) {
        this.plugin = plugin;
    }

    public void ban(Player player, String reason) {
        Bukkit.getScheduler().runTask((org.bukkit.plugin.Plugin) plugin, () -> {
            player.kickPlayer("SwayCoreAC Ban: " + reason);
            Bukkit.broadcastMessage("§c[SwayCoreAC] §e" + player.getName() + " has been banned for: §c" + reason);
        });
    }
}
