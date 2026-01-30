package com.ERP.CRM.PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.ERP.CRM.Utils.DriverFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class NavigationPOM {

    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    private final By DashboardWelcome = By.xpath("/html/body/h2");
    private final By LogoutButton = By.xpath("/html/body/a");

    private final By LoginFform = By.xpath("/html/body/div/h2");

    private final By NavigationBar = By.xpath("/html/body/div[1]//a");
    private final By VisibleNavigationBar = By.xpath("/html/body/div[1]");





    public void LogoutDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(LogoutButton)).click();
    }
    public String LogoutText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(LogoutButton)).getText();
    }
    public String DashBoardWelcomemsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(DashboardWelcome)).getText();
    }
    public String LoginForm(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(LoginFform)).getText();
    }

    public List<String> NavigationList(){
        List<WebElement> navElements = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(NavigationBar)
        );
        return navElements.stream().map(WebElement::getText).map(String::trim).collect(Collectors.toList());
    }

    public void NavigationBarVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(VisibleNavigationBar)).isDisplayed();
    }
    public WebDriver currentDriver(){
        return this.driver;
    }
}
