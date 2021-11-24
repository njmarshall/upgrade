package upgrade.test.framework.ui.utils;

import org.openqa.selenium.WebDriver;

public class SeleniumUtils {
    public static String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }
}
