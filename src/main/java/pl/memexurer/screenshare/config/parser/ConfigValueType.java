package pl.memexurer.screenshare.config.parser;

import pl.memexurer.screenshare.config.parser.impl.ColoredStringValueParser;
import pl.memexurer.screenshare.config.parser.impl.LocationValueParser;

public enum ConfigValueType {
    DEFAULT(),
    LOCATION(new LocationValueParser()),
    COLORED_STRING(new ColoredStringValueParser());

    private ConfigValueParser parser;

    ConfigValueType(ConfigValueParser parser) {
        this.parser = parser;
    }

    ConfigValueType() {
    }

    public Object parse(Object val) {
        return parser.parse(val);
    }

    public Object stringify(Object obj) {
        return parser.stringify(obj);
    }
}
