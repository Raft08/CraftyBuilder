package be.raft.crafty.item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Item {
    private final ItemStack stack;
    private ItemMeta meta;

    public Item(ItemStack stack) {
        this.stack = stack;
        this.meta = stack.getItemMeta();
    }

    public Item(ItemStack stack, ItemMeta meta) {
        this.stack = stack;
        this.meta = meta;
        stack.setItemMeta(meta);
    }

    private void updateMeta() {
        stack.setItemMeta(meta);
    }

    public void setName(String name) {
        meta.setDisplayName(name);
        updateMeta();
    }

    public String getName() {
        return meta.getDisplayName();
    }

    public void setMaterial(Material mat) {
        stack.setType(mat);
    }

    public Material getMaterial() {
        return stack.getType();
    }

    public void setAmount(int amount) {
        stack.setAmount(amount);
    }

    public int getAmount() {
        return stack.getAmount();
    }

    public void setDurability(short durability) {
        stack.setDurability(durability);
    }

    public short getDurability() {
        return stack.getDurability();
    }

    public void setData(MaterialData data) {
        stack.setData(data);
    }

    public MaterialData getData() {
        return stack.getData();
    }

    public void setEnchantments(Map<Enchantment, Integer> enchantments) {
        stack.addUnsafeEnchantments(enchantments);
    }

    public Map<Enchantment, Integer> getEnchantments() {
        return stack.getEnchantments();
    }

    public void setLore(List<String> lore) {
        meta.setLore(lore);
        updateMeta();
    }

    public List<String> getLore() {
        return meta.getLore();
    }

    public void addEnchant(Enchantment ench, int level, boolean ignoreLevelRestriction) {
        meta.addEnchant(ench, level, ignoreLevelRestriction);
        updateMeta();
    }

    public boolean hasEnchant(Enchantment ench) {
        return meta.hasEnchant(ench);
    }

    public int getEnchantLevel(Enchantment ench) {
        return meta.getEnchantLevel(ench);
    }

    public void addItemFlags(ItemFlag... flags) {
        meta.addItemFlags(flags);
        updateMeta();
    }

    public Set<ItemFlag> getItemFlags() {
        return meta.getItemFlags();
    }

    public ItemStack toItemStack() {
        return stack;
    }
}
