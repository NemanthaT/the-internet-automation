package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

/**
 * TC01 - Valid login redirects to the secure area.
 */
public class ValidLoginTest extends BaseTest {

    @Test(description = "User logs in with valid credentials and reaches the secure area")
    public void testValidLoginRedirectsToSecureArea() {
        LoginPage loginPage = new LoginPage(driver).open();

        loginPage.login("tomsmith", "SuperSecretPassword!");

        Assert.assertTrue(loginPage.isOnSecureArea(),
                "Expected to land on /secure after valid login, but was on: " + driver.getCurrentUrl());
        Assert.assertTrue(loginPage.getFlashMessage().contains("You logged into a secure area"),
                "Expected success flash message not shown");
    }
}
