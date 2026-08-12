package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;

/**
 * TC05 - Clicking Start waits out the loading spinner and reveals the
 * "Hello World!" text. This is the scenario used for the debugging
 */
public class DynamicLoadingTest extends BaseTest {

    @Test(description = "Start button reveals Hello World text after loading completes")
    public void testDynamicLoadingRevealsText() {
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver).openExample1();

        dynamicLoadingPage.clickStart();
        String finishText = dynamicLoadingPage.waitForFinishText();

        Assert.assertEquals(finishText, "Hello World!",
                "Expected 'Hello World!' to appear after loading finished");
    }
}
