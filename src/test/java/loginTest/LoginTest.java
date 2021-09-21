package loginTest;

import baseTest.BaseTest;
import org.junit.Test;

public class LoginTest extends BaseTest{

    @Test
    public void signInWithCustomerUser(){
        loginPage.openLoginPage();
        loginPage.clickCustomerLoginButton();
        customerPage.chooseCustomerName();
    }

    @Test
    public void signInWithBankManagerLogin(){
        loginPage.openLoginPage();

    }

}
