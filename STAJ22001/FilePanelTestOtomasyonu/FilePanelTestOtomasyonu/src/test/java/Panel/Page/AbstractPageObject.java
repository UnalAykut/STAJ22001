package Panel.Page;

package com.filemarket.ecta.page.panel;

import com.filemarket.ecta.driver.DriverManager;
import com.filemarket.ecta.util.Utils;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;


import static com.filemarket.ecta.config.ConfigurationManager.configuration;
import static com.filemarket.ecta.util.Utils.*;
import static org.openqa.selenium.support.PageFactory.initElements;
import static com.filemarket.ecta.util.Constants.GLOBAL_TIME_OUT;

@Log4j2
public class AbstractPageObject {


    @FindBy(xpath = "//span[text()='Dashboard']/ancestor::a")
    private static WebElement dashboardMenu;


    @FindBy(xpath = "//table//tbody")
    private static WebElement tableBody;
    @FindBy(xpath = "//table//th")
    private static List<WebElement> tableHeaders;
    @FindBy(xpath = "//i[text()='search']/parent::div/parent::div/preceding-sibling::div/input")
    private static WebElement generalSearchInput;
    @FindBy(xpath = "//table//tbody/tr[not(@class)]")
    private static WebElement tableFilter;
    @FindBy(xpath = "//div[@class='v-data-footer']//div[@class='v-select__slot']")
    private static WebElement dataLimitSelect;
    @FindBy(xpath = "//div[@role='listbox']")
    private static WebElement dataLimitList;
    @FindBy(xpath = "//div[@class='v-data-footer']//ul[contains(@class,'pagination')]")
    private static WebElement pagination;
    @FindBy(xpath = "//ul[@aria-label='Pagination']")
    private static WebElement pagination1;
    @FindBy(xpath = "(//button[normalize-space()='Tamam'])[1]")
    private static WebElement popupButton;


    private static Actions actions = new Actions(DriverManager.getWebDriver());


    protected AbstractPageObject() {
        initElements(new AjaxElementLocatorFactory(DriverManager.getWebDriver(), configuration().timeout()), this);
    }

    public static void waitNavigationBar() {
        elementDisplayed(dashboardMenu);
    }


    public void refreshPage() {
        Utils.refreshThePage();
    }

    public static void elementDisplayed(WebElement webElement) {
        Utils.waitForVisibility(webElement, 12);
        Assert.assertTrue(webElement.isDisplayed());
        log.info(webElement.getTagName() + " is displaying");
    }

    public static boolean isElementDisplayed(WebElement webElement) {
        Utils.waitForVisibility(webElement, 10);
        return webElement.isDisplayed();
    }

    public static void doubleClick(WebElement element) {
        highlightElement(element);
        new Actions(DriverManager.getWebDriver()).doubleClick(element).build().perform();
    }

    public static void elementNotDisplayed(WebElement webElement) {
        Utils.waitForInvisibilityOf(webElement);
        try {
            Assert.assertFalse(webElement.isDisplayed());
            log.info("WebElement is not displaying");
        } catch (NoSuchElementException exception) {
            log.info("WebElement is displaying");
        }
    }

    public static void performKeyboardAction(Keys keys) {
        Actions actions = new Actions(DriverManager.getWebDriver());
        actions.keyDown(keys)
                .perform();
        waitFor(1);
    }

    public static void fillInput(WebElement element, String text) {
        element.clear();
        Utils.sendKeys(element, text);
    }


    public static void copyValueByMouseKeyboardAction(WebElement webElement) {
        actions.doubleClick(webElement)
                .pause(2000)
                .keyDown(Keys.CONTROL)
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .pause(2000)
                .perform();
    }

    public static void pasteValueByMouseKeyboardAction(WebElement webElement) {

        actions.doubleClick(webElement)
                .pause(2000)
                .keyDown(Keys.CONTROL)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .pause(2000)
                .perform();
    }

