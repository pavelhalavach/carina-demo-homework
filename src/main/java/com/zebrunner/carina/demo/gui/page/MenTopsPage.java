package com.zebrunner.carina.demo.gui.page;

import com.zebrunner.carina.demo.gui.component.ProductItem;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenTopsPage extends AbstractPage {
    @FindBy(xpath = "//div[contains(@class,'product-item-info')]")
    private List<ExtendedWebElement> productItemsElements;

//    @FindBy(xpath = "//li[contains(@class,'pages-item-next')]//a[contains(@class,'next')]/span[text()='Next']")
    @FindBy(css = "li.item.pages-item-next a.action.next")
    private ExtendedWebElement nextButton;

    @FindBy(xpath = "//*[@id=\"toolbar-amount\"]/span[3]")
    private ExtendedWebElement productItemsQuantity;

    @FindBy(xpath = "//*[@id=\"toolbar-amount\"]/span[2]")
    private ExtendedWebElement productItemsQuantityOnPage;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]")
    private ExtendedWebElement toolBar;

    public MenTopsPage(WebDriver driver) {
        super(driver);
    }

    public List<ProductItem> getAllProducts() {
        List<ProductItem> allProducts = new ArrayList<>();
        while (true){
            pause(4);
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
        return Integer.parseInt(productItemsQuantity.getText());
    }

    public Integer getProductItemsOnPageQuantity() {
        return Integer.parseInt(productItemsQuantityOnPage.getText());
    }

    public void clickNextButton() {
        ((JavascriptExecutor) getDriver())
                .executeScript("arguments[0].click();", nextButton.getElement());
    }
}
