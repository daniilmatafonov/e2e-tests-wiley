package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static helpers.TestData.expectedWhoWeServerItems;
import static helpers.TestData.printExpectedItems;

public class MainPage {

    @Step("Open Wiley main site page")
    public void openMainSitePage() {
        open("/");
    }

    @Step("Check Who We Serve has items: Students, Instructors, Book Authors, Professionals, Researchers, Institutions, Librarians, Corporations, Societies, Journal Editors, Bookstores, Government")
    public List<String> getWhoWeServeItems(final String name) {
        SelenideElement whoWeServeItem = $x("//a[contains(text(),'" + name + "')]");
        actions().moveToElement(whoWeServeItem).click().build().perform();
        final ElementsCollection items = $$("#Level1NavNode1 > ul li");
        final List<String> result = items.stream().map(WebElement::getText).collect(Collectors.toList());
        return result;
    }

    @Step("Validate items")
    public boolean validateItemsCount(List<String> elements, Set expected) {
        return elements.containsAll(expected);
    }
}
