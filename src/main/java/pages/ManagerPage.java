package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagerPage extends ParentPage{
    @FindBy(xpath = ".//button[@ng-click='showCust()']")
    private WebElement customerButton;

    @FindBy(xpath = ".//input[@placeholder='Search Customer']")
    private WebElement inputCustomerSearch;

    public ManagerPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step
    public ManagerPage clickCustomerButton() {
        clickOnElement(customerButton);
        return this;
    }

    @Step
    public ManagerPage checkingPresenceTheCustomerSearchInputElement() {
        try {
            Assert.assertTrue("The Customer Search Input Element is not present", isElementPresent(inputCustomerSearch));
            logger.info("The Customer Search Input Element is present");
        } catch (Exception e) {
            writeErrorAndStopTest(e);
        }
        return this;
    }

    @Step
    public ManagerPage enterTextIntoSearchCustomerInputElement(String customerName) {
        enterTextToElement(inputCustomerSearch, customerName);
        return this;
    }

    public ManagerPage checkingPresenceCustomerInGreed() {
        
        return this;
    }
}
