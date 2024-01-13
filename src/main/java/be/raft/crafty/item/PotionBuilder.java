package be.raft.crafty.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PotionBuilder extends ItemBuilder {
    protected PotionBuilder(ItemStack stack, PotionMeta meta) {
        super(stack, meta);
    }

    /**
     * Adds a custom potion effect to this potion.
     * @param potionEffect potion effect
     */
    public PotionBuilder addCustomPotionEffect(PotionEffect potionEffect) {
        return this.addCustomPotionEffect(potionEffect);
    }

    /**
     * Adds a custom potion effect to this potion.
     * @param potionEffect potion effect
     * @param overwrite true if any existing effect of the same type should be overwritten
     */
    public PotionBuilder addCustomPotionEffect(PotionEffect potionEffect, boolean overwrite) {
        return this.addCustomPotionEffect(potionEffect, overwrite);
    }

    /**
     * Removes a potion effect from the potion.
     * @param type potion effect type
     */
    public PotionBuilder removeCustomPotionEffect(PotionEffectType type) {
        return this.removeCustomPotionEffect(type);
    }

    /**
     * Moves a potion effect to the top of the potion effect list.
     * @param type potion effect type
     */
    public PotionBuilder setMainEffect(PotionEffectType type) {
        return this.setMainEffect(type);
    }

    /**
     * Create a Builder from an {@link ItemStack}.
     * @param stack item stack 
     */
    public static PotionBuilder create(ItemStack stack) {
        return new PotionBuilder(stack, (PotionMeta) stack.getItemMeta());
    }

    /**
     * Create a Builder from a defined {@link Material}.
     * @param material material
     */
    public static PotionBuilder create(Material material) {
        return PotionBuilder.create(new ItemStack(material));
    }

}
