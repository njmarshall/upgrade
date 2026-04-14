package upgrade.test.framework.ui;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import upgrade.test.framework.core.ConfigManager;
import upgrade.test.framework.testdata.TestDataRetriever;

/**
 * Base class for all Selenium UI tests.
 * Manages ChromeDriver lifecycle and shared test data.
 * Headless mode is controlled via config (browser.headless=true/false).
 */
public class BaseUITest {

    protected static TestDataRetriever testData;
    protected static WebDriver driver;

    @BeforeAll
    static void beforeSuite() {
        testData = new TestDataRetriever();

        ChromeDriverManager.chromedriver();

        ChromeOptions options = new ChromeOptions();
        if (ConfigManager.getInstance().isBrowserHeadless()) {
            options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
        }
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterAll
    static void afterSuite() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}