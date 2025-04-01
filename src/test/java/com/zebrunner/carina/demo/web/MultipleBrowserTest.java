package com.zebrunner.carina.demo.web;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.component.HeaderMenuSignOut;
import com.zebrunner.carina.demo.gui.page.CustomerLoginPage;
import com.zebrunner.carina.demo.gui.page.HomePage;
import com.zebrunner.carina.webdriver.core.capability.impl.desktop.SafariCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleBrowserTest implements IAbstractTest {
    private HeaderMenuSignOut headerMenuSignOutChrome;
    private HeaderMenuSignOut headerMenuSignOutSafari;

    @BeforeMethod
    public void setUp() {
        HomePage homePageChrome = new HomePage(getDriver("chrome"));
        HomePage homePageSafari = new HomePage(getDriver("safari",
                new SafariCapabilities().getCapability("Safari Browser")));
        homePageChrome.open();
        homePageSafari.open();
        Assert.assertTrue(homePageChrome.isPageOpened(), "HomePage is not opened");
        Assert.assertTrue(homePageSafari.isPageOpened(), "HomePage is not opened");

        headerMenuSignOutChrome = homePageChrome.getTopMenuSignOut();
        headerMenuSignOutSafari = homePageSafari.getTopMenuSignOut();
        headerMenuSignOutChrome.assertUIObjectPresent();
        headerMenuSignOutSafari.assertUIObjectPresent();
    }

    @Test()
    public void testSignInWithValidCredentialsMultipleBrowser() {
        CustomerLoginPage customerLoginPageChrome = headerMenuSignOutChrome.openCustomerLoginPage();
        customerLoginPageChrome.typeEmail("test5@test.com");
        customerLoginPageChrome.typePassword("Password123");

        HomePage homePageChrome = customerLoginPageChrome.clickSignInExpectingSuccess();
        Assert.assertTrue(homePageChrome.isPageOpened(), "MyAccountPage is not opened");

        CustomerLoginPage customerLoginPageSafari = headerMenuSignOutSafari.openCustomerLoginPage();
        customerLoginPageSafari.typeEmail("test5@test.com");
        customerLoginPageSafari.typePassword("Password123");

        HomePage homePageSafari = customerLoginPageSafari.clickSignInExpectingSuccess();
        Assert.assertTrue(homePageSafari.isPageOpened(), "MyAccountPage is not opened");
    }

    @Test()
    public void testSignInWithInvalidCredentialsMultipleBrowser() {
        CustomerLoginPage customerLoginPageChrome = headerMenuSignOutChrome.openCustomerLoginPage();
        customerLoginPageChrome.typeEmail("test5@test.com");
        customerLoginPageChrome.typePassword("Password1234");

        CustomerLoginPage customerLoginPageWithErrorC = customerLoginPageChrome.clickSignInExpectingFailure();
        Assert.assertTrue(customerLoginPageWithErrorC.isIncorrectSignInMessage(),
                "Incorrect sign in message");

        CustomerLoginPage customerLoginPageSafari = headerMenuSignOutSafari.openCustomerLoginPage();
        customerLoginPageSafari.typeEmail("test5@test.com");
        customerLoginPageSafari.typePassword("Password1234");

        CustomerLoginPage customerLoginPageWithErrorS = customerLoginPageSafari.clickSignInExpectingFailure();
        Assert.assertTrue(customerLoginPageWithErrorS.isIncorrectSignInMessage(),
                "Incorrect sign in message");
    }
}
