package com.swaycore.swayCoreAC.Checks;

import com.swaycore.anticheat.PlayerData;
import com.swaycore.anticheat.core.CheckManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class TimerCheck implements Listener {

    private final CheckManager checkManager;

    public TimerCheck(CheckManager checkManager) {
        this.checkManager = checkManager;
        Bukkit.getPluginManager().registerEvents(this, checkManager.getPlugin());
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        PlayerData data = checkManager.getPlayerData(e.getPlayer().getUniqueId());
        long now = System.currentTimeMillis();
        long diff = now - data.getLastMoveTime();
        if (data.getLastMoveTime() != 0 && diff < 45) {
            checkManager.getViolationManager().addViolation(e.getPlayer(), "Timer", 1);
        }
        data.setLastMoveTime(now);
    }
}
