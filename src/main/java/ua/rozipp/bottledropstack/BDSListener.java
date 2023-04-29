package ua.rozipp.bottledropstack;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class BDSListener implements Listener {

    @EventHandler
    public void onPlayerDropItemEvent(PlayerDropItemEvent event) {
        Item drop = event.getItemDrop();
        ItemStack dropStack = drop.getItemStack();
        if (!(dropStack.getType().equals(Material.POTION))) return;
        for (Entity entity : drop.getLocation().getChunk().getEntities()) {
            if (entity instanceof Item) {
                if (drop.getLocation().distanceSquared(entity.getLocation()) < 9) {
                    Item item = (Item) entity;
                    ItemStack itemStack = item.getItemStack();
                    if (itemStack.getType().equals(Material.POTION))
                        if (itemStack.getItemMeta().equals(dropStack.getItemMeta()))
                        {
                            int dropAmount = dropStack.getAmount();
                            int itemAmount = itemStack.getAmount();
                            int freeAmount = 64 - itemAmount;
                            if (freeAmount >= dropAmount) {
                                itemStack.setAmount(itemAmount + dropAmount);
                                drop.remove();
                            } else {
                                itemStack.setAmount(64);
                                dropStack.setAmount(dropAmount - freeAmount);
                            }
                        }
                }
            }
        }
    }


}
