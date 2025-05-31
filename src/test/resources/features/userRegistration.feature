Feature: User Registration

    # Scenario Outline – Required for VG
  Scenario Outline: Invalid email scenarios during user registration
    Given I am using "<browser>" browser
    And I am on the registration page
    When I enter "<dob>" as the date of birth
    And I enter "<name>" as the first name
    And I enter "<lastName>" as the last name
    And I enter "<email>" as the email
    And I confirm the email with "<confirmEmail>"
    And I enter "<password>" as the password
    And I confirm the password with "<confirmPassword>"
    And I select my basketball role
    And I "<acceptTerms>" the terms and conditions
    And I accept the age over Eighteen
    And I accept the Code of Ethics
    And I submit the form
    Then I should see an error message for "<errorField>" saying "<errorMessage>"


    Examples:
      | browser | dob        | name | lastName | email                 | confirmEmail          | password    | confirmPassword | acceptTerms   | errorField          | errorMessage                                                              |
      | chrome  | 01/01/1990 | Max  | Lund     | max88101@example.com  | max88101@example.com  | Password123 | Password123     | accept        | ConfirmationMessage | THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND                 |
      | chrome  | 01/01/1990 | Tom  | Hanks    | tom12011@example.com  | tom12011@example.com  | Password123 | Password123     | do not accept | TermsAccept         | You must confirm that you have read and accepted our Terms and Conditions |
      | firefox | 01/01/1990 | Lisa |          | lisa12011@example.com | lisa12011@example.com | Password123 | Password123     | accept        | member_lastname     | Last Name is required                                                     |


