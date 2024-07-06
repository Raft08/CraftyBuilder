package be.raft.crafty.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class PotionBuilder<T extends ItemBuilder<T>> extends ItemBuilder<T> {
    private PotionEffectType mainEffect;
    private final ArrayList<PotionEffect> potionEffects;

    protected PotionBuilder(ItemStack stack) {
        super(stack);

        mainEffect = null;
        potionEffects = new ArrayList<>();
    }

    /**
     * Adds a potion effect to the potion.
     * @param effect the effect to add to the potion.
     */
    public PotionBuilder<T> addPotionEffect(PotionEffect effect) {
        this.potionEffects.add(effect);
        return this;
    }

    /**
     * Sets the main potion effect of the potion.
     * @param type the type of the main effect to give to the potion.
     */
    public PotionBuilder<T> mainEffect(PotionEffectType type) {
        this.mainEffect = type;
        return this;
    }

    /**
     * Build the item.
     * @return the built item.
     */
    public ItemStack build() {
        ItemStack buildStack = new ItemStack(this.stack);
        PotionMeta buildMeta = (PotionMeta) buildStack.getItemMeta();

        if (mainEffect != null) {
            buildMeta.setMainEffect(mainEffect);
        }

        if (!potionEffects.isEmpty()) {
            potionEffects.forEach(potionEffect -> buildMeta.addCustomEffect(potionEffect, false));
        }

        buildStack.setItemMeta(buildMeta);

        return buildStack;
    }

    /**
     * Create a Builder from an {@link ItemStack}.
     * @param stack item stack
     */
    public static PotionBuilder<?> create(ItemStack stack) {
        return new PotionBuilder<>(stack);
    }

    /**
     * Create a Builder from a defined {@link Material}.
     * @param material material
     */
    public static PotionBuilder<?> create(Material material) {
        return PotionBuilder.create(new ItemStack(material));
    }


}
