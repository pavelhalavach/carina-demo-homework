package com.zebrunner.carina.demo.web;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.component.TopMenuSignOut;
import com.zebrunner.carina.demo.gui.page.CustomerLoginPage;
import com.zebrunner.carina.demo.gui.page.HomePage;
import com.zebrunner.carina.demo.gui.page.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTest implements IAbstractTest {
    private TopMenuSignOut topMenuSignOut;

    @BeforeMethod
    public void setUp() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "HomePage is not opened");

        topMenuSignOut = homePage.getTopMenuSignOut();
        topMenuSignOut.assertUIObjectPresent();
    }

    @Test()
    public void testSignInWithValidCredentials() {
        CustomerLoginPage customerLoginPage = topMenuSignOut.openCustomerLoginPage();
        customerLoginPage.typeEmail("test5@test.com");
        customerLoginPage.typePassword("Password123");

        HomePage homePage = customerLoginPage.clickSignInExpectingSuccess();
        Assert.assertTrue(homePage.isPageOpened(), "MyAccountPage is not opened");
    }

    @Test()
    public void testSignInWithInvalidCredentials(){
        CustomerLoginPage customerLoginPage = topMenuSignOut.openCustomerLoginPage();
        customerLoginPage.typeEmail("test5@test.com");
        customerLoginPage.typePassword("Password1234");

        CustomerLoginPage customerLoginPageWithError = customerLoginPage.clickSignInExpectingFailure();
        Assert.assertTrue(customerLoginPageWithError.isIncorrectSignInMessage(),
                "Incorrect sign in message");
    }

    @Test()
    public void testSignInWithInvalidEmailFormat(){
        CustomerLoginPage customerLoginPage = topMenuSignOut.openCustomerLoginPage();
        customerLoginPage.typeEmail("asd");
        customerLoginPage.typePassword("Password1234");

        CustomerLoginPage customerLoginPageWithError = customerLoginPage.clickSignInExpectingFailure();
        Assert.assertTrue(customerLoginPageWithError.getInvalidEmailErrorMessage(),
                "Incorrect sign in message");
    }

    @Test()
    public void testSignInWithEmptyPassword(){
        CustomerLoginPage customerLoginPage = topMenuSignOut.openCustomerLoginPage();
        customerLoginPage.typeEmail("test5@test.com");
        customerLoginPage.typePassword("");

        CustomerLoginPage customerLoginPageWithError = customerLoginPage.clickSignInExpectingFailure();
        Assert.assertTrue(customerLoginPageWithError.isEmptyPasswordErrorMessage(),
                "Incorrect sign in message");
    }

}
