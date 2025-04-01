package com.zebrunner.carina.demo.gui.page;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.config.WebDriverConfiguration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Locale;

public class NetflixHomePage extends AbstractPage {
    @FindBy(id = ":r1:")
    private ExtendedWebElement langSelector;

    @FindBy(xpath = "//select[@id=':r1:']/option")
    private List<ExtendedWebElement> langList;

    public NetflixHomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.netflix.com/pl-en/");
    }

    public NetflixHomeLocalePage goToNetflixHomeLocalePage(WebDriver driver){
        openLangList();
        if (!langList.isEmpty()) {
            for (ExtendedWebElement element : langList) {
                String localeStr = Configuration.getRequired(WebDriverConfiguration.Parameter.LOCALE);
                Locale locale = parseLocale(localeStr);
                if (element.getAttribute("lang").equals(locale.getLanguage())) {
                    element.click();
                    return new NetflixHomeLocalePage(driver);
                }
            }
        }
        throw new RuntimeException("Unable to find Netflix locale page");
    }

    public void openLangList(){
        langSelector.click();
    }

    private Locale parseLocale(String localeToParse) {
        String[] localeSettings = localeToParse.trim().split("_");
        String lang, country = "";
        lang = localeSettings[0];
        if (localeSettings.length > 1) {
            country = localeSettings[1];
        }
        return new Locale(lang, country);
    }

}
