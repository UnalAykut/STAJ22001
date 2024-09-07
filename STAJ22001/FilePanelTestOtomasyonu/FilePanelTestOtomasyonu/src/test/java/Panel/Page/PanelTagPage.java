package Panel.Page;

package com.filemarket.ecta.test.panel;

import com.filemarket.ecta.driver.DriverManager;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PanelTagPage extends AbstractPageObject {

    @FindBy(xpath = "//table//tbody")
    private static WebElement tableBody;

    @FindBy(xpath = "//div[@class='v-data-footer']//div[@class='v-select__slot']")
    private WebElement dataLimitSelect;

    @FindBy(xpath = "//ul[contains(@class,'pagination')]")
    private static WebElement pagination;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    private WebElement productCodeSearchField;

    @FindBy(xpath = "(//input[@type='text'])[3]")
    private WebElement productNameSearchField;

    @FindBy(xpath = "(//td[@class='text-start'])[1]")
    private WebElement firstProductCode;

    @FindBy(xpath = "(//td[@class='text-start'])[2]")
    private WebElement firstProductName;

    @FindBy(xpath = "(//td[@class='text-start'])[3]")
    private WebElement firstProductTag;

    @FindBy(xpath = "(//td[@class='text-start'])[4]")
    private WebElement firstProductCategory;

    @FindBy(xpath = "(//td[@class='text-start'])[5]")
    private WebElement firstProductSubCategory;


    @FindBy(xpath = "(//a[@role='button'])[1]")
    private WebElement editButton;

    public static List<WebElement> getTagList() {
        return tableBody.findElements(By.xpath("//tr[@class]"));
    }

    public static int countRows() {
        return getTagList().size();
    }

    public static void changePage(int value) {
        pagination.findElements(By.tagName("li")).stream()
                .filter(i -> i.getText().equals(String.valueOf(value)))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public List<String> getProductCodeList() {
        return tableBody.findElements(By.tagName("td")).stream()
                .map(WebElement::getText)
                .filter(NumberUtils::isCreatable)
                .toList();
    }

    public void searchByProductCode(String value) {
        productCodeSearchField.sendKeys(value);
    }

    public void searchByProductName(String value) {
        productNameSearchField.sendKeys(value);
    }

    public String getFirstProductCode() {
        return firstProductCode.getText();
    }

    public String getFirstProductName() {
        return firstProductName.getText();
    }

    public String getFirstProductCategoryName() {
        return firstProductCategory.getText();
    }

    public String getFirstProductSubCategoryName() {
        return firstProductSubCategory.getText();
    }

    public String getFirstProductTagName() {
        return firstProductTag.getText();
    }

    public void scrollDown() {
        JavascriptExecutor jsx = (JavascriptExecutor) DriverManager.getWebDriver();
        jsx.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
    }

    public void clickEditButton() {
        editButton.click();
    }


}

