package pl.memexurer.screenshare.data;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pl.memexurer.screenshare.ScreenSharePlugin;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

public class CheckedPlayerData {
    private HashMap<UUID, CheckedPlayer> checkedPlayers;

    public CheckedPlayerData() {
        this.checkedPlayers = new HashMap<>();
    }

    public Optional<CheckedPlayer> findPlayer(String playerName) {
        return checkedPlayers.values().stream().filter(player -> player.getName().equalsIgnoreCase(playerName)).findAny();
    }

    public CheckedPlayer checkPlayer(Player player) {
        player.sendMessage(ScreenSharePlugin.getPluginInstance().getPluginConfiguration().MESSAGE_BROADCAST_CHECK);
        return this.checkedPlayers.put(player.getUniqueId(), new CheckedPlayer(player));
    }

    public CheckedPlayer getPlayer(Player player) {
        return checkedPlayers.get(player.getUniqueId());
    }

    public Optional<CheckedPlayer> createPlayer(Player playerPlayer) {
        if (playerPlayer == null) return Optional.empty();

        CheckedPlayer player = new CheckedPlayer(playerPlayer);
        this.checkedPlayers.put(playerPlayer.getUniqueId(), player);

        return Optional.of(player);
    }
}
