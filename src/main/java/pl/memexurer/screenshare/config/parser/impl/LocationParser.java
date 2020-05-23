package pl.memexurer.screenshare.config.parser.impl;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import pl.memexurer.screenshare.config.parser.ConfigValueParser;

public class LocationParser implements ConfigValueParser<String, Location> {
    @Override
    public Location parse(String obj) {
        if (obj == null) return null;
        String[] splittedString = obj.split(",");
        return new Location(Bukkit.getWorld(splittedString[0]), Integer.parseInt(splittedString[1]), Integer.parseInt(splittedString[2]), Integer.parseInt(splittedString[3]));
    }

    @Override
    public String convert(Location obj) {
        return obj.getWorld().getName() + "," + obj.getBlockX() + "," + obj.getBlockY() + "," + obj.getBlockZ();
    }
}
