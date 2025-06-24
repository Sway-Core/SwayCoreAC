package com.swaycore.anticheat.checks;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.*;
import com.swaycore.anticheat.AdvancedAntiCheat;
import com.swaycore.anticheat.core.CheckManager;

public class BadPacketsCheck extends PacketAdapter {

    private final CheckManager checkManager;

    public BadPacketsCheck(AdvancedAntiCheat plugin, CheckManager checkManager) {
        super(plugin, ListenerPriority.HIGH, PacketType.Play.Client.KEEP_ALIVE);
        this.checkManager = checkManager;
    }

    @Override
    public void onPacketReceiving(PacketEvent event) {
        long keepAliveId = event.getPacket().getLongs().read(0);
        if (keepAliveId < 0) {
            checkManager.getViolationManager().addViolation(event.getPlayer(), "BadPackets", 2);
        }
    }
}
