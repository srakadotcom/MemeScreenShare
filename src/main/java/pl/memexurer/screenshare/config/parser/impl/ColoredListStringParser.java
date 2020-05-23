package pl.memexurer.screenshare.config.parser.impl;

import pl.memexurer.screenshare.config.parser.ConfigValueParser;
import pl.memexurer.screenshare.util.ChatUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ColoredListStringParser implements ConfigValueParser<List<String>, String> {

    @Override
    public String parse(List<String> value) {
        return value.stream().map(ChatUtil::fixColor).collect(Collectors.joining("\n"));
    }

    @Override
    public List<String> convert(String object) {
        return Arrays.stream(object.split("\n")).map(str -> str.replace('\u00A7', '&')).collect(Collectors.toList());
    }
}
