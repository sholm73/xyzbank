package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends ParentPage {
    @FindBy(xpath = ".//strong[text()=' Welcome ']/span")
    private WebElement welcomeCustomerTitle;
    @FindBy(id = "accountSelect")
    private WebElement selectAccountNum;
    @FindBy(xpath = ".//*[@ng-hide='noAccount' and @class='center'][1]//strong[2]")
    private WebElement currBalanceValue;
    @FindBy(xpath = ".//button[@ng-click='deposit()']")
    private WebElement buttonMenuDeposit;
    @FindBy(xpath = ".//input[@placeholder='amount']")
    private WebElement inputAmount;
    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement buttonPutDeposit;
    @FindBy(xpath = ".//span[text()='Deposit Successful']")
    private WebElement successfulMsg;

    public AccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step
    public AccountPage checkIsWelcomeTitlePresent(String customerName) {
        try {
            Assert.assertTrue("Welcome title is not present", isElementPresent(welcomeCustomerTitle));
            Assert.assertEquals("Label with Customer name is not present in Account Page", customerName, welcomeCustomerTitle.getText());
            logger.info("Label with Customer name '" + customerName + "' present in Account Page");
        } catch (Exception e) {
            writeErrorAndStopTest(e);
        }
        return this;
    }

    public AccountPage selectingAnAccountNumberFromDropDown(String accountNum) {
        selectTextInDropDown(selectAccountNum, accountNum);
        return this;
    }

    public AccountPage addingFundsToTheDepositAndCheckingResult(String amount) {
        String balance;
        try {
            balance = Integer.toString(Integer.parseInt(currBalanceValue.getText()) +
                    Integer.parseInt(amount));
            clickOnElement(buttonMenuDeposit);
            enterTextToElement(inputAmount, amount);
            clickOnElement(buttonPutDeposit);
            Assert.assertTrue("No message found Successful Deposit", isElementPresent(successfulMsg));
            Assert.assertEquals("Wrong deposit amount", balance, currBalanceValue.getText());
            logger.info("Deposit Successful!");
        } catch (Exception e){
         writeErrorAndStopTest(e);
        }
        return this;
    }
}
