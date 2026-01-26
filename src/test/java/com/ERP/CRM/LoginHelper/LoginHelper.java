package com.ERP.CRM.LoginHelper;
import com.ERP.CRM.PageObjectModels.LoginPom;

public class LoginHelper {

    private final LoginPom loginPom;

    public LoginHelper(){
        this.loginPom = new LoginPom();
    }
    public void FullLoginProcess(String username, String passw){
        loginPom.enterId(username);
        loginPom.enterPassword(passw);
        loginPom.ClickLoginButton();
    }


}
