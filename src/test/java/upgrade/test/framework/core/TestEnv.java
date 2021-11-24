package upgrade.test.framework.core;

import upgrade.test.framework.api.utils.HttpUtils;

import java.net.URL;

public class TestEnv {

    private final String theURL;
    private String userName = null;
    private String userPassword = null;

    public TestEnv(String theURL) {
        this.theURL = theURL;
    }

    public TestEnv(String theURL, String userName, String userPassword){
        this.theURL = theURL;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public URL getURL() {
        return HttpUtils.getURLfromString(theURL);
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
