package locators;

import org.openqa.selenium.By;

public interface FBLocators {
By emailAddressTextbox=By.cssSelector("[name='email']");
By passwordField=By.cssSelector("input#pass");
By loginButton=By.cssSelector("[name='login']");
By facebookHomePageIcon=By.cssSelector("path.p361ku9c");
By statusTextbox=By.xpath("//*[contains(text(),'on your mind,')]");
By postButton=By.xpath("//span[text()='Post']");
By statusField=By.xpath("//div[contains(@aria-label,'on your mind,')]");
By createPostDialog=By.xpath("//span[text()='Create post']");
By postedMessage=By.cssSelector("div.kvgmc6g5.cxmmr5t8.oygrvhab.hcukyx3x.c1et5uql");
}
