package com.zebrunner.carina.demo.mobile;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.mobile.android.ChooseAlarmTypePage;
import com.zebrunner.carina.demo.mobile.android.FirstAlarmPage;
import com.zebrunner.carina.demo.mobile.common.WelcomePageBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
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
        Assert.assertEquals(welcomePage.getWelcomeText(), "Welcome to Alarm Clock Xtreme");
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
}
