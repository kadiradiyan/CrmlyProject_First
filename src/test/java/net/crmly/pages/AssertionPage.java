package net.crmly.pages;

import net.crmly.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AssertionPage {
    public AssertionPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//*[@id=\"pagetitle\"]")
    public WebElement activityStreamTab;




    @FindBy(xpath = "(//*[@class='feed-com-files-cont'])[1]//img[@alt]")
    public  List<WebElement> webElementList;



    //@FindBy(xpath = "(//*[@class='feed-com-files-cont'])[1]//span//img")
    @FindBy(xpath = "//*[@id=\"disk-attach-image-352\"]")
    public WebElement elementsOfFirstAC;

//(//*[@class='feed-com-files-cont'])[1]
    @FindBy(xpath = "//a[@href='#']//span[.='More']")
    public WebElement moreButton;

    @FindBy(xpath = "//span[.='Delete']")
    public WebElement deleteButton;

    @FindBy(xpath = "//*[@id=\"disk-attach-478\"]")
    //@FindBy(xpath = "//*[@id=\"disk-attach-466\"]")
    public WebElement fileNameofFourthAC;

    //@FindBy(xpath = "(//*[@class='feed-com-files-cont'])[1]//span//img")

    @FindBy (xpath = "(//*[@class='feed-com-files-cont'])[1]//span//img")
    public List<WebElement> webElementListImages;



    @FindBy (xpath = "//td[@class='files-name']//span[@class='f-wrap']")
    public List <WebElement> webElementListImageNames;

}
