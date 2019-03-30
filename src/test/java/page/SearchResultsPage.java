package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@class='g']")
    List<WebElement> searchResultElements;

    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    private WebElement searchResultsField;


    @FindBy(xpath = "//a[@aria-label='Page 2']")
    private WebElement page2Button;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getSearchResultCount() {
        return searchResultElements.size();
    }

    public List<String> getSearchResultsList() {
        List<String> searchResultsList = new ArrayList<String>();
        for (WebElement searchResult : searchResultElements) {
            searchResultsList.add(searchResult.getText());
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchResult);
            searchResultsList.add(searchResult.getText());
        }
        return searchResultsList;
    }

    public boolean isPageLoaded() {
        return searchResultsField.isDisplayed()
                && driver.getCurrentUrl().contains("q=Selenium");
    }


    public SearchResultsSecondPage goTo2SearchPage() {
        page2Button.click();
        return new SearchResultsSecondPage(driver);
    }


}
