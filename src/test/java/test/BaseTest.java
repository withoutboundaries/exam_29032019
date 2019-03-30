package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.StartPage;

public class BaseTest {
    WebDriver driver;
    StartPage startPage;


    /**
     * beforeTest is a method used before running all tests in all Sublasses of this project. This method always opens new driver and page StartPage
     */
    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gnatyshko_i\\IdeaProjects\\exam_29032019\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        startPage = new StartPage(driver);

    }

    /**
     * afterMethod is a method used after running all tests in all Sublasses of this project. This method always quits the driver.
     */
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }


}
