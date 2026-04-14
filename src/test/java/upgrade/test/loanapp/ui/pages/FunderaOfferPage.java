package upgrade.test.loanapp.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import upgrade.test.framework.ui.BasePage;

/**
 * Page object for the optional Fundera partner offer interstitial.
 * This page may or may not appear during the loan funnel — callers should
 * check {@link #isDisplayed()} before interacting.
 */
public class FunderaOfferPage extends BasePage {

    private final By LOGO_IMAGE_LOCATOR =
            By.xpath("//img[contains(@src, 'media/fundera-logo')]");
    private final By CONTINUE_UPGRADE_LOCATOR =
            By.xpath("//a[contains(text(), 'No thanks, I would like to continue with Upgrade')]");

    public FunderaOfferPage(final WebDriver driver) {
        super(driver);
        // Do NOT wait for element here — this page is conditional.
        // Callers must check isDisplayed() first.
    }

    /**
     * Returns true if the Fundera offer interstitial is currently visible.
     */
    public boolean isDisplayed() {
        return isElementPresent(LOGO_IMAGE_LOCATOR);
    }

    /**
     * @deprecated Use {@link #isDisplayed()} instead — the driver parameter is redundant.
     */
    @Deprecated
    public boolean logoImageExists(final WebDriver driver) {
        return isDisplayed();
    }

    public void clickContinueUpgrade() {
        waitForElementToAppear(CONTINUE_UPGRADE_LOCATOR);
        clickElement(CONTINUE_UPGRADE_LOCATOR);
    }
}
