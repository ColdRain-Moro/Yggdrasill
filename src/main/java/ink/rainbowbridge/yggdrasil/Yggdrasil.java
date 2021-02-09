package ink.rainbowbridge.yggdrasil;

import io.izzel.taboolib.loader.Plugin;
import io.izzel.taboolib.loader.PluginBoot;
import io.izzel.taboolib.module.config.TConfig;
import io.izzel.taboolib.module.inject.TInject;
import io.izzel.taboolib.module.locale.logger.TLogger;
import io.izzel.taboolib.util.item.Items;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.HashMap;


public class Yggdrasil extends Plugin {
    public static PluginBoot instance = null;
    public static HashMap<String, ItemStack> items = new HashMap<>();
    public static PluginBoot getInst(){
        return instance;
    }

    /**
     * 获取物品文件目录
     * @return category
     */
    public static File getDir(){
        return new File(getInst().getDataFolder(),"Items");
    }

    /**
     * 重载所有物品的方法
     */
    public static void ReloadItems() {
        items = new HashMap<>();
        String[] dir = getDir().list();
        for (String str : dir) {
            try {
                if (str.endsWith(".yml")) {
                    FileConfiguration conf = YamlConfiguration.loadConfiguration(new File(getDir(), str));
                    //优先读取ItemStack
                    if (conf.getItemStack("ItemStack") != null) {
                        items.put(str.replace(".yml", ""), conf.getItemStack("ItemStack"));
                        if (!config.getBoolean("Silent-Loading", false)) {
                            getLogger().info("从Items文件夹读取到ItemStack类型物品: &8" + str.replace(".yml", ""));
                        }
                    } else if (conf.getString("ItemJson") != null) {
                        if (Items.fromJson(conf.getString("ItemJson")) != null) {
                            items.put(str.replace(".yml", ""), Items.fromJson(conf.getString("ItemJson")));
                            if (!config.getBoolean("Silent-Loading", false)) {
                                getLogger().info("从Items文件夹读取到ItemJson类型物品: &8" + str.replace(".yml", ""));
                            }
                        }
                    }
                }
            }catch (Exception ex){
                getLogger().error("加载物品配置出现错误: "+str);
            }
        }
    }

    public static void sendWithoutPrefix(CommandSender sender, String s) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',s));
    }

    @Override
    public void onEnable() {
        //物品文件夹
        instance = this.getPlugin();
        getLogger().info("Yggdrasil 正在加载.....");
        long time = System.currentTimeMillis();
        ReloadItems();
        getLogger().info("载入完成，耗时: &8"+(System.currentTimeMillis()-time)+"ms");
    }

    @Override
    public void onDisable() {
    }

    @TInject(value = "config.yml")
    public static final TConfig config = null;

    /**
     * 是否在给予物品时替换PAPI变量
     * @return boolean
     */
    public static boolean isPAPIReplace(){
        return config.getBoolean("PAPI-Replace",true);
    }

    /**
     * 获取TLogger实例
     * @return TLogger
     */
    public static TLogger getLogger(){
       return TLogger.getUnformatted("Yggdrasil");
    }

    /**
     * 发送消息
     * @param sender sender
     * @param str message
     */
    public static void send(CommandSender sender, String str){
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',config.getString("Partly-Prefix","&7&l[&f&lYggdrasil&7&l] &7")+str));
    }
}
