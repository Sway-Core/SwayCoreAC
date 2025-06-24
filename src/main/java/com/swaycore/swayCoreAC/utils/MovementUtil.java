package com.swaycore.anticheat.utils;

import org.bukkit.Location;

public class MovementUtil {

    public static boolean isMoving(Location from, Location to) {
        return from.getX() != to.getX() || from.getZ() != to.getZ();
    }

    public static boolean isJumping(Location from, Location to) {
        return from.getY() < to.getY();
    }
}
