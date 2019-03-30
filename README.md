1. exam_29032019 is a project with a simple goal: to verify whether the word "Selenium" is found on the first 2 pages in google.com (browser Chrome).
In order to achieve this goal 2 packages were created: page and test.
In the page package are located 4 pages: BasePage which is subclassed by the rest 3 pages (StartPage, SearchResultsPage,SearchResultsSecondPage). These 3 pages describe the separate Class Object and include the elements, methods and constructor on the separate page.
In the test package are located 2 classes: BaseTest which is subclassed by SearchTest. All tests are written in SearchTest. For this current moment only 1 class SearchTest extends BaseTest, but in future one more class of tests may be created so BaseTest is needed.

2. In order to run the project's tests the following needs to be installed:
-Google Chrome browser (latest version)
-JDK 1.8
https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
-Intellij IDEA (Community version)
https://www.jetbrains.com/idea/download/
-Chromedriver.exe (http://chromedriver.chromium.org/downloads)

3. Tests in SearchTest should be run one by one because every next test depends on the previous one. For running the tests click on 'Run Test' (green triangle) in the class SearchTest.
The test are successfully passed, but sometimes slow speed of the Internet may be the reason of tests' failure because some Webelements may need more time to be loaded. In such case please add 'wait' method for several seconds (see example in the Constructor of the class StartPage).
