package testsuite;

import browser.BrowserActions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import utilities.TestData;

public class Login_TestSuite {

    LoginPage loginPage;
    BrowserActions browserActions;
    TestData testData;
    HomePage homePage;


    @Parameters("browser")
    @BeforeClass
    public void initializeBrowser(String browserName) {

        browserActions = new BrowserActions();
        testData = new TestData();
        if (browserName.equalsIgnoreCase("Chrome")) {
            browserActions.launchChrome();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            browserActions.launchFirefox();
        } else {
            System.out.println("Invalid browser specified");
        }

    }

    @BeforeMethod
    public void applicationLaunch() {
        browserActions.launchApplication(testData.getData("appUrl"));
        loginPage = new LoginPage(browserActions.driver);
        loginPage.verifyFacebookLoginPage();
    }

    @Test(description = "Login to Facebook with valid user credentials and post a status message")
    public void loginToFacebook() throws Exception {
        loginPage.enterUsername(testData.getData("userName"));
        loginPage.enterPassword(testData.getData("password"));
        loginPage.clickOnLoginButton();
        homePage=new HomePage(browserActions.driver);
        homePage.verifyHomePage();
        homePage.postAMessage(testData.getData("message"));
        String postedText=homePage.getPostedMessage();
        System.out.println("Posted Message: "+postedText);
    }

    @AfterMethod
    public void quitBrowser(){
        browserActions.closeBrowser();
    }
}
