package com.ERP.CRM.PageObjectModels;

import com.ERP.CRM.Utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPom {
    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    private final By idInput = By.xpath("/html/body/div/form/input[1]");
    private final By password = By.xpath("/html/body/div/form/input[2]");
    private final By loginButton = By.xpath("/html/body/div/form/button");
    private final By ErrorMsg = By.xpath("/html/body/div/p");
    private final By DashboardWelcome = By.xpath("/html/body/h2");
    private final By LogoutButton = By.xpath("/html/body/a");

    public void enterId(String id){
        wait.until(ExpectedConditions.visibilityOfElementLocated(idInput)).sendKeys(id);
    }
    public void enterPassword(String pass){
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
    }
    public void ClickLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public String ErrorMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMsg)).getText();
    }

    public void LogoutDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(LogoutButton)).isDisplayed();
    }
    public void DashBoardWelcomemsg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(DashboardWelcome)).getText();
    }


}
