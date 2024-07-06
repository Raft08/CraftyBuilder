package be.raft.crafty.item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.security.Key;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Item Builder, create new items by chaining functions!
 */
public class ItemBuilder<T extends ItemBuilder<T>> {
    protected final ItemStack stack;

    private String displayName;
    private List<String> lore;
    private int amount;
    private HashMap<Enchantment, Integer> enchantments;
    private List<ItemFlag> itemFlags;
    private short durability;

    protected ItemBuilder(ItemStack stack) {
        this.stack = stack;

        displayName = "";
        lore = List.of();
        amount = 1;
        enchantments = new HashMap<>();
        itemFlags = List.of();
        durability = 0;
    }

    /**
     * Sets the display name for the item.
     * @param displayName display name for the item.
     */
    public ItemBuilder<T> displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Adds lore to the item, this will override the previously set lore.
     * @param lines lines to add to the lore.
     */
    public ItemBuilder<T> setLore(String... lines) {
        this.lore = List.of(lines);
        return this;
    }

    /**
     * Sets the amount of items.
     * @param amount amount of items.
     */
    public ItemBuilder<T> amount(int amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Adds an enchantment to the item.
     * @param enchantment the enchantment to add.
     * @param level the level of the enchantment.
     */
    public ItemBuilder<T> addEnchant(Enchantment enchantment, int level) {
        this.enchantments.put(enchantment, level);
        return this;
    }

    /**
     * Add an item flags to the item.
     * @param flags flags to add.
     */
    public ItemBuilder<T> addItemFlags(ItemFlag... flags) {
        itemFlags.addAll(Arrays.asList(flags));

        return this;
    }

    /**
     * Sets the durability of the item.
     * @param durability durability of the item
     */

    public ItemBuilder<T> setDurability(short durability) {
        this.durability = durability;

        return this;
    }

    /**
     * Build the item.
     * @return the built item.
     */
    public ItemStack build() {
        ItemStack buildStack = new ItemStack(this.stack);
        ItemMeta buildMeta = buildStack.getItemMeta();

        if (!this.displayName.isEmpty()) {
            buildMeta.setDisplayName(this.displayName);
        }

        if (!this.lore.isEmpty()) {
            buildMeta.setLore(this.lore);
        }

        if (!this.itemFlags.isEmpty()) {
            itemFlags.forEach(buildMeta::addItemFlags);
        }

        buildStack.setAmount(this.amount);

        enchantments.forEach((ench, level) -> buildMeta.addEnchant(ench, level, true));

        buildStack.setDurability(this.durability);

        buildStack.setItemMeta(buildMeta);

        return buildStack;
    }

    /**
     * Create a Builder from an {@link ItemStack}.
     * @param stack item stack
     */
    public static ItemBuilder<?> create(ItemStack stack) {
        return new ItemBuilder<>(stack);
    }

    /**
     * Create a Builder from a defined {@link Material}.
     * @param material material
     */
    public static ItemBuilder<?> create(Material material) {
        return ItemBuilder.create(new ItemStack(material));
    }
}
