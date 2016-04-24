package net.BukkitPE.command;

import net.BukkitPE.Server;
import net.BukkitPE.command.defaults.*;
import net.BukkitPE.event.TranslationContainer;
import net.BukkitPE.utils.MainLogger;
import net.BukkitPE.utils.TextFormat;
import net.BukkitPE.utils.Utils;

import java.util.*;


public class SimpleCommandMap implements CommandMap {
    protected Map<String, Command> knownCommands = new HashMap<>();

    private Server server;

    public SimpleCommandMap(Server server) {
        this.server = server;
        this.setDefaultCommands();
    }

    private void setDefaultCommands() {
        this.register("BukkitPE", new VersionCommand("version"));
        this.register("BukkitPE", new PluginsCommand("plugins"));
        this.register("BukkitPE", new SeedCommand("seed"));
        this.register("BukkitPE", new HelpCommand("help"));
        this.register("BukkitPE", new StopCommand("stop"));
        this.register("BukkitPE", new TellCommand("tell"));
        this.register("BukkitPE", new DefaultGamemodeCommand("defaultgamemode"));
        this.register("BukkitPE", new BanCommand("ban"));
        this.register("BukkitPE", new BanIpCommand("ban-ip"));
        this.register("BukkitPE", new BanListCommand("banlist"));
        this.register("BukkitPE", new PardonCommand("pardon"));
        this.register("BukkitPE", new PardonIpCommand("pardon-ip"));
        this.register("BukkitPE", new SayCommand("say"));
        this.register("BukkitPE", new MeCommand("me"));
        this.register("BukkitPE", new ListCommand("list"));
        this.register("BukkitPE", new DifficultyCommand("difficulty"));
        this.register("BukkitPE", new KickCommand("kick"));
        this.register("BukkitPE", new OpCommand("op"));
        this.register("BukkitPE", new DeopCommand("deop"));
        this.register("BukkitPE", new WhitelistCommand("whitelist"));
        this.register("BukkitPE", new SaveOnCommand("save-on"));
        this.register("BukkitPE", new SaveOffCommand("save-off"));
        this.register("BukkitPE", new SaveCommand("save-all"));
        this.register("BukkitPE", new GiveCommand("give"));
        this.register("BukkitPE", new EffectCommand("effect"));
        this.register("BukkitPE", new EnchantCommand("enchant"));
        this.register("BukkitPE", new ParticleCommand("particle"));
        this.register("BukkitPE", new GamemodeCommand("gamemode"));
        this.register("BukkitPE", new KillCommand("kill"));
        this.register("BukkitPE", new SpawnpointCommand("spawnpoint"));
        this.register("BukkitPE", new SetWorldSpawnCommand("setworldspawn"));
        this.register("BukkitPE", new TeleportCommand("tp"));
        this.register("BukkitPE", new TimeCommand("time"));
        //this.register("BukkitPE", new TimingsCommand("timings"));
        this.register("BukkitPE", new ReloadCommand("reload"));
        this.register("BukkitPE", new WeatherCommand("weather"));
        this.register("BukkitPE", new XpCommand("xp"));

        if ((boolean) this.server.getConfig("debug.commands", false)) {
            this.register("BukkitPE", new StatusCommand("status"));
            this.register("BukkitPE", new GarbageCollectorCommand("gc"));
            //this.register("BukkitPE", new DumpMemoryCommand("dumpmemory"));
        }
    }

    @Override
    public void registerAll(String fallbackPrefix, List<? extends Command> commands) {
        for (Command command : commands) {
            this.register(fallbackPrefix, command);
        }
    }

    @Override
    public boolean register(String fallbackPrefix, Command command) {
        return this.register(fallbackPrefix, command, null);
    }

