package pl.memexurer.screenshare;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.memexurer.screenshare.command.AcknowledgeCommand;
import pl.memexurer.screenshare.command.check.CheckCommand;
import pl.memexurer.screenshare.command.check.SetCheckCommand;
import pl.memexurer.screenshare.config.configuration.impl.PluginConfiguration;
import pl.memexurer.screenshare.config.configuration.impl.PluginDataConfiguration;
import pl.memexurer.screenshare.data.CheckedPlayerData;
import pl.memexurer.screenshare.listener.PlayerActionListener;

public final class ScreenSharePlugin extends JavaPlugin {
    private static ScreenSharePlugin PLUGIN_INSTANCE;

    private final CheckedPlayerData checkedPlayerData = new CheckedPlayerData();
    private final PluginConfiguration pluginConfiguration = new PluginConfiguration(this);
    private final PluginDataConfiguration pluginDataConfiguration = new PluginDataConfiguration(this);

    public static ScreenSharePlugin getPluginInstance() {
        return ScreenSharePlugin.PLUGIN_INSTANCE;
    }

    @Override
    public void onEnable() {
        ScreenSharePlugin.PLUGIN_INSTANCE = this;

        pluginConfiguration.load();
        pluginDataConfiguration.load();

        Bukkit.getPluginManager().registerEvents(new PlayerActionListener(), this);

        getCommand("check").setExecutor(new CheckCommand());
        getCommand("setcheck").setExecutor(new SetCheckCommand());
        getCommand("acknowledge").setExecutor(new AcknowledgeCommand());
    }

    public PluginConfiguration getPluginConfiguration() {
        return pluginConfiguration;
    }

    public PluginDataConfiguration getPluginDataConfiguration() {
        return pluginDataConfiguration;
    }

    public CheckedPlayerData getCheckedPlayerData() {
        return checkedPlayerData;
    }
}
