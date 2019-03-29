package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@name='btnK']")
    private WebElement searchButton;
    String searchTerm="Selenium";

    public LandingPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return searchField.isDisplayed()
                && driver.getCurrentUrl().contains("https://www.google.com/");
    }

public SearchResultsPage input (){
    searchField.sendKeys(searchTerm);
    searchButton.click();
    return new SearchResultsPage (driver);
}



}
