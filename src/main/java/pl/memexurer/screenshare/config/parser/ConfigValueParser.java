package pl.memexurer.screenshare.config.parser;

public interface ConfigValueParser<K, T> {
    T parse(K value);

    K convert(T object);
}
