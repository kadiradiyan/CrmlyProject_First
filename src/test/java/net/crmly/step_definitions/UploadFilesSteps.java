package net.crmly.step_definitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.crmly.pages.AssertionPage;
import net.crmly.pages.LogInPage;
import net.crmly.pages.StreamPage;
import net.crmly.utilities.BrowserUtils;
import net.crmly.utilities.Driver;
import org.openqa.selenium.*;
;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class UploadFilesSteps {

    LogInPage logInPage = new LogInPage();
    StreamPage streamPage = new StreamPage();
    AssertionPage assertionPage = new AssertionPage();

    WebDriver driver;
    WebDriverWait wait;
    String uploadPageUrl = "https://qa.crmly.net";

    String projectPath = System.getProperty("user.dir");

    String textEditorPageUrl = "https://qa.crmly.net/stream/?login=yes";
    String file1 = projectPath+"\\"+"src\\test\\resources\\features\\SampleGIFImage_135kbmb.gif";
    String file2 = projectPath+"\\"+"src\\test\\resources\\features\\SampleJPGImage_500kbmb.jpg";
    String file3 = projectPath+"\\"+"src\\test\\resources\\features\\SamplePNGImage_500kbmb.png";
    String file4 = projectPath+"\\"+"src\\test\\resources\\features\\SampleAudio_0.7mb.mp3";
    String file5 = projectPath+"\\"+"src\\test\\resources\\features\\SamplePDFFile_5mb.pdf";
    String file6 = projectPath+"\\"+"src\\test\\resources\\features\\SampleDOCFile_100kb.doc";
    String unsupportedFile = projectPath+"\\"+"src\\test\\resources\\features\\SampleXLSFile_38kb.xls";
    String picture1 = projectPath+"\\"+"src\\test\\resources\\features/SampleJPGImage_500kbmb.jpg";
    String picture2 = projectPath+"\\"+"src\\test\\resources\\features\\SamplePNGImage_500kbmb.png";
    String picture3 = projectPath+"\\"+"src\\test\\resources\\features\\SampleGIFImage_135kbmb.gif";
    String nonPictureFile = "projectPath"+"\\"+"src\\test\\resources\\features/SampleDOCFile_100kb.doc";


    @Given("User is on the upload page")
    public void user_is_on_upload_page() {
        logInPage.navigateLogInPage();
        logInPage.loginAsHr();


    }

    @When("User selects max {int} files to upload")
    public void user_selects_max_files_to_upload(Integer maxFiles) {

        streamPage.messageTab.click();
        streamPage.uploadFilesIcon.click();

        WebElement fileInput = streamPage.uploadFileButton;

        List<String> files = List.of(file1, file2, file3);
        for (int i = 0; i < maxFiles && i < files.size(); i++) {
            fileInput.sendKeys(files.get(i));
        }


    }

    @When("User clicks the upload button")
    public void user_clicks_the_upload_button() {
        BrowserUtils.sleep(20);
        streamPage.sendButton.click();
    }


    @Then("User sees all the files on stream page \\(list)")
    public void user_Sees_All_TheFiles_On_StreamPage_List(List<String> fileNames) {
        BrowserUtils.sleep(2);
        // String attributeNameOfAlt="";
        for (WebElement element : assertionPage.webElementList) {
            //attributeNameOfAlt=element.getAttribute("alt");
            // System.out.println(attributeNameOfAlt);
            Assert.assertTrue(element.isDisplayed());
        }


    }

    @Then("User clicks on {string} button and clicks on {string} button")
    public void user_Clicks_On_Button_And_Clicks_On_Button(String moreButton, String delete) {
        assertionPage.moreButton.click();
        assertionPage.deleteButton.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

    }

    //-------------------------------------------------------------------------------------------------------////
    //-------------------------------------------------------------------------------------------------------////


    @When("User selects {int} files in different formats to upload")
    public void user_selects_files_in_different_formats_to_upload(Integer selectedFiles) {

        streamPage.messageTab.click();
        streamPage.uploadFilesIcon.click();

        WebElement fileInput = streamPage.uploadFileButton;

        List<String> files = List.of(file4, file5, file6);
        //file4= mp3, file5=pdf, file6=doc
        for (int i = 0; i < selectedFiles && i <= files.size(); i++) {
            fileInput.sendKeys(files.get(i));
        }


    }

    @Then("User should see the files displayed on stream page")
    public void user_should_the_files_displayed_on_streampage() {
        BrowserUtils.sleep(2);

        for (WebElement element : assertionPage.webElementList) {
            Assert.assertTrue(element.isDisplayed());

        }
    }

//-------------------------------------------------------------------------------------------------------////
    //-------------------------------------------------------------------------------------------------------////


    @When("User selects {int} pictures to upload")
    public void user_selects_pictures_to_upload(Integer pictures) {


        streamPage.messageTab.click();
        streamPage.uploadFilesIcon.click();

        WebElement fileInput = streamPage.uploadFileButton;

        List<String> picturesList = List.of(picture1, picture2, picture3);
        for (int i = 0; i < pictures && i < picturesList.size(); i++) {
            fileInput.sendKeys(picturesList.get(i));
        }

    }

    @Then("User should see the uploaded pictures \\(list)")
    public void user_should_see_the_uploaded_pictures(List<String> imageNames) {
        BrowserUtils.sleep(2);
        List<String> imageTexts = new ArrayList<>();
        for (WebElement eachImage : assertionPage.webElementListImages) {
            imageTexts.add(eachImage.getAttribute("alt"));
            Assert.assertTrue(eachImage.isDisplayed());

        }
    }


    //-------------------------------------------------------------------------------------------------------////
    //-------------------------------------------------------------------------------------------------------////
    @When("User inserts uploaded files and pictures into the text")
    public void user_inserts_uploaded_files_and_pictures_into_text() {



        streamPage.messageTab.click();
        WebElement fileInput = streamPage.uploadFileButton;

        List<String> fileList = List.of(file6, file2, picture2);

        for (int i = 0; i  < fileList.size()-1; i++) {
            BrowserUtils.waitForVisibility(streamPage.uploadFilesIcon, 5);
            streamPage.uploadFilesIcon.click();
            fileInput.sendKeys(fileList.get(i));
            BrowserUtils.waitFor(9);
            streamPage.insertInText.click();
        }
        streamPage.sendButton.click();
    }





    //-------------------------------------------------------------------------------------------------------////
    //-------------------------------------------------------------------------------------------------------////
    @Given("User has uploaded files and pictures")
    public void user_has_uploaded_files_and_pictures() {
        // Upload some files and pictures
    }


    @When("User clicks the remove button for a file or picture")
    public void user_clicks_the_remove_button_for_a_file_or_picture() {
        // Click on the remove button for a file or picture
    }

    @When("User removes a file before sending")
    public void user_removes_file_before_sending() {
        driver.get(textEditorPageUrl);
        WebElement fileLink1 = driver.findElement(By.xpath("//a[@href='" + file1 + "']"));
        WebElement removeFileButton = fileLink1.findElement(By.xpath("../button[@class='remove-file-button']"));
        removeFileButton.click();
    }

    @Then("User should see the file or picture removed")
    public void user_should_see_the_file_or_picture_removed() {
        // Verify that the file or picture is removed
    }







    //-------------------------------------------------------------------------------------------------------////
    //-------------------------------------------------------------------------------------------------------////



    @When("User renames a file before sending")
    public void user_renames_file_before_sending() {
        driver.get(textEditorPageUrl);
        WebElement fileLink1 = driver.findElement(By.xpath("//a[@href='" + file1 + "']"));
        WebElement renameFileButton = fileLink1.findElement(By.xpath("../button[@class='rename-file-button']"));
        renameFileButton.click();
        WebElement renameInput = driver.findElement(By.xpath("//input[@class='rename-file-input']"));
        renameInput.clear();
        renameInput.sendKeys("newname.pdf");
    }





    @When("User renames a file before uploading it")
    public void user_renames_a_file_before_uploading_it() {
        // Rename a file before uploading it
    }

    @Then("User should see a success message")
    public void user_should_see_a_success_message() {
        // Verify that the success message is displayed
    }}

/*    @When("User selects more than {int} files to upload")
    public void user_selects_more_than_files_to_upload(Integer int1) {
        // Select more files than the allowed limit
    }

    @When("User selects files in unsupported formats to upload")
    public void user_selects_files_in_unsupported_formats_to_upload() {
        // Select files in unsupported formats
    }


    @When("User selects non-picture files as pictures to upload")
    public void userSelectsNonPictureFilesAsPicturesToUpload() {}}

        @Then("Unsupported files are not uploaded")
    public void unsupported_files_are_not_uploaded() {
        WebElement uploadErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("upload-error-message")));
        Assert.assertEquals("Unsupported file format.", uploadErrorMessage.getText());
    }


    @Then("Files and pictures are uploaded successfully")
public void files_and_pictures_are_uploaded_successfully() {
        WebElement uploadSuccessMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("upload-success-message")));
        Assert.assertEquals("Files and pictures uploaded successfully.", uploadSuccessMessage.getText());
        }}*/








