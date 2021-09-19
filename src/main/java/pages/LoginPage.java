package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(xpath = ".//button[text() = 'Customer Login']")
    private WebElement buttonCustomerLogin;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage loginWithCustomerCredential() {
        openLoginPage();
        clickOnElement(buttonCustomerLogin, "Customer Login");
        return this;
    }

    private LoginPage openLoginPage() {
        try {
            webDriver.get(baseURL + "login");
            //logger.info("Login page was opened");
        } catch (Exception e) {
            //logger.error("Can not work with LoginPage " + e);
            Assert.fail("Can not work with LoginPage");
        }
        return this;
    }


}
