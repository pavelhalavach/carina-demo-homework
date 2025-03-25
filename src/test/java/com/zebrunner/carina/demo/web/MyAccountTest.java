package com.zebrunner.carina.demo.web;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.gui.component.TopMenuSignIn;
import com.zebrunner.carina.demo.gui.component.TopMenuSignOut;
import com.zebrunner.carina.demo.gui.page.CustomerLoginPage;
import com.zebrunner.carina.demo.gui.page.HomePage;
import com.zebrunner.carina.demo.gui.page.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountTest extends AbstractTest {
    private HomePage homePage;
    private CustomerLoginPage customerLoginPage;

    @BeforeMethod
    public void setUp() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "HomePage is not opened");

        TopMenuSignOut topMenuSignOut = homePage.getTopMenuSignOut();
        topMenuSignOut.assertUIObjectPresent();
        customerLoginPage = topMenuSignOut.openCustomerLoginPage();
        customerLoginPage.typeEmail("test5@test.com");
        customerLoginPage.typePassword("Password123");
    }

    @Test()
    public void testMyAccountIsOpened() {
        homePage = customerLoginPage.clickSignInExpectingSuccess();
        Assert.assertTrue(homePage.isPageOpened(), "MyAccountPage is not opened");

        TopMenuSignIn topMenuSignIn = homePage.getTopMenuSignIn();
        topMenuSignIn.assertUIObjectPresent();

        MyAccountPage myAccountPage = topMenuSignIn.openMyAccountPage();
        Assert.assertTrue(myAccountPage.isPageOpened(), "MyAccountPage is not opened");
    }

    @Test()
    public void testMyAccountEmailInfoIsValid() {
        homePage = customerLoginPage.clickSignInExpectingSuccess();
        Assert.assertTrue(homePage.isPageOpened(), "MyAccountPage is not opened");

        TopMenuSignIn topMenuSignIn = homePage.getTopMenuSignIn();
        topMenuSignIn.assertUIObjectPresent();

        MyAccountPage myAccountPage = topMenuSignIn.openMyAccountPage();
        Assert.assertTrue(myAccountPage.isPageOpened(), "MyAccountPage is not opened");

        Assert.assertEquals(myAccountPage.getEmailInfo(), "test5@test.com");
    }
}
