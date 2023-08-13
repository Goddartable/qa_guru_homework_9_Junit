package guru.qa.tests;

import guru.qa.pages.JUnit5Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class WritingJUnit5Tests extends TestBase {
    JUnit5Pages jUnit5Page = new JUnit5Pages();

    @CsvFileSource(resources = "/Data4parameterizedTest.csv")
    @DisplayName("Проверка поиска на сайте jetbrains.com с помощью @CsvFileSource")
    @ParameterizedTest(name = "При поиске {0} в результатах отображается текст {1}")
    void SearchWritingJunit5GuideCsvFileSource(String input, String result) {
        jUnit5Page
                .openGuidePage()
                .setSearch(input)
                .checkSearch(result);
    }

    @CsvSource(value = {
            "Source | Creating a Data Source",
            "Create | In the Database View, create a data source for our database"
    }, delimiter = '|')
    @DisplayName("Проверка поиска на сайте jetbrains.com с помощью @CsvSource")
    @ParameterizedTest(name = "При поиске {0} в результатах отображается текст {1}")
    void SearchWritingJunit5GuideCsvSource(String input, String result) {
        jUnit5Page
                .openGuidePage()
                .setSearch(input)
                .checkSearch(result);
    }

    static Stream<Arguments> jetbrainsSiteStreamSearchTest() {
        return Stream.of(
                Arguments.of("Add Breakpoint"),
                Arguments.of("Search Everywhere")
        );
    }

    @MethodSource(value = "jetbrainsSiteStreamSearchTest")
    @DisplayName("Проверка поиска на сайте jetbrains.com с помощью @MethodSource")
    @ParameterizedTest(name = "При поиске {0} в результатах отображается текст {0}")
    void SearchJunit5LocaleMethodSource(String input) {
        jUnit5Page
                .openGuidePage()
                .setSearch(input)
                .checkSearch(input);
    }

}
