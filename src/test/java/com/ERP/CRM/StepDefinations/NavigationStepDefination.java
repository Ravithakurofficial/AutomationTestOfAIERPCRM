package com.ERP.CRM.StepDefinations;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.ERP.CRM.PageObjectModels.NavigationPOM;
import org.junit.Assert;
import com.ERP.CRM.LoginHelper.LoginHelper;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NavigationStepDefination {

    NavigationPOM navigationPOM = new NavigationPOM();
    LoginHelper loginHelper = new LoginHelper();



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



    @Given("the user logs in with {string} {string}")
    public void theUserLogsInWith(String userId, String pass) {
        loginHelper.LoginWithCookies(userId,pass,navigationPOM.currentDriver());

    }

}
