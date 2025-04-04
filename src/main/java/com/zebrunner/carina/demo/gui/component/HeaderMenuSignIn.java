package com.zebrunner.carina.demo.gui.component;

import com.zebrunner.carina.demo.gui.page.HeaderMenuItemPage;
import com.zebrunner.carina.demo.gui.page.MyAccountPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderMenuSignIn extends AbstractUIObject{
    @FindBy(css = "button.action.switch")
    private ExtendedWebElement buttonActionSwitch;
    @FindBy(linkText = "My Account")
    private ExtendedWebElement myAccountLink;
    @FindBy(xpath = "//*[@id='ui-id-2']/li[3]")
    private ExtendedWebElement menMenu;
    @FindBy(xpath = "//*[@id='ui-id-17']")
    private ExtendedWebElement menTopsSubmenu;


    public HeaderMenuSignIn(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public MyAccountPage openMyAccountPage(){
        buttonActionSwitch.click();
        myAccountLink.click();
        return new MyAccountPage(driver);
    }

    private void hoverOnMenMenu() {
        menMenu.hover();
    }

    public boolean isMenTopsDisplayed() {
        hoverOnMenMenu();
        return menTopsSubmenu.isDisplayed();
    }

    public HeaderMenuItemPage openHeaderMenuItemPage(Integer id){
        if (id > 2 && id < 9) {

        }
        hoverOnMenMenu();
        menTopsSubmenu.click();
        return new HeaderMenuItemPage(getDriver());
    }

}
