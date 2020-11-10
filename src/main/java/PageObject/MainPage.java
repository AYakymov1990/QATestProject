package PageObject;

import Utils.PageInit;
import Utils.ParsingProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;


public class MainPage extends PageInit {



    private String xpath;
    private String checkCurrency;

    @FindBy(xpath = "//header/nav[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]")
    WebElement dropDownList;

    @FindBy(xpath = "//span[@class = 'price']")
    WebElement priceCurrency;

    public void selectCurrencyОfGoods(String currency) {

        Reporter.log("Click drop down list",true);
        dropDownList.click();
        xpath = String.format("//a[contains(text(),'%s')]", currency);
        WebElement currencyGoods = driver.findElement(By.xpath(xpath));
        Reporter.log("Select currency value",true);
        currencyGoods.click();

    }

    public String checkCurrencyOfGoods() {

        Reporter.log("get text currency value",true);
        checkCurrency = priceCurrency.getText();

        return checkCurrency;

    }


    public MainPage getStoreUrl() {

        Reporter.log("go to the store website",true);
        driver.get(getUrl());
        return this;

    }


    public static String getUrl() {

        return ParsingProperties.getUrl();

    }
}
