package br.com.thiaago.forcefield.action.impl

import br.com.thiaago.forcefield.action.Action
import br.com.thiaago.forcefield.spigot.events.PlayerUseForceFieldItemEvent
import org.bukkit.Bukkit
import org.bukkit.Color
import org.bukkit.Location
import org.bukkit.Particle
import org.bukkit.Particle.DustOptions
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.util.Vector
import kotlin.math.cos
import kotlin.math.sin

class ForceFieldAction : Action {

    private val sizeParticleCircle = 5.0

    override fun execute(player: Player, context: List<*>?) {
        val event = PlayerUseForceFieldItemEvent(player, context)
        Bukkit.getPluginManager().callEvent(event)
        if (event.isCancelled) return

        createParticleCircle(player.location)
        pushEntities(player)
    }

    private fun pushEntities(player: Player) {
        for (entity in player.getNearbyEntities(sizeParticleCircle, sizeParticleCircle, sizeParticleCircle)) {
            if (entity !is LivingEntity) continue
            val playerCenterLocation: Location = player.eyeLocation
            val playerToThrowLocation = entity.eyeLocation
            val x = playerToThrowLocation.x - playerCenterLocation.x
            val y = playerToThrowLocation.y - playerCenterLocation.y
            val z = playerToThrowLocation.z - playerCenterLocation.z
            val vector = Vector(x, y, z)
            vector.normalize()
            vector.multiply(1.5)
            entity.velocity = vector
        }


    }

    private fun createParticleCircle(location: Location) {
        var counter = 0
        while (counter <= 90) {
            val particleLoc = Location(location.world, location.x, location.y, location.z)
            particleLoc.x = location.x + cos(counter.toDouble()) * sizeParticleCircle
            particleLoc.z = location.z + sin(counter.toDouble()) * sizeParticleCircle
            particleLoc.y += 1
            location.world.spawnParticle(Particle.REDSTONE, particleLoc, 1, DustOptions(Color.GREEN, 2f))
            counter += 1
        }
    }

}