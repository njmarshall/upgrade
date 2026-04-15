package upgrade.test.framework.core;

import upgrade.test.framework.api.utils.HttpUtils;

import java.net.URL;

/**
 * Lightweight value object encapsulating a test environment's URL and
 * optional credentials.
 *
 * <p>For most use cases, prefer {@link ConfigManager} which loads all
 * environment config from properties files. Use TestEnv directly only
 * when constructing one-off environment configurations programmatically.</p>
 */
public class TestEnv {

    private final String url;
    private final String userName;
    private final String userPassword;

    public TestEnv(String url) {
        this(url, null, null);
    }

    public TestEnv(String url, String userName, String userPassword) {
        this.url = url;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public URL getURL() {
        return HttpUtils.getURLfromString(url);
    }

    public String getRawUrl() {
        return url;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public boolean hasCredentials() {
        return userName != null && userPassword != null;
    }
}