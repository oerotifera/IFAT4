package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    private static final By CART_ITEM = By.cssSelector(".cart_item");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public ArrayList<String> getProductsNames() {
        List<WebElement> allProductNames = driver.findElements(CART_ITEM);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProductNames) {
            names.add(product.getText());
        }
        return names;
    }
}