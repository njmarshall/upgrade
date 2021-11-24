package upgrade.test.framework.ui;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import upgrade.test.framework.testdata.TestDataRetriever;

public class BaseUITest {
    protected static TestDataRetriever testData = null;
    protected static WebDriver driver;

    @BeforeAll
    public static void beforeSuite() {
        testData = new TestDataRetriever();

        System.setProperty("headless", "false"); // You can set this property elsewhere
        String headless = System.getProperty("headless");

        ChromeDriverManager.chromedriver();
        if (!"true".equals(headless)) {
            driver = new ChromeDriver();
        } else {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        }
    }

    @AfterAll
    public static void afterSuite() {
        if(null != driver) {
            driver.quit();
        }
    }
}
