package com.swaycore.swayCoreAC.core;

import com.comphenix.protocol.ProtocolLibrary;
import com.swaycore.anticheat.AdvancedAntiCheat;
import com.swaycore.anticheat.PlayerData;
import com.swaycore.anticheat.checks.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class CheckManager {

    private final AdvancedAntiCheat plugin;
    private final ViolationManager violationManager;

    public CheckManager(AdvancedAntiCheat plugin, ViolationManager violationManager) {
        this.plugin = plugin;
        this.violationManager = violationManager;

        new TimerCheck(this);
        new YawRateLimitCheck(this);
        new PingSpoofCheck(this);
        ProtocolLibrary.getProtocolManager().addPacketListener(new ScaffoldCheck(plugin, this));
        ProtocolLibrary.getProtocolManager().addPacketListener(new BadPacketsCheck(plugin, this));
    }

    public AdvancedAntiCheat getPlugin() { return plugin; }
    public PlayerData getPlayerData(UUID uuid) { return plugin.getPlayerData(uuid); }
    public ViolationManager getViolationManager() { return violationManager; }
}