    @Override
    public boolean register(String fallbackPrefix, Command command, String label) {
        if (label == null) {
            label = command.getName();
        }
        label = label.trim().toLowerCase();
        fallbackPrefix = fallbackPrefix.trim().toLowerCase();

        boolean registered = this.registerAlias(command, false, fallbackPrefix, label);

        List<String> aliases = new ArrayList<>(Arrays.asList(command.getAliases()));

        for (Iterator<String> iterator = aliases.iterator(); iterator.hasNext(); ) {
            String alias = iterator.next();
            if (!this.registerAlias(command, true, fallbackPrefix, alias)) {
                iterator.remove();
            }
        }
        command.setAliases(aliases.stream().toArray(String[]::new));

        if (!registered) {
            command.setLabel(fallbackPrefix + ":" + label);
        }

        command.register(this);

        return registered;
    }

    private boolean registerAlias(Command command, boolean isAlias, String fallbackPrefix, String label) {
        this.knownCommands.put(fallbackPrefix + ":" + label, command);
        if ((command instanceof VanillaCommand || isAlias) && this.knownCommands.containsKey(label)) {
            return false;
        }

        if (this.knownCommands.containsKey(label) && this.knownCommands.get(label).getLabel() != null && this.knownCommands.get(label).getLabel().equals(label)) {
            return false;
        }

        if (!isAlias) {
            command.setLabel(label);
        }

        this.knownCommands.put(label, command);

        return true;
    }

    @Override
    public boolean dispatch(CommandSender sender, String cmdLine) {
        String[] args = cmdLine.split(" ");

        if (args.length == 0) {
            return false;
        }

        String sentCommandLabel = args[0].toLowerCase();
        String[] newargs = new String[args.length - 1];
        System.arraycopy(args, 1, newargs, 0, newargs.length);
        args = newargs;
        Command target = this.getCommand(sentCommandLabel);

        if (target == null) {
            return false;
        }

        try {
            target.execute(sender, sentCommandLabel, args);
        } catch (Exception e) {
            sender.sendMessage(new TranslationContainer(TextFormat.RED + "%commands.generic.exception"));
            this.server.getLogger().critical(this.server.getLanguage().translateString("BukkitPE.command.exception", new String[]{cmdLine, target.toString(), Utils.getExceptionMessage(e)}));
            MainLogger logger = sender.getServer().getLogger();
            if (logger != null) {
                logger.logException(e);
            }
        }

        return true;
    }

    @Override
    public void clearCommands() {
        for (Command command : this.knownCommands.values()) {
            command.unregister(this);
        }
        this.knownCommands.clear();
        this.setDefaultCommands();
    }

    @Override
    public Command getCommand(String name) {
        if (this.knownCommands.containsKey(name)) {
            return this.knownCommands.get(name);
        }
        return null;
    }

    public Map<String, Command> getCommands() {
        return knownCommands;
    }

    public void registerServerAliases() {
        Map<String, List<String>> values = this.server.getCommandAliases();
        for (Map.Entry<String, List<String>> entry : values.entrySet()) {
            String alias = entry.getKey();
            List<String> commandStrings = entry.getValue();
            if (alias.contains(" ") || alias.contains(":")) {
                this.server.getLogger().warning(this.server.getLanguage().translateString("BukkitPE.command.alias.illegal", alias));
                continue;
            }
            List<String> targets = new ArrayList<>();

            String bad = "";

            for (String commandString : commandStrings) {
                String[] args = commandString.split(" ");
                Command command = this.getCommand(args[0]);

                if (command == null) {
                    if (bad.length() > 0) {
                        bad += ", ";
                    }
                    bad += commandString;
                } else {
                    targets.add(commandString);
                }
            }

            if (bad.length() > 0) {
                this.server.getLogger().warning(this.server.getLanguage().translateString("BukkitPE.command.alias.notFound", new String[]{alias, bad}));
                continue;
            }

            if (!targets.isEmpty()) {
                this.knownCommands.put(alias.toLowerCase(), new FormattedCommandAlias(alias.toLowerCase(), targets));
            } else {
                this.knownCommands.remove(alias.toLowerCase());
            }
        }
    }
}