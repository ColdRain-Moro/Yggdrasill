package ink.rainbowbridge.yggdrasil.commands;

import ink.rainbowbridge.yggdrasil.commands.sub.*;
import io.izzel.taboolib.module.command.base.BaseCommand;
import io.izzel.taboolib.module.command.base.BaseMainCommand;
import io.izzel.taboolib.module.command.base.BaseSubCommand;
import io.izzel.taboolib.module.command.base.SubCommand;

@BaseCommand(name = "yggdrasil",permission = "yggdrasil.admin")
public class MainCommand extends BaseMainCommand {

    @SubCommand(description = "插件/作者相关,版本信息")
    BaseSubCommand about = new About();
    @SubCommand(description = "直接获取一个指定物品")
    BaseSubCommand get = new Get();
    @SubCommand(description = "给予指定玩家指定数量的指定物品")
    BaseSubCommand give = new Give();
    @SubCommand(description = "列出所有已保存的物品")
    BaseSubCommand list = new List();
    @SubCommand(description = "重载插件")
    BaseSubCommand reload = new Reload();
    @SubCommand(description = "保存手中物品")
    BaseSubCommand save = new Save();
}
