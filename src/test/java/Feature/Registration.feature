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
    And User Selected NO for Subscribe Radio button
    And User cliked on disclimer
    And User Clicked on Continue
    Then User should register successfully and Navigate to Account success page
    And NO is saved on Subscribe or unsubscribe to newsletter page

  Scenario: TC_RF_008_Verify_Registering_Account_by_entering_different_passwords_into_Password_and_Password_Confirm_fields
    When User Enter Valid details in FirstName
    And User Enter Valid LastName
    And User Enter Valid Email
    And User Enter Valid telephone
    And User Enter Invalid Password
    And User Enter Invalid confirm password
    And User cliked on disclimer
    And User Clicked on Continue
    Then Registration should not be done and should show valid error messsage for password mismatch

  Scenario Outline: TC_RF_009_Verify_Registering_Account_by_providing_the_existing_account_details()
    When User Enter Valid details in FirstName <FirstName>
    And User Enter Valid LastName<LastName>
    And User Enter Valid Email<Email>
    And User Enter Valid telephone<Telephone>
    And User Enter Valid Password<Password>
    And User Enter valid confirm password<ConfPass>
    And User cliked on disclimer
    And User Clicked on Continue
    Then Registration should not be done and should show error messagae indication Email already exists

    Examples: 
      | FirstName | LastName | Email            | Telephone | Password | ConfPass |
      | Somesh    | Landge   | Somesh@gmail.com |    111111 | Test@123 | Test@123 |

  @test1
  Scenario Outline: TC_RF_010_Verify_registraton_With_invalidEmail()
    When User Enter Valid details in FirstName
    And User Enter Valid LastName
    And User Enter Valid Invalid Email<InvalidEmail>
    And User Enter Valid telephone
    And User Enter Invalid Password
    And User Enter Invalid confirm password
    And User cliked on disclimer
    And User Clicked on Continue
    Then Registration should not be done and should show error messagae indication Invalid Email <error_message >

    Examples: 
      | invalidEmail    | error_message                                                             |
      | amotoori        | Please include an '@' in the email address. 'amotoori' is missing an '@'. |
      | amotoori@       | Please enter a part following '@'. 'amotoori@' is incomplete.             |
      | amotoori@gmail. | '.' is used at a wrong position in 'gmail.'.                              |
      | amotoori@gmail  | E-Mail Address does not appear to be valid!                               |
