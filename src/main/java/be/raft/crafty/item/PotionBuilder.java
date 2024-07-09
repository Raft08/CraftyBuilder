package be.raft.crafty.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class PotionBuilder<T extends ItemBuilder<T>> extends ItemBuilder<T> {
    private PotionEffectType mainEffect;
    private final List<PotionEffect> potionEffects;

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
     * Builds the item.
     * @return the build item.
     */
    @Override
    public ItemStack build() {
        ItemStack buildStack = new ItemStack(this.stack);
        PotionMeta buildMeta = (PotionMeta) this.stack.getItemMeta();

        if (mainEffect != null) {
            buildMeta.setMainEffect(mainEffect);
        }

        potionEffects.forEach(effect -> buildMeta.addCustomEffect(effect, false));

        buildStack.setItemMeta(buildMeta);
        return buildStack;
    }

    /**
     * Create a Builder from an {@link ItemStack}.
     */
    public static PotionBuilder<?> create() {
        return new PotionBuilder<>(new ItemStack(Material.POTION));
    }
}
