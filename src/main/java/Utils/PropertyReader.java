package Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static PropertyReader prop;
    private final Properties properties;

    public PropertyReader(){
        properties = new Properties();
    }

    public static synchronized PropertyReader getInstance(){
        if (prop == null){
            prop = new PropertyReader();
        }
        return prop;
    }

    public void loader(String filePath){
        InputStream inp;
        inp = getClass().getClassLoader().getResourceAsStream(filePath);
        try{
            properties.load(inp);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public String getValue(String key){
        return properties.getProperty(key).trim();
    }
}
