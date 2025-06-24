package com.swaycore.anticheat.checks;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.*;
import com.swaycore.anticheat.AdvancedAntiCheat;
import com.swaycore.anticheat.PlayerData;
import com.swaycore.anticheat.core.CheckManager;

public class ScaffoldCheck extends PacketAdapter {

    private final CheckManager checkManager;

    public ScaffoldCheck(AdvancedAntiCheat plugin, CheckManager checkManager) {
        super(plugin, ListenerPriority.NORMAL, PacketType.Play.Client.POSITION_LOOK);
        this.checkManager = checkManager;
    }

    @Override
    public void onPacketReceiving(PacketEvent event) {
        PlayerData data = checkManager.getPlayerData(event.getPlayer().getUniqueId());
        long now = System.currentTimeMillis();
        long diff = now - data.getLastClickTime();
        if (diff < 5) {
            checkManager.getViolationManager().addViolation(event.getPlayer(), "Scaffold", 1);
        }
        data.setLastClickTime(now);
    }
}
