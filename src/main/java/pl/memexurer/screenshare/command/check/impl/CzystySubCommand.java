package pl.memexurer.screenshare.command.check.impl;

import org.bukkit.command.CommandSender;
import pl.memexurer.screenshare.command.check.CheckSubCommand;
import pl.memexurer.screenshare.data.CheckedPlayer;

public class CzystySubCommand implements CheckSubCommand {
    @Override
    public void execute(CommandSender sender, CheckedPlayer player) {
        if(!player.isBeingChecked()) {
            sendMessage(sender, "&4Blad: &7Ten gracz nie jest sprawdzany.");
            return;
        }

        player.legit();
    }
}
