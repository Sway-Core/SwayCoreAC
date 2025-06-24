package com.swaycore.swayCoreAC;

import org.bukkit.plugin.java.JavaPlugin;

public final class SwayCoreAC extends JavaPlugin {
    private CheckManager checkManager;
    private ViolationManager violationManager;
    private BanManager banManager;
    private AlertManager alertManager;
    private LogManager logManager;
    private final Map<UUID, PlayerData> playerDataMap = new HashMap<>();

    @Override
    public void onEnable() {
        logManager = new LogManager(getDataFolder() + "/violations.log");
        banManager = new BanManager(this);
        alertManager = new AlertManager(this);
        violationManager = new ViolationManager(this, banManager, alertManager);
        checkManager = new CheckManager(this, violationManager);
        getLogger().info("SwayCoreAC enabled successfully.");
        new GuiCommand(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("SwayCoreAC disabled.");
    }

    public PlayerData getPlayerData(UUID uuid) {
        return playerDataMap.computeIfAbsent(uuid, PlayerData::new);
    }
}
