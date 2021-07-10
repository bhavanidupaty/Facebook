package utilities;

import org.openqa.selenium.WebElement;

public class CommonMethods {
    public void typeDataInField(WebElement element, String text){

        if (element.isDisplayed()){
            System.out.println("TextBox is available");
            element.sendKeys(text);
        }
        else{
            System.out.println("TextBox is not available");
        }
    }


    public void clickOnButton(WebElement element){
        if (element.isEnabled()){
            System.out.println("Button is visible and enabled");
            element.click();
        }
        else{
            System.out.println("Button is not available");
        }
    }

    public void verifyFieldValue(WebElement element,String text){
        if(text.equals(element.getAttribute("value"))){
            System.out.println(element.getAttribute("name")+" Field is successfully entered: "+text);
        }
        else{
            System.out.println(element.getAttribute("name")+" Field value is not as entered: FAIL");
        }
    }



}
