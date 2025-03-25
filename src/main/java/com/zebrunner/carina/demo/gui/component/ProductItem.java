package com.zebrunner.carina.demo.gui.component;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductItem extends AbstractUIObject {
    @FindBy(css = "a.product-item-link")
    private ExtendedWebElement productName;

    @FindBy(css = ".price")
    private ExtendedWebElement price;

    @FindBy(css = "img.product-image-photo")
    private ExtendedWebElement image;

    @FindBy(css = "button.action.tocart")
    private ExtendedWebElement addToCartButton;

    @FindBy(css = ".product-item-info")
    private ExtendedWebElement productCard;

    public ProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductPrice() {
        return price.getText();
    }

    public String getProductImage() {
        return image.getText();
    }

    public boolean isAddToCartButtonPresent() {
        productCard.hover();
        return addToCartButton.isPresent();
    }

    public void addToCart() {
        productCard.hover();
        addToCartButton.click();
    }
}
