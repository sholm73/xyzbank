package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerPage extends ParentPage{
    @FindBy(id = "userSelect")
    private WebElement customerNameDropDown;

    @FindBy(xpath = ".//label[text()='Your Name :']")
    private WebElement customerLabel;

    @FindBy(xpath = ".//button[text()='Login']")
    private WebElement loginButton;

    public CustomerPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step
    public CustomerPage checkLabelYourNameVisible() {
        Assert.assertTrue("Label Your Name is not displayed", isLabelCustomerNamePresent());
        return this;
    }

    private boolean isLabelCustomerNamePresent() {
        return isElementPresent(customerLabel);
    }

    @Step
    public CustomerPage selectCustomerNameInDropDown(String customerName) {
        selectTextInDropDown(customerNameDropDown, customerName);
        return this;
    }

    @Step
    public AccountPage clickOnLoginButton() {
        clickOnElement(loginButton);
        return new AccountPage(webDriver);
    }


}
