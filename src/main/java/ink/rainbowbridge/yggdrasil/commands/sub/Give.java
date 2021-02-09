package ink.rainbowbridge.yggdrasil.commands.sub;

import ink.rainbowbridge.yggdrasil.Yggdrasil;
import io.izzel.taboolib.cronus.CronusUtils;
import io.izzel.taboolib.module.command.base.BaseSubCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class Give extends BaseSubCommand {
    @Override
    public void onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (Bukkit.getPlayer(strings[0]) != null) {
            if (Yggdrasil.items.containsKey(strings[1])) {
                ItemStack item = Yggdrasil.items.get(strings[0]);
                try {
                    //可不敢给太多,但貌似这里逻辑有问题？
                    if (Integer.parseInt(strings[2]) <= 2048) {
                        item.setAmount(Integer.parseInt(strings[2]));
                    }
                } catch (Exception ex) {
                    Yggdrasil.send(commandSender, "&4错误: 物品数量错误");
                    return;
                }
                CronusUtils.addItem(Bukkit.getPlayer(strings[0]), item);
                Yggdrasil.send(commandSender, "物品 &f" + strings[1]+" &f*"+strings[2] + " &7已发送到 &f" + strings[0] + " 的背包......");
                return;
            }
            Yggdrasil.send(commandSender, "&4错误: 没有找到物品 &f" + strings[1]);
            return;
        }
        Yggdrasil.send(commandSender,"&4错误: 玩家不在线或不存在");
    }
}
