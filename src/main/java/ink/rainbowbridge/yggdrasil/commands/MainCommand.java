package ink.rainbowbridge.yggdrasil.commands;

import ink.rainbowbridge.yggdrasil.commands.sub.*;
import ink.rainbowbridge.yggdrasil.commands.sub.sync.AddSyncTag;
import ink.rainbowbridge.yggdrasil.commands.sub.sync.ClearSyncTag;
import io.izzel.taboolib.module.command.base.*;

@BaseCommand(name = "yggdrasil",permission = "yggdrasil.admin",aliases = {"ygg","yitem"})
public class MainCommand extends BaseMainCommand {

    @SubCommand(description = "插件/作者相关,版本信息")
    BaseSubCommand about = new About();
    @SubCommand(description = "直接获取一个指定物品",type = CommandType.PLAYER,arguments = {"Item"})
    BaseSubCommand get = new Get();
    @SubCommand(description = "给予指定玩家指定数量的指定物品",arguments = {"Online_Player","Item","Amount"})
    BaseSubCommand give = new Give();
    @SubCommand(description = "列出所有已保存的物品")
    BaseSubCommand list = new List();
    @SubCommand(description = "重载插件")
    BaseSubCommand reload = new Reload();
    @SubCommand(description = "保存手中物品(ItemStack/ItemJson)",type = CommandType.PLAYER,arguments = {"Name","Type"})
    BaseSubCommand save = new Save();
    @SubCommand(description = "强制覆盖保存物品",type = CommandType.PLAYER,arguments = {"Name","Type"})
    BaseSubCommand cover = new Cover();
    @SubCommand(description = "为手中物品加上同步NBTTag",type = CommandType.PLAYER,arguments = {"同步物品内部名"})
    BaseSubCommand addTag = new AddSyncTag();
    @SubCommand(description = "清除手中物品的同步NBTTag",type = CommandType.PLAYER)
    BaseSubCommand clearTag = new ClearSyncTag();
}
