package testcases;

import base.TestBase;
import extentlisteners.ExtentManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LogInScreen;
import utilities.ScrollUtil;

import java.io.IOException;

public class TitleSectionTest extends TestBase {

    LogInScreen login;
    HomeScreen home;

    @BeforeTest
    public void init() throws IOException {

        setUp();
        login = new LogInScreen(driver);
        home = new HomeScreen(driver);
    }

    @Test
    public void validateTitle() {

        login.clickGetStartedBtn().chooseTopics(4).clickContinue().skipLogin();
//        home.goToTitleSection(1);
//TODO Ovo ne radi, povezano je sa pronalazanjenjem elementa iz HomeScreen class-e
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        takeScreenshot();
        ScrollUtil.scrollUp(2, driver);

    }

    @AfterTest
    public void quitDriver() {
        quit();
    }


}
