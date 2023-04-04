package net.crmly.pages;

import net.crmly.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StreamPage {
    public StreamPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "/html/body/span")
    public WebElement insertTextMessage;
    @FindBy(xpath = "//*[@id=\"feed-add-post-form-tab-message\"]/span")
    public WebElement messageTab;

    @FindBy(xpath = "//*[@id=\"bx-b-uploadfile-blogPostForm\"]")
    public WebElement uploadFilesIcon;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement uploadFileButton;

    @FindBy(css = "button#blog-submit-button-save")
    public WebElement sendButton;

    @FindBy(xpath = "//span[.='Insert in text']")
    public WebElement insertInTextButton;
    @FindBy(xpath = "//span[@class= 'del-but']")
    public WebElement deleteButton;
    @FindBy(xpath = "//span[@class= 'f-wrap']")
    public WebElement clickOnFileToRename;

    @FindBy(xpath = "(//td//span[.='Insert in text'])//span")
    public WebElement insertInText;

  
    @FindBy (xpath = "//span[@class='files-name-edit-btn']")
    public WebElement editButton;
    @FindBy (xpath = "(//span[@class='del-but'])[1]")
    public WebElement removeButton1;

    @FindBy (xpath = "//input[@class='files-name-edit-inp']")
    public WebElement editFieldForPDF;

    @FindBy(xpath = "//a[contains(text(),'test')]")
    public WebElement intextTest;


}
