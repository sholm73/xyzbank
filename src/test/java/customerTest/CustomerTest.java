package customerTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class CustomerTest extends BaseTest {

    @Test
    public void customerSearchInList() {
        loginPage.openLoginPage()
                .clickBankManagerLoginButton()
                .clickCustomersMenuButton()
                .checkingPresenceTheCustomerSearchInputElement()
                .enterTextIntoSearchCustomerInputElement(TestData.CUSTOMER_FIRST_NAME)
                .checkingPresenceCustomerInGreed(TestData.CUSTOMER_FIRST_NAME, TestData.CUSTOMER_SECOND_NAME);
    }

    @Test
    public void addNewCustomer() {
        loginPage.openLoginPage()
                .clickBankManagerLoginButton()
                .clickOnAddCustomerMenuButton()
                .checkVisibleAddCustomerButton()
                .enterTextIntoTextForCreateNewCustomer(TestData.NEW_CUSTOMER_FIRST_NAME,
                        TestData.NEW_CUSTOMER_SECOND_NAME,
                        TestData.NEW_CUSTOMER_POST_CODE)
                .clickOnButtonAddCustomerForAddedData()
                .clickCustomersMenuButton()
                .enterTextIntoSearchCustomerInputElement(TestData.NEW_CUSTOMER_FIRST_NAME)
                .checkNewCustomerInCustomersList(TestData.NEW_CUSTOMER_FIRST_NAME,
                        TestData.NEW_CUSTOMER_SECOND_NAME,
                        TestData.NEW_CUSTOMER_POST_CODE)
                .deleteNewCustomer()
        ;
    }
}
