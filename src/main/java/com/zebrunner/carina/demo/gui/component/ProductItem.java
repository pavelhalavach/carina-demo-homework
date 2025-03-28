package com.zebrunner.carina.demo.gui.component;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.PageFactory.initElements;

public class ProductItem extends AbstractUIObject {
    private String name;
    private String price;
    private String image;

//    @FindBy(css = "button.action.tocart")
    private ExtendedWebElement addToCartButton;

//    @FindBy(css = ".product-item-info")
    private ExtendedWebElement productCard;

    public ProductItem(WebDriver driver, ExtendedWebElement productCard) {
        super(driver);
        this.productCard = productCard;
        this.name = productCard.findExtendedWebElement(By.cssSelector("a.product-item-link")).getText();
        this.price = productCard.findExtendedWebElement(By.cssSelector(".price")).getText();
        this.image = productCard.findExtendedWebElement(By.cssSelector("img.product-image-photo")).getName();
        this.addToCartButton = productCard.findExtendedWebElement(By.cssSelector("button.action.tocart"));

    }

    public String getProductName() {
        return name;
//        return productName.getText();
    }

    public String getProductPrice() {
        return price;
    }

    public String getProductImage() {
        return image;
    }

    public boolean isAddToCartButtonPresent() {
//        productCard.hover();
        return addToCartButton.isPresent();
    }

    public void addToCart() {
        productCard.hover();
        addToCartButton.click();
    }
}
