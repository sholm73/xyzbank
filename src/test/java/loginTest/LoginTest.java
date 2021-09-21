package loginTest;

import baseTest.BaseTest;
import org.junit.Test;

public class LoginTest extends BaseTest{

    @Test
    public void signInWithCustomerUser(){
        loginPage.openLoginPage()
                .clickCustomerLoginButton()
                .checkIsLabelCustomerNameVisible()
                .selectUserNameInDropDown()
                .clickOnLoginButton()
        //loginPage.clickCustomerLoginButton();
        //customerPage.chooseCustomerName()
         ;
    }

    @Test
    public void signInWithBankManagerLogin(){
        loginPage.openLoginPage();

    }

}
