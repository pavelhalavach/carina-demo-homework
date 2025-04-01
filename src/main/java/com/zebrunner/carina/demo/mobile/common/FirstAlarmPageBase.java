package com.zebrunner.carina.demo.mobile.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class FirstAlarmPageBase extends AbstractPage {
    public abstract ChooseAlarmTypePageBase goToChooseAlarmTypePage();

    public FirstAlarmPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getFirstAlarmText();
}
