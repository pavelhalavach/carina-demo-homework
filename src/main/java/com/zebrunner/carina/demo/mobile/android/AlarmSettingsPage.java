package com.zebrunner.carina.demo.mobile.android;

import com.zebrunner.carina.demo.mobile.common.AlarmSettingsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AlarmSettingsPageBase.class)
public class AlarmSettingsPage extends AlarmSettingsPageBase {

    @FindBy(xpath = "//android.widget.TextView[contains(@content-desc, 'day')]")
    private List<ExtendedWebElement> selectDayToRepeatMenu;

    @FindBy(id = "com.alarmclock.xtreme.free:id/txt_toolbar_settings_save")
    private ExtendedWebElement saveButton;

    public AlarmSettingsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void selectDayForAlarmAndSave(String day){
        for (ExtendedWebElement dayMenu : selectDayToRepeatMenu) {
            if (dayMenu.getElement().getAttribute("content-desc").equals(day)) {
                dayMenu.click();
            }
        }
        saveButton.click();
    }
}
