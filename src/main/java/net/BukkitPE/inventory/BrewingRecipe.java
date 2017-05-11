package net.BukkitPE.inventory;


import net.BukkitPE.Server;
import net.BukkitPE.item.Item;

import java.util.UUID;

public class BrewingRecipe implements Recipe {
    private final Item output;
    private final Item potion;
    private UUID id;
    private Item ingredient;

    public BrewingRecipe(Item result, Item ingredient, Item potion) {
        this.output = result.clone();
        this.ingredient = ingredient.clone();
        this.potion = potion.clone();
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID uuid) {
        if (id != null) {
            throw new IllegalStateException("Id is already set");
        }

        this.id = uuid;
    }

    public Item getInput() {
        return ingredient.clone();
    }

    public void setInput(Item item) {
        ingredient = item.clone();
    }

    public Item getPotion() {
        return potion.clone();
    }

    @Override
    public Item getResult() {
        return output.clone();
    }

    @Override
    public void registerToCraftingManager() {
        Server.getInstance().getCraftingManager().registerBrewingRecipe(this);
    }
}