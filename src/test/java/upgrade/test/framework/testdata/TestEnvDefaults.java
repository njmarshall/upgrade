package upgrade.test.framework.testdata;

import upgrade.test.framework.core.ConfigManager;

import java.net.URL;

/**
 * @deprecated Replaced by {@link ConfigManager}.
 * This class existed as a holder for hardcoded default values and is retained
 * only for reference. All config should now be loaded via ConfigManager from
 * config.properties / config.local.properties.
 */
@Deprecated
public class TestEnvDefaults {

    private TestEnvDefaults() { }

    @Deprecated
    public static URL getURL() {
        return null; // Use ConfigManager.getInstance().getLoanAppUrl() instead
    }

    @Deprecated
    public static String getAdminUserName() {
        return ConfigManager.getInstance().get("admin.username", "");
    }

    @Deprecated
    public static String getAdminUserPassword() {
        return ConfigManager.getInstance().get("admin.password", "");
    }
}