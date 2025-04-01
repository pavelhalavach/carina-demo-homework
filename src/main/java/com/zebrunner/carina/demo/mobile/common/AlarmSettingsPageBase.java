package com.zebrunner.carina.demo.mobile.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AlarmSettingsPageBase extends AbstractPage {
    public AlarmSettingsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void selectDayForAlarmAndSave(String day);
}
