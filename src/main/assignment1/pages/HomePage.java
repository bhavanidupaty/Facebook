package pages;

import locators.FBLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CommonMethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage implements FBLocators {
    private WebDriver driver;
    WebDriverWait wait;
    public CommonMethods commonMethods;
    JavascriptExecutor js;

    public HomePage(WebDriver driver){
        this.driver=driver;
        js = (JavascriptExecutor)driver;
        driver.navigate().refresh();
        wait=new WebDriverWait(driver,20);
        commonMethods= new CommonMethods();
    }

    public void verifyHomePage(){

        wait.until(ExpectedConditions.titleContains("Facebook"));
        String pageTitle=driver.getTitle();
        if (pageTitle.equalsIgnoreCase("Facebook")) {
            System.out.println(pageTitle+" page is displayed");
        }

        else {
            System.out.println("Oops!! Home page is not displayed: FAIL");
            System.out.println("actual displayed page is: "+pageTitle);
        }

    }

    public void postAMessage(String message){
        wait.until(ExpectedConditions.presenceOfElementLocated(FBLocators.facebookHomePageIcon));
        WebElement elementHome= driver.findElement(FBLocators.facebookHomePageIcon);
        commonMethods.clickOnButton(elementHome);
        wait.until(ExpectedConditions.presenceOfElementLocated(FBLocators.statusTextbox));
        WebElement elementStatus=driver.findElement(FBLocators.statusTextbox);
        if (elementStatus.isDisplayed()){
            commonMethods.clickOnButton(elementStatus);
            WebElement elementCreatePostDialog=driver.findElement(FBLocators.createPostDialog);
            driver.switchTo().activeElement().click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(FBLocators.statusField));
            WebElement elementStatusField= driver.findElement(FBLocators.statusField);
            commonMethods.typeDataInField(elementStatusField,message);
            WebElement elementPostButton= driver.findElement(FBLocators.postButton);
            commonMethods.clickOnButton(elementPostButton);
        }
       else {
            System.out.println("Status box isn't displayed");

       }


    }

    public String getPostedMessage(){
       wait.until(ExpectedConditions.presenceOfElementLocated(FBLocators.postedMessage));

       WebElement elementPost= driver.findElement(FBLocators.postedMessage);
       return elementPost.getText();
    }

}
