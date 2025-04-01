package com.zebrunner.carina.demo.mobile.android;

import com.zebrunner.carina.demo.mobile.common.SetAlarmTimePageBase;
import com.zebrunner.carina.demo.mobile.common.WelcomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SetAlarmTimePageBase.class)
public class SetAlarmTimePage extends SetAlarmTimePageBase {

    public SetAlarmTimePage(WebDriver driver) {
        super(driver);
    }
}
