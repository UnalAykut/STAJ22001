package Panel.Test;

import com.filemarket.ecta.page.panel.PanelNavigationBar;
import com.filemarket.ecta.page.panel.PanelTagPage;
import com.filemarket.ecta.page.panel.PanelTagUpdatePage;
import com.filemarket.ecta.test.BaseTestForPanel;
import com.filemarket.ecta.util.Utils;
import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.filemarket.ecta.util.Constants.*;
import static com.filemarket.ecta.util.Constants.TAG.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class PanelTagPageTest extends BaseTestForPanel {

    private static final String TAG_PRODUCT_CODE = "42702490";
    private static final String TAG_PRODUCT_NAME = "handdess el dezenfektanı 1000 ml";
    private static final String DETAIL_PRODUCT_TAG_NAME = "temizlik";
    private static final String TAG_CATEGORY_TAG_NAME = "kişisel bakım";
    private static final String TAG_SUB_CATEGORY_TAG_NAME = "kolonya";


    @BeforeMethod
    public void refreshPage() {
        PanelNavigationBar panelNavigationBar = new PanelNavigationBar();
        panelNavigationBar.clickDashboard();
        Utils.waitForPageToLoad();
        panelNavigationBar.clickTags();
        Utils.waitForPageToLoad();
    }


    @SneakyThrows
    @Test(description = TEST_P_TAG_001, groups = {"panel"})
    public void openPageAndCheckList() {
        PanelTagPage panelTagPage = new PanelTagPage();
        Utils.waitForPageToLoad();

        assertEquals(PanelTagPage.countRows(), LIST_DEFAULT_SIZE);
    }

    @SneakyThrows
    @Test(description = TEST_P_TAG_002, groups = {"panel"})
    public void changeDataLimitAndCheckList() {
        var tagPage = new PanelTagPage();
        tagPage.scrollDown();
        tagPage.changeDataLimit(LIST_FIFTEEN_SIZE);
        wait(3);

        List<WebElement> tagList = tagPage.getTagList();

        assertThat(tagList).hasSize(LIST_FIFTEEN_SIZE);
    }

    @SneakyThrows
    @Test(description = TEST_P_TAG_003, groups = {"panel"})
    public void changePageAndCheckData() {
        PanelTagPage panelTagPage = new PanelTagPage();
        String firstPageFirstProductCode = panelTagPage.getFirstProductCode();
        panelTagPage.changePage(TABLE_FOURTH_PAGE);
        wait(5);
        String fourthPageFirstProductCode = panelTagPage.getFirstProductCode();

        assertNotEquals(firstPageFirstProductCode, fourthPageFirstProductCode);
    }

    @SneakyThrows
    @Test(description = TEST_P_TAG_004, groups = {"panel"})
    public void searchByProductCode() {
        var tagPage = new PanelTagPage();
        String firstPageFirstProductCode = tagPage.getFirstProductCode();
        tagPage.searchByProductCode(firstPageFirstProductCode);
        wait(3);
        List<String> productCodeList = tagPage.getProductCodeList();

        boolean result = productCodeList.stream().allMatch(item -> item.contains(firstPageFirstProductCode));

        assertTrue(result);
    }

    @SneakyThrows
    @Test(description = TEST_P_TAG_005, groups = {"panel"})
    public void clickTagEditChangeValueAndSave() {
        var tagPage = new PanelTagPage();

        tagPage.searchByProductCode(TAG_PRODUCT_CODE);

        wait(4);

        tagPage.clickEditButton();

        wait(2);

        var panelTagUpdatePage = new PanelTagUpdatePage();

        panelTagUpdatePage.sendKeysTagTextarea(DETAIL_PRODUCT_TAG_NAME);

        wait(2);

        panelTagUpdatePage.clickSaveButton();

        tagPage.searchByProductCode(TAG_PRODUCT_CODE);

        wait(2);

        String expectedTagName = tagPage.getFirstProductTagName();

        assertTrue(expectedTagName.contains(DETAIL_PRODUCT_TAG_NAME));
        assertEquals(TAG_PRODUCT_CODE, tagPage.getFirstProductCode());

    }

    @SneakyThrows
    @Test(description = TEST_P_TAG_006, groups = {"panel"}, priority = 1)
    public void checkTagDataFilteredByProductName() {
        var tagPage = new PanelTagPage();
        tagPage.searchByProductName(TAG_PRODUCT_NAME);

        wait(2);

        String expectedTagName = tagPage.getFirstProductTagName();

        assertEquals(TAG_PRODUCT_CODE, tagPage.getFirstProductCode());
        assertEquals(TAG_PRODUCT_NAME, tagPage.getFirstProductName());
        assertTrue(expectedTagName.contains(DETAIL_PRODUCT_TAG_NAME));
        assertEquals(TAG_CATEGORY_TAG_NAME, tagPage.getFirstProductCategoryName());
        assertEquals(TAG_SUB_CATEGORY_TAG_NAME, tagPage.getFirstProductSubCategoryName());
    }
}
