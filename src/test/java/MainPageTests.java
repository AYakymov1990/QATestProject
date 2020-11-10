import PageObject.MainPage;
import Utils.ParsingProperties;
import Utils.TestInit;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MainPageTests extends TestInit {

    @Test
    public void getUrl() {

        Reporter.log("Test getUrl started" ,true );
        initMainPage()
                .getStoreUrl();
        Assert.assertEquals("http://prestashop-automation.qatestlab.com.ua/ru/", driver.getCurrentUrl());
    }

    @Test
    public void selectCurrencyОfGoods() {

        Reporter.log("Test selectCurrencyOfGoods started",true);
        initMainPage()
                .getStoreUrl()
                .selectCurrencyОfGoods("USD");
        Assert.assertEquals(initMainPage().checkCurrencyOfGoods(), "0,61 $");


    }
}
