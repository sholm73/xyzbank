package customerTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;
import pages.LoginPage;

public class CustomerTest extends BaseTest {
    private final String CUSTOMER_NAME = TestData.CUSTOMER_FIRST_NAME + " " +  TestData.CUSTOMER_SECOND_NAME;

    @Test
    public void customerSearchInList(){
        loginPage.openLoginPage()
                .clickBankManagerLoginButton()
                .clickCustomerButton()
                .checkingPresenceTheCustomerSearchInputElement()
                .enterTextIntoSearchCustomerInputElement(CUSTOMER_NAME)
                .checkingPresenceCustomerInGreed()
                ;
    }
}
