package com.amazon.page;

import com.amazon.util.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NavigationBarPage extends BasePage {

    public NavigationBarPage(WebDriver driver) {
        super( driver );
    }

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchTextBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement submitButton;

    @FindBy(id = "nav-link-accountList")
    private WebElement loginAccountListButton;

    @FindBy(id = "nav-cart")
    private WebElement cartButton;

    @FindBy(id = "searchDropdownBox")
    private WebElement categoryDropdown;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private WebElement accountName;

    public void inputSearchTextBox(String searchText) {
        Utils.waitForElementToBeVisible( driver, searchTextBox ).sendKeys( searchText );
    }

    public void clickSubmitButton() {
        Utils.waitForElementToBeClickable( driver, submitButton ).click();
    }

    public void onHoverLoginAccountListButton() {
        Actions actions = new Actions( driver );
        actions.moveToElement( Utils.waitForElementToBeVisible( driver, loginAccountListButton ) ).perform();
    }

    public void clickLoginAccountListButton() {
        Utils.waitForElementToBeClickable( driver, loginAccountListButton ).click();
    }

    public void selectCategory(String category) {
        Select dropdown = new Select( Utils.waitForElementToBeVisible( driver, categoryDropdown ) );
        dropdown.selectByVisibleText( category );
    }

    public boolean isLoginSuccessful() {
        String actualData="Merhaba, Giriş yapın";
        String expectedData=  Utils.waitForElementToBeVisible( driver,accountName ).getText();
        if(expectedData.equals( actualData )){
                return false;
        }
            return true;

    }
}