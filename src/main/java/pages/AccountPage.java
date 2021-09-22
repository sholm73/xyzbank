package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends ParentPage {
    @FindBy(xpath = ".//strong[text()=' Welcome ']/span")
    private WebElement welcomeCustomerTitle;

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

}
