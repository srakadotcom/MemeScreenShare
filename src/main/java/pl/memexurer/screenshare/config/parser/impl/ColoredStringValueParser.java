package pl.memexurer.screenshare.config.parser.impl;

import pl.memexurer.screenshare.config.parser.ConfigValueParser;
import pl.memexurer.screenshare.util.ChatUtil;

import java.util.List;
import java.util.stream.Collectors;

public class ColoredStringValueParser implements ConfigValueParser {
    @Override
    public Object parse(Object value) {
        if(value instanceof String) return ChatUtil.fixColor((String) value);
        else if(value instanceof List) return ((List<String>) value).stream().map(ChatUtil::fixColor).collect(Collectors.joining("\n"));
        return null;
    }

    @Override
    public Object stringify(Object object) {
        if(object instanceof String) return ChatUtil.undoColor((String) object);
        else if(object instanceof List) return ((List<String>) object).stream().map(ChatUtil::undoColor).collect(Collectors.toList());
        return null;
    }
}
