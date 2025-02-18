Feature: Registration Functionality

  Background: 
    Given User is navigated to Registration page

  Scenario: TC_RF_003_verify_Registering_Account_Using_MandatoryFields
    When User Enter Valid details in FirstName
    And User Enter Valid LastName
    And User Enter Valid Email
    And User Enter Valid telephone
    And User Enter Valid Password
    And User Enter valid confirm password
    And User cliked on disclimer
    And User Clicked on Continue
    Then User should register successfully and Navigate to Account success page

  Scenario: TC_RF_003_verify_Registering_An_Account_providing_all_fields
    When User Enter Valid details in FirstName
    And User Enter Valid LastName
    And User Enter Valid Email
    And User Enter Valid telephone
    And User Enter Valid Password
    And User Enter valid confirm password
    And User Selected YES for Subscribe Radio button
    And User cliked on disclimer
    And User Clicked on Continue
    Then User should register successfully and Navigate to Account success page

  Scenario: TC_RF_004_Verify_proper_notification_messages_with_no_data_in_the_madetory_field
    When User Did not fill any data
    And User Clicked on Continue
    Then User should get proper validation error on each mandetory field

  Scenario: TC_RF_005_Verify_Registering_an_Accountwith_Newsletter_field_As_YES()
    When User Enter Valid details in FirstName
    And User Enter Valid LastName
    And User Enter Valid Email
    And User Enter Valid telephone
    And User Enter Valid Password
    And User Enter valid confirm password
    And User Selected YES for Subscribe Radio button
    And User cliked on disclimer
    And User Clicked on Continue
    Then User should register successfully and Navigate to Account success page
    And YES is saved on Subscribe or unsubscribe to newsletter page

  Scenario: TC_RF_006_Verify_Registering_an_Accountwith_Newsletter_field_As_NO()
    When User Enter Valid details in FirstName
    And User Enter Valid LastName
    And User Enter Valid Email
    And User Enter Valid telephone
    And User Enter Valid Password
    And User Enter valid confirm password
    And User Selected YES for Subscribe Radio button
    And User cliked on disclimer
    And User Clicked on Continue
    Then User should register successfully and Navigate to Account success page
    And NO is saved on Subscribe or unsubscribe to newsletter page
