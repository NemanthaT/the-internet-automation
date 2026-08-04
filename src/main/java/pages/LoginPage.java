package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By flashMessage = By.id("flash");
    private final By pagePath = By.cssSelector("body");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get(utils.ConfigReader.getBaseUrl() + "/login");
        return this;
    }

    public void login(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
    }

    public String getFlashMessage() {
        return getText(flashMessage);
    }

    public boolean isOnLoginPage() {
        return driver.getCurrentUrl().endsWith("/login");
    }

    public boolean isOnSecureArea() {
        return driver.getCurrentUrl().contains("/secure");
    }
}
