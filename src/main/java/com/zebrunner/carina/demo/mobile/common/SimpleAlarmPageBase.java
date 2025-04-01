package com.zebrunner.carina.demo.mobile.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SimpleAlarmPageBase extends AbstractPage {
    public SimpleAlarmPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getTitleText();

    public abstract AlarmSettingsPageBase goToSettingsPage();

    public abstract SetAlarmTimePageBase goToSetAlarmTimePage();
}
