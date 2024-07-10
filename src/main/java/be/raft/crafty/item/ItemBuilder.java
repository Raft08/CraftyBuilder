package be.raft.crafty.item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

public class ItemBuilder<T extends ItemBuilder<T>> {
    protected final ItemStack stack;

    private String displayName;
    private List<String> lore;
    private int amount;
    private final HashMap<Enchantment, Integer> enchantments;
    private final List<ItemFlag> itemFlags;
    private short durability;

    private PotionEffectType mainEffect;
    private final List<PotionEffect> potionEffects;

    protected ItemBuilder(ItemStack stack) {
        this.stack = stack;

        displayName = "";
        lore = new ArrayList<>();
        amount = 1;
        enchantments = new HashMap<>();
        itemFlags = new ArrayList<>();
        durability = 0;

        mainEffect = null;
        potionEffects = new ArrayList<>();
    }

    /**
     * Sets the display name for the item.
     * @param displayName display name for the item.
     * @return this ItemBuilder instance for method chaining.
     */
    public ItemBuilder<T> displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Adds lore to the item, this will override the previously set lore.
     * @param lines lines to add to the lore.
     * @return this ItemBuilder instance for method chaining.
     */
    public ItemBuilder<T> setLore(String... lines) {
        this.lore = Arrays.asList(lines);
        return this;
    }

    /**
     * Sets the amount of items.
     * @param amount amount of items.
     * @return this ItemBuilder instance for method chaining.
     */
    public ItemBuilder<T> amount(int amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Adds an enchantment to the item.
     * @param enchantment the enchantment to add.
     * @param level the level of the enchantment.
     * @return this ItemBuilder instance for method chaining.
     */
    public ItemBuilder<T> addEnchant(Enchantment enchantment, int level) {
        this.enchantments.put(enchantment, level);
        return this;
    }

    /**
     * Add item flags to the item.
     * @param flags flags to add.
     * @return this ItemBuilder instance for method chaining.
     */
    public ItemBuilder<T> addItemFlags(ItemFlag... flags) {
        itemFlags.addAll(Arrays.asList(flags));
        return this;
    }

    /**
     * Sets the durability of the item.
     * @param durability durability of the item.
     * @return this ItemBuilder instance for method chaining.
     */
    public ItemBuilder<T> setDurability(short durability) {
        this.durability = durability;
        return this;
    }

    /**
     * Sets the main potion effect of the potion.
     * @param type the type of the main effect to give to the potion.
     * @return this ItemBuilder instance for method chaining.
     */
    public ItemBuilder<T> mainEffect(PotionEffectType type) {
        this.mainEffect = type;
        return this;
    }

    /**
     * Adds a potion effect to the potion.
     * @param effect the effect to add to the potion.
     * @return this ItemBuilder instance for method chaining.
     */
    public ItemBuilder<T> addPotionEffect(PotionEffect effect) {
        this.potionEffects.add(effect);
        return this;
    }

    /**
     * Builds the item stack with specified properties.
     * @return the built item stack.
     */
    public ItemStack build() {
        ItemStack buildStack = new ItemStack(this.stack);
        ItemMeta buildMeta = this.stack.getItemMeta();

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

        if (buildMeta instanceof PotionMeta) {
            PotionMeta potionMeta = (PotionMeta) buildMeta;

            if (mainEffect != null) {
                potionMeta.setMainEffect(mainEffect);
            }

            potionEffects.forEach(effect -> potionMeta.addCustomEffect(effect, false));

            buildStack.setItemMeta(potionMeta);
        }

        return buildStack;
    }

    /**
     * Create a Builder from an {@link ItemStack}.
     * @param stack item stack
     * @return a new ItemBuilder instance.
     */
    public static ItemBuilder<?> create(ItemStack stack) {
        return new ItemBuilder<>(stack);
    }

    /**
     * Create a Builder from a defined {@link Material}.
     * @param material material
     * @return a new ItemBuilder instance.
     */
    public static ItemBuilder<?> create(Material material) {
        return ItemBuilder.create(new ItemStack(material));
    }

    /**
     * Create a Builder from a {@link Material} and a {@link Short}.
     * @param material the material of the ItemStack to create.
     * @param data the data of the ItemStack to create.
     * @return a new ItemBuilder instance.
     */
    public static ItemBuilder<?> create(Material material, byte data) {
        return new ItemBuilder<>(new ItemStack(material, 1, data));
    }
}
