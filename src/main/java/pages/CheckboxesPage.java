package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxesPage extends BasePage {

    private final By checkboxes = By.cssSelector("#checkboxes input[type='checkbox']");

    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }

    public CheckboxesPage open() {
        driver.get(utils.ConfigReader.getBaseUrl() + "/checkboxes");
        return this;
    }

    public List<WebElement> getCheckboxes() {
        waitForVisible(checkboxes);
        return driver.findElements(checkboxes);
    }

    public void toggle(int index) {
        getCheckboxes().get(index).click();
    }

    public boolean isChecked(int index) {
        return getCheckboxes().get(index).isSelected();
    }
}
