package com.swaycore.anticheat;

import java.util.UUID;

public class PlayerData {
    private final UUID uuid;
    private long lastClickTime;
    private long lastMoveTime;
    private float lastYaw;
    private boolean hasLastYaw;

    public PlayerData(UUID uuid) {
        this.uuid = uuid;
        this.lastClickTime = 0;
        this.lastMoveTime = 0;
        this.hasLastYaw = false;
    }

    public long getLastClickTime() { return lastClickTime; }
    public void setLastClickTime(long lastClickTime) { this.lastClickTime = lastClickTime; }
    public long getLastMoveTime() { return lastMoveTime; }
    public void setLastMoveTime(long lastMoveTime) { this.lastMoveTime = lastMoveTime; }
    public float getLastYaw() { return lastYaw; }
    public void setLastYaw(float lastYaw) { this.lastYaw = lastYaw; this.hasLastYaw = true; }
    public boolean hasLastRotation() { return hasLastYaw; }
}
