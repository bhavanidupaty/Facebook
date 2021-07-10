package pages;

import locators.FBLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.CommonMethods;

public class LoginPage implements FBLocators {

    private WebDriver driver;
    public CommonMethods commonMethods;
      public LoginPage(WebDriver driver){
        this.driver=driver;
        commonMethods= new CommonMethods();
    }

    public void verifyFacebookLoginPage(){
        String pageTitle=driver.getTitle();
        if (pageTitle.contains("Facebook – Log In")) {
            System.out.println(pageTitle+" page is displayed");
        }

        else {
            System.out.println("Oops!! Login page is not displayed: FAIL");
            System.out.println("actual displayed page is: "+pageTitle);
        }
    }

    public void enterUsername(String userName){
        WebElement elementUserName=driver.findElement(FBLocators.emailAddressTextbox);
        commonMethods.typeDataInField(elementUserName,userName);
        commonMethods.verifyFieldValue(elementUserName,userName);

    }

    public void enterPassword(String password){
        WebElement elementPassword=driver.findElement(FBLocators.passwordField);
        commonMethods.typeDataInField(elementPassword,password);

    }

    public void clickOnLoginButton(){
        WebElement elementLoginButton=driver.findElement(FBLocators.loginButton);
        commonMethods.clickOnButton(elementLoginButton);
    }

}
