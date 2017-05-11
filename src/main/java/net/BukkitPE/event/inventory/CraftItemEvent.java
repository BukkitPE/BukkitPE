package net.BukkitPE.event.inventory;

import net.BukkitPE.Player;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.Event;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.inventory.Recipe;
import net.BukkitPE.item.Item;

/**
 * BukkitPE Project
 */
public class CraftItemEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final Recipe recipe;
    private final Player player;
    private Item[] input = new Item[0];

    public CraftItemEvent(Player player, Item[] input, Recipe recipe) {
        this.player = player;
        this.input = input;
        this.recipe = recipe;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

    public Item[] getInput() {
        Item[] items = new Item[this.input.length];
        for (int i = 0; i < this.input.length; i++) {
            items[i] = this.input[i].clone();
        }

        return items;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public Player getPlayer() {
        return player;
    }
}