package ch.bfh.gr33nopo55um.enocean.helper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.Properties;

/**
 * @author silas
 * @class Class for reading the config file
 */
public class ReadConfig {
    private InputStream inputStream;

    public String readPropertyValue(String value) throws IOException {
        String result = null;

        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            Date time = new Date(System.currentTimeMillis());

            /**
             * @brief get the property value and print it out

             */
            result = prop.getProperty(value);


            /**
             * @brief throws error if no prop file is available
             */
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            assert inputStream != null;
            inputStream.close();
        }
        return result;
    }
}

