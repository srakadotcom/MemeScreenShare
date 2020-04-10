package pl.memexurer.screenshare.config.configuration.impl;

import org.bukkit.plugin.java.JavaPlugin;
import pl.memexurer.screenshare.config.configuration.ConfigurationSource;
import pl.memexurer.screenshare.config.configuration.CustomConfiguration;
import pl.memexurer.screenshare.config.parser.ConfigValueType;

import java.util.List;

public class PluginConfiguration extends CustomConfiguration {
    public PluginConfiguration(JavaPlugin plugin) {
        super(plugin);
    }

    @ConfigurationSource(path = "ban.format")
    public String BAN_FORMAT;

    @ConfigurationSource(path = "ban.logout.time")
    public String BAN_TIME_LOGOUT;

    @ConfigurationSource(path = "ban.logout.reason")
    public String BAN_REASON_LOGOUT;

    @ConfigurationSource(path = "ban.found.time")
    public String BAN_TIME_FOUND;

    @ConfigurationSource(path = "ban.found.reason")
    public String BAN_REASON_FOUND;

    @ConfigurationSource(path = "ban.acknowledgment.time")
    public String BAN_TIME_ACKNOWLEDGMENT;

    @ConfigurationSource(path = "ban.acknowledgment.reason")
    public String BAN_REASON_ACKNOWLEDGMENT;

    @ConfigurationSource(path = "ban.delay")
    public int BAN_DELAY;

    @ConfigurationSource(path = "messages.checking.message", valueType = ConfigValueType.COLORED_STRING)
    public String MESSAGE_CHECKING;

    @ConfigurationSource(path = "messages.checking.broadcast", valueType = ConfigValueType.COLORED_STRING)
    public String MESSAGE_BROADCAST_CHECK;

    @ConfigurationSource(path = "messages.checked.cheater.message", valueType = ConfigValueType.COLORED_STRING)
    public String MESSAGE_CHEATER;

    @ConfigurationSource(path = "messages.checked.cheater.broadcast", valueType = ConfigValueType.COLORED_STRING)
    public String MESSAGE_BROADCAST_CHEATER;

    @ConfigurationSource(path = "messages.checked.legit.message", valueType = ConfigValueType.COLORED_STRING)
    public String MESSAGE_LEGIT;

    @ConfigurationSource(path = "messages.checked.legit.broadcast", valueType = ConfigValueType.COLORED_STRING)
    public String MESSAGE_BROADCAST_LEGIT;

    @ConfigurationSource(path = "messages.checked.logout", valueType = ConfigValueType.COLORED_STRING)
    public String MESSAGE_BROADCAST_LOGOUT;

    @ConfigurationSource(path = "messages.checked.acknowledgment.broadcast", valueType = ConfigValueType.COLORED_STRING)
    public String MESSAGE_BROADCAST_ACKNOWLEDGMENT;

    @ConfigurationSource(path = "messages.checked.acknowledgment.message", valueType = ConfigValueType.COLORED_STRING)
    public String MESSAGE_ACKNOWLEDGMENT;

    @ConfigurationSource(path = "messages.command_not_allowed", valueType = ConfigValueType.COLORED_STRING)
    public String MESSAGE_COMMAND_NOT_ALLOWED;

    @ConfigurationSource(path = "messages.checked_message_format", valueType = ConfigValueType.COLORED_STRING)
    public String MESSAGE_CHECKED_FORMAT;

    @ConfigurationSource(path = "check.allowed_commands")
    public List<String> CHECK_ALLOWED_COMMANDS;


}
