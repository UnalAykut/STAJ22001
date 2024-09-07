package com.amazon.page;

import com.amazon.util.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {
    public SearchResultPage(WebDriver driver) {
        super( driver );
    }

    @FindBy(xpath = "//div[contains(@class, 's-result-item') and @data-index]")
    private List<WebElement> searchResultsData;


    public void clickItemSearchResultsData(int dataIndex) throws InterruptedException {
        boolean elements = searchResultsData.isEmpty();
        if (!elements && dataIndex < searchResultsData.size()) {
            Utils.scrollToElementUntilVisible( driver, searchResultsData.get( dataIndex ) );
            searchResultsData.get( dataIndex ).click();
        } else {
            throw new IllegalArgumentException( "Data bulunamadı, index değeri yanlış girilmiş olabilir." );
        }
    }

    public String actualProductName(int dataIndex) throws InterruptedException {
        boolean elements = searchResultsData.isEmpty();
        if (!elements && dataIndex < searchResultsData.size()) {
            Utils.scrollToElementUntilVisible( driver, searchResultsData.get( dataIndex ) );
            String name=searchResultsData.get(dataIndex).getText().split("\\n")[0].trim();
            System.out.println(name);
            return name;
        }
        throw new IllegalArgumentException( "Data bulunamadı, index değeri yanlış girilmiş olabilir.Ürün isimleri eşleşmemiş olabilir." );

    }

}

