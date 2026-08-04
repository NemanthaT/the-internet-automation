package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

/**
 * TC02 - Invalid credentials are rejected with an error message,
 * and the user stays on the login page.
 */
public class InvalidLoginTest extends BaseTest {

    @Test(description = "User attempts login with an invalid password and sees an error")
    public void testInvalidLoginShowsErrorMessage() {
        LoginPage loginPage = new LoginPage(driver).open();

        loginPage.login("tomsmith", "wrongPassword");

        Assert.assertTrue(loginPage.isOnLoginPage(),
                "Expected to remain on /login after invalid credentials");
        Assert.assertTrue(loginPage.getFlashMessage().contains("Your password is invalid"),
                "Expected invalid-password error message not shown");
    }
}
