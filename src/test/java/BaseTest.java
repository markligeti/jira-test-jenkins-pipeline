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
    // test 008
    DesiredCapabilities capabilities;
    WebDriver driver;
    String gridURL;
    Platform platform;
    String browser;
    int timeout;

    // CREDENTIALS
    String username;
    String password;

    // POM PAGES
    LoginPage loginPage;
    DashboardPage dashboardPage;

    // TEST DATA
    String baseUrl;
    List<String> projects;
    List<String> issueTypes;

    @BeforeAll
    void setupTestEnvironment() {
        this.username = System.getenv("JIRA_USERNAME");
        this.password = System.getenv("JIRA_PASSWORD");
        this.baseUrl = System.getenv("JIRA_BASE_URL");
        this.gridURL = System.getenv("JIRA_GRID_URL");
        this.browser = System.getenv("BROWSER");
        this.platform = Platform.fromString(
                System.getenv("PLATFORM")
        );
        this.setCapabilities();

        projects = Arrays.asList("TOUCAN", "JETI", "COALA");
        issueTypes = Arrays.asList("Story", "Task", "Bug");
    }

    private void setCapabilities() {
        capabilities = new DesiredCapabilities();
//        capabilities.setCapability("max_duration", timeout);
        capabilities.setBrowserName(browser);
        capabilities.setPlatform(platform);
        capabilities.setVersion("");
    }

    @BeforeEach
    void setDriver() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL(gridURL), capabilities);
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
