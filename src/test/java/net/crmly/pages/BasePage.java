package net.crmly.pages;

import net.crmly.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

/*
    When we implement POM Design (Page Object Model Design Pattern) pattern we solve StaleElementReferenceException by default.

            - How it works?
            - Every time we want to use WebElement located using @FindBy annotation, it will be re-located in the line we are using it.
            - Basically it will automatically do a "freshness check" which will eliminate the StaleElementReferenceException
     */

/*
    - We have centralized pretty much everything re-usable such as:
            - important test data: in our configuration.properties
    - utility methods in utilities packages under different classes
        - Driver
        - ConfigurationReader
        - BrowserUtils
- The only thing that we didn't centralize or create a structure around is LOCATING WEB ELEMENTS.
            - PAGE OBJECT MODEL DESIGN PATTERN SOLVES THIS ISSUE WE CURRENTLY HAVE.

 */



}
