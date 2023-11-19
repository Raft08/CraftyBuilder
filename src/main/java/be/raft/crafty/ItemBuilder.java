package be.raft.crafty;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Item Builder, create new items by chaining functions!
 */
public class ItemBuilder {
    private final ItemStack stack;
    private final ItemMeta meta;

    private ItemBuilder(ItemStack stack, ItemMeta meta) {
        this.stack = stack;
        this.meta = meta;
    }

    /**
     * Sets the display name for the item.
     * @param displayName display name for the item.
     */
    public ItemBuilder displayName(String displayName) {
        this.meta.setDisplayName(displayName);
        return this;
    }

    /**
     * Appends lore to already existing lore list.
     * @param appender consumer that adds lines to the lore.
     */
    public ItemBuilder loreAppender(Consumer<List<String>> appender) {
        List<String> lore = new ArrayList<>();
        appender.accept(lore);
        this.meta.setLore(lore);
        return this;
    }

    /**
     * Adds lore to the item, this will override the previously set lore.
     * @param lines lines to add to the lore.
     */
    public ItemBuilder setLore(String... lines) {
        this.meta.setLore(Arrays.asList(lines));
        return this;
    }

    /**
     * Sets the amount of items.
     * @param amount amount of items.
     */
    public ItemBuilder amount(int amount) {
        this.stack.setAmount(amount);
        return this;
    }

    /**
     * Adds an enchantment to the item.
     * Use {@link #addEnchant(Enchantment, int, boolean)} to prevent bypass level restriction.
     * @param enchantment the enchantment to add.
     * @param level the level of the enchantment.
     */
    public ItemBuilder addEnchant(Enchantment enchantment, int level) {
        return this.addEnchant(enchantment, level, false);
    }

    /**
     * Adds an enchantment to the item.
     * @param enchantment the enchantment to add.
     * @param level the level of the enchantment.
     * @param ignoreLevelRestriction prevent bypass of the level restriction.
     */
    public ItemBuilder addEnchant(Enchantment enchantment, int level, boolean ignoreLevelRestriction) {
        this.meta.addEnchant(enchantment, level, ignoreLevelRestriction);
        return this;
    }

    /**
     * Add an item flags to the item.
     * @param flags flags to add.
     */
    public ItemBuilder addItemFlags(ItemFlag... flags) {
        this.meta.addItemFlags(flags);
        return this;
    }

    /**
     * Sets the durability of the item.
     * @param durability durability of the item
     */
    public ItemBuilder setDurability(short durability) {
        this.stack.setDurability(durability);
        return this;
    }

    /**
     * Build the item.
     * @return the built item.
     */
    public ItemStack build() {
        ItemStack buildStack = new ItemStack(this.stack);
        buildStack.setItemMeta(this.meta);

        return buildStack;
    }

    /**
     * Create a Builder from an {@link ItemStack}.
     * @param stack item stack
     */
    public static ItemBuilder create(ItemStack stack) {
        return new ItemBuilder(stack, stack.getItemMeta());
    }

    /**
     * Create a Builder from a defined {@link Material}.
     * @param material material
     */
    public static ItemBuilder create(Material material) {
        return ItemBuilder.create(new ItemStack(material));
    }
}
