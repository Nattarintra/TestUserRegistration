Feature: User Registration


# Successful Registration
  Scenario: Successful registration with valid details
    Given I am using "chrome" browser
    #Given I am using "firefox" browser
    Given I am on the registration page
    When I enter a valid date of birth
    And I enter "Max" as the first name
    And I enter "Lund" as the last name
    And I enter "maxlund123@example.com" as the email
    And I confirm the email with "maxlund123@example.com"
    And I enter "Password555" as the password
    And I confirm the password with "Password555"
    And I select my basketball role
    And I accept the Code of Ethics and Terms
    And I submit the form
    Then I should see a confirmation message "THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND"

