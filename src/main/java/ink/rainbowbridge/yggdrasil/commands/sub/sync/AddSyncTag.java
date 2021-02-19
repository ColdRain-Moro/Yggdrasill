package ink.rainbowbridge.yggdrasil.commands.sub.sync;

import ink.rainbowbridge.yggdrasil.Yggdrasil;
import io.izzel.taboolib.module.command.base.BaseSubCommand;
import io.izzel.taboolib.module.nms.NMS;
import io.izzel.taboolib.module.nms.nbt.NBTBase;
import io.izzel.taboolib.module.nms.nbt.NBTCompound;
import io.izzel.taboolib.util.item.Items;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * @Author 寒雨
 * @Since 10:10 2021/2/19
 **/
public class AddSyncTag extends BaseSubCommand {
    @Override
    public void onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = (Player)commandSender;
        if (Items.isNull(p.getInventory().getItemInMainHand())){
            Yggdrasil.send(commandSender,"&4手中物品不能为空");
            return;
        }
        ItemStack item =  p.getInventory().getItemInMainHand();
        NBTCompound compound = NMS.handle().loadNBT(item);
        compound.put("Yggdrasil-SyncTag",new NBTBase(strings[0]));
        p.getInventory().setItemInMainHand(NMS.handle().saveNBT(item,compound));
        Yggdrasil.send(commandSender,"操作成功!");
    }
}
