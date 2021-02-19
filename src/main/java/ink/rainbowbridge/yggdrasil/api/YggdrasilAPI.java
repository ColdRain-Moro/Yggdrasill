package ink.rainbowbridge.yggdrasil.api;

import ink.rainbowbridge.yggdrasil.Yggdrasil;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class YggdrasilAPI {
    /**
     * 获取Yggdrasil中读取的物品
     * @param name 内部名
     * @return ItemStack，不存在则为null
     */
    public static ItemStack getItemLoaded(String name){
        try{
            ItemStack item = Yggdrasil.items.get(name);
           return Yggdrasil.items.get(name);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 替换物品lore与displayName的PAPI变量
     * @param p 目标玩家
     * @param item 物品
     */
    public static void ReplacePAPI(Player p , ItemStack item){
        if (item.hasItemMeta()){
            ItemMeta meta = item.getItemMeta();
            if (item.getItemMeta().hasLore()){
                meta.setLore(PlaceholderAPI.setPlaceholders(p,meta.getLore()));
            }
            if (item.getItemMeta().hasDisplayName()){
                meta.setDisplayName(PlaceholderAPI.setPlaceholders(p,meta.getDisplayName()));
            }
            item.setItemMeta(meta);
        }
    }
}
