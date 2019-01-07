import Models.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasketTest extends BaseTest {

    @Test
    public void basketTest() throws Throwable {

        //Step 1
        homePage.closeAgreementPopup()
                //Step 2
                .navigateToRandomCategory("dzialy");

        //Step 3
        Product productArticle = productsListPage.SelectRandomProductArticle();

        //Step 4
        Product productItem = new Product();
        productItem.setName(productPage.getProductName()).setPrice(productPage.getPrice());
        Assert.assertEquals(productArticle.name, productItem.name);

        //Step 5
        productPage.addToCart(false);

    }
}
