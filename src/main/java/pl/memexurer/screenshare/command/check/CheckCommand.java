package pl.memexurer.screenshare.command.check;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pl.memexurer.screenshare.ScreenSharePlugin;
import pl.memexurer.screenshare.command.check.impl.CheaterSubCommand;
import pl.memexurer.screenshare.command.check.impl.CzystySubCommand;
import pl.memexurer.screenshare.command.check.impl.SprawdzSubCommand;
import pl.memexurer.screenshare.data.CheckedPlayer;
import pl.memexurer.screenshare.util.ChatUtil;

import java.util.Optional;

public class CheckCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("screenshare.check")) {
            sendMessage(sender, "&4Blad: &7Nie posiadasz wystarczajacych uprawnien do uzycia tej komendy.");
            return true;
        }

        if(args.length != 2) {
            sendMessage(sender, "&4Blad: &7Poprawne uzycie: /" + label + " (sprawdz/cheater/czysty) (nick)");
            return true;
        }

        Optional<CheckedPlayer> player = ScreenSharePlugin.getPluginInstance().getCheckedPlayerData().findPlayer(args[1]);
        if(!player.isPresent()) {
            player = ScreenSharePlugin.getPluginInstance().getCheckedPlayerData().createPlayer(Bukkit.getPlayer(args[1]));
            if(!player.isPresent()) {
                sendMessage(sender, "&4Blad: &7Gracz jest offline!");
                return true;
            }
        }

        if(args[0].equalsIgnoreCase("sprawdz")) {
            new SprawdzSubCommand().execute(sender, player.get());
        } else if(args[0].equalsIgnoreCase("cheater")) {
            new CheaterSubCommand().execute(sender, player.get());
        } else if (args[0].equalsIgnoreCase("czysty")) {
            new CzystySubCommand().execute(sender, player.get());
        } else {
            sendMessage(sender, "&4Blad: &7Poprawne uzycie: /" + label + " (sprawdz/cheater/czysty) (nick)");
        }
        return true;
    }

    private void sendMessage(CommandSender sender, String str) {
        sender.sendMessage(ChatUtil.fixColor(str));
    }
}
