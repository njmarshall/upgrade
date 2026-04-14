package upgrade.test.framework.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Centralized configuration manager.
 * Loads from config.local.properties if present (git-ignored),
 * falls back to config.properties for defaults.
 */
public class ConfigManager {

    private static final String DEFAULT_CONFIG = "config.properties";
    private static final String LOCAL_CONFIG   = "config.local.properties";

    private static ConfigManager instance;
    private final Properties props = new Properties();

    private ConfigManager() {
        loadFile(DEFAULT_CONFIG);
        loadFile(LOCAL_CONFIG);   // overrides defaults if present
    }

    public static synchronized ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    private void loadFile(String fileName) {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (is != null) {
                props.load(is);
            }
        } catch (IOException e) {
            System.err.println("ConfigManager: could not load " + fileName + " — " + e.getMessage());
        }
    }

    public String get(String key) {
        String value = System.getProperty(key, props.getProperty(key));
        if (value == null) {
            throw new IllegalStateException("Missing required config key: " + key);
        }
        return value;
    }

    public String get(String key, String defaultValue) {
        return System.getProperty(key, props.getProperty(key, defaultValue));
    }

    // ---- Typed convenience accessors ----

    public String getLoanAppUrl() {
        return get("api.loanapp.url");
    }

    public String getUiLoanAppUrl() {
        return get("ui.loanapp.url");
    }

    public String getExistingLoanAppId() {
        return get("testdata.existing.loan.app.id");
    }

    public String getNonExistingLoanAppId() {
        return get("testdata.nonexisting.loan.app.id");
    }

    public boolean isBrowserHeadless() {
        return Boolean.parseBoolean(get("browser.headless", "false"));
    }
}
