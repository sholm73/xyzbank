package pages;

import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class ParentPage {
    Logger logger = Logger.getLogger(getClass());
    static WebDriver webDriver;
    WebDriverWait webDriverWait10, webDriverWait15;

    public static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    protected final String baseURL = configProperties.base_url();

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait10 = new WebDriverWait(webDriver, configProperties.TIME_FOR_DEFAULT_WAIT());
        webDriverWait15 = new WebDriverWait(webDriver, configProperties.TIME_FOR_EXPLICIT_WAIT_LOW());
    }

    protected void enterTextToElement(WebElement webElement, String text) {
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.clear();
            webElement.sendKeys(text);
            logger.info("'" + text + "' was inputted in element");
        } catch (Exception e) {
            writeErrorAndStopTest(e);
        }
    }

    protected void clickOnElement(WebElement webElement) {
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            writeErrorAndStopTest(e);
        }
    }

    protected void selectValueInDropDown(WebElement dropDown, String value) {
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(dropDown));
            Select select = new Select(dropDown);
            select.selectByValue(value);
            logger.info("'" + value + "' was select in DropDown");
        } catch (Exception e) {
            writeErrorAndStopTest(e);
        }
    }

    protected void selectTextInDropDown(WebElement dropDown, String text) {
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(dropDown));
            Select select = new Select(dropDown);
            select.selectByVisibleText(text);
            logger.info("'" + text + "' was selected in DropDown");
        } catch (Exception e) {
            writeErrorAndStopTest(e);
        }
    }

    public void writeErrorAndStopTest(Exception e) {
        logger.error("Can`t work with element: " + e);
        Assert.fail("Can`t work with element: " + e);
    }

    protected boolean isElementPresent(WebElement webElement) {
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
            boolean state = webElement.isDisplayed();
            if (state) {
                logger.info("Element is present");
            } else {
                logger.info("Element is not present");
            }
            return state;
        } catch (Exception e) {
            logger.info("Element is not present");
            return false;
        }
    }

}
