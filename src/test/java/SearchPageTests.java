import Utils.TestInit;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SearchPageTests extends TestInit {


    @Test
    public void sortingPrice(){

        Reporter.log("Test sortingPrice started",true);
        initSearchPage()
               .getStoreUrl()
                .searchInCatalog("dress","USD");
        Assert.assertEquals(initSearchPage().actualPriceOfGoods(),initSearchPage().sortingPrice());
    }

    @Test
    public void checkingCorrectnessDiscount(){

        Reporter.log("Test checkingCorrectnessDiscount started",true);
        Assert.assertEquals(initSearchPage().checkingCorrectnessDiscount(0.76, 20),
                initSearchPage().actualPriceDiscount("0,61"));





    }
}
