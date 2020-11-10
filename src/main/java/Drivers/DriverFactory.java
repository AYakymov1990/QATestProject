package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static final String CHROME = "chrome";
    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            Path path = FileSystems.getDefault().getPath("src/main/resources/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", path.toString());
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeBrowser() {
        if (driver == null) {
            return;
        }
        driver.quit();
        driver = null;
    }
}
