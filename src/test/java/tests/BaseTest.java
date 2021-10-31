package tests;

import com.codeborne.selenide.Configuration;
import configuration.IConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class BaseTest {

    public static final IConfig CONFIG = ConfigFactory.create(IConfig.class, System.getProperties());
    private static final String ALLURE_SELENIDE_LISTENER_NAME = "AllureSelenide";

    @BeforeAll
    static void setup() {
        addListener(ALLURE_SELENIDE_LISTENER_NAME, new AllureSelenide().screenshots(true).savePageSource(true));
        if (CONFIG.env() != null) {
            Configuration.browser = CONFIG.browser();
            Configuration.baseUrl = CONFIG.url();
        }
    }

    @AfterEach
    public void afterEach() {
        closeWebDriver();
    }
}
