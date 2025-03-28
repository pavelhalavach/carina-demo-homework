package com.zebrunner.carina.demo.web;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.component.ProductItem;
import com.zebrunner.carina.demo.gui.component.TopMenuSignOut;
import com.zebrunner.carina.demo.gui.page.HomePage;
import com.zebrunner.carina.demo.gui.page.MenTopsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class MenTopsTest implements IAbstractTest {
    private TopMenuSignOut topMenuSignOut;

    @BeforeMethod
    public void setUp() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "HomePage is not opened");

        topMenuSignOut = homePage.getTopMenuSignOut();
        topMenuSignOut.assertUIObjectPresent();
    }

    @Test
    public void testMenTopsProductsQuantityMatchesExpected() {
        Assert.assertTrue(topMenuSignOut.isMenTopsDisplayed(), "MenTops is not displayed");
        MenTopsPage menTopsPage = topMenuSignOut.openMenTopsPage();
        List<ProductItem> products = menTopsPage.getAllProducts();
        Assert.assertEquals(menTopsPage.getProductItemsQuantity(), products.size());
    }

    @Test
    public void testMenTopsProductsQuantityOnPageMatchesExpected(){
        Assert.assertTrue(topMenuSignOut.isMenTopsDisplayed(), "MenTops is not displayed");
        MenTopsPage menTopsPage = topMenuSignOut.openMenTopsPage();

        Assert.assertEquals(menTopsPage.getProductItemsOnPageQuantity(),
                menTopsPage.getAllProductsOnPage().size());
    }

    @Test
    public void testEachMenTopsProductHasNamePriceImage(){
        Assert.assertTrue(topMenuSignOut.isMenTopsDisplayed(), "MenTops is not displayed");
        MenTopsPage menTopsPage = topMenuSignOut.openMenTopsPage();

        List<ProductItem> products = menTopsPage.getAllProducts();
        for (ProductItem product : products) {
            Assert.assertFalse(product.getProductName().isEmpty(), "Product name should not be empty");
            Assert.assertFalse(product.getProductImage().isEmpty(), "Product image should not be empty");
            Assert.assertFalse(product.getProductPrice().isEmpty(), "Product price should not be empty");
        }
    }

    @Test
    public void testAddToCartButtonPresence() {
        Assert.assertTrue(topMenuSignOut.isMenTopsDisplayed(), "MenTops is not displayed");
        MenTopsPage menTopsPage = topMenuSignOut.openMenTopsPage();

        List<ProductItem> products = menTopsPage.getAllProductsOnPage();
        for (ProductItem product : products) {
            Assert.assertTrue(product.isAddToCartButtonPresent(), "Product should has Add to Cart button");
        }
    }
}
