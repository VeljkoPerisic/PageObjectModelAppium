package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.AppiumServer;
import utilities.CommonUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class TestBase {

    public AppiumDriver<MobileElement> driver;

    public static String loadPropertyFile = "Android_flipboard.properties";
    public static Logger log = Logger.getLogger(TestBase.class);

    public void takeScreenshot() {

        Date d = new Date();
        String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
        File scrFile = ((TakesScreenshot) ScreenBase.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\reports\\" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUp() throws IOException {

        if(driver == null) {
            PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\log4j.properties");

            if(loadPropertyFile.startsWith("Android_")) {

                AppiumServer.start();
                log.info("Appium server started");
                CommonUtils.loadAndroidConfProp(loadPropertyFile);
                log.info(loadPropertyFile + " properties file loaded!!!");
                CommonUtils.setAndroidCapabilities();
                driver = CommonUtils.getAndroidDriver();


            }else if(loadPropertyFile.startsWith("IOS_")) {

            }
        }
    }

    public void quit() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
        log.info("Test case execution completed");

        AppiumServer.stop();
        log.info("Appium server stopped");

    }
}
