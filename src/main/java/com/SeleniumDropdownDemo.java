package com;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumDropdownDemo {
    private static WebDriver driver;
    public SeleniumDropdownDemo(WebDriver driver)
    {
        this.driver = driver;
    }
    public  WebDriver getFirefoxInstance()
    {
        driver = new FirefoxDriver(  );
        return driver;
    }
    public void getWebsiteDemo() throws InterruptedException {
       // System.setProperty("webdriver.chrome.driver","C:\\Users\\Owner\\chromedriver.exe");
       // System.setProperty("webdriver.gecko.driver","C:\\Users\\Owner\\GekoDriver\\geckodriver.exe");

        driver.navigate().to( "https://www.testandquiz.com/selenium/testing.html" );
        Select dropdown = new  Select (driver.findElement( By.id("testingDropdown") ));
        dropdown.selectByIndex( 1 );
        dropdown.selectByValue( "Performance" );
        dropdown.selectByVisibleText( "Performance Testing" );
        Thread.sleep( 10000 );

        WebElement radiobuttonMale =      driver.findElement( By.xpath( "//*[@id=\"male\"]" ) );
        radiobuttonMale.isDisplayed();
        radiobuttonMale.click();
        Thread.sleep( 10000 );
        WebElement radioButtonFemale = driver.findElement( By.xpath( "//*[@id=\"female\"]" ) );
        radioButtonFemale.isDisplayed();
        radioButtonFemale.click();
        Thread.sleep( 10000 );

        WebElement textBox = driver.findElement( By.xpath( "//*[@id=\"fname\"]" ) );
        textBox.isDisplayed();
        textBox.sendKeys( "Gbenga" );
        WebElement summitButton = driver.findElement( By.cssSelector( "#idOfButton" ) );
        summitButton.click();
        Thread.sleep( 10000 );

        //WebElement linkText = driver.findElement( By.linkText( "This is a link" ));
        WebElement linkText = driver.findElement( By.partialLinkText(" a link" ));
         linkText.click();
         String pageUrlAfterlink = driver.getCurrentUrl();
         String expectedUrl ="https://www.javatpoint.com/";
        Assert.assertEquals( expectedUrl,pageUrlAfterlink );


    }
    public void CloseBrowser(){
        driver.close();
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","C:\\Users\\Owner\\GekoDriver\\geckodriver.exe");
        SeleniumDropdownDemo dem = new SeleniumDropdownDemo( driver );
        dem.getFirefoxInstance();
        dem.getWebsiteDemo();
        dem.CloseBrowser();
    }
}
