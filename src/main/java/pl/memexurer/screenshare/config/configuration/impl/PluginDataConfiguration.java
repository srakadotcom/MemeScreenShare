package pl.memexurer.screenshare.config.configuration.impl;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import pl.memexurer.screenshare.config.configuration.ConfigurationSource;
import pl.memexurer.screenshare.config.configuration.CustomConfiguration;
import pl.memexurer.screenshare.config.parser.ConfigValueType;

public class PluginDataConfiguration extends CustomConfiguration {
    public PluginDataConfiguration(JavaPlugin plugin) {
        super(plugin, "data.yml");
    }

    @ConfigurationSource(path = "check.location", valueType = ConfigValueType.LOCATION)
    public Location CHECK_LOCATION;
}
