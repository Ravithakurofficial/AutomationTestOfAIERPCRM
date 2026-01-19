package com.ERP.CRM.StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.ERP.CRM.PageObjectModels.LoginPom;


import static org.junit.Assert.assertEquals;

public class LoginStepDefination{

    // Make WebDriver instance accessible to all steps
    LoginPom login = new LoginPom();
    @When("the user enters a valid ID {string}")
    public void the_user_enters_a_valid_id(String ID) {
        login.enterId(ID);
    }
    @And("the user enters a valid password {string}")
    public void the_user_enters_a_valid_password(String passw) {
       login.enterPassword(passw);
    }
    @And("the user enters a invalid password {string}")
    public void the_user_enters_a_invalid_password(String passw) {
        login.enterPassword(passw);
    }
    @And("the user clicks the Login button")
    public void the_user_clicks_the_login_button() {
        login.ClickLoginButton();
    }
    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        login.LogoutDisplayed();
    }

    @And("the user sees a success message")
    public void the_user_sees_a_success_message() {
        login.DashBoardWelcomemsg();
    }

    @When("the user enters an invalid ID {string}")
    public void the_user_enters_an_invalid_id(String ID) {
       login.enterId(ID);
    }

    @Then("an error message should be displayed saying {string}")
    public void an_error_message_should_be_displayed_saying(String expectedMsg) {
        assertEquals(expectedMsg,login.ErrorMessage());
    }

    @When("the user enter empty ID {string}")
    public void theUserEnterEmptyID(String nonId) {
       login.enterId(nonId);
    }

    @And("the user enter empty password {string}")
    public void theUserEnterEmptyPassword(String nonpass) {
        login.enterPassword(nonpass);
    }
}
