package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagerPage extends ParentPage {
    @FindBy(xpath = ".//button[@ng-click='showCust()']")
    private WebElement customerButton;
    @FindBy(xpath = ".//input[@placeholder='Search Customer']")
    private WebElement inputCustomerSearch;
    @FindBy(xpath = ".//tr[@class='ng-scope']/td[1]")
    private WebElement firstName;
    @FindBy(xpath = ".//tr[@class='ng-scope']/td[2]")
    private WebElement secondName;
    @FindBy(xpath = ".//tr[@class='ng-scope']/td[3]")
    private WebElement postCode;
    @FindBy(xpath = ".//tr[@class='ng-scope']/td[4]")
    private WebElement customerDeleteButton;
    @FindBy(xpath = ".//button[@ng-click='addCust()']")
    private WebElement addCustomerMenuButton;
    @FindBy(xpath = ".//input[@placeholder='First Name']")
    private WebElement customerFirstName;
    @FindBy(xpath = ".//input[@placeholder='Last Name']")
    private WebElement customerLastName;
    @FindBy(xpath = ".//input[@placeholder='Post Code']")
    private WebElement customerPostCode;
    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement buttonAddNewCustomer;

    public ManagerPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step
    public ManagerPage clickCustomersMenuButton() {
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

    @Step
    public ManagerPage checkingPresenceCustomerInGreed(String customerFirstName, String customerSecondName) {
        try {
            Assert.assertEquals("The Customer is not present in the client list", firstName.getText(), customerFirstName);
            Assert.assertEquals("The Customer is not present in the client list", secondName.getText(), customerSecondName);
            logger.info(String.format("Customer '%s %s' found in the customer list", customerFirstName, customerSecondName));
        } catch (Exception e) {
            writeErrorAndStopTest(e);
        }
        return this;
    }

    public ManagerPage checkVisibleAddCustomerButton() {
        try {
            Assert.assertTrue("A client button is not present", isElementPresent(addCustomerMenuButton));
            logger.info("Is present a client button");
        } catch (Exception e) {
            writeErrorAndStopTest(e);
        }

        return this;
    }

    public ManagerPage clickOnAddCustomerMenuButton() {
        clickOnElement(addCustomerMenuButton);
        return this;
    }

    public ManagerPage enterTextIntoTextForCreateNewCustomer(String newCustomerFirstName,
                                                             String newCustomerSecondName,
                                                             String newCustomerPostCode) {
        enterTextToElement(customerFirstName, newCustomerFirstName);
        enterTextToElement(customerLastName, newCustomerSecondName);
        enterTextToElement(customerPostCode, newCustomerPostCode);
        return this;
    }

    public ManagerPage clickOnButtonAddCustomerForAddedData() {
        clickOnElement(buttonAddNewCustomer);
        if (webDriver.switchTo().alert() != null) {
            Alert alert = webDriver.switchTo().alert();
            alert.dismiss();
        }
        return this;
    }

    public ManagerPage checkNewCustomerInCustomersList(String newCustomerFirstName,
                                                       String newCustomerSecondName,
                                                       String newCustomerPostCode) {
        try {
            Assert.assertEquals("The Customer is not present in the client list", firstName.getText(), newCustomerFirstName);
            Assert.assertEquals("The Customer is not present in the client list", secondName.getText(), newCustomerSecondName);
            Assert.assertEquals("The Customer is not present in the client list", postCode.getText(), newCustomerPostCode);
            logger.info(String.format("Customer '%s %s' with post code %s found in the customer list",
                    secondName.getText(), firstName.getText(), postCode.getText()));
        } catch (Exception e) {
            writeErrorAndStopTest(e);
        }
        return this;
    }

    public ManagerPage deleteNewCustomer() {
        try {
            clickOnElement(customerDeleteButton);
            logger.info(String.format("Customer '%s %s' successfully deleted",
                    secondName.getText(), firstName.getText()));
        } catch (Exception e){
            writeErrorAndStopTest(e);
        }
        return this;
    }
}
