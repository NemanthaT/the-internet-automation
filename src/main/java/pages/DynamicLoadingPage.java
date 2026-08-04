package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingPage extends BasePage {

    private final By startButton = By.cssSelector("#start button");
    private final By finishText = By.id("finish");
    private final By loadingIndicator = By.id("loading");

    // The #loading element is never removed from the DOM — the page only
    // toggles its CSS display style. Waiting for it to be absent
    // (findElements().isEmpty()) can never succeed; waiting for invisibility
    // is the correct condition. Kept as its own longer timeout since the
    // spinner runs ~5s by design plus browser/JS overhead.
    private static final Duration DYNAMIC_LOAD_TIMEOUT = Duration.ofSeconds(20);

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    public DynamicLoadingPage openExample1() {
        driver.get(utils.ConfigReader.getBaseUrl() + "/dynamic_loading/1");
        return this;
    }

    public void clickStart() {
        click(startButton);
    }

    /** Waits out the loading spinner, then returns the text that appears. */
    public String waitForFinishText() {
        WebDriverWait longWait = new WebDriverWait(driver, DYNAMIC_LOAD_TIMEOUT);
        longWait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIndicator));
        return getText(finishText);
    }
}