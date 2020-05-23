package pl.memexurer.screenshare.config.parser;

import pl.memexurer.screenshare.config.parser.impl.ColoredStringParser;
import pl.memexurer.screenshare.config.parser.impl.LocationParser;

public enum ConfigValueType {
    DEFAULT(null),
    LOCATION(new LocationParser()),
    COLORED_STRING(new ColoredStringParser());

    private ConfigValueParser parser;

    ConfigValueType(ConfigValueParser parser) {
        this.parser = parser;
    }

    public Object parse(Object val) {
        return parser.parse(val);
    }

    public Object stringify(Object obj) {
        return parser.stringify(obj);
    }
}
