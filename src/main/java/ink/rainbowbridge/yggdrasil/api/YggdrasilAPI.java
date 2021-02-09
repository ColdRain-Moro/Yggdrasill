package ink.rainbowbridge.yggdrasil.api;

import ink.rainbowbridge.yggdrasil.Yggdrasil;
import org.bukkit.inventory.ItemStack;

public class YggdrasilAPI {
    /**
     * 获取Yggdrasil中读取的物品
     * @param name 内部名
     * @return ItemStack，不存在则为null
     */
    public static ItemStack getItemLoaded(String name){
        try{
           return Yggdrasil.items.get(name);
        }catch (Exception e){
            return null;
        }
    }
}
