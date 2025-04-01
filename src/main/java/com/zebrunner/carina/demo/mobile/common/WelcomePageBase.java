package com.zebrunner.carina.demo.mobile.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WelcomePageBase extends AbstractPage {
    public abstract FirstAlarmPageBase goToFirstAlarmPage();

    public WelcomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getWelcomeText();
}
