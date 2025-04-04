package com.zebrunner.carina.demo.mobile.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ChooseAlarmTypePageBase extends AbstractPage {


    public ChooseAlarmTypePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SimpleAlarmPageBase goToSimpleAlarmPage();
}
