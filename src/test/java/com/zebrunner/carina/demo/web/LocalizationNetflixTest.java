package com.zebrunner.carina.demo.web;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.page.NetflixHomeLocalePage;
import com.zebrunner.carina.demo.gui.page.NetflixHomePage;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.utils.resources.L10N;
import com.zebrunner.carina.webdriver.config.WebDriverConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Locale;

public class LocalizationNetflixTest implements IAbstractTest {

    @BeforeClass
    public void testLocaleLoad(){
        Locale locale = L10N.getLocale();
        String loadedLocale = locale.getLanguage() + "_" + locale.getCountry();
        String configLocale = Configuration.getRequired(WebDriverConfiguration.Parameter.LOCALE);
        Assert.assertEquals(loadedLocale, configLocale);
    }

    @Test
    public void testLocalizationNetflix() {
        NetflixHomePage netflixHomePage = new NetflixHomePage(getDriver());
        netflixHomePage.open();
        Assert.assertTrue(netflixHomePage.isPageOpened(), "Netflix home page is not opened");

        NetflixHomeLocalePage netflixHomeLocalePage = netflixHomePage.goToNetflixHomeLocalePage(getDriver());

        SoftAssert softAssert = new SoftAssert();
        String actual = netflixHomeLocalePage.getWelcomeText();
        String expected = L10N.getText("NetflixHomeLocalePage.welcomeText");
        System.out.println(expected);
        softAssert.assertEquals(actual, expected);
        softAssert.assertAll();

    }

}
