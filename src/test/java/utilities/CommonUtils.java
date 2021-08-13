package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class CommonUtils {

    private static AppiumDriver<MobileElement> driver;
    private static URL serverUrl;
    private static DesiredCapabilities capabilities = new DesiredCapabilities();
    private static String APPIUM_PORT;
    private static int IMPLICIT_WAIT_TIME;
    private static int EXPLICIT_WAIT_TIME;
    private static String BASE_PKG;
    private static String APP_ACTIVITY;
    private static String APP_PATH;
    private static String BROWSER_NAME;
    private static String PLATFORM_NAME;
    private static String PLATFORM_VERSION;
    private static String DEVICE_NAME;
    private static String UDID;
    private static String BUNDLE_ID;
    private static String APP;

    private static Properties prop = new Properties();


    public static void loadAndroidConfProp(String loadPropertyFile) throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/" + loadPropertyFile);
        prop.load(fis);

        IMPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("implicit.wait"));
        EXPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("explicit.wait"));
        BASE_PKG = prop.getProperty("base.pkg");
        APP_ACTIVITY = prop.getProperty("application.activity");
        APP_PATH = prop.getProperty("application.path");
        BROWSER_NAME = prop.getProperty("browser.name");
        PLATFORM_NAME = prop.getProperty("platform.name");
        PLATFORM_VERSION = prop.getProperty("platform.version");
        DEVICE_NAME = prop.getProperty("device.name");
        APPIUM_PORT = prop.getProperty("appium.server.port");
    }

    public static void setAndroidCapabilities() {

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, BASE_PKG);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
//        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BROWSER_NAME);


    }

    public static void loadIOSdConfProp(String loadPropertyFile) {
    }

    public static void setIOSCapabilities() {

    }

    public static AppiumDriver<MobileElement> getAndroidDriver() throws MalformedURLException {

        serverUrl = new URL("http://localhost:" + APPIUM_PORT + "/wd/hub");
        driver = new AndroidDriver<MobileElement>(serverUrl, capabilities);
        return driver;
    }

    public static AppiumDriver<MobileElement> getIOSDriver() {

        return driver;
    }
}
