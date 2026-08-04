package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxesPage;

/**
 * TC03 - Toggling a checkbox flips its checked state.
 * Checkbox 1 starts unchecked, checkbox 2 starts checked on this page.
 */
public class CheckboxesTest extends BaseTest {

    @Test(description = "Toggling checkbox 1 changes its state from unchecked to checked")
    public void testToggleCheckboxChangesState() {
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver).open();

        boolean initialState = checkboxesPage.isChecked(0);
        checkboxesPage.toggle(0);
        boolean newState = checkboxesPage.isChecked(0);

        Assert.assertFalse(initialState, "Expected checkbox 1 to start unchecked");
        Assert.assertTrue(newState, "Expected checkbox 1 to be checked after toggling");
    }
}
