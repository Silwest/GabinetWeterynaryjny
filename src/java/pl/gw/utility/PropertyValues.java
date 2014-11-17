/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author Silwest
 */
public class PropertyValues {

    public Map<String, String> getPropValues() throws IOException {

        Map<String, String> result = new HashMap<>();

        Properties prop = new Properties();
        try{
        String propFileName = "config.properties";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        prop.load(inputStream);
        if (inputStream == null) {
            throw new FileNotFoundException("Property file not found in the catalog");
        }

        result.put("emailUser", prop.getProperty("emailUser"));
        result.put("emailPassword", prop.getProperty("emailPassword"));
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return result;
    }

}
