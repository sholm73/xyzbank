package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CustomerPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver webDriver;
    protected LoginPage loginPage;
    protected CustomerPage customerPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage(webDriver);
    }


    @After
    public void tearDown() {
        webDriver.quit();
    }

}
