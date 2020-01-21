import POM.DashboardPage;
import POM.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@TestInstance(Lifecycle.PER_CLASS)
public class BaseTest {
    WebDriver driver;
    String nodeURL;

    // POM PAGES
    LoginPage loginPage;
    DashboardPage dashboardPage;
    // CREDENTIALS
    String username;
    String password;
    // TEST DATA
    String baseUrl;
    List<String> projects;
    List<String> issueTypes;

    @BeforeAll
    void setupTestEnvironment() {
        this.username = System.getenv("JIRA_USERNAME");
        this.password = System.getenv("JIRA_PASSWORD");
        this.nodeURL = "https://selenium:" + password + "@seleniumhub.codecool.codecanvas.hu/wd/hub";
        this.baseUrl = "https://jira.codecool.codecanvas.hu/";

        projects = Arrays.asList("TOUCAN", "JETI", "COALA");
        issueTypes = Arrays.asList("Story", "Task", "Bug");
    }

    @BeforeEach
    void setDriver() throws MalformedURLException {
//        // TODO: Drivers util class, getChromeDriver method + other browsers
//        System.setProperty("webdriver.chrome.driver", Util.getDriverPath("chromedriver"));
//        this.driver = new ChromeDriver();

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.LINUX);
        driver = new RemoteWebDriver(new URL(nodeURL), capabilities);
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        navigateTo(baseUrl + loginPage.getUrl());
    }

    @AfterEach
    void quitDriver() {
        driver.quit();
    }

    void navigateTo(String url) {
        driver.get(url);
    }
}
