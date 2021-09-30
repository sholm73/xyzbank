package accountTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class AccountTest extends BaseTest {
    private final String CUSTOMER_NAME = TestData.CUSTOMER_FIRST_NAME + " " +  TestData.CUSTOMER_SECOND_NAME;
    @Test
    public void addAmountToDeposit(){
        loginPage.openLoginPage()
                .clickCustomerLoginButton()
                .checkLabelYourNameVisible()
                .selectCustomerNameInDropDown(CUSTOMER_NAME)
                .clickOnLoginButton()
                .checkIsWelcomeTitlePresent(CUSTOMER_NAME)
                .selectingAnAccountNumberFromDropDown(TestData.ACCOUNT_NUM)
                .addingFundsToTheDepositAndCheckingResult("1000")

                ;
    }

}
