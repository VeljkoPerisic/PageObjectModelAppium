package screens;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomeScreen extends ScreenBase {

    @AndroidFindBy(id = "flipboard.app:id/sliding_title_strip_container")
    public List<AndroidElement> title;
    //TODO Proveriti zasto ovo ne radi, ne mogu da pronadjem id od stripa na vrhu

    @AndroidFindBy(id = "flipboard.app:id/bottom_nav_view_icon")
    public List<AndroidElement> bottomNavigation;

    public HomeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void goToTitleSection(int sectionCount){
        title.get(sectionCount).click();

    }

    public void selectBottomPanel(int screenNo) {
        bottomNavigation.get(screenNo-1).click();
    }
}
