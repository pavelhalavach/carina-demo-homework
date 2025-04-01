package com.zebrunner.carina.demo.gui.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.checkerframework.checker.i18n.qual.Localized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NetflixHomeLocalePage extends AbstractPage {

    @Localized
    @FindBy(css = "h1.default-ltr-cache-16hrlzl-StyledContainer.euy28770")
    private ExtendedWebElement welcomeText;

    @Localized
    @FindBy(css = ".default-ltr-cache-hccik6-StyledContainer.euy28770")
    private ExtendedWebElement welcomeSubText;

    @Localized
    @FindBy(css = ".pressable_styles__a6ynkg0." +
            "button_styles__1kwr4ym0.default-ltr-cache-u5y28f-StyledBaseButton.e1ax5wel2")
    private ExtendedWebElement getStartedButton;

    public NetflixHomeLocalePage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeText() {
        return welcomeText.getText();
    }

    public String getWelcomeSubText() {
        return welcomeSubText.getText();
    }

    public String getGetStartedButtonText() {
        return getStartedButton.getText();
    }
}
