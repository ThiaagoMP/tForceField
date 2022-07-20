package br.com.thiaago.forcefield.spigot.listener

import br.com.thiaago.forcefield.action.impl.ForceFieldAction
import br.com.thiaago.forcefield.constant.NBTTag
import io.github.bananapuncher714.nbteditor.NBTEditor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent

class PlayerListener : Listener {

    @EventHandler
    fun onInteract(event: PlayerInteractEvent) {
        if (!event.action.isRightClick) return
        if (!NBTEditor.contains(event.player.inventory.itemInMainHand, NBTTag.NBT_TAG_ITEM_FORCEFIELD.value)) return
        val action = ForceFieldAction()
        action.execute(event.player, null)
    }

}