package com.ERP.CRM.PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.ERP.CRM.Utils.DriverFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class NavigationPOM {

    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    private final By DashboardWelcome = By.xpath("/html/body/h2");
    private final By LogoutButton = By.xpath("/html/body/a");




    public void LogoutDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(LogoutButton)).click();
    }
    public String LogoutText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(LogoutButton)).getText();
    }
    public String DashBoardWelcomemsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(DashboardWelcome)).getText();
    }
}
