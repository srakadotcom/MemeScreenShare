package pl.memexurer.screenshare.data;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import pl.memexurer.screenshare.ScreenSharePlugin;
import pl.memexurer.screenshare.config.configuration.impl.PluginConfiguration;

public class CheckedPlayer {
    private String name;
    private String checkedBy;
    private Location previousLocation;

    public CheckedPlayer(Player player) {
        this.name = player.getName();
    }

    public String getName() {
        return name;
    }

    public String getCheckedBy() {
        return checkedBy;
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(name);
    }

    public void checkPlayer(Player checkedBy) {
        Player checkedPlayer = getPlayer();

        this.previousLocation = checkedPlayer.getLocation();
        this.checkedBy = checkedBy.getName();
        if (ScreenSharePlugin.getPluginInstance().getPluginDataConfiguration().CHECK_LOCATION != null)
            checkedPlayer.teleport(ScreenSharePlugin.getPluginInstance().getPluginDataConfiguration().CHECK_LOCATION);
        checkedPlayer.sendMessage(ScreenSharePlugin.getPluginInstance().getPluginConfiguration().MESSAGE_CHECKING);
        Bukkit.broadcastMessage(ScreenSharePlugin.getPluginInstance().getPluginConfiguration().MESSAGE_BROADCAST_CHECK.replace("{PLAYER}", name));
    }

    public void checkPlayer() {
        Player checkedPlayer = getPlayer();

        this.previousLocation = checkedPlayer.getLocation();
        this.checkedBy = "Console";
        if (ScreenSharePlugin.getPluginInstance().getPluginDataConfiguration().CHECK_LOCATION != null)
            checkedPlayer.teleport(ScreenSharePlugin.getPluginInstance().getPluginDataConfiguration().CHECK_LOCATION);
        checkedPlayer.sendMessage(ScreenSharePlugin.getPluginInstance().getPluginConfiguration().MESSAGE_CHECKING);
        Bukkit.broadcastMessage(ScreenSharePlugin.getPluginInstance().getPluginConfiguration().MESSAGE_BROADCAST_CHECK.replace("{PLAYER}", name));
    }

    public void legit() {
        this.checkedBy = null;

        Player player = getPlayer();
        player.teleport(previousLocation);
        player.sendMessage(ScreenSharePlugin.getPluginInstance().getPluginConfiguration().MESSAGE_LEGIT);
        Bukkit.broadcastMessage(ScreenSharePlugin.getPluginInstance().getPluginConfiguration().MESSAGE_BROADCAST_LEGIT.replace("{PLAYER}", name));
    }

    public void banCheater() {
        this.checkedBy = null;

        Player player = getPlayer();

        PluginConfiguration configuration = ScreenSharePlugin.getPluginInstance().getPluginConfiguration();
        player.sendMessage(configuration.MESSAGE_CHEATER);
        Bukkit.broadcastMessage(configuration.MESSAGE_BROADCAST_CHEATER.replace("{PLAYER}", name));

        Bukkit.getScheduler().scheduleSyncDelayedTask(ScreenSharePlugin.getPluginInstance(), () ->
                        banPlayer(configuration.BAN_TIME_FOUND, configuration.BAN_REASON_FOUND),
                configuration.BAN_DELAY * 20);
    }

    public void banLogout() {
        this.checkedBy = null;

        PluginConfiguration configuration = ScreenSharePlugin.getPluginInstance().getPluginConfiguration();
        Bukkit.broadcastMessage(configuration.MESSAGE_BROADCAST_LOGOUT.replace("{PLAYER}", name));

        banPlayer(configuration.BAN_TIME_LOGOUT, configuration.BAN_REASON_LOGOUT);
    }

    public void acknowledge() {
        this.checkedBy = null;

        Player player = getPlayer();

        PluginConfiguration configuration = ScreenSharePlugin.getPluginInstance().getPluginConfiguration();
        player.sendMessage(configuration.MESSAGE_ACKNOWLEDGMENT);
        Bukkit.broadcastMessage(configuration.MESSAGE_BROADCAST_ACKNOWLEDGMENT.replace("{PLAYER}", name));

        Bukkit.getScheduler().scheduleSyncDelayedTask(ScreenSharePlugin.getPluginInstance(), () ->
                        banPlayer(configuration.BAN_TIME_ACKNOWLEDGMENT, configuration.BAN_REASON_ACKNOWLEDGMENT),
                configuration.BAN_DELAY * 20);
    }

    public boolean isBeingChecked() {
        return checkedBy != null;
    }

    private void banPlayer(String time, String reason) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ScreenSharePlugin.getPluginInstance().getPluginConfiguration().BAN_FORMAT
                .replace("{PLAYER}", name)
                .replace("{TIME}", time)
                .replace("{REASON}", reason)); //TODO: dodać message formattera
    }
}
