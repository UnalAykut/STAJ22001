package Panel.Page;


import com.filemarket.ecta.driver.DriverManager;
import com.filemarket.ecta.util.Utils;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.filemarket.ecta.util.Constants.GLOBAL_TIME_OUT;

@Getter
public class PanelCategoryPage extends AbstractPageObject {

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/ul")
    private WebElement pagination;

    @FindBy(xpath = "//tr[2]/td[3]")
    private WebElement DATA_TABLE_FIRST_CATEGORY_NAME_XPATH;

    @FindBy(xpath = "//tr[3]/td[3]")
    private WebElement DATA_TABLE_SECOND_CATEGORY_NAME_XPATH;

    @FindBy(xpath = "//table//tbody/tr[not(@class)]")
    private WebElement tableFilter;

    @FindBy(xpath = "(//tbody)[2]")
    private WebElement innerTableBody;

    @FindBy(xpath = "(//table)[2]//th")
    private List<WebElement> innerTableHeaders;

    @FindBy(xpath = "//p")
    private List<WebElement> subCategories;

    @FindBy(xpath = "//tr[2]")
    private WebElement sourceElement;

    @FindBy(xpath = "//tr[3]")
    private WebElement targetElement;

    @FindBy(xpath = "//div[@aria-labelledby='swal2-title']//h2")
    private static WebElement afterTransactionPopUpMessage;

    @FindBy(xpath = "//button[contains(text(),'Kaydet')]")
    WebElement saveButton;

    @FindBy(xpath = "//div[@class='v-card__actions']//button[contains(text(),'Devam Et')]")
    private static WebElement continueButtonOnPopup;

    @FindBy(xpath = "//div[contains(text(),'Durum')]/following-sibling::div//label/span")
    WebElement statusSlider;

    @FindBy(xpath = "//div[contains(text(),'Durum')]/following-sibling::div//label/input")
    WebElement statusInput;

    @FindBy(xpath = "(//i[@class='far fa-edit'])[1]")
    private WebElement firstEditButton;

    @FindBy(xpath = "//table//tr/td/input[@type='text']")
    private WebElement searchNameCategoryField;

    @FindBy(xpath = "//button[contains(@class, 'mdi-chevron-down')]")
    private WebElement subCategoryDropdown;

    @FindBy(xpath = "//tr[1]//a[contains(@class, 'btn-icon')]/i[contains(@class, 'fa-edit')]")
    private WebElement editSubCategory;

    @FindBy(xpath = "//a[@class='remove-image' and text()='−']")
    private WebElement removeImageButton;

    @FindBy(xpath = "//input[@class='btn-custom-upload']")
    private WebElement categoryImageInputField;


    public void changePageNumber(int value) {
        var selectPage = pagination.findElements(By.className("page-link")).stream()
                .filter(i -> i.getText().equals(String.valueOf(value)))
                .findAny()
                .orElseThrow();

        selectPage.click();
    }

    public String getCategoryName() {
        return DATA_TABLE_FIRST_CATEGORY_NAME_XPATH.getText();
    }

    public void scrollDown() {
        JavascriptExecutor jsx = (JavascriptExecutor) DriverManager.getWebDriver();
        jsx.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
    }

    public WebElement selectIconButton(int randomNumber) {
        return tableFilter.findElement(
                By.xpath("(//button[@type='button'])[" + randomNumber + "]"));
    }

    public WebElement selectCategoryName(int randomNumber) {
        Utils.waitFor(2);
        return tableFilter.findElement(
                By.xpath("//tr[" + randomNumber + "]/td[3]"));
    }

    public List<WebElement> subCategories() {
        Utils.waitFor(2);
        return subCategories;
    }

    public List<String> getInnerColumnData(String filterColumn) {
        Utils.waitForVisibility(By.xpath("//tr"), GLOBAL_TIME_OUT);
        List<WebElement> filterOutput = innerTableBody.findElements(
                By.xpath("./tr/td[position()='" + getInnerTableHeaderIndex(filterColumn) + "']"));

        List<String> outputList = new ArrayList<>();
        if (filterOutput.size() != 0) {
            if (!filterOutput.get(0).getText().isEmpty()) {
                outputList = filterOutput.stream().map(WebElement::getText).toList();
            } else {
                outputList = filterOutput.stream().
                        map(i -> i.findElement(By.xpath("./*")).getText().trim()).toList();
            }
        }
        return outputList;
    }

    public int getInnerTableHeaderIndex(String label) {
        Utils.waitFor(3);
        for (int i = 0; i < innerTableHeaders.size(); i++) {
            if (innerTableHeaders.get(i).getText().contains(label)) {
                return i + 1;
            }
        }
        return -1;
    }

    public void setCategoryStatus(String status) {
        Utils.scrollDown(DriverManager.getWebDriver(), 600);
        Utils.waitFor(2);
        Utils.waitForVisibility(statusSlider, 5);
        if (status.equalsIgnoreCase("active")) {
            System.out.println("Status before action: " + statusInput.isSelected());
            if (!statusInput.isSelected()) {
                statusSlider.click();
                Utils.waitFor(2);
                System.out.println("Status after action: " + statusInput.isSelected());
            }
        } else if (status.equalsIgnoreCase("passive")) {
            System.out.println("Status before action: " + statusInput.isSelected());
            if (statusInput.isSelected()) {
                statusSlider.click();
                Utils.waitFor(2);
                System.out.println("Status after action: " + statusInput.isSelected());
            }
        }
    }

    public void dragAndDrop() {
        Utils.waitFor(2);
        dragAndDrop(sourceElement, targetElement);
    }

    public void clickSaveButton() {
        Utils.waitForVisibility(saveButton, 5);
        saveButton.click();
        Utils.waitFor(2);
    }

    public void clickContinueButton() {
        Utils.waitForVisibility(continueButtonOnPopup, 5);
        continueButtonOnPopup.click();
        Utils.waitFor(2);
    }

    public void verifyTheSuccessMessage(String transaction) {
        Utils.waitForVisibility(afterTransactionPopUpMessage, 10);
        if (transaction.equalsIgnoreCase("update")) {
            Assert.assertEquals(afterTransactionPopUpMessage.getText().trim(), "Kategori bilgisi güncellendi!");
        }
    }

    public void firstEditCategory() {
        firstEditButton.click();
    }

    public void searchByCategoryName(String name) {
        searchNameCategoryField.clear();
        searchNameCategoryField.sendKeys(name);
    }


    public void editSubCategory() {
        subCategoryDropdown.click();
        editSubCategory.click();
    }

    public void deleteCategoryImage() {
        Utils.scrollDown();
        Utils.waitFor(2);
        Utils.clickWithJS(removeImageButton);
        Utils.waitFor(2);

    }

    public void addCategoryImage(String imagePath) {
        Utils.scrollDown();
        Utils.waitFor(2);
        categoryImageInputField.sendKeys(imagePath);
        Utils.waitFor(2);
    }


}

