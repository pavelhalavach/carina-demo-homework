package com.zebrunner.carina.demo.mobile.android;

import com.zebrunner.carina.demo.mobile.common.ChooseAlarmTypePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ChooseAlarmTypePage extends ChooseAlarmTypePageBase {
    @FindBy(xpath = "(//androidx.cardview.widget" +
            ".CardView[@resource-id='com.alarmclock.xtreme.free:id/crv_large_tile_root'])[1]" +
            "/android.view.ViewGroup")
    private ExtendedWebElement simpleAlarm;
    @FindBy(xpath = "(//androidx.cardview.widget" +
            ".CardView[@resource-id='com.alarmclock.xtreme.free:id/crv_large_tile_root'])[2]" +
            "/android.view.ViewGroup")
    private ExtendedWebElement challengingAlarm;
    @FindBy(xpath = "(//androidx.cardview.widget" +
            ".CardView[@resource-id='com.alarmclock.xtreme.free:id/crv_large_tile_root'])[3]" +
            "/android.view.ViewGroup")
    private ExtendedWebElement gentleAlarm;
    @FindBy(xpath = "(//androidx.cardview.widget" +
            ".CardView[@resource-id='com.alarmclock.xtreme.free:id/crv_large_tile_root'])[4]" +
            "/android.view.ViewGroup")
    private ExtendedWebElement customAlarm;

    public ChooseAlarmTypePage(WebDriver driver) {
        super(driver);
    }

    public boolean isSimpleAlarmPresent() {
        return simpleAlarm.isPresent();
    }
    public boolean isChallengingAlarmPresent() {
        return challengingAlarm.isPresent();
    }
    public boolean isGentleAlarmPresent() {
        return gentleAlarm.isPresent();
    }
    public boolean isCustomAlarmPresent() {
        return customAlarm.isPresent();
    }
}
