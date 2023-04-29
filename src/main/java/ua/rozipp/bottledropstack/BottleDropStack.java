package ua.rozipp.bottledropstack;

import org.bukkit.plugin.java.JavaPlugin;

public final class BottleDropStack extends JavaPlugin {

    @Override
    public void onEnable() {
       getLogger().info("Start plugin Bottle DropStack ");
       this.getServer().getPluginManager().registerEvents(new BDSListener(), this);
    }

    @Override
    public void onDisable() {

    }
}
