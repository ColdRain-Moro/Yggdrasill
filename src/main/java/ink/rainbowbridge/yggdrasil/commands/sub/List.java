package ink.rainbowbridge.yggdrasil.commands.sub;

import ink.rainbowbridge.yggdrasil.Yggdrasil;
import io.izzel.taboolib.module.command.base.BaseSubCommand;
import io.izzel.taboolib.module.tellraw.TellrawJson;
import io.izzel.taboolib.util.item.Items;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class List extends BaseSubCommand {
    @Override
    public void onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        //究极无敌Tellraw展示物品，病毒库牛逼！
        Yggdrasil.send(commandSender,"&f&lYggdrasil &7- &8物品列表&f(点击获取)");
        Yggdrasil.send(commandSender," ");
        for (String name : Yggdrasil.items.keySet()){
            TellrawJson.create().append(ChatColor.translateAlternateColorCodes('&',"&7"+name+" &8- &7[" + Items.getName(Yggdrasil.items.get(name)) + "&7]"))
                    .hoverItem(Yggdrasil.items.get(name))
                    .clickCommand("/yggdrasil get "+name)
                    .send(commandSender);
        }
    }
}
