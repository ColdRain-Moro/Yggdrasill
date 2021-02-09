package ink.rainbowbridge.yggdrasil.commands.sub;

import ink.rainbowbridge.yggdrasil.Yggdrasil;
import io.izzel.taboolib.module.command.base.BaseSubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class About extends BaseSubCommand {
    @Override
    public void onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Yggdrasil.sendWithoutPrefix(commandSender,"&f&lYggdrasil &7- &8&lby.&7&l寒雨");
        Yggdrasil.sendWithoutPrefix(commandSender,"&7插件版本: &f"+Yggdrasil.getInst().getDescription().getVersion());
    }
}
