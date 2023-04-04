@CRMLY10-212
Feature: Uploading files and pictures
  User story:  As a user, I should be able to upload files When pictures as messages
Background:
    Given User is on the upload page

  @first @done
  Scenario: Uploading multiple supported files at the same time
    #Given User is on the upload page
    When User selects max 3 files to upload
    And User clicks the upload button
    Then User sees all the files on stream page (list)
      | SampleGIFImage_135kbmb.gif |
      | SampleJPGImage_500kbmb.jpg |
      | SamplePNGImage_500kbmb.png |
    Then User clicks on "more" button and clicks on "delete" button


  @second @done
  Scenario: Uploading files in different formats
   # Given User is on the upload page
    When User selects 3 files in different formats to upload
    And User clicks the upload button
    Then User should see the files displayed on stream page
    Then User clicks on "more" button and clicks on "delete" button


  @third  @done
  Scenario: Uploading pictures
   # Given User is on the upload page
    When User selects 3 pictures to upload
    And User clicks the upload button
    Then User should see the uploaded pictures (list)
      |SampleJPGImage_500kbmb.jpg|
      |SamplePNGImage_500kbmb.png|
      |SampleGIFImage_135kbmb.gif|
    Then User clicks on "more" button and clicks on "delete" button


  @fourth @done
  Scenario: Inserting files and images into the text
   # Given User is on the upload page
    When User inserts uploaded files and pictures into the text
    Then User clicks on "more" button and clicks on "delete" button


  #@fifth  @wip
  #Scenario: Removing files and images at any time before sending
   # Given User has uploaded files and pictures
    #When User clicks the remove button for a file or picture
    #Then User should see the file or picture removed
    #Then User clicks on "more" button and clicks on "delete" button


 # @sixth
  #Scenario: Renaming the file before sending it
   # Given User is on the upload page
  #  When User renames a file before uploading it
   # And User clicks the upload button
    #Then User should see a success message
    #Then User clicks on "more" button and clicks on "delete" button




#@willDeleteLater
 # Scenario: Uploading more than 3 files at the same time
  #  Given User is on the upload page
   # When User selects more than 3 files to upload
    #And User clicks the upload button
    #Then User should see an error message
#@extra1
  #Scenario: Uploading files in unsupported formats
   # Given User is on the upload page
    #When User selects files in unsupported formats to upload
    #And User clicks the upload button
    #Then User should see an error message
#@extra2
  #Scenario: Uploading non-picture files as pictures
   # Given User is on the upload page
    #When User selects non-picture files as pictures to upload
    #And User clicks the upload button
