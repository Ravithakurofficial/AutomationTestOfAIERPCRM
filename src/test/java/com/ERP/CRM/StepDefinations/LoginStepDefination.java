package com.ERP.CRM.StepDefinations;

import com.ERP.CRM.pathFile.Pathfile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class LoginStepDefination extends Pathfile {

    // Make WebDriver instance accessible to all steps
    private static WebDriver driver;

    // Open browser and navigate to URL
    public void openBrowser() {
        // Make sure chromedriver is set in system PATH or set below
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Localurl);
    }

    @When("the user enters a valid ID")
    public void the_user_enters_a_valid_id() {
        openBrowser();
        WebElement idField = driver.findElement(By.xpath(idInput));
        idField.sendKeys("thakurravikumar400@gmail.com"); // Replace with test data
    }

    @And("the user enters a valid password")
    public void the_user_enters_a_valid_password() {
        WebElement passwordField = driver.findElement(By.xpath(password));
        passwordField.sendKeys("123456789"); // Replace with test data
    }

    @And("the user clicks the Login button")
    public void the_user_clicks_the_login_button() {
        WebElement loginBtn = driver.findElement(By.xpath(loginButton));
        loginBtn.click();
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        // Check After Login Logout option is Present
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
        WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LogoutButton)));
        if(logoutButton.isDisplayed()){
            System.out.println("now on dashboard");
        }
        else{
            throw new AssertionError("Logout button is NOT visible!");
        }

        driver.quit();


    }

    @And("the user sees a success message")
    public void the_user_sees_a_success_message() {
        WebElement successMsg = driver.findElement(By.xpath(DashboardWelcome)); // Replace with actual locator
        assertEquals("Welcome, thakurravikumar400@gmail.com!", successMsg.getText());
    }

    @When("the user enters an invalid ID")
    public void the_user_enters_an_invalid_id() {
        openBrowser();
        WebElement idField = driver.findElement(By.xpath(idInput));
        idField.sendKeys("invalidUser");
        WebElement passwordField = driver.findElement(By.xpath(password));
        passwordField.sendKeys("123456789"); // Replace with test data
        WebElement loginBtn = driver.findElement(By.xpath(loginButton));
        loginBtn.click();
    }

    @Then("an error message should be displayed saying {string}")
    public void an_error_message_should_be_displayed_saying(String expectedMsg) {
        WebElement errorMsg = driver.findElement(By.xpath(ErrorMsg)); // Replace with actual locator
        assertEquals(expectedMsg, errorMsg.getText());
        driver.quit();
    }
}
