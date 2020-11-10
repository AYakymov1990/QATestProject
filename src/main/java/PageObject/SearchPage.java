package PageObject;

import Utils.PageInit;
import Utils.ParsingProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class SearchPage extends PageInit {




    List<String> price = new ArrayList<String>();
    private String xpath;
    private Double payment;


    @FindBy(xpath = "//input[@class = 'ui-autocomplete-input']")
    WebElement seachInCatalog;

    @FindBy(xpath = "//a[@class = 'select-title']")
    WebElement sortingDropDownList;

    @FindBy(xpath = "//a[contains(text(),'Цене: от высокой к низкой')]")
    WebElement criterionFromHighToLow;

    @FindBy(xpath = "//header/nav[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]")
    WebElement dropDownList;

    public void searchInCatalog(String goods, String currency) {

        Reporter.log("Click on dropDownList Currency");
        dropDownList.click();
        xpath = String.format("//a[contains(text(),'%s')]", currency);
        WebElement currencyGoods = driver.findElement(By.xpath(xpath));
        currencyGoods.click();
        Reporter.log("Send in input Name of product",true);
        seachInCatalog.sendKeys(goods);
        Reporter.log("Click Enter",true);
        seachInCatalog.sendKeys(Keys.ENTER);
    }

    public List<String> sortingPrice() {

        Reporter.log("Click Sorting Drop Down list",true);
        sortingDropDownList.click();
        Reporter.log("Select High to low option",true);
        criterionFromHighToLow.click();
        Reporter.log("Add to list sorting price of goods",true);
        List<WebElement> priceGoods = driver.findElements(By.xpath("//span[@class='price']"));
        priceGoods.stream().map(WebElement::getText).forEach(price::add);
        price.sort(Comparator.reverseOrder());

        return price;

    }

    public List<String> actualPriceOfGoods(){

        List<String> actualPrice = new ArrayList<>();
        actualPrice.add("1,90 $");
        actualPrice.add("1,14 $");
        actualPrice.add("1,08 $");
        actualPrice.add("1,00 $");
        actualPrice.add("0,97 $");
        actualPrice.add("0,61 $");
        actualPrice.add("0,61 $");

        return actualPrice;
    }

    public String checkingCorrectnessDiscount(Double priceBeforeDiscount,int amountOfDiscount){

        Reporter.log("Checking Correctness Discount of goods",true);
        payment = priceBeforeDiscount - priceBeforeDiscount * amountOfDiscount / 100;
        String result = String.format("%.2f",payment);

        return result;

    }

    public String actualPriceDiscount(String actualPrice){

        return  actualPrice;
    }


    public SearchPage getStoreUrl() {

        Reporter.log("go to the store website",true);
        driver.get(getUrl());
        return this;

    }

    public static String getUrl() {

        return ParsingProperties.getUrl();

    }


}
