package com.zebrunner.carina.demo.gui.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CustomerLoginPage extends AbstractPage {
    @FindBy(id = "email")
    private ExtendedWebElement emailField;
    @FindBy(id = "pass")
    private ExtendedWebElement passwordField;
    @FindBy(id = "send2")
    private ExtendedWebElement signInButton;
    @FindBy(id = "email-error")
    private ExtendedWebElement invalidEmailErrorMessage;
    @FindBy(id = "pass-error")
    private ExtendedWebElement emptyPasswordErrorMessage;
    @FindBy(css = "div[data-bind*='prepareMessageForHtml']")
    private ExtendedWebElement incorrectSignInMessage;

    public CustomerLoginPage(WebDriver driver) {
        super(driver);
    }

    public void typeEmail(String email) {
        emailField.type(email);
    }

    public void typePassword(String password) {
        passwordField.type(password);
    }

    public HomePage clickSignInExpectingSuccess() {
        signInButton.click();
        return new HomePage(getDriver());
    }

    public CustomerLoginPage clickSignInExpectingFailure() {
        signInButton.click();
        return new CustomerLoginPage(getDriver());
    }

    public boolean isIncorrectSignInMessage() {
        return incorrectSignInMessage.isPresent();
    }

    public boolean getInvalidEmailErrorMessage() {
        return invalidEmailErrorMessage.isPresent();
    }

    public boolean isEmptyPasswordErrorMessage() {
        return emptyPasswordErrorMessage.isPresent();
    }
}
