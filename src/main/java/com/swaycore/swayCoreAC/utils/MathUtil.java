package com.swaycore.anticheat.utils;

public class MathUtil {

    public static double getDelta(double a, double b) {
        return Math.abs(a - b);
    }

    public static double getOffset(double x1, double z1, double x2, double z2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(z1 - z2, 2));
    }

    public static boolean isPacketExcessive(double value, double limit) {
        return value > limit;
    }
}
