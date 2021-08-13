package screens;

import base.ScreenBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LogInScreen extends ScreenBase {


    @AndroidFindBy(id = "flipboard.app:id/first_launch_cover_continue")
    public WebElement continueButton;

    public LogInScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    public ChooseTopicsScreen clickGetStartedBtn(){
        continueButton.click();
        return new ChooseTopicsScreen(driver);
    }




}
