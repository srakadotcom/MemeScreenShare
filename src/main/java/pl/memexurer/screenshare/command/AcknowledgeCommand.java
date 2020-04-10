package pl.memexurer.screenshare.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pl.memexurer.screenshare.ScreenSharePlugin;
import pl.memexurer.screenshare.data.CheckedPlayer;
import pl.memexurer.screenshare.util.ChatUtil;

import java.util.Optional;

public class AcknowledgeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Optional<CheckedPlayer> player = ScreenSharePlugin.getPluginInstance().getCheckedPlayerData().findPlayer(args[1]);
        if(!player.isPresent()) {
            sender.sendMessage(ChatUtil.fixColor("&4Blad: &7Nie jestes sprawdzany."));
            return true;
        }

        player.get().acknowledge();
        return true;
    }
}
