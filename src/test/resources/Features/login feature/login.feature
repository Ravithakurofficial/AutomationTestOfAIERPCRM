Feature: User Login
  @C38
  Scenario: Successful login with valid ID and valid password
    When the user enters a valid ID
    And the user enters a valid password
    And the user clicks the Login button
    Then the user should be redirected to the dashboard
    And the user sees a success message
  @C39
  Scenario: Login attempt with invalid ID and valid password
    When the user enters an invalid ID
    And the user enters a valid password
    And the user clicks the Login button
    Then an error message should be displayed saying "Invalid Gmail or Password"