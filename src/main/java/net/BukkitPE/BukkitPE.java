package net.BukkitPE;

import net.BukkitPE.command.CommandReader;
import net.BukkitPE.utils.MainLogger;
import net.BukkitPE.utils.ServerKiller;

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
    public final static String CODENAME = "SharpKnife";

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
                System.out.print(" \n____        _    _    _ _   _____  ______ ");
                System.out.print(" \n|  _ \\      | |  | |  (_) | |  __ \\|  ____|");
                System.out.print(" \n| |_) |_   _| | _| | ___| |_| |__) | |__   ");
                System.out.print(" \n|  _ <| | | | |/ / |/ / | __|  ___/|  __|  ");
                System.out.print(" \n| |_) | |_| |   <|   <| | |_| |    | |____ ");
                System.out.print(" \n|____// \\__,_|_|\\_\\_|\\_\\_|\\__|_|    |______|");
                System.out.print(" \n*                                           ");
                System.out.print(" \n* Starting......                            ");
            }
            Server server = new Server(logger, PATH, DATA_PATH, PLUGIN_PATH);
        } catch (Exception e) {
            logger.logException(e);
        }

        if (ANSI) {
            System.out.print((char) 0x1b + "]0;Stopping BukkitPE....." + (char) 0x07);
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
            System.out.print((char) 0x1b + "]0;The server has stopped!" + (char) 0x07);
        }
        System.exit(0);
    }


}
