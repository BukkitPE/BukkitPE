package net.BukkitPE.command.defaults;

import net.BukkitPE.Player;
import net.BukkitPE.command.Command;
import net.BukkitPE.command.CommandSender;
import net.BukkitPE.event.TranslationContainer;
import net.BukkitPE.potion.Effect;
import net.BukkitPE.potion.InstantEffect;
import net.BukkitPE.utils.TextFormat;

/**
 * Created by Snake1999 and Pub4Game on 2016/1/23.
 * Package net.BukkitPE.command.defaults in project BukkitPE.
 */
public class EffectCommand extends Command {
    public EffectCommand(String name) {
        super(name, "%BukkitPE.command.effect.description", "%commands.effect.usage");
        this.setPermission("BukkitPE.command.effect");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!this.testPermission(sender)) {
            return true;
        }
        if (args.length < 2) {
            sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));
            return true;
        }
        Player player = sender.getServer().getPlayer(args[0]);
        if (player == null) {
            sender.sendMessage(new TranslationContainer(TextFormat.RED + "%commands.generic.player.notFound"));
            return true;
        }
        if (args[1].equalsIgnoreCase("clear")) {
            for (Effect effect : player.getEffects().values()) {
                player.removeEffect(effect.getId());
            }
            sender.sendMessage(new TranslationContainer("commands.effect.success.removed.all", player.getDisplayName()));
            return true;
        }
        Effect effect;
        try {
            effect = Effect.getEffect(Integer.parseInt(args[1]));
        } catch (NumberFormatException a) {
            try {
                effect = Effect.getEffectByName(args[1]);
            } catch (Exception e) {
                sender.sendMessage(new TranslationContainer("commands.effect.notFound", args[1]));
                return true;
            }
        }
        int duration = 300;
        int amplification = 0;
        if (args.length >= 3) {
            try {
                duration = Integer.valueOf(args[2]);
            } catch (NumberFormatException a) {
                sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));
                return true;
            }
            if (!(effect instanceof InstantEffect)) {
                duration *= 20;
            }
        } else if (effect instanceof InstantEffect) {
            duration = 1;
        }
        if (args.length >= 4) {
            try {
                amplification = Integer.valueOf(args[3]);
            } catch (NumberFormatException a) {
                sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));
                return true;
            }
        }
        if (args.length >= 5) {
            String v = args[4].toLowerCase();
            if (v.matches("(?i)|on|true|t|1")) {
                effect.setVisible(false);
            }
        }
        if (duration == 0) {
            if (!player.hasEffect(effect.getId())) {
                if (player.getEffects().size() == 0) {
                    sender.sendMessage(new TranslationContainer("commands.effect.failure.notActive.all", player.getDisplayName()));
                } else {
                    sender.sendMessage(new TranslationContainer("commands.effect.failure.notActive", new String[]{effect.getName(), player.getDisplayName()}));
                }
                return true;
            }
            player.removeEffect(effect.getId());
            sender.sendMessage(new TranslationContainer("commands.effect.success.removed", new String[]{effect.getName(), player.getDisplayName()}));
        } else {
            effect.setDuration(duration).setAmplifier(amplification);
            player.addEffect(effect);
            Command.broadcastCommandMessage(sender, new TranslationContainer("%commands.effect.success", new String[]{effect.getName(), String.valueOf(effect.getId()), String.valueOf(effect.getAmplifier()), player.getDisplayName(), String.valueOf(effect.getDuration() / 20)}));
        }
        return true;
    }
}
