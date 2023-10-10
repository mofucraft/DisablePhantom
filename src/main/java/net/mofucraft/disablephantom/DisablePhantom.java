package net.mofucraft.disablephantom;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Phantom;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class DisablePhantom extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onPhantomSpawn(EntitySpawnEvent e) {
        Entity ent = e.getEntity();
        String wn = ent.getWorld().getName();

        if(ent instanceof Phantom && wn.equals("world")) {
            e.setCancelled(true);
        }
    }

}
