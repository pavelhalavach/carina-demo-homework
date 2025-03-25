package com.zebrunner.carina.demo.gui.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends AbstractPage {
    @FindBy(css = "h1.page-title")
    private ExtendedWebElement pageTitle;
    @FindBy(css = "div.box-content")
    private ExtendedWebElement contactInfo;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return pageTitle.isDisplayed();
    }

    public String getEmailInfo(){
        String[] lines = contactInfo.getText().split("\\n");
        return lines[1];
    }
}
