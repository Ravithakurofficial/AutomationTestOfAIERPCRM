package com.ERP.CRM.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.ERP.CRM.Utils.DriverFactory;
import org.openqa.selenium.WebDriver;

public class loginHook {

    public static WebDriver driver;

    @Before
    public void Setup(){
        driver = DriverFactory.getDriver();
        driver.get("http://localhost:8080/");
    }

    @After
    public void TearDown(){
        DriverFactory.quitDriver();
    }
}
