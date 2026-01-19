package com.ERP.CRM.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.ERP.CRM.Utils.DriverFactory;


public class loginHook {
    @Before
    public void Setup(){
        DriverFactory.getDriver().get("http://localhost:8080/");

    }

    @After
    public static void TearDown(){
        DriverFactory.quitDriver();

    }
}
