package ink.rainbowbridge.yggdrasil.commands.sub;

import ink.rainbowbridge.yggdrasil.Yggdrasil;
import io.izzel.taboolib.module.command.base.BaseSubCommand;
import io.izzel.taboolib.module.config.TConfig;
import io.izzel.taboolib.util.item.Items;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class Cover extends BaseSubCommand {
    @Override
    public void onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length == 1){
            asItemStack(commandSender, strings);
        }
        else if (strings.length == 2){
            switch (strings[1].toLowerCase()){
                case "itemstack":{
                    asItemStack(commandSender, strings);
                }
                case "itemjson":{
                    ItemStack item = ((Player)commandSender).getInventory().getItemInMainHand();
                    if (!Items.isNull(item)) {
                        Yggdrasil.items.put(strings[0],item);
                        TConfig conf = TConfig.create(new File(Yggdrasil.getDir(),strings[0]+".yml"));
                        conf.set("ItemJson", Items.toJson(item));
                        conf.saveToFile();
                        Yggdrasil.send(commandSender,"已经以内部名称: &f"+strings[0]+" &7强制覆盖 ["+ Items.getName(item)+"&7] (ItemJson)");
                        return;
                    }
                    Yggdrasil.send(commandSender,"&4错误: 手中物品不能为空");
                }
            }
        }
    }

    private void asItemStack(@NotNull CommandSender commandSender, @NotNull String[] strings) {
        ItemStack item = ((Player)commandSender).getInventory().getItemInMainHand();
        if (!Items.isNull(item)) {
            Yggdrasil.items.put(strings[0],item);
            TConfig conf = TConfig.create(new File(Yggdrasil.getDir(),strings[0]+".yml"));
            conf.set("ItemStack",item);
            conf.saveToFile();
            Yggdrasil.send(commandSender,"已经以内部名称: &f"+strings[0]+" &7强制覆盖 ["+ Items.getName(item)+"&7] (ItemStack)");
            return;
        }
        Yggdrasil.send(commandSender,"&4错误: 手中物品不能为空");
    }
}
