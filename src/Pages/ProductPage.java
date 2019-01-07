package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    public  ProductPage(WebDriver driver) {super(driver);}

    public String getProductName(){
        waitForElementToAppear(nameLabel);
        return nameLabel.getText();
    }

    public Double getPrice(){
        waitForElementToAppear(priceLabel);
        String price = priceLabel.getText();
        price = price.replace(',', '.').substring(0, price.lastIndexOf(' '));
        price.replace(" ", "");

        return Double.parseDouble(price);
    }

    public ProductPage addToCart(Boolean goToCart){
        addToCartButton.click();
        waitForElementToAppear(goToCartButton);

        if (goToCart)
            goToCartButton.click();
        else
            continueShoppingButton.click();

        waitForJQuery();
        return this;
    }

    @FindBy(css = "[itemscope]>div>h1")
    WebElement nameLabel;

    @FindBy(xpath = "//*[@itemscope]/div/div[span[contains(., 'zł')]]")
    WebElement priceLabel;

    @FindBy(id = "add-to-cart-button")
    WebElement addToCartButton;

    @FindBy(id = "add-to-cart-si-precart")
    WebElement goToCartButton;

    @FindBy(xpath = "//button[contains(., 'kontynuuj zakupy')]")
    WebElement continueShoppingButton;
}
