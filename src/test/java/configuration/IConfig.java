package configuration;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${env}.properties")
public interface IConfig extends Config {

    @Key("env")
    String env();

    @Key("browser")
    String browser();

    @Key("url")
    String url();
}
