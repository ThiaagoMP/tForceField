package br.com.thiaago.forcefield.spigot.command

import br.com.thiaago.forcefield.constant.NBTTag
import br.com.thiaago.forcefield.spigot.utils.ItemBuilder
import io.github.bananapuncher714.nbteditor.NBTEditor
import me.saiintbrisson.minecraft.command.annotation.Command
import me.saiintbrisson.minecraft.command.command.Context
import org.bukkit.Material
import org.bukkit.entity.Player

class GiveItemCommand {

    @Command(name = "ffitem", description = "Command to give item forcefield", permission = "ffitem.use")
    fun handleCommand(context: Context<Player>) {
        if (context.sender.inventory.itemInMainHand.type != Material.AIR) {
            context.sendMessage("§cPlease remove the item from your hand!")
            return
        }

        var itemBuilder =
            ItemBuilder(Material.NETHER_STAR).setDisplayName("§aForceField").setLore("", "§6Click to use forcefield!")
                .build()
        itemBuilder = NBTEditor.set(itemBuilder, context.sender.name, NBTTag.NBT_TAG_ITEM_FORCEFIELD.value)

        context.sender.inventory.setItemInMainHand(itemBuilder)
    }

}