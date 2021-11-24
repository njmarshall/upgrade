package upgrade.test.loanapp.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import upgrade.test.framework.ui.BasePage;

public class FunderaOfferPage extends BasePage {

    private final By LOGO_IMAGE_LOCATOR = By.xpath("//img[contains(@src, 'media/fundera-logo')]");
    private final By CONTINUE_UPGRADE_LOCATOR =
            By.xpath("//a[contains(text(), 'No thanks, I would like to continue with Upgrade')]");

    public FunderaOfferPage(final WebDriver driver) {
        super(driver);
        waitForElementToAppear(LOGO_IMAGE_LOCATOR);
    }

    public boolean logoImageExists(final WebDriver driver) {
        return isElementPresent(LOGO_IMAGE_LOCATOR);
    }

    public void clickContinueUpgrade() {
        clickElement(CONTINUE_UPGRADE_LOCATOR);
    }
}
