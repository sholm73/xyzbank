package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class HomePage extends ParentPage{

    @FindBy(xpath = ".//button[text() = 'Bank Manager Login']")
    private WebElement buttonBankManagerLogin;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
}
