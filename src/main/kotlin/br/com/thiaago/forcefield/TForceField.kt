package br.com.thiaago.forcefield

import br.com.thiaago.forcefield.spigot.SpigotLoader
import org.bukkit.plugin.java.JavaPlugin

class TForceField : JavaPlugin() {

    override fun onEnable() {
        SpigotLoader.load(this)
    }

}