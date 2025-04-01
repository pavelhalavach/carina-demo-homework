package com.zebrunner.carina.demo.web;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.crypto.Algorithm;
import com.zebrunner.carina.crypto.CryptoTool;
import com.zebrunner.carina.crypto.CryptoToolBuilder;
import com.zebrunner.carina.demo.gui.component.HeaderMenuSignOut;
import com.zebrunner.carina.demo.gui.page.CustomerLoginPage;
import com.zebrunner.carina.demo.gui.page.HomePage;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest {

    @Test()
    public void testSignInWithValidCredentials() {
        CustomerLoginPage customerLoginPage = headerMenuSignOut.openCustomerLoginPage();
        customerLoginPage.typeEmail("test5@test.com");
        String password = "Password123";
        customerLoginPage.typePassword(password);

        CryptoTool cryptoTool = CryptoToolBuilder.builder()
                .setKey(R.CONFIG.get("crypto_key_value"))
                .chooseAlgorithm(Algorithm.AES_ECB_PKCS5_PADDING)
                .build();

        String encryptedPass = cryptoTool.encrypt(password);
        Assert.assertEquals(cryptoTool.decrypt(encryptedPass), password);

        HomePage homePage = customerLoginPage.clickSignInExpectingSuccess();
        Assert.assertTrue(homePage.isPageOpened(), "MyAccountPage is not opened");
    }

    @Test()
    public void testSignInWithInvalidCredentials(){
        CustomerLoginPage customerLoginPage = headerMenuSignOut.openCustomerLoginPage();
        customerLoginPage.typeEmail("test5@test.com");
        customerLoginPage.typePassword("Password1234");

        CustomerLoginPage customerLoginPageWithError = customerLoginPage.clickSignInExpectingFailure();
        Assert.assertTrue(customerLoginPageWithError.isIncorrectSignInMessage(),
                "Incorrect sign in message");
    }

    @Test()
    public void testSignInWithInvalidEmailFormat(){
        CustomerLoginPage customerLoginPage = headerMenuSignOut.openCustomerLoginPage();
        customerLoginPage.typeEmail("asd");
        customerLoginPage.typePassword("Password1234");

        CustomerLoginPage customerLoginPageWithError = customerLoginPage.clickSignInExpectingFailure();
        Assert.assertTrue(customerLoginPageWithError.getInvalidEmailErrorMessage(),
                "Incorrect sign in message");
    }

    @Test()
    public void testSignInWithEmptyPassword(){
        CustomerLoginPage customerLoginPage = headerMenuSignOut.openCustomerLoginPage();
        customerLoginPage.typeEmail("test5@test.com");
        customerLoginPage.typePassword("");

        CustomerLoginPage customerLoginPageWithError = customerLoginPage.clickSignInExpectingFailure();
        Assert.assertTrue(customerLoginPageWithError.isEmptyPasswordErrorMessage(),
                "Incorrect sign in message");
    }

}
