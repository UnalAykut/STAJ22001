import Panel.Page.AbstractPageObject;
import com.filemarket.ecta.util.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

    public class PanelStorePage extends AbstractPageObject {
        @FindBy(xpath = "//a[starts-with(@href, '#/stores/detail/F')]")
        private WebElement storeName;

        @FindBy(xpath = "//table//tr/td[2]/input[@type='text']")
        private WebElement cityFilterField;

        @FindBy(xpath = "//table//tr/td[3]/input[@type='text']")
        private WebElement districtFilterField;


        public void changePageNumber(int value) {
            WebElement selectPage = pagination.stream()
                    .filter(button -> button.getText().equals(String.valueOf(value)))
                    .findFirst()
                    .orElseThrow();
            selectPage.click();
        }
        public void clickStoreName() {
            storeName.click();
        }
        public void filterStatusActive() {
            pageStatusBar.click();
            activeStatus.click();
        }

        public void filterCity(String value){
            cityFilterField.sendKeys(value);
        }

        public void filterDistrict(String value){
            districtFilterField.sendKeys(value);
        }

        public List<String> getCityNameList() {
            int cityColumnIndex = getCityColumnIndex();
            List<WebElement> cityElements = tableBody.findElements(By.xpath("./tr/td[" + cityColumnIndex + "]"));

            cityElements.forEach(element -> System.out.println("Bulunan şehir: " + element.getText()));

            return cityElements.stream()
                    .map(WebElement::getText)
                    .filter(city -> !city.trim().isEmpty()) // Boş olanları filtrele
                    .toList();
        }