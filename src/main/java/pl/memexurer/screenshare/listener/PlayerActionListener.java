package pl.memexurer.screenshare.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import pl.memexurer.screenshare.ScreenSharePlugin;
import pl.memexurer.screenshare.data.CheckedPlayer;

public class PlayerActionListener implements Listener {
    @EventHandler
    public void commandDisablerHandler(PlayerCommandPreprocessEvent e) {
        CheckedPlayer player = ScreenSharePlugin.getPluginInstance().getCheckedPlayerData().getPlayer(e.getPlayer());
        if(player == null || !player.isBeingChecked()) return;

        String command = e.getMessage().substring(1).split(" ")[0];
        if(!ScreenSharePlugin.getPluginInstance().getPluginConfiguration().CHECK_ALLOWED_COMMANDS.contains(command)) {
            e.getPlayer().sendMessage(ScreenSharePlugin.getPluginInstance().getPluginConfiguration().MESSAGE_COMMAND_NOT_ALLOWED);
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void chatMessageHandler(AsyncPlayerChatEvent e) {
        CheckedPlayer player = ScreenSharePlugin.getPluginInstance().getCheckedPlayerData().getPlayer(e.getPlayer());
        if(player == null || !player.isBeingChecked()) return;

        e.setCancelled(true);
        for(Player p: Bukkit.getOnlinePlayers()) {
            if (!p.hasPermission("screenshare.check") || !player.getName().equals(p.getName())) continue;
            p.sendMessage(ScreenSharePlugin.getPluginInstance().getPluginConfiguration().MESSAGE_CHECKED_FORMAT
            .replace("{PLAYER}", e.getPlayer().getName())
            .replace("{MESSAGE}", e.getMessage()));
        }
    }

    @EventHandler
    public void logoutHandler(PlayerQuitEvent e) {
        CheckedPlayer player = ScreenSharePlugin.getPluginInstance().getCheckedPlayerData().getPlayer(e.getPlayer());
        if (player == null || !player.isBeingChecked()) return;

        player.banLogout();
    }
}
