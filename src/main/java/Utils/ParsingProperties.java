package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ParsingProperties {

    private static String url;


    public static void parsingProperties() throws IOException {

        Properties props = new Properties();
        props.load(new FileInputStream(new File("src/main/resources/config.properties")));
        url = props.getProperty("url");

    }

    public static String getUrl() {
        return url;
    }

}
