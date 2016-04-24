/*
 *
 * ____        _    _    _ _   _____  ______ 
 * |  _ \      | |  | |  (_) | |  __ \|  ____|
 * | |_) |_   _| | _| | ___| |_| |__) | |__   
 * |  _ <| | | | |/ / |/ / | __|  ___/|  __|  
 * | |_) | |_| |   <|   <| | |_| |    | |____ 
 * |____/ \__,_|_|\_\_|\_\_|\__|_|    |______|
 *                                           
 *                                          
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * @author BukkitPE Team
 * @link http://www.bukkitpe.net/
 *
 *
*/
package net.BukkitPE;

import net.BukkitPE.command.CommandReader;  
import net.BukkitPE.utils.MainLogger;
import net.BukkitPE.utils.ServerKiller;

public class BukkitPE {

 public final static String VERSION = "1.0.0";
 public final static String API_VERSION = "1.0.0";
 public final static String CODENAME = "Cake";
 public final static String MINECRAFT_VERSION = "v0.14.1 alpha";
 public final static String MINECRAFT_VERSION_NETWORK = "0.14.1";

 public final static String PATH = System.getProperty("user.dir") + "/";
 public final static String DATA_PATH = System.getProperty("user.dir") + "/";
 public final static String PLUGIN_PATH = DATA_PATH + "plugins";
 public final static String CRASH_DUMP = DATA_PATH + "Dumps"; // Stores server crashdumps..ect) 
 public static final long START_TIME = System.currentTimeMillis();
 public static boolean ANSI = true;
 public static boolean shortTitle = false;
 public static int DEBUG = 1;
 public static void main(String[] args) {

        // Shorten the tiles if needed for old Win8 builds ()
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("windows")) {
            if (osName.contains("windows 8") || osName.contains("2012")) {
                shortTitle = true;
            }
        }
        // For linux based os
       String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("linux")) {
            if (osName.contains("Linux") || osName.contains("2012")) {
                shortTitle = false;
            }
    }
        //Starting parameters
        for (String arg : args) {
            switch (arg) {
                case "disable-ansi":
                    ANSI = false;
                    break;
            }
        }

        MainLogger logger = new MainLogger(DATA_PATH + "server.log");

        try {
            if (ANSI) {
                System.out.print((char) 0x1b + "]0;Starting BukkitPE Server For Minecraft: PE" + (char) 0x07);
            }
            Server server = new Server(logger, PATH, DATA_PATH, PLUGIN_PATH);
        } catch (Exception e) {
            logger.logException(e);
        }

        if (ANSI) {
            System.out.print((char) 0x1b + "]0;Stopping Server standby..." + (char) 0x07);
        }
        logger.info("Stopping other threads");

        for (Thread thread : java.lang.Thread.getAllStackTraces().keySet()) {
            if (!(thread instanceof InterruptibleThread)) {
                continue;
            }
            logger.debug("Stopping " + thread.getClass().getSimpleName() + " thread");
            if (thread.isAlive()) {
                thread.interrupt();
            }
        }

        ServerKiller killer = new ServerKiller(8);
        killer.start();

        logger.shutdown();
        logger.interrupt();
        CommandReader.getInstance().removePromptLine();

        if (ANSI) {
            System.out.print((char) 0x1b + "]0;Server has stopped" + (char) 0x07);
        }
        System.exit(0);
    }


}
