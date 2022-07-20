package br.com.thiaago.forcefield.spigot.events

import org.bukkit.entity.Player
import org.bukkit.event.Cancellable
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class PlayerUseForceFieldItemEvent(val player: Player, val context: List<*>?) : Event(), Cancellable {

    private val handlers = HandlerList()
    private var cancelled = false

    override fun isCancelled(): Boolean {
        return cancelled
    }

    override fun setCancelled(cancel: Boolean) {
        cancelled = cancel
    }

    override fun getHandlers(): HandlerList {
        return handlers
    }

    fun getHandlersList(): HandlerList {
        return handlers
    }
}