package be.raft.crafty.plugin;

import be.raft.crafty.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CraftyItems {
    public static final ItemStack MY_CUSTOM_ITEM = ItemBuilder.create(Material.STICK)
            .displayName("My Custom Item")
            .amount(10)
            .build();

    public static final ItemStack MULTILINE_LORE_ITEM = ItemBuilder.create(Material.STICK)
            .displayName("This Item's lore is multiline!")
            .amount(32)
            .setLore("This is the first line!", "This is the second line!")
            .build();

    public static final ItemStack POTION_ITEM = ItemBuilder.create(Material.POTION)
            .addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*30, 0))
            .mainEffect(PotionEffectType.SPEED)
            .build();

}
