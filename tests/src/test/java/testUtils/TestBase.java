package testUtils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.DriverSupport;

public abstract class TestBase {
    protected WebDriver driver;

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser", "url"})
    public void setUp(String browser, String url) {
        System.setProperty("webdriver.gecko.driver", "C:/opts/geckodriver-v0.25.0-win64/geckodriver.exe");
        DriverSupport driverSupport = new DriverSupport();
        driver = driverSupport.initDriver(browser);
        driver.get(url);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
