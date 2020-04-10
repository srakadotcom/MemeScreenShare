package pl.memexurer.screenshare.command.check;

import org.bukkit.command.CommandSender;
import pl.memexurer.screenshare.data.CheckedPlayer;
import pl.memexurer.screenshare.util.ChatUtil;

public interface CheckSubCommand {
    void execute(CommandSender sender, CheckedPlayer player);

    default void sendMessage(CommandSender sender, String str) {
        sender.sendMessage(ChatUtil.fixColor(str));
    }
}
