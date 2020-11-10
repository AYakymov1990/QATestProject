package Utils;

import Drivers.DriverFactory;
import PageObject.MainPage;
import PageObject.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class TestInit {

    protected static WebDriver driver;

    @BeforeMethod
    public void beforeTestRun() throws IOException {

        ParsingProperties.parsingProperties();
        Reporter.log("Browser Open",true);
        driver = DriverFactory.getDriver();

    }

    public static ParsingProperties initProperties() {

        return new ParsingProperties();

    }

    public static MainPage initMainPage() {

        return new MainPage();

    }

    public static SearchPage initSearchPage(){

        return new SearchPage();

    }

    @AfterMethod
    public void afterTest() {

        Reporter.log("Test ended",true);
        DriverFactory.closeBrowser();
        Reporter.log("Browser closed",true);

    }

}
