Feature: User Login


  @C38
  Scenario: Successful login with valid ID and valid password
    When the user enters a valid ID "thakurravikumar400@gmail.com"
    And the user enters a valid password "123456789"
    And the user clicks the Login button
    Then the user should be redirected to the dashboard
    And the user sees a success message
  @C39
  Scenario: Login attempt with invalid ID and invalid password
    When the user enters an invalid ID "estst@hahah.com"
    And the user enters a invalid password "141651515"
    And the user clicks the Login button
    Then an error message should be displayed saying "Invalid Gmail or Password"

  @C41
    Scenario: Login attempt with invalid ID and valid password
    When the user enters an invalid ID "estst@hahah.com"
    And the user enters a valid password "123456789"
    And the user clicks the Login button
    Then an error message should be displayed saying "Invalid Gmail or Password"
  @C42
  Scenario: Login attempt with valid ID and invalid password
    When the user enters a valid ID "thakurravikumar400@gmail.com"
    And the user enters a invalid password "141651515"
    And the user clicks the Login button
    Then an error message should be displayed saying "Invalid Gmail or Password"
  @C43
  Scenario: Login attempt with empty ID and empty password
    When the user enter empty ID " "
    And the user enter empty password " "
    And the user clicks the Login button
    Then an error message should be displayed saying "Invalid Gmail or Password"
  @C44
  Scenario: Login attempt with empty ID and valid password
    When the user enter empty ID " "
    And the user enters a valid password "123456789"
    And the user clicks the Login button
    Then an error message should be displayed saying "Invalid Gmail or Password"
