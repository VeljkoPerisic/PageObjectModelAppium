package testcases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screens.ChooseTopicsScreen;
import screens.LogInScreen;

import java.io.IOException;

public class FlipboardLoginTest extends TestBase {

    LogInScreen login;
    ChooseTopicsScreen topicsScreen;

    //Inicijalizacija svega
    @BeforeTest
    public void init() throws IOException {
        setUp();
        login = new LogInScreen(driver);
        topicsScreen = new ChooseTopicsScreen(driver);
    }

    @Test(priority = 1)
    public void validateGetStartedButton() {

        login.clickGetStartedBtn();
//        Assert.fail("Failing the test");
    }
    @Test (priority = 2)
    public void chooseTopicsTest() {
        topicsScreen.chooseTopics(4).clickContinue();

    }

    @AfterTest
    public void quitDriver() {

        quit();
    }
}
