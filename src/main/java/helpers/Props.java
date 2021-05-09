package helpers;

import com.google.gson.JsonObject;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import static java.lang.System.out;

public class Props {
    private static final Logger LOG = LoggerFactory.getLogger(Props.class);
    private static Properties properties;
    private static Map<String, Object> map;


    /**
     * Gets the key from Config.properties related to chosen profile
     *
     * @param key
     **/

    public static String getProp(String key) {
        loadRunConfigProps();
        if ((key == null) || key.isEmpty()) {
            return "";
        } else {
            return properties.getProperty(key);

        }
    }


    public static void loadRunConfigProps() {
        properties = new Properties();
        try (InputStream inputStream = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }


}
