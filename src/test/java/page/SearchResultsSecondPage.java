package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsSecondPage extends BasePage {
    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    private WebElement searchResultsFieldSecondPage;

    @FindBy(xpath ="//div[@class='g']")
    List<WebElement> searchResultElementsSecondPage;


    public SearchResultsSecondPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getSearchResultCount() {
        return searchResultElementsSecondPage.size();
    }

    public List<String> getSearchResultsList() {
        List<String> searchResultsList = new ArrayList<String>();
        for (WebElement searchResult : searchResultElementsSecondPage) {
            searchResultsList.add(searchResult.getText());
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchResult);
            searchResultsList.add(searchResult.getText());
        }
        return searchResultsList;
    }

    public boolean isPageLoaded() {
        return searchResultsFieldSecondPage.isDisplayed()
                && driver.getCurrentUrl().contains("q=Selenium");
    }
}
