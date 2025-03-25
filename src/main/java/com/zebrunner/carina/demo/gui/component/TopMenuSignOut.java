package com.zebrunner.carina.demo.gui.component;

import com.zebrunner.carina.demo.gui.page.CustomerLoginPage;
import com.zebrunner.carina.demo.gui.page.MenTopsPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TopMenuSignOut extends AbstractUIObject{
    @FindBy(linkText = "Sign In")
    private ExtendedWebElement signInLink;
    @FindBy(xpath = "//*[@id=\"ui-id-2\"]/li[3]")
    private ExtendedWebElement menMenu;
    @FindBy(xpath = "//*[@id=\"ui-id-17\"]")
    private ExtendedWebElement menTopsSubmenu;

    public TopMenuSignOut(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CustomerLoginPage openCustomerLoginPage(){
        signInLink.click();
        return new CustomerLoginPage(driver);
    }

    private void hoverOnMenMenu() {
        menMenu.hover();
    }

    public boolean isMenTopsDisplayed() {
        hoverOnMenMenu();
        return menTopsSubmenu.isDisplayed();
    }

    public MenTopsPage openMenTopsPage(){
        hoverOnMenMenu();
        menTopsSubmenu.click();
        return new MenTopsPage(getDriver());
    }

}
