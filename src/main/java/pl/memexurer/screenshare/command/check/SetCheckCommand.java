package pl.memexurer.screenshare.command.check;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.memexurer.screenshare.ScreenSharePlugin;
import pl.memexurer.screenshare.util.ChatUtil;

public class SetCheckCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatUtil.fixColor("&4Blad: &7Ta komenda jest dostepna tylko dla graczy."));
            return true;
        }

        if(!sender.hasPermission("screenshare.setcheck")) {
            sender.sendMessage(ChatUtil.fixColor("&4Blad: &7Nie posiadasz wystarczajacych uprawnien do uzycia tej komendy."));
            return true;
        }

        ScreenSharePlugin.getPluginInstance().getPluginDataConfiguration().CHECK_LOCATION = ((Player) sender).getLocation();
        ScreenSharePlugin.getPluginInstance().getPluginDataConfiguration().save();

        sender.sendMessage(ChatColor.GREEN + "Pomyslnie ustawiono miejsce sprawdzania graczy.");
        return true;
    }
}
