import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Forgeahead-Shital on 2/6/2017.
 */

public class FileReader  {

    public String  displayUrls(String var)throws Exception {

        Properties prop = new Properties();

        String propFileName = "input.properties";
        prop.getProperty(propFileName);
        InputStream inputStream;
        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }
        String baseURL = prop.getProperty("baseURL");

return (baseURL);

    }
}
