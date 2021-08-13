package screens;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ChooseTopicsScreen extends ScreenBase {

    @AndroidFindBy(id = "flipboard.app:id/topic_picker_topic_row_topic_tag")
    public List<AndroidElement> topic;

    @AndroidFindBy(id = "flipboard.app:id/topic_picker_continue_button")
    public WebElement pickerContinueButton;

    @AndroidFindBy(id = "flipboard.app:id/account_login_buttons_skip")
    public WebElement skipLoginButton;

    public ChooseTopicsScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public ChooseTopicsScreen chooseTopics(int topicsCount) {
        for (int i = 0; i<topicsCount; i++){
            topic.get(i).click();
            System.out.println(topic.get(i).getText());
        }
        return this;

    }

    public ChooseTopicsScreen clickContinue() {
        pickerContinueButton.click();

        return this;
    }


    public HomeScreen skipLogin() {
        skipLoginButton.click();

        return new HomeScreen(driver);
    }

}
