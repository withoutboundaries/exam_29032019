package test;


import org.testng.Assert;
import org.testng.annotations.Test;
import page.SearchResultsPage;
import page.SearchResultsSecondPage;

import java.util.List;

public class SearchTest extends BaseTest {


    @Test
    public void successfulSearchTest() {


        String searchTerm = "Selenium";

        Assert.assertTrue(startPage.isPageLoaded(), "Start page is not loaded");

        SearchResultsPage searchResultsPage = startPage.input();
        Assert.assertTrue(searchResultsPage.isPageLoaded(), "Search Results page is not loaded");

        Assert.assertEquals(searchResultsPage.getSearchResultCount(), 9,
                "Search results count is wrong on the first page");

        List<String> searchResultsList = searchResultsPage.getSearchResultsList();
        for (String searchResult : searchResultsList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "SearchTerm: " + searchTerm + " not fount in: \n" + searchResult);
        }

        SearchResultsSecondPage searchResultsSecondPage = searchResultsPage.goTo2SearchPage();
        Assert.assertTrue(searchResultsSecondPage.isPageLoaded(), "Search Results Second page is not loaded");

        Assert.assertEquals(searchResultsSecondPage.getSearchResultCount(), 10,
                "Search results count is wrong on the second page");

        List<String> searchResultsListSecondPage = searchResultsSecondPage.getSearchResultsList();
        for (String searchResult : searchResultsList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "SearchTerm: " + searchTerm + " not fount in: \n" + searchResult);
        }

    }

}
