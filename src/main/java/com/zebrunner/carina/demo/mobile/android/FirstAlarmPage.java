package com.zebrunner.carina.demo.mobile.android;

import com.zebrunner.carina.demo.mobile.common.ChooseAlarmTypePageBase;
import com.zebrunner.carina.demo.mobile.common.FirstAlarmPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = FirstAlarmPageBase.class)
public class FirstAlarmPage extends FirstAlarmPageBase {
    @FindBy(id = "com.alarmclock.xtreme.free:id/btn_create_alarm")
    private ExtendedWebElement createFirstAlarmButton;

    @FindBy(id = "com.alarmclock.xtreme.free:id/txt_title")
    private ExtendedWebElement firstAlarmText;

    public FirstAlarmPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ChooseAlarmTypePageBase goToChooseAlarmTypePage() {
        createFirstAlarmButton.click();
        return new ChooseAlarmTypePage(getDriver());
    }

    @Override
    public String getFirstAlarmText() {
        return firstAlarmText.getText();
    }

}
