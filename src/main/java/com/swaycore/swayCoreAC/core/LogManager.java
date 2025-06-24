package com.swaycore.anticheat.core;

import java.io.*;

public class LogManager {

    private final File logFile;

    public LogManager(String path) {
        this.logFile = new File(path);
    }

    public void log(String message) {
        try {
            if (!logFile.exists()) logFile.createNewFile();
            FileWriter fw = new FileWriter(logFile, true);
            fw.write(message + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
