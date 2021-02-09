package ink.rainbowbridge.yggdrasil.commands.sub;

import ink.rainbowbridge.yggdrasil.Yggdrasil;
import io.izzel.taboolib.module.command.base.BaseSubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Reload extends BaseSubCommand {
    @Override
    public void onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        long time = System.currentTimeMillis();
        Yggdrasil.ReloadItems();
        Yggdrasil.config.reload();
        Yggdrasil.send(commandSender,"重载完成 &8[&f"+(System.currentTimeMillis()-time)+"&8]");
    }
}
