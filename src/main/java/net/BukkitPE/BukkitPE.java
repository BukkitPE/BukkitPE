package net.BukkitPE;

import net.BukkitPE.command.CommandReader;
import net.BukkitPE.utils.MainLogger;
import net.BukkitPE.utils.ServerKiller;
import net.BukkitPE.debug.debug;

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
 * This program is free software, and it's under GNU General Public License v3.0+
 * You can redistribute it and/or modify under the same license.
 *
 * @author BukkitPE Team
 * @link http://www.bukkitpe.net/
 *
 *
*/
public class BukkitPE {

    public final static String VERSION = "1.0dev";
    public final static String API_VERSION = "1.0.0";
    public final static String CODENAME = "CakeJava"; //It uses java so that'd only be logical.
    public final static String MINECRAFT_VERSION = "v0.15.6 alpha";
    public final static String MINECRAFT_VERSION_NETWORK = "0.15.6";

    public final static String PATH = System.getProperty("user.dir") + "/";
    public final static String DATA_PATH = System.getProperty("user.dir") + "/";
    public final static String PLUGIN_PATH = DATA_PATH + "plugins";
    public static final long START_TIME = System.currentTimeMillis();
    public static boolean ANSI = true;
    public static boolean shortTitle = false;
    public static int DEBUG = 1;

    public static void main(String[] args) {

        //Shorter title for windows 8/2012
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("windows")) {
            if (osName.contains("windows 8") || osName.contains("2012")) {
                shortTitle = true;
            }
        }

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
                net.BukkitPE.debug(" \n____        _    _    _ _   _____  ______ ");
                net.BukkitPE.debug(" \n|  _ \\      | |  | |  (_) | |  __ \\|  ____|");
                net.BukkitPE.debug(" \n| |_) |_   _| | _| | ___| |_| |__) | |__   ");
                net.BukkitPE.debug(" \n|  _ <| | | | |/ / |/ / | __|  ___/|  __|  ");
                net.BukkitPE.debug(" \n| |_) | |_| |   <|   <| | |_| |    | |____ ");
                net.BukkitPE.debug(" \n|____// \\__,_|_|\\_\\_|\\_\\_|\\__|_|    |______|");
                net.BukkitPE.debug(" \n* Starting......                            ");
            }
            Server server = new Server(logger, PATH, DATA_PATH, PLUGIN_PATH);
        } catch (Exception e) {
            logger.logException(e);
        }

        if (ANSI) {
            net.BukkitPE.debug("Stopping BukkitPE.....");
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
            net.BukkitPE.debug("Server has stopped!");
        }
        System.exit(0);
    }


}
