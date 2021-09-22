package loginTest;

import baseTest.BaseTest;
import org.junit.Test;

public class LoginTest extends BaseTest{
   private final String CUSTOMER_NAME = "Hermoine Granger";

    @Test
    public void signInWithCustomerUser(){
        loginPage.openLoginPage()
                .clickCustomerLoginButton()
                .checkIsLabelCustomerNameVisible()
                .selectCustomerNameInDropDown(CUSTOMER_NAME)
                .clickOnLoginButton()
                .checkIsWelcomeTitlePresent(CUSTOMER_NAME);
    }

    @Test
    public void signInWithBankManagerLogin(){
        loginPage.openLoginPage()
                .clickBankManagerLoginButton();

    }

}
