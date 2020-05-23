package pl.memexurer.screenshare.config.parser.impl;

import pl.memexurer.screenshare.config.parser.ConfigValueParser;
import pl.memexurer.screenshare.util.ChatUtil;

public class ColoredStringParser implements ConfigValueParser<String, String> {
    @Override
    public String parse(String obj) {
        if (obj == null) return null;
        return ChatUtil.fixColor(obj);
    }

    @Override
    public String stringify(String object) {
        return object.replace("\u00A7", "&");
    }
}
