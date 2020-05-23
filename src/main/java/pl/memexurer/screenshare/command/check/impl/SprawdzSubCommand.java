package pl.memexurer.screenshare.command.check.impl;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.memexurer.screenshare.command.check.CheckSubCommand;
import pl.memexurer.screenshare.data.CheckedPlayer;

public class SprawdzSubCommand implements CheckSubCommand {
    @Override
    public void execute(CommandSender sender, CheckedPlayer player) {
        if(!(sender instanceof Player)) {
            sendMessage(sender, "&4Blad: &7Ta komenda jest dostepna tylko dla graczy.");
            return;
        }

        if(player.getPlayer().hasPermission("screenshare.check")) {
            sendMessage(sender, "&4Blad: &7Nie mozesz sprawdzic tego gracza - posiada on permisje do sprawdzania graczy");
            return;
        }

        if(player.isBeingChecked()) {
            sendMessage(sender, "&4Blad: &7Ten gracz juz jest sprawdzany (przez admina " + player.getCheckedBy() + ")!");
            return;
        }

        player.checkPlayer((Player) sender);
    }
}
