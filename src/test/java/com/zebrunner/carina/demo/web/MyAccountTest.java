package com.zebrunner.carina.demo.web;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.gui.component.HeaderMenuSignIn;
import com.zebrunner.carina.demo.gui.component.HeaderMenuSignOut;
import com.zebrunner.carina.demo.gui.page.CustomerLoginPage;
import com.zebrunner.carina.demo.gui.page.HomePage;
import com.zebrunner.carina.demo.gui.page.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest{
    private CustomerLoginPage customerLoginPage;

    @Test()
    public void testMyAccountIsOpened() {
        customerLoginPage = headerMenuSignOut.openCustomerLoginPage();
        customerLoginPage.typeEmail("test5@test.com");
        customerLoginPage.typePassword("Password123");
        homePage = customerLoginPage.clickSignInExpectingSuccess();
        Assert.assertTrue(homePage.isPageOpened(), "MyAccountPage is not opened");

        HeaderMenuSignIn headerMenuSignIn = homePage.getTopMenuSignIn();
        headerMenuSignIn.assertUIObjectPresent();

        MyAccountPage myAccountPage = headerMenuSignIn.openMyAccountPage();
        Assert.assertTrue(myAccountPage.isPageOpened(), "MyAccountPage is not opened");
    }

    @Test()
    public void testMyAccountEmailInfoIsValid() {
        customerLoginPage = headerMenuSignOut.openCustomerLoginPage();
        customerLoginPage.typeEmail("test5@test.com");
        customerLoginPage.typePassword("Password123");
        homePage = customerLoginPage.clickSignInExpectingSuccess();
        Assert.assertTrue(homePage.isPageOpened(), "MyAccountPage is not opened");

        HeaderMenuSignIn headerMenuSignIn = homePage.getTopMenuSignIn();
        headerMenuSignIn.assertUIObjectPresent();

        MyAccountPage myAccountPage = headerMenuSignIn.openMyAccountPage();
        Assert.assertTrue(myAccountPage.isPageOpened(), "MyAccountPage is not opened");

        Assert.assertEquals(myAccountPage.getEmailInfo(), "test5@test.com");
    }
}
