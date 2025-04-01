package com.zebrunner.carina.demo.web;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.component.HeaderMenuSignOut;
import com.zebrunner.carina.demo.gui.page.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements IAbstractTest {
    HomePage homePage;
    HeaderMenuSignOut headerMenuSignOut;
    @BeforeMethod
    public void setUp() {
        homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "HomePage is not opened");

        headerMenuSignOut = homePage.getTopMenuSignOut();
        headerMenuSignOut.assertUIObjectPresent();
    }
}
