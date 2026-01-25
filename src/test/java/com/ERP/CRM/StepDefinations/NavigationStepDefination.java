package com.ERP.CRM.StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.ERP.CRM.PageObjectModels.NavigationPOM;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class NavigationStepDefination extends LoginStepDefination {

    NavigationPOM navigationPOM = new NavigationPOM();
    @Given("the user is logged in and on the Dashboard page {string} {string}")
    public void theUserIsLoggedInAndOnTheDashboardPage(String Id, String Pass) {
        the_user_enters_a_valid_id(Id);
        the_user_enters_a_valid_password(Pass);
        the_user_clicks_the_login_button();
    }


    @When("the user clicks the {string} button")
    public void theUserClicksTheButton(String arg0) {
        assertEquals(arg0,navigationPOM.LogoutText());
        navigationPOM.LogoutDisplayed();
    }

    @Then("the user should be logged out successfully")
    public void theUserShouldBeLoggedOutSuccessfully() {

        
    }

    @And("the user should be redirected to the Login page")
    public void theUserShouldBeRedirectedToTheLoginPage() {
        
    }

    @And("the Dashboard should not be accessible via the browser back button")
    public void theDashboardShouldNotBeAccessibleViaTheBrowserBackButton() {
    }

    @When("the user views the navigation bar")
    public void theUserViewsTheNavigationBar() {
        
    }

    @Then("all menu items should be visible:")
    public void allMenuItemsShouldBeVisible() {
    }
}
