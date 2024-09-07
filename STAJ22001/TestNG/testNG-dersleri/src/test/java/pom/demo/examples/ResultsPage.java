package pom.demo.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultsPage {

    private WebDriver driver;
    private By productList = By.cssSelector(".list-ul .column");
    private By addBasket=By.xpath( "//*[@id=\"unfDetailForm\"]/div[2]/div[2]/div[1]/button" );
    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Ürün listesini döndüren metot
    public List<WebElement> productsList(){
        return driver.findElements(productList);
    }

    // Belirli bir ürün öğesine tıklayan metot
    public void clickProduct(int index) {
        List<WebElement> products = productsList();
        if (index < products.size()) {
            WebElement product = products.get(index);
            WebElement link = product.findElement(By.cssSelector("a.plink"));
            link.click();
        } else {
            throw new IndexOutOfBoundsException("Geçersiz ürün indeksi: " + index);
        }
    }

    public  void addBasketTest(){
        driver.findElement( addBasket ).click();
    }
}
