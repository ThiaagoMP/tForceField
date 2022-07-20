package br.com.thiaago.forcefield.spigot

import br.com.thiaago.forcefield.spigot.command.GiveItemCommand
import br.com.thiaago.forcefield.spigot.listener.PlayerListener
import me.saiintbrisson.bukkit.command.BukkitFrame
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class SpigotLoader {

    companion object {
        fun load(plugin: JavaPlugin) {
            val bukkitFrame = BukkitFrame(plugin)
            bukkitFrame.registerCommands(GiveItemCommand())
            Bukkit.getPluginManager().registerEvents(PlayerListener(), plugin)
        }
    }

}