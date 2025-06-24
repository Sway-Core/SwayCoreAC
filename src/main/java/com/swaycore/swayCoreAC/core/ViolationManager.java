package com.swaycore.swayCoreAC.core;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import java.util.*;

public class ViolationManager {

    private final Map<UUID, Integer> violations = new HashMap<>();
    private final BanManager banManager;
    private final AlertManager alertManager;

    public ViolationManager(Object plugin, BanManager banManager, AlertManager alertManager) {
        this.banManager = banManager;
        this.alertManager = alertManager;
    }

    public void addViolation(Player player, String check, int amount) {
        UUID uuid = player.getUniqueId();
        int total = violations.getOrDefault(uuid, 0) + amount;
        violations.put(uuid, total);

        alertManager.alert(player, check, total);

        if (total >= 50) {
            banManager.ban(player, check);
        }
    }
}
