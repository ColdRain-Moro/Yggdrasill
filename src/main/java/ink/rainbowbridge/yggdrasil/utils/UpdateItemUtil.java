package ink.rainbowbridge.yggdrasil.utils;

import ink.rainbowbridge.yggdrasil.Yggdrasil;
import ink.rainbowbridge.yggdrasil.api.YggdrasilAPI;
import io.izzel.taboolib.module.nms.NMS;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 寒雨
 * @Since 10:34 2021/2/19
 **/
public class UpdateItemUtil {
    public static void update(Player p){
        new BukkitRunnable() {
            @Override
            public void run() {
                List<ItemStack> items = new ArrayList<>();
                for(ItemStack item : p.getInventory().getContents()){
                   if(NMS.handle().loadNBT(item).containsKey("Yggdrasil-SyncTag")) {
                       String name = NMS.handle().loadNBT(item).get("Yggdrasil-SyncTag").asString();
                       if (Yggdrasil.items.containsKey(name)) {
                           ItemStack updateItem = Yggdrasil.items.get(name);
                           updateItem.setAmount(item.getAmount());
                           if (Yggdrasil.isPAPIReplace()){
                               YggdrasilAPI.ReplacePAPI(p,updateItem);
                           }
                           try{
                               updateItem.setDurability(item.getDurability());
                           }catch (Exception ignored){}
                            items.add(updateItem);
                           continue;
                       }
                   }
                   items.add(item);
                }
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        ItemStack[] itemStacks = new ItemStack[items.size()];
                        items.toArray(itemStacks);
                        p.getInventory().setContents(itemStacks);
                    }
                }.runTask(Yggdrasil.getInst());
            }
        }.runTaskAsynchronously(Yggdrasil.getInst());
    }
}
