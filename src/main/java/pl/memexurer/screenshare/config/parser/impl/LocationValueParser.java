package pl.memexurer.screenshare.config.parser.impl;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import pl.memexurer.screenshare.config.parser.ConfigValueParser;

public class LocationValueParser implements ConfigValueParser {
    @Override
    public Object parse(Object value) {
        if (value == null) {
            return null;
        }
        String[] splitted = ((String) value).split(",");
        if (splitted.length == 6)
            return new Location(Bukkit.getWorld(splitted[0]), Integer.parseInt(splitted[1]), Integer.parseInt(splitted[2]), Integer.parseInt(splitted[3]), Float.parseFloat(splitted[4]), Float.parseFloat(splitted[5]));
        else if (splitted.length == 4)
            return new Location(Bukkit.getWorld(splitted[0]), Integer.parseInt(splitted[1]), Integer.parseInt(splitted[2]), Integer.parseInt(splitted[3]));
        else return null;
    }

    @Override
    public String stringify(Object object) {
        Location loc = (Location) object;
        if (loc.getYaw() != 0 && loc.getPitch() != 0)
            return loc.getWorld().getName() + "," + loc.getBlockX() + "," + loc.getBlockY() + "," + loc.getBlockZ() + "," + loc.getYaw() + "," + loc.getPitch();
        else return loc.getWorld().getName() + "," + loc.getBlockX() + "," + loc.getBlockY() + "," + loc.getBlockZ();
    }
}
