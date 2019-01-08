import Models.Product;
import Pages.ProductPage;
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
        ((ProductPage)productPage.pageValidator.productSelectedMatсhesArticle(productArticle, productItem))

                //step 5
                .addToCart(false);
    }
}
