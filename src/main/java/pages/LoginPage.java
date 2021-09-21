package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(xpath = ".//button[text()='Customer Login']")
    private WebElement buttonCustomerLogin;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

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

    public CustomerPage clickCustomerLoginButton() {
        try {
            buttonCustomerLogin.click();
            logger.info("The Customer selection page is open!");
        } catch (Exception e) {
            logger.error("The customer selection page is not open!");
            Assert.fail("The customer selection page is not open!");
        }
        return new CustomerPage(webDriver);
    }

}
