package net.crmly.pages;

import net.crmly.utilities.ConfigurationReader;
import net.crmly.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
      /*
     WHAT IS Page Object Model Design Pattern?

    - Creating java class for each page of the web application.
    - All of the related web elements to current page will be stored to its own .java class.
    - We can also store related re-usable utility methods in its "page" class as well.
     */

    public LogInPage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//input[@name='USER_LOGIN']")
    public WebElement userLogin;

    @FindBy(xpath = "//input[@name='USER_PASSWORD']")
    public WebElement userPassword;

    @FindBy (xpath = "//input[@type='submit']")
    public WebElement loginButton;

    /**
     * below methods will log in using credentials from:
     *  configuration.properties
     */


    public void navigateLogInPage(){
        Driver.getDriver().get(ConfigurationReader.getProperty("crmly.url"));
    }

    public void loginAsHr(){
        userLogin.sendKeys(ConfigurationReader.getProperty("hr.username"));
        userPassword.sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();
    }
    public void loginAsMarketing(){
        userLogin.sendKeys(ConfigurationReader.getProperty("marketing.username"));
        userPassword.sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();
    }

    public void loginAsHelpdesk(){
        userLogin.sendKeys(ConfigurationReader.getProperty("helpdesk.username"));
        userPassword.sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();
    }

    public void logInWithCredentials (String username, String password){
        userLogin.sendKeys(username);
        userPassword.sendKeys(password);
        loginButton.click();
    }

}
