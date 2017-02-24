package com.prachi.selenium.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleAboutPageTest {
    
    private WebDriver driver = null;
    private int scrollWaitInterval = 20;
    
    public static void main(String[] args) {
        GoogleAboutPageTest googleAboutPageTest = new GoogleAboutPageTest();
        
        googleAboutPageTest.initializeChromeWebDriver();
        googleAboutPageTest.navigateToAndTestAboutPageScrolling();
        googleAboutPageTest.waitForScrollingToComplete();
        googleAboutPageTest.navigateToCreateAccountPage();
        
        String childWindowTitle = googleAboutPageTest.getChildWindowTitle();
        System.out.println("Child window title: " + childWindowTitle);
    }
    
    public void initializeChromeWebDriver(){
        System.setProperty("webdriver.chrome.driver", "/Users/prachiutkhede/Downloads/chromedriver");
        driver = new ChromeDriver();
    }
    
    public void navigateToAndTestAboutPageScrolling() {
        driver.get("https://www.google.com/gmail/about/");
        
        Actions action = new Actions(driver);
        WebElement scrollElement =  driver.findElement(By.xpath("html/body/main/section/div[1]/div"));
        
        // Perform 'click' action on the scroll down element
        action.click(scrollElement).build().perform();
    }
    
    public void waitForScrollingToComplete() {
        // Explicitly wait for scrolling to complete
        WebDriverWait wait = new WebDriverWait(driver, scrollWaitInterval);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/main/section/section[1]/div[2]/div")));        
    }
    
    public void navigateToCreateAccountPage() {
        // On the About page get the link element to the
        // create account page and navigate to it.
        WebElement createAccountElement = driver.findElement(By.xpath("/html/body/nav/div/a[3]"));
        createAccountElement.click();
        
        Set<String> windowhandle = driver.getWindowHandles();   
        Iterator<String> windowit = windowhandle.iterator();
        
        // Get parent and child window handles.
        String parent = windowit.next();
        String child = windowit.next();

        // Navigate to the child window
        driver.switchTo().window(child); 
    }
    
    public String getChildWindowTitle() {
        return driver.getTitle();
    }
}

