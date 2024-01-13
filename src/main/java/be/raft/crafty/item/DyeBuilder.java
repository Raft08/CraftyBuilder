package be.raft.crafty.item;

import be.raft.crafty.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

public class DyeBuilder extends ItemBuilder {
    protected DyeBuilder(ItemStack stack, ItemMeta meta) {
        super(stack, meta);
    }

    /**
     * Set the color of the dye
     * @param color color
     */
    public DyeBuilder setColor(Color color) {
        return this.setColor(color.getData());
    }

    /**
     * Set the color of the dye with a byte
     * @param data byte of the color
     */
    @SuppressWarnings("deprecation")
    public DyeBuilder setColor(byte data) {
        MaterialData mData = new MaterialData(this.stack.getType(), data);
        return (DyeBuilder) this.setData(mData);
    }

    /**
     * Create a Builder from an {@link ItemStack}.
     * @param stack item stack
     */
    public static DyeBuilder create(ItemStack stack) {
        return new DyeBuilder(stack, stack.getItemMeta());
    }

    /**
     * Create a Builder from a defined {@link Material}.
     * @param material material
     */
    public static DyeBuilder create(Material material) {
        return DyeBuilder.create(new ItemStack(material));
    }
}
