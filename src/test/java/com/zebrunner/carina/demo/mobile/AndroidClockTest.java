package com.zebrunner.carina.demo.mobile;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.mobile.android.*;
import com.zebrunner.carina.demo.mobile.common.WelcomePageBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AndroidClockTest implements IAbstractTest {

    private WelcomePageBase welcomePage;

    @BeforeMethod
    public void setUp() {
        welcomePage = initPage(getDriver(), WelcomePageBase.class);
    }

    @Test
    public void testWelcomePageText() {
        Assert.assertEquals(welcomePage.getWelcomeText(), "Welcome to\nAlarm Clock Xtreme");
    }

    @Test
    public void testFirstAlarmPageText() {
        FirstAlarmPage firstAlarmPage = (FirstAlarmPage) welcomePage.goToFirstAlarmPage();
        Assert.assertEquals(firstAlarmPage.getFirstAlarmText(), "Helping millions wake up daily");
    }

    @Test
    public void testChooseAlarmTypePageAreAllTypesPresent() {
        FirstAlarmPage firstAlarmPage = (FirstAlarmPage) welcomePage.goToFirstAlarmPage();
        ChooseAlarmTypePage chooseAlarmTypePage = (ChooseAlarmTypePage) firstAlarmPage.goToChooseAlarmTypePage();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(chooseAlarmTypePage.isSimpleAlarmPresent(), "Simple alarm present");
        softAssert.assertTrue(chooseAlarmTypePage.isChallengingAlarmPresent(), "Challenging alarm present");
        softAssert.assertTrue(chooseAlarmTypePage.isGentleAlarmPresent(), "Gentle alarm present");
        softAssert.assertTrue(chooseAlarmTypePage.isCustomAlarmPresent(), "Custom alarm present");
        softAssert.assertAll();
    }

    @Test
    public void testSimpleAlarmText(){
        FirstAlarmPage firstAlarmPage = (FirstAlarmPage) welcomePage.goToFirstAlarmPage();
        ChooseAlarmTypePage chooseAlarmTypePage = (ChooseAlarmTypePage) firstAlarmPage.goToChooseAlarmTypePage();
        SimpleAlarmPage simpleAlarmPage = (SimpleAlarmPage) chooseAlarmTypePage.goToSimpleAlarmPage();

        Assert.assertEquals(simpleAlarmPage.getTitleText(), "Simple");
    }

    @Test void testSettingsPageOnSimpleAlarmIsOpened(){
        FirstAlarmPage firstAlarmPage = (FirstAlarmPage) welcomePage.goToFirstAlarmPage();
        ChooseAlarmTypePage chooseAlarmTypePage = (ChooseAlarmTypePage) firstAlarmPage.goToChooseAlarmTypePage();
        SimpleAlarmPage simpleAlarmPage = (SimpleAlarmPage) chooseAlarmTypePage.goToSimpleAlarmPage();

        AlarmSettingsPage alarmSettingsPage = (AlarmSettingsPage) simpleAlarmPage.goToSettingsPage();
        Assert.assertTrue(alarmSettingsPage.isPageOpened(), "Page opened");
    }

    @DataProvider(name = "menuDays")
    public Object[][] menuDays() {
        return new Object[][]{
                {"Monday"},
                {"Tuesday"},
                {"Wednesday"},
                {"Thursday"},
                {"Friday"},
                {"Saturday"},
                {"Sunday"}
        };
    }

    @Test(dataProvider = "menuDays")
    void testSettingsPageChoosingDayForAlarmAndSave(String day){
        FirstAlarmPage firstAlarmPage = (FirstAlarmPage) welcomePage.goToFirstAlarmPage();
        ChooseAlarmTypePage chooseAlarmTypePage = (ChooseAlarmTypePage) firstAlarmPage.goToChooseAlarmTypePage();
        SimpleAlarmPage simpleAlarmPage = (SimpleAlarmPage) chooseAlarmTypePage.goToSimpleAlarmPage();

        AlarmSettingsPage alarmSettingsPage = (AlarmSettingsPage) simpleAlarmPage.goToSettingsPage();
        alarmSettingsPage.selectDayForAlarmAndSave(day);
    }

    @Test void testSetTimePageOnSimpleAlarmIsOpened(){
        FirstAlarmPage firstAlarmPage = (FirstAlarmPage) welcomePage.goToFirstAlarmPage();
        ChooseAlarmTypePage chooseAlarmTypePage = (ChooseAlarmTypePage) firstAlarmPage.goToChooseAlarmTypePage();
        SimpleAlarmPage simpleAlarmPage = (SimpleAlarmPage) chooseAlarmTypePage.goToSimpleAlarmPage();

        SetAlarmTimePage setAlarmTimePage = (SetAlarmTimePage) simpleAlarmPage.goToSetAlarmTimePage();
        Assert.assertTrue(setAlarmTimePage.isPageOpened(), "Page opened");
    }
}
