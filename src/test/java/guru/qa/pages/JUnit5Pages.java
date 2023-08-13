package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class JUnit5Pages {
    private SelenideElement
            searchBtn = $("#search-dropdown"),
            searchInput = $("#searchbox-input"),
            searchMenu = $("#search-menu");

    public JUnit5Pages openGuidePage() {
        open("/idea/guide/");
        return this;
    }

    public JUnit5Pages setSearch(String input) {
        searchBtn.click();
        searchInput.setValue(input);
        return this;
    }

    public JUnit5Pages checkSearch(String result) {
        searchMenu.shouldHave(text(result));
        return this;
    }
}
