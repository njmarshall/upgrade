package upgrade.test.framework.testdata;

import upgrade.test.framework.api.utils.HttpUtils;

import java.net.URL;

public class TestEnvDefaults {
    public static final String theURL = "http://192.0.0.1";
    public static final String adminUserName="user";
    public static final String adminUserPassword="password";

    public static URL getURL() {
        return HttpUtils.getURLfromString(theURL);
    }

    public static String getAdminUserName() {
        return adminUserName;
    }

    public static String getAdminUserPassword() {
        return adminUserPassword;
    }
}
