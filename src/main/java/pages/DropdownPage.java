package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

    private final By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public DropdownPage open() {
        driver.get(utils.ConfigReader.getBaseUrl() + "/dropdown");
        return this;
    }

    public void selectOptionByVisibleText(String text) {
        Select select = new Select(waitForVisible(dropdown));
        select.selectByVisibleText(text);
    }

    public String getSelectedOptionText() {
        Select select = new Select(waitForVisible(dropdown));
        return select.getFirstSelectedOption().getText();
    }
}
