package com.ERP.CRM.StepDefinations;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.ERP.CRM.PageObjectModels.NavigationPOM;
import org.junit.Assert;
import com.ERP.CRM.LoginHelper.LoginHelper;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class NavigationStepDefination {

    NavigationPOM navigationPOM = new NavigationPOM();
    LoginHelper loginHelper = new LoginHelper();
    @Given("the user is logged in and on the Dashboard page {string} {string}")
    public void theUserIsLoggedInAndOnTheDashboardPage(String Id, String Pass) {
        loginHelper.FullLoginProcess(Id,Pass);
    }


    @When("the user clicks the {string} button")
    public void theUserClicksTheButton(String arg0) {
        assertEquals(arg0,navigationPOM.LogoutText());
        navigationPOM.LogoutDisplayed();
    }

    @Then("the user should be logged out successfully")
    public void theUserShouldBeLoggedOutSuccessfully() {
        assertEquals(navigationPOM.LoginForm(),"Login");
    }

    @And("the user should be redirected to the Login page")
    public void theUserShouldBeRedirectedToTheLoginPage() {
        assertEquals(navigationPOM.LoginForm(),"Login");
    }

    @When("the user views the navigation bar")
    public void theUserViewsTheNavigationBar() {
        navigationPOM.NavigationBarVisible();
    }

    @Then("all menu items should be visible:")
    public void allMenuItemsShouldBeVisible(DataTable table) {
        List<String> expectedOutput = table.asList();
        List<String> actualoutcome = navigationPOM.NavigationList();
        assertEquals(actualoutcome,expectedOutput);
    }
}
