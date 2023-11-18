package be.raft.crafty.plugin;

import be.raft.crafty.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CraftyItems {
    public static final ItemStack MY_CUSTOM_ITEM = ItemBuilder.create(Material.STICK)
            .displayName("My Custom Item")
            .amount(10)
            .loreAppender(append -> append.add("This is my custom item's lore!"))
            .build();

    public static final ItemStack MULTILINE_LORE_ITEM = ItemBuilder.create(Material.STICK)
            .displayName("This Item's lore is multiline!")
            .amount(32)
            .setLore("This is the first line!", "This is the second line!")
            .build();
}
