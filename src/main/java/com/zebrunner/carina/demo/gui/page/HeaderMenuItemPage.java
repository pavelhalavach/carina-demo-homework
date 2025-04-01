package com.zebrunner.carina.demo.gui.page;

import com.zebrunner.carina.demo.gui.component.ProductItem;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HeaderMenuItemPage extends AbstractPage {
    @FindBy(xpath = "//div[contains(@class,'product-item-info')]")
    private List<ExtendedWebElement> productItemsElements;

    @FindBy(css = "li.item.pages-item-next a.action.next")
    private ExtendedWebElement nextButton;

    @FindBy(xpath = "//*[@id='toolbar-amount']/span[3]")
    private ExtendedWebElement productItemsQuantity;

    @FindBy(xpath = "//*[@id='toolbar-amount']/span[2]")
    private ExtendedWebElement productItemsQuantityOnPage;

    @FindBy(xpath = "//*[@id='toolbar-amount']/span[1]")
    private ExtendedWebElement productItemsQuantityOnSinglePage;

    public HeaderMenuItemPage(WebDriver driver) {
        super(driver);
    }

    public List<ProductItem> getAllProducts() {
        List<ProductItem> allProducts = new ArrayList<>();
        while (true){
            allProducts.addAll(productItemsElements
                    .stream()
                    .map(element ->
                            new ProductItem(getDriver(), element))
                    .collect(Collectors.toList())
            );
            if (nextButton.isPresent()) {
                clickNextButton();
            } else {
                break;
            }
        }
        return allProducts;
    }

    public List<ProductItem> getAllProductsOnPage(){
        return productItemsElements
                .stream()
                .map(element ->
                        new ProductItem(getDriver(), element)).collect(Collectors.toList());
    }

    public Integer getProductItemsQuantity() {
        if (productItemsQuantity.isPresent()) {
            return Integer.parseInt(productItemsQuantity.getText());
        }
        return getProductItemsOnPageQuantity();
    }

    public Integer getProductItemsOnPageQuantity() {
        if (productItemsQuantityOnPage.isPresent()) {
            return Integer.parseInt(productItemsQuantityOnPage.getText());
        }
        return Integer.parseInt(productItemsQuantityOnSinglePage.getText());
    }

    public void clickNextButton() {
        ((JavascriptExecutor) getDriver())
                .executeScript("arguments[0].click();", nextButton.getElement());
    }
}
