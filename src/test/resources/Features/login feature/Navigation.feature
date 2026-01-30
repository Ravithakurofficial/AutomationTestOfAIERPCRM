Feature: Navigation Work

  Background: User logs into the application
    Given the user logs in with "thakurravikumar400@gmail.com" "123456789"

  @C46
  Scenario: Verify the Logout button is visible and functional
    When the user clicks the "Logout" button
    Then the user should be logged out successfully
    And the user should be redirected to the Login page

  @C47
  Scenario: Verify all navigation menu items are displayed
    When the user views the navigation bar
    Then all menu items should be visible:
      | Dashboard      |
      | Stocks         |
      | Leads          |
      | Templates      |
      | Customers      |
      | HR             |
      | Transport      |
      | Update Price   |
      | Create Invoice |
