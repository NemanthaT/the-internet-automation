package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;

/**
 * TC04 - Selecting an option from the dropdown updates the selected value.
 */
public class DropdownTest extends BaseTest {

    @Test(description = "Selecting Option 2 from the dropdown updates the selected value")
    public void testSelectOptionUpdatesDropdown() {
        DropdownPage dropdownPage = new DropdownPage(driver).open();

        dropdownPage.selectOptionByVisibleText("Option 2");

        Assert.assertEquals(dropdownPage.getSelectedOptionText(), "Option 2",
                "Expected 'Option 2' to be selected in the dropdown");
    }
}
