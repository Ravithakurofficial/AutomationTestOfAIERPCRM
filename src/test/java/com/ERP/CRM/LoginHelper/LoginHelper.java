package com.ERP.CRM.LoginHelper;

import com.ERP.CRM.PageObjectModels.LoginPom;
import com.SessionUtilities.SessionManager;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginHelper {

    private final LoginPom loginPom;
    private SessionManager manager;

    public LoginHelper(){  // ✅ No-arg constructor
        this.loginPom = new LoginPom();
    }

    public void FullLoginProcess(String username, String passw , WebDriver driver) throws IOException {
        loginPom.enterId(username);
        loginPom.enterPassword(passw);
        loginPom.ClickLoginButton();
        manager = new SessionManager(driver);
        manager.storeSessionFile("SessionFile"+username,username);
    }

    public void LoginWithCookies(String username, String passw , WebDriver driver){
        manager.usePreviousLoggedInSession("SessionFile"+username);
    }
}
