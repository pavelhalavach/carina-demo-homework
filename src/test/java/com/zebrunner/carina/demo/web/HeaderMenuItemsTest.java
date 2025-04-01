package com.zebrunner.carina.demo.web;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.component.ProductItem;
import com.zebrunner.carina.demo.gui.component.HeaderMenuSignOut;
import com.zebrunner.carina.demo.gui.page.HomePage;
import com.zebrunner.carina.demo.gui.page.HeaderMenuItemPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class HeaderMenuItemsTest extends BaseTest {

    @DataProvider(name = "menuCategories")
    public Object[][] menuCategories() {
        return new Object[][]{
                {"ui-id-9"},
                {"ui-id-10"},
                {"ui-id-11"},
                {"ui-id-12"},
                {"ui-id-13"},
                {"ui-id-14"},
                {"ui-id-15"},
                {"ui-id-16"},
                {"ui-id-17"},
                {"ui-id-18"},
                {"ui-id-19"},
                {"ui-id-20"}
        };
    }

    @Test(dataProvider = "menuCategories")
    public void testMenTopsProductsQuantityMatchesExpected(String id) {
        HeaderMenuItemPage headerMenuItemPage = headerMenuSignOut.openCategoryById(id);
        List<ProductItem> products = headerMenuItemPage.getAllProducts();
        Assert.assertEquals(headerMenuItemPage.getProductItemsQuantity(), products.size());
    }

    @Test(dataProvider = "menuCategories")
    public void testMenTopsProductsQuantityOnPageMatchesExpected(String id) {
        HeaderMenuItemPage headerMenuItemPage = headerMenuSignOut.openCategoryById(id);

        Assert.assertEquals(headerMenuItemPage.getProductItemsOnPageQuantity(),
                headerMenuItemPage.getAllProductsOnPage().size());
    }

    @Test(dataProvider = "menuCategories")
    public void testEachMenTopsProductHasNamePriceImage(String id) {
        HeaderMenuItemPage headerMenuItemPage = headerMenuSignOut.openCategoryById(id);

        List<ProductItem> products = headerMenuItemPage.getAllProducts();
        for (ProductItem product : products) {
            Assert.assertFalse(product.getProductName().isEmpty(), "Product name should not be empty");
            Assert.assertFalse(product.getProductImage().isEmpty(), "Product image should not be empty");
            Assert.assertFalse(product.getProductPrice().isEmpty(), "Product price should not be empty");
        }
    }

    @Test(dataProvider = "menuCategories")
    public void testAddToCartButtonPresence(String id) {
        HeaderMenuItemPage headerMenuItemPage = headerMenuSignOut.openCategoryById(id);

        List<ProductItem> products = headerMenuItemPage.getAllProductsOnPage();
        for (ProductItem product : products) {
            Assert.assertTrue(product.isAddToCartButtonPresent(), "Product should has Add to Cart button");
        }
    }
}