    public static void changeDataLimit(int value) {
        dataLimitSelect.click();
        List<WebElement> dataLimitTitles = dataLimitList.
                findElements(By.xpath(".//*[@class='v-list-item__title']"));
        Utils.waitForClickablility(dataLimitTitles.get(0));
        dataLimitTitles.stream()
                .filter(item -> item.getText().equals(String.valueOf(value)))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public static void changePage(int value) {
        pagination.findElements(By.tagName("li")).stream()
                .filter(i -> i.getText().equals(String.valueOf(value)))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public static void changePage1(int value) {
        pagination1.findElements(By.tagName("li")).stream()
                .filter(i -> i.getText().equals(String.valueOf(value)))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public static List<WebElement> getTableList() {
        return tableBody.findElements(By.xpath("./tr[@class]"));
    }

    public static int countRows() {
        return getTableList().size();
    }

    public static int getTableHeaderIndex(String label) {
        Utils.waitFor(3);
        for (int i = 0; i < tableHeaders.size(); i++) {
            if (tableHeaders.get(i).getAttribute("aria-label").contains(label)) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void searchByAnyInput(String filterColumn, String filterValue) {
        WebElement filterInput = tableFilter.findElement(
                By.xpath("./td[position()='" + getTableHeaderIndex(filterColumn) + "']/*"));
        filterInput.click();
        filterInput.sendKeys(filterValue);
    }

    public static void searchByAnySelectListOption(String filterColumn, String filterValue) {
        WebElement selectBox = tableFilter.findElement(
                By.xpath("./td[position()='" + getTableHeaderIndex(filterColumn) + "']/*"));
        selectBox.click();
        Select select = new Select(selectBox);
        select.selectByVisibleText(filterValue);
        selectBox.click();
    }

    public static List<String> getColumnData(String filterColumn) {
        Utils.waitForVisibility(By.xpath("//tr[@class]"), GLOBAL_TIME_OUT);
        List<WebElement> filterOutput = tableBody.findElements(
                By.xpath("./tr[@class]/td[position()='" + getTableHeaderIndex(filterColumn) + "']"));
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

    public static String getRandomDataFromColumn(String filterColumn) {
        Random random = new Random();
        List<String> randomizedList = getColumnData(filterColumn);
        String filterValue;
        do {
            filterValue = randomizedList.get(random.nextInt(randomizedList.size()));
        } while (filterValue.equals("-") || filterValue.isEmpty());
        return filterValue;
    }

    public static String getRandomDataFromSelectList(String filterColumn) {
        WebElement selectBox = tableFilter.findElement(
                By.xpath("./td[position()='" + getTableHeaderIndex(filterColumn) + "']/*"));
        Select select = new Select(selectBox);
        List<String> optionsList = select.getOptions().stream()
                .map(WebElement::getText).toList();
        Random random = new Random();
        String randomOption = "";
        do {
            randomOption = optionsList.get(random.nextInt(optionsList.size()));
            //System.out.println("FILTER VALUE : " + randomOption);
        } while (randomOption.contains("Seçiniz"));
        return randomOption;
    }

    public static boolean matchColumnDataAfterFilter(String filterColumn, String filterType) {
        String filterValue = "";

        do {
            switch (filterType) {
                case "Select":
                    filterValue = getRandomDataFromSelectList(filterColumn);
                    searchByAnySelectListOption(filterColumn, filterValue);
                    break;
                case "Input":
                    filterValue = getRandomDataFromColumn(filterColumn);
                    searchByAnyInput(filterColumn, filterValue);
                    break;
            }

            Utils.waitFor(5);
        } while (getColumnData(filterColumn).isEmpty());

        String finalFilterValue;
        if (!filterColumn.equalsIgnoreCase("Adı Soyadı") && !filterColumn.equalsIgnoreCase("E-Ticaret Ürün Adı")) {
            finalFilterValue = filterValue.toUpperCase(Locale.ROOT);
        } else finalFilterValue = filterValue;

        boolean isMatched = getColumnData(filterColumn)
                .stream()
                .allMatch(item -> item.contains(finalFilterValue.trim()));

        return isMatched;
    }


    public static boolean matchColumnDataAfterGeneralSearch(String filterColumn) {

        generalSearchInput.sendKeys(Keys.CONTROL, "A");
        generalSearchInput.sendKeys(Keys.DELETE);
        String filterValue = getRandomDataFromColumn(filterColumn);
        String finalFilterValue;
        if (!filterColumn.equalsIgnoreCase("Adı Soyadı")) {
            finalFilterValue = filterValue.toUpperCase(Locale.ROOT);
        } else finalFilterValue = filterValue;

        fillInput(generalSearchInput, finalFilterValue);

        boolean isMatched = getColumnData(filterColumn)
                .stream()
                .allMatch(item -> item.contains(finalFilterValue.trim()));

        return isMatched;
    }


    public void copyValueInContent(String randomValue) {
        // StringSelection sınıfını kullanarak kopyalanacak metni panoya kopyala
        StringSelection stringSelection = new StringSelection(randomValue);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    public static int createRandomNumber(int start, int end) {
        Random random = new Random();
        return random.nextInt(start, end);
    }

    public void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
        actions.dragAndDrop(sourceElement, targetElement).perform();
    }

    public static void handlePopupMessage() {
        Utils.waitForVisibility(popupButton, 3);
        popupButton.click();
        Utils.waitFor(2);
    }

    public static void clearTextInInput(WebElement webElement) {
        Actions actions = new Actions(DriverManager.getWebDriver());
        actions.moveToElement(webElement).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
        Utils.waitFor(1);
    }

    public static WebElement getTableBody() {
        return tableBody;
    }

    public static void backToPreScreen(){
        DriverManager.getWebDriver().navigate().back();
    }

}
