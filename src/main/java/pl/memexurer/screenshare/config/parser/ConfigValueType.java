package pl.memexurer.screenshare.config.parser;

import pl.memexurer.screenshare.config.parser.impl.ColoredListStringParser;
import pl.memexurer.screenshare.config.parser.impl.LocationParser;

public enum ConfigValueType {
    DEFAULT(null),
    LOCATION(new LocationParser()),
    COLORED_STRING(new ColoredListStringParser());

    private ConfigValueParser parser;

    ConfigValueType(ConfigValueParser parser) {
        this.parser = parser;
    }

    public Object parse(Object val) {
        return parser.parse(val);
    }

    public Object convert(Object obj) {
        return parser.convert(obj);
    }
}
