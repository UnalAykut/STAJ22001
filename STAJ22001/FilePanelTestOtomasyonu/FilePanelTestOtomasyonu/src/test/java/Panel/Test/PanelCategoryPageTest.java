package Panel.Test;

package com.filemarket.ecta.test.panel;

import com.filemarket.ecta.page.panel.AbstractPageObject;
import com.filemarket.ecta.page.panel.PanelCategoryPage;
import com.filemarket.ecta.page.panel.PanelNavigationBar;
import com.filemarket.ecta.test.BaseTestForPanel;
import com.filemarket.ecta.util.Utils;
import lombok.SneakyThrows;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.filemarket.ecta.page.panel.AbstractPageObject.*;
import static com.filemarket.ecta.util.Constants.*;
import static com.filemarket.ecta.util.Constants.CATEGORY.*;
import static org.testng.Assert.*;

public class PanelCategoryPageTest extends BaseTestForPanel {


    @BeforeMethod
    public void refreshPage() {
        PanelNavigationBar panelNavigationBar = new PanelNavigationBar();
        panelNavigationBar.clickDashboard();
        panelNavigationBar.clickCategory();
        Utils.waitForPageToLoad();
    }

    @SneakyThrows
    @Test(description = TEST_P_CATEGORY_001, groups = {"panel"})
    public void openPageAndCheckList() {

        PanelCategoryPage panelCategoryPage = new PanelCategoryPage();
        Utils.waitForPageToLoad();

        assertEquals(AbstractPageObject.countRows(), LIST_DEFAULT_SIZE);
    }

    @SneakyThrows
    @Test(description = TEST_P_CATEGORY_002, groups = {"panel"})
    public void changeDataLimitAndCheckList() {
        Utils.scrollDown();
        AbstractPageObject.changeDataLimit(LIST_FIFTEEN_SIZE);
        wait(2);

        assertEquals(AbstractPageObject.countRows(), LIST_FIFTEEN_SIZE);
    }

    @SneakyThrows
    @Test(description = TEST_P_CATEGORY_003, groups = {"panel"})
    public void changePageNumberAndCheckDataDifference() {

        var panelCategoryPage = new PanelCategoryPage();

        String firstPageFirstCategoryName = panelCategoryPage.getCategoryName();

        panelCategoryPage.changePageNumber(2);

        wait(5);

        String secondPageFirstCategoryName = panelCategoryPage.getCategoryName();

        assertNotEquals(firstPageFirstCategoryName, secondPageFirstCategoryName);
    }

    @SneakyThrows
    @Test(enabled = false, description = TEST_P_CATEGORY_004, groups = {"panel"})
    public void searchByCategoryNameAndCheckData() {

        String filterColumn = "Kategori Adı";
        boolean isMatched = AbstractPageObject.matchColumnDataAfterFilter(filterColumn, "Input");

        assertFalse(AbstractPageObject.getColumnData(filterColumn).isEmpty());
        assertTrue(isMatched);
    }

    @SneakyThrows
    @Test(description = TEST_P_CATEGORY_005, groups = {"panel"})
    public void openPageAndSubCategoryCheckList() {

        PanelCategoryPage panelCategoryPage = new PanelCategoryPage();
        Utils.waitForPageToLoad();
        int randomNumber = createRandomNumber(2, getTableList().size() + 2);
        panelCategoryPage.selectIconButton(randomNumber).click();

        List<String> getInnerColumnData = panelCategoryPage.getInnerColumnData("Kategori Adı");
        System.out.println(getInnerColumnData);
        panelCategoryPage.selectCategoryName(randomNumber).click();
        List<String> subCategoryList = panelCategoryPage.subCategories().stream().map(t-> t.getText().split("-")[1]).toList();
        System.out.println(subCategoryList);
        Utils.waitFor(3);
        assertEquals(getInnerColumnData, subCategoryList);
    }

    @SneakyThrows
    @Test(description = TEST_P_CATEGORY_006, groups = {"panel"})
    public void dragAndDrop() {
        var panelCategoryPage = new PanelCategoryPage();

        String firstCategoryName = panelCategoryPage.getDATA_TABLE_FIRST_CATEGORY_NAME_XPATH().getText();
        String secondCategoryName = panelCategoryPage.getDATA_TABLE_SECOND_CATEGORY_NAME_XPATH().getText();

        panelCategoryPage.dragAndDrop();
        Utils.waitFor(3);
        String newFirstCategoryName = panelCategoryPage.getDATA_TABLE_FIRST_CATEGORY_NAME_XPATH().getText();
        String newSecondCategoryName = panelCategoryPage.getDATA_TABLE_SECOND_CATEGORY_NAME_XPATH().getText();

        boolean checkNameFirst = firstCategoryName.equals(newSecondCategoryName);
        boolean checkNamesecond = secondCategoryName.equals(newFirstCategoryName);

        panelCategoryPage.dragAndDrop();

        assertTrue(checkNameFirst);
        assertTrue(checkNamesecond);
    }

}

