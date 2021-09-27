package loginTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class LoginTest extends BaseTest{
   private final String CUSTOMER_NAME = TestData.CUSTOMER_FIRST_NAME + " " +  TestData.CUSTOMER_SECOND_NAME;

    @Test
    public void signInWithCustomerUser(){
        loginPage.openLoginPage()
                .clickCustomerLoginButton()
                .checkLabelYourNameVisible()
                .selectCustomerNameInDropDown(CUSTOMER_NAME)
                .clickOnLoginButton()
                .checkIsWelcomeTitlePresent(CUSTOMER_NAME);
    }

    @Test
    public void signInWithBankManagerLogin(){
        loginPage.openLoginPage()
                .clickBankManagerLoginButton()
                .clickCustomersMenuButton()
                .checkingPresenceTheCustomerSearchInputElement();
    }


}
