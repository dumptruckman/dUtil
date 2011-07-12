package com.dumptruckman.util.io;

import java.io.File;
import java.io.IOException;
import org.bukkit.util.config.Configuration;

/**
 *
 * @author dumptruckman
 */
public class ConfigIO {

    private Configuration data;

    public ConfigIO(File file) {
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) { }
        }
        this.data = new Configuration(file);
    }

    public ConfigIO(Configuration data) {
        this.data = data;
    }

    public void save() {
        Thread save = new Thread() {
            @Override public void run() {
                data.save();
            }
        };
        save.start();
    }

    public Configuration load() {
        data.load();
        return data;
    }
}
