package com.swaycore.anticheat.checks;

import com.swaycore.anticheat.PlayerData;
import com.swaycore.anticheat.core.CheckManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class YawRateLimitCheck implements Listener {

    private final CheckManager checkManager;

    public YawRateLimitCheck(CheckManager checkManager) {
        this.checkManager = checkManager;
        Bukkit.getPluginManager().registerEvents(this, checkManager.getPlugin());
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        PlayerData data = checkManager.getPlayerData(e.getPlayer().getUniqueId());
        float currentYaw = e.getTo().getYaw();
        if (data.hasLastRotation()) {
            float deltaYaw = Math.abs(currentYaw - data.getLastYaw());
            if (deltaYaw > 180 && deltaYaw < 359.9f) {
                checkManager.getViolationManager().addViolation(e.getPlayer(), "AimAssist", 1);
            }
        }
        data.setLastYaw(currentYaw);
    }
}
