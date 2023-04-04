package net.crmly.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
      /*
 Why did we create ConfigurationReader?
- We created the re-usable .getProperty() utility method in ConfigurationReader class
- We can call this method in any class and any package when we need to read from configuration.properties file
 */

    // step1: create the Object of Properties
    private static Properties properties = new Properties(); // used private assess modifier to make the Object un-accessible  outside this Class. Also, the specifier is made static, because we want it to run first!

    static { //

        try {

            // step2: We need to open the file in java memory: FileInputStream
            FileInputStream file = new FileInputStream("src/configuration.properties");

            //step3: Load the properties Object using FileInputStream object
            properties.load(file); // the exception in this line, before we wrap with 'try and catch block', is grander than the exception in above line 24, hence we use superclass Exception

            file.close();  // close the file

        } catch (IOException e) {

            System.out.println("File not found in the ConfigurationReader class.");
            e.printStackTrace();
        }
    }

    // the code above enables us to create getProperty() method in line 33
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }
}

