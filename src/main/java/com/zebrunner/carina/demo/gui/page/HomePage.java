package com.zebrunner.carina.demo.gui.page;

import com.zebrunner.carina.demo.gui.component.TopMenuSignIn;
import com.zebrunner.carina.demo.gui.component.TopMenuSignOut;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    @FindBy(className = "page-header")
    private TopMenuSignOut topMenuSignOut;
    @FindBy(className = "page-header")
    private TopMenuSignIn topMenuSignIn;
    @FindBy(xpath = "//span[@class='base' and @data-ui-id='page-title-wrapper']")
    private ExtendedWebElement homePageTitle;
    @FindBy(css = "button.css-1n36tvh")
    private ExtendedWebElement privacyButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public TopMenuSignOut getTopMenuSignOut() {
        privacyButton.click();
        return topMenuSignOut;
    }

    public TopMenuSignIn getTopMenuSignIn() {
//        privacyButton.click();
        return topMenuSignIn;
    }
}
