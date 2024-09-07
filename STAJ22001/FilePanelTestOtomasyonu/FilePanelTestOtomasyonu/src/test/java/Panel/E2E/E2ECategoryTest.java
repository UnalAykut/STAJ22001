package Panel.E2E;

public class E2ECategoryTest {
    public void changeSubCategoryStatus() {
        MobileHomePage mobileHomePage = new MobileHomePage();
        PanelCategoryPage panelCategoryPage = new PanelCategoryPage();
        PanelNavigationBar panelNavigationBar = new PanelNavigationBar();
        panelNavigationBar.clickCategory();
        Utils.waitForPageToLoad();
        panelCategoryPage.searchByCategoryName("Bebek");
        panelCategoryPage.editSubCategory();
        wait(3);
        panelCategoryPage.setCategoryStatus("active");
        panelCategoryPage.clickSaveButton();
        mobileHomePage.selectSpecificCategory("Bebek");
        boolean isSubCategoryVisible = mobileHomePage.isSubCategoryPresent("Bebek Bezleri");
        Assert.assertTrue(isSubCategoryVisible);
        panelNavigationBar.clickCategory();
        Utils.waitForPageToLoad();
        panelCategoryPage.searchByCategoryName("Bebek");
        panelCategoryPage.editSubCategory();
        wait(3);
        panelCategoryPage.setCategoryStatus("passive");
        panelCategoryPage.clickSaveButton();
        mobileHomePage.goToHomePage();
        mobileHomePage.selectSpecificCategory("Bebek");
        boolean isSubCategoryNotVisible = !mobileHomePage.isSubCategoryPresent("Bebek Bezleri");
        Assert.assertTrue(isSubCategoryNotVisible);
    }
}
