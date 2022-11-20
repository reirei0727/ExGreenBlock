package exgreenblock.exgreenblock;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.List;

public class EventListner implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        Player player = e.getPlayer(); // イベントを起こしたプレイヤー
        Location toLocation = e.getTo(); // イベントを起こしたプレイヤーの進んだ先
        Location loc = player.getLocation();
        World w = player.getWorld();

        Block underBlockType = toLocation.getBlock().getRelative(BlockFace.DOWN); // 進んだ先の真下のブロックのMaterial

        if(GreenMaterials.isGreenMaterial(underBlockType.getType())||GreenMaterials.isGreenMaterial(loc.getBlock().getType())){
            player.sendMessage(ChatColor.RED + "緑ブロックを踏みました（"+underBlockType.getType()+")");
            w.createExplosion(loc,5F,false,false);
        }
    }

    @EventHandler
    public void onPickUp(EntityPickupItemEvent e){
        if(e.getEntity() instanceof Player){
            if(GreenMaterials.isGreenMaterial(e.getItem().getItemStack().getType())){
                Player p = (Player)e.getEntity();
                World w = p.getWorld();
                p.sendMessage(ChatColor.RED + "緑ブロックを拾いました("+e.getItem().getItemStack().getType()+")");
                w.createExplosion(p.getLocation(),5F,false,false);
            }

        }
    }
}

