package net.crmly.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
      /*
Driver Utility Review:

- Why did we create Driver utility class and method?

#1- We were having hard time passing the SAME(current) driver instance in different classes and different packages.
#2- We had to write too many lines just to instantiate our "driver"
#3- Now we are not only instantiating our driver in just one line, we are also optimizing the setups.
    - determine the type of browser by reading from "configuration.properties" file
    - window.maximize is implemented in our Driver util class
    - timeOut.implicitlyWait is implemented in our Driver util class
*/

//----------------------------------------------------------------------------------------------
/*
- How are we able to return the same instance of our driver?
- We implemented Singleton Design Pattern.

- What is a design pattern?
- Repeatable solution to a repeating issue.

- Singleton Design Pattern:
- Singleton Design Pattern makes sure we are returning the same instance every time we call our method.
- In our case we are trying to return the same instance of DRIVER
 */

//-------------------------------------------------------------------------------------------------

/*
How do we implement the Singleton Design Pattern?

#1- Create private constructor.
    - Once we create private constructor, we are closing access to the object the class (Driver util)
    - We create private variable for our WebDriver to close access from outside.

#2- Create getter method to deliver the object (WebDriver) in the way we want to deliver it.
    - The way we deliver it with using Singleton Design Pattern.
        - If first time calling of the method/object, it will create and do setups.
        - Next time we call the same method/object, it will keep returning the same object until the session ends or terminated by us.

 */
//-----------------------------------------------------------------------------------------------------

    private Driver() { /*
    Creating a private Constructor, so that we can close the access to the Object from the outside Class
     */

    }

    // we make WebDriver private, in order to close the access from the outside Class.
    //  private static WebDriver driver; // value is null by default
    private static InheritableThreadLocal <WebDriver> driverPool = new InheritableThreadLocal<>(); // We wrap our "driver" instance with InheritableThreadLocal

//Now that we are using "InheritableThreadLocal", we adjust our code in .getDriver() method to use methods coming from "InheritableThreadLocal"
//
//Instead of using : "driver" we use "driverPool.get()"
//Instead of using : driver = new ChromeDriver(); we use --> driverPool.set(new ChromeDriver());
//Instead of using : driver == null --> driverPool.remove();


    //create re-usable utility method, which returns the same driver instance when called
    public static WebDriver getDriver() {
/*
        if (driver == null) {
            //Read browserType from configuration.properties.
            //This way we can control which browser is opened outside our code, from configuration.properties.
            String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depending on the browserType that configuration.properties file is returning, switch statement will determine the case and open the matching browser
             */

      /*
            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup(); // this is coming from bonigarcia
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    break;

            }
        }
        return driver;


       */

        if (driverPool.get() == null) {
            String browserType = ConfigurationReader.getProperty("browser");
            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup(); // this is coming from bonigarcia
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    break;

            }
        }
        return driverPool.get();
    }



    //driver.quit() ----> noSuchElement
    //driver.close()--> will give an Exception

//How to handle Closing or Quitting driver with Driver utility class?
//
//--> When we created a new .getDriver() method in Driver utility class and implemented Singleton design pattern.
//
//--> This design pattern requires my driver to be "driver == null (true)" to be able to generate a new driver.
//
//--> When we use default driver.quit() method that is coming from Selenium library, we terminate the existing driver session completely.
//
//--> This creates issue for our existing structure. Since driver is not null or session is completely deleted/terminated, we cannot continue with our execution of following tests.
//
//--> To solve this issue, we created Driver.closeDriver() method in line 120.

//--> In this method 2 thing are happening:
//    #1- We use driver.quit() to terminate the session and close browsers.
//    #2- Set the driver session value back to "null", so rest of our tests can be executed.

    /*
    This method will make sure, that our driver value is always null after using quit() method
     */


    public static void closeDriver(){

       /* if (driver != null){
            driver.quit(); // this line will terminate the existing session.
            driver = null;
        }

*/

        if (driverPool.get() != null){
            driverPool.get().quit(); // this line will terminate the existing session. value will not even be null
            driverPool.remove();
        }

    }





}
