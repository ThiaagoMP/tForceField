package br.com.thiaago.forcefield.action

import org.bukkit.entity.Player

interface Action {

    fun execute(player: Player, context: List<*>?)

}