package com.prachi.selenium.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FormSubmit {

    private WebDriver driver = null;

    public WebDriver getChromeWebDriver(){
        System.setProperty("webdriver.chrome.driver", "/Users/prachiutkhede/Downloads/chromedriver");
        return new ChromeDriver();
    }

    public void testFormSubmission() {
        //getting Chrome WebDriver
        driver = getChromeWebDriver();
        driver.manage().window().maximize();

        // fetching the web site 
        driver.get("http://spicejet.com/");

        // Get the source destination input element
        WebElement fromElement = driver.findElement(By.xpath("//input[contains(@id,'ctl00_mainContent_ddl_originStation1_CTXT')]"));        
        fromElement.click();

        // Type first few alphabets of the source destination. 
        fromElement.sendKeys("go");

        // Select the intended source element.
        WebElement requiredFromElement = driver.findElement(By.xpath("//a[@value='GOI']"));
        requiredFromElement.click();

        // Select the target destination element
        WebElement toElement = driver.findElement(By.xpath("//input[contains(@id,'ctl00_mainContent_ddl_destinationStation1_CTXT')]"));
        toElement.click();

        //Check whether the  target destination element is selected after source destination 
        WebElement requiredToElement = driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']"));
        if(requiredToElement.getCssValue("display").equals("block")){
            driver.findElement(By.xpath("//a[@value='BLR']")).click();
        }        
    }
    
    public static void main(String[] args) {
        FormSubmit formSubmit =new FormSubmit();
        formSubmit.testFormSubmission();
    }
}
