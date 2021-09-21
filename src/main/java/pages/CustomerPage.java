package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerPage extends ParentPage{
    @FindBy(xpath = ".//select//option[@value='1']")
    WebElement customerNameDropDown;

    public CustomerPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void chooseCustomerName() {
        try {
            customerNameDropDown.click();
            logger.info("A user named is selected!");
        } catch (Exception e) {
            logger.error("Can't work with the Customer Name select");
        }

    }
}
