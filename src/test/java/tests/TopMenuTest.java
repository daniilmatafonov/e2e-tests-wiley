package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;

import java.util.List;

import static helpers.TestData.expectedWhoWeServerItems;

public class TopMenuTest extends BaseTest{

    private static final String WHO_WE_SERVE = "WHO WE SERVE";
    private final MainPage mainPage = new MainPage();

    @Test
    public void checkWhoWeServeItemsHasExactElements() {
        mainPage.openMainSitePage();
        final List<String> items = mainPage.getWhoWeServeItems(WHO_WE_SERVE);
        mainPage.validateItemsCount(items, expectedWhoWeServerItems());
    }


}
