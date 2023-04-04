package net.crmly.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import net.crmly.utilities.BrowserUtils;
import net.crmly.utilities.Driver;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    //    - Hooks class will allow us to pass pre- and post-conditions for each scenario and each step.
//    - Hooks class is seperated from feature file
//    - Therefore it will go into the implementation side (step_definitions)
//
//- How does my project know where to find the Hooks class and execute the annotations?
//    - Basically logic is coming from the cucumber annotations and also glue path we provide in the runner class. Combination of annotations and glue path we use
//
//
//- Can we create more than one  @Before, @After, @BeforeStep, @AfterStep
//- Yes.
//
//- If we have multiple versions of the same annotation, we can prioritize the running order using the "order" keyword.
//
//- The lower the number passed in the order, earlier it will get executed.
//- The methods will be executed in the order it is specified with numbers.
    ;
    @BeforeStep
    public void setupScenario() {

    }




    // We can create more than more @Before, @After, @BeforeStep, @AfterStep
    // If we have multiple versions of the same annotation, we can prioritize the running order using the "order" keyword

    // @Before (value = "@login", order = 1)
  /*  public void setupScenarioForLogins() {
        System.out.println("====this will only apply to scenarios with @login tag");
    }


   */

  /* @Before(value = "@db", order = 0)
    public void setupForDatabaseScenarios() {

        System.out.println("====this will only apply to scenarios with @db tag");
    }


   */

    @After
    public void teardownScenario(Scenario scenario) { // keeps track of currently executed scenario

        if (scenario.isFailed()) { //--> if scenario fails this method will return TRUE boolean value and take a                                   screenshot

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }

        //BrowserUtils.sleep(5);
        Driver.closeDriver();

        //  System.out.println("_________________ Closing browser using cucumber @After ________________");
        //    System.out.println("============= Scenario ended. Take screenshot if failed!");

    }

 /*    @BeforeStep
     public void setupStep() {
         System.out.println("xxx Applying set up using @BeforeStep xxx");
       }
*/
/*     @AfterStep
    public void afterStep() {
       System.out.println("xxx Applying teardown using @AfterStep xxx");
         BrowserUtils.sleep(5);

     }*/
//@After
public void after() {
    System.out.println("xxx Applying teardown using @After xxx");
    BrowserUtils.sleep(5);
    Driver.closeDriver();}
}

