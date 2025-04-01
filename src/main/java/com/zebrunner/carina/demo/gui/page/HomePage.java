package com.zebrunner.carina.demo.gui.page;

import com.zebrunner.carina.demo.gui.component.HeaderMenuSignIn;
import com.zebrunner.carina.demo.gui.component.HeaderMenuSignOut;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    @FindBy(className = "page-header")
    private HeaderMenuSignOut headerMenuSignOut;
    @FindBy(className = "page-header")
    private HeaderMenuSignIn headerMenuSignIn;
    @FindBy(xpath = "//span[@class='base' and @data-ui-id='page-title-wrapper']")
    private ExtendedWebElement homePageTitle;
    @FindBy(css = "button.css-1n36tvh")
    private ExtendedWebElement privacyButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HeaderMenuSignOut getTopMenuSignOut() {
        privacyButton.click();
        return headerMenuSignOut;
    }

    public HeaderMenuSignIn getTopMenuSignIn() {
        return headerMenuSignIn;
    }
}
