package com.swaycore.anticheat.checks;

import com.swaycore.anticheat.core.CheckManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PingSpoofCheck {

    public PingSpoofCheck(CheckManager checkManager) {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    int ping = getPing(player);
                    if (ping < 0 || ping > 1000) {
                        checkManager.getViolationManager().addViolation(player, "PingSpoof", 1);
                    }
                }
            }
        }.runTaskTimer(checkManager.getPlugin(), 20, 100);
    }

    private int getPing(Player player) {
        try {
            return player.getPing();
        } catch (NoSuchMethodError e) {
            return 0;
        }
    }
}
