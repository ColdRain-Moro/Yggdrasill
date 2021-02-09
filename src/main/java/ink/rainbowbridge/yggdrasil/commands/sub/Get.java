package ink.rainbowbridge.yggdrasil.commands.sub;

import ink.rainbowbridge.yggdrasil.Yggdrasil;
import io.izzel.taboolib.cronus.CronusUtils;
import io.izzel.taboolib.module.command.base.BaseSubCommand;
import io.izzel.taboolib.util.item.Items;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class Get extends BaseSubCommand {
    @Override
    public void onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (Yggdrasil.items.containsKey(strings[0])){
            ItemStack item = Yggdrasil.items.get(strings[0]);
            CronusUtils.addItem((Player)commandSender,Yggdrasil.items.get(strings[0]));
            Yggdrasil.send(commandSender,"物品 &f"+strings[0]+" &7已发送到你的背包......");
            return;
        }
        Yggdrasil.send(commandSender,"&4错误: 没有找到物品 &f"+strings[0]);
    }
}
