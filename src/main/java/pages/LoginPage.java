package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(xpath = ".//button[text()='Customer Login']")
    private WebElement buttonCustomerLogin;

    @FindBy(xpath = ".//button[text()='Bank Manager Login']")
    private WebElement buttonBankManagerLogin;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step
    public LoginPage openLoginPage() {
        try {
            webDriver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Can not work with Login Page: " + e);
            Assert.fail("Can not work with Login Page: " + e);
        }
        return this;
    }

    @Step
    public CustomerPage clickCustomerLoginButton() {
        try {
            buttonCustomerLogin.click();
            logger.info("The Customer selection page is opened!");
        } catch (Exception e) {
            logger.error("The customer selection page is not opened!");
            Assert.fail("The customer selection page is not opened!");
        }
        return new CustomerPage(webDriver);
    }

    public ManagerPage clickBankManagerLoginButton() {
        try {
            buttonBankManagerLogin.click();
            logger.info("The Customer selection page is opened!");
        } catch (Exception e) {
            logger.error("The customer selection page is not opened!");
            Assert.fail("The customer selection page is not opened!");
        }
        return new ManagerPage(webDriver);
    }
}
