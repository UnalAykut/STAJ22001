package Panel.Page;

package com.filemarket.ecta.page.panel;

import com.filemarket.ecta.util.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PanelNavigationBar extends AbstractPageObject {

    @FindBy(xpath = "//span[text()='Dashboard']/ancestor::a")
    private WebElement dashboard;

    @FindBy(xpath = "//span[text()='Siparişler']/ancestor::a")
    private WebElement orders;

    @FindBy(xpath = "//*[@id=\"kt_aside_menu\"]/div/ul/li[3]/a/span[2]")
    private WebElement products;

    @FindBy(xpath = "//*[@id=\"kt_aside_menu\"]/div/ul/li[5]/a/span[2]")
    private WebElement customers;

    @FindBy(xpath = "//span[text()='Mağazalar']/ancestor::li[contains(@class,'menu-item-submenu')]")
    private WebElement store;

    @FindBy(xpath = "//*[@id=\"kt_aside_menu\"]/div/ul/li[6]/div/ul/li[2]")
    private WebElement subStore;

    @FindBy(xpath = "//span[text()='Slotlar']")
    private WebElement subSlot;

    @FindBy(xpath = "//*[@id=\"kt_aside_menu\"]/div/ul/li[4]/a/span[2]")
    private WebElement category;

    @FindBy(xpath = "//a[contains(@class, 'menu-toggle') and contains(span[@class='menu-text'], 'Etiketler')]")
    private WebElement tag;

    @FindBy(xpath = "//*[@id=\"kt_aside_menu\"]/div/ul/li[8]/div/ul/li[2]/a/span")
    private WebElement subTag;

    @FindBy(xpath = "//a[@href='#/tag/file-import']")
    private WebElement batchInput;

    @FindBy(xpath = "//*[@id=\"kt_aside_menu\"]/div/ul/li[10]")
    private WebElement settings;

    @FindBy(xpath = "//*[@id=\"kt_aside_menu\"]/div/ul/li[10]/div/ul/li[2]")
    private WebElement users;

    @FindBy(xpath = "//*[@id=\"kt_aside_menu\"]/div/ul/li[10]/div/ul/li[3]")
    private WebElement contract;

    @FindBy(xpath = "//*[@id=\"kt_aside_menu\"]/div/ul/li[10]/div/ul/li[4]")
    private WebElement ticket;

    @FindBy(xpath = "//li[11]")
    private WebElement  audit;

    @FindBy(xpath = "(//span[normalize-space()='Audit'])[1]")
    private WebElement logs;

    @FindBy(xpath = "//span[text()='Bannerlar']")
    private WebElement banner;

    @FindBy(xpath = "//span[normalize-space()='SSS']")
    private WebElement SSSPage;

    public void clickDashboard() {
        Utils.waitFor(3);
        Utils.waitForClickablility(dashboard);
        dashboard.click();
    }

    public void clickOrders() {
        Utils.waitForClickablility(orders);
        orders.click();
    }
    public void clickProducts() {
        Utils.waitForClickablility(products);
        products.click();
    }

    public void clickCustomers() {
        Utils.waitForClickablility(customers);
        customers.click();
    }

    public void clickStore() {
        Utils.waitForClickablility(store);
        if(!store.getAttribute("class").contains("menu-item-open")){
            store.click();
        }
        subStore.click();
    }

    public void clickSlot() {
        Utils.waitForClickablility(store);
        if(!store.getAttribute("class").contains("menu-item-open")){
            store.click();
        }
        Utils.waitFor(2);
        subSlot.click();
    }

    public void clickLogs() {
        Utils.hover(audit);
        if (logs.isDisplayed()) {
            logs.click();
        } else {
            Utils.waitForClickablility(audit);
            audit.click();
            Utils.waitFor(2);
            Utils.hover(logs);
            logs.click();
        }
    }

    public void clickCategory() {
        Utils.waitForClickablility(category);
        category.click();
        Utils.waitFor(2);
    }

    public void clickContract() {
        Utils.waitForClickablility(settings);
        settings.click();
        Utils.waitFor(2);
        contract.click();
    }

    public void clickTags() {
        Utils.waitForClickablility(tag);
        tag.click();
        Utils.waitForVisibility(subTag,5);
        subTag.click();
        Utils.waitFor(2);
    }

    public void clickBatchInput() {
        tag.click();
        Utils.waitFor(2);
        batchInput.click();
    }

    public void clickTicket() {
        Utils.waitForClickablility(settings);
        settings.click();
        Utils.waitFor(2);
        ticket.click();
    }

    public void clickUsers() {
        Utils.waitForClickablility(settings);
        settings.click();
        Utils.waitFor(2);
        users.click();
    }

    public void clickSSS() {
        Utils.waitFor(2);
        settings.click();
        Utils.waitFor(2);
        SSSPage.click();
    }

    public void clickBanner() {
        Utils.waitFor(2);
        banner.click();
    }

}

