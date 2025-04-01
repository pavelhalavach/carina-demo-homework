package com.zebrunner.carina.demo.gui.component;

import com.zebrunner.carina.demo.gui.page.CustomerLoginPage;
import com.zebrunner.carina.demo.gui.page.HeaderMenuItemPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HeaderMenuSignOut extends AbstractUIObject{
    @FindBy(linkText = "Sign In")
    private ExtendedWebElement signInLink;
    @FindBy(xpath = "//*[@class='ui-corner-all' and @role='menuitem']")
    private List<ExtendedWebElement> menuItems;


    public HeaderMenuSignOut(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CustomerLoginPage openCustomerLoginPage(){
        signInLink.click();
        return new CustomerLoginPage(driver);
    }

    public HeaderMenuItemPage openCategoryById(String id) {
        Map<String, ExtendedWebElement> menuItemsMap = menuItems.stream()
                .collect(Collectors.toMap(item ->
                        item.getElement().getAttribute("id"), Function.identity()));

        ExtendedWebElement menuItem = menuItems.stream()
                .filter(item -> id.equals(item.getElement().getAttribute("id")))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Menu Item with " + id + " not found"));

        ((JavascriptExecutor) getDriver())
                .executeScript("arguments[0].click();", menuItem.getElement());

        return new HeaderMenuItemPage(driver);
    }

}
