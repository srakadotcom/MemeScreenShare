package pl.memexurer.screenshare.config.parser;

public interface ConfigValueParser {
    Object parse(Object value);

    Object stringify(Object object);
}
