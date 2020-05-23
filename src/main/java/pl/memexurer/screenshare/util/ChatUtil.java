package pl.memexurer.screenshare.util;

import org.bukkit.ChatColor;

public final class ChatUtil {
    public static String fixColor(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}
