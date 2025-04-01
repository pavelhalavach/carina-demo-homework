package com.zebrunner.carina.demo.mobile.android;

import com.zebrunner.carina.demo.mobile.common.FirstAlarmPageBase;
import com.zebrunner.carina.demo.mobile.common.WelcomePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends WelcomePageBase {
    @FindBy(id = "com.alarmclock.xtreme.free:id/btn_eula_accept")
    private ExtendedWebElement getStartedButton;

    @FindBy(id = "com.alarmclock.xtreme.free:id/txt_welcome")
    private ExtendedWebElement welcomeText;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public FirstAlarmPageBase goToFirstAlarmPage() {
        getStartedButton.click();
        return new FirstAlarmPage(getDriver());
    }

    @Override
    public String getWelcomeText() {
        return welcomeText.getText();
    }
}
