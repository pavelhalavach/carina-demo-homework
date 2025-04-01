package com.zebrunner.carina.demo.mobile.android;

import com.zebrunner.carina.demo.mobile.common.AlarmSettingsPageBase;
import com.zebrunner.carina.demo.mobile.common.SetAlarmTimePageBase;
import com.zebrunner.carina.demo.mobile.common.SimpleAlarmPageBase;
import com.zebrunner.carina.demo.mobile.common.WelcomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SimpleAlarmPageBase.class)
public class SimpleAlarmPage extends SimpleAlarmPageBase {
    @FindBy(id = "com.alarmclock.xtreme.free:id/btn_set_time")
    private ExtendedWebElement setTimeButton;
    @FindBy(id = "com.alarmclock.xtreme.free:id/action_settings")
    private ExtendedWebElement settingsButton;
    @FindBy(id = "com.alarmclock.xtreme.free:id/txt_title")
    private ExtendedWebElement titleText;

    public SimpleAlarmPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getTitleText() {
        return titleText.getText();
    }

    @Override
    public AlarmSettingsPageBase goToSettingsPage() {
        settingsButton.click();
        return new AlarmSettingsPage(getDriver());
    }

    @Override
    public SetAlarmTimePageBase goToSetAlarmTimePage() {
        setTimeButton.click();
        return new SetAlarmTimePage(getDriver());
    }
}
