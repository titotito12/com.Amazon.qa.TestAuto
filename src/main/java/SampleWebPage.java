

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SampleWebPage {
    WebDriver driver = null;

    public WebDriver getChromeInstance(){

        driver = new ChromeDriver();
        return driver;
    }
    public WebDriver getFirefoxInstance(){
        driver = new FirefoxDriver(  );
        return driver;
    }
    public void getWebSite(String browser) throws InterruptedException {
        if (browser.equalsIgnoreCase( "chrome" ))
        {
           // System.setProperty( "webdriver.chrome.driver","C:\\Users\\Owner\\chromedriver.exe" );
            driver = getChromeInstance();
        }
        else
            {
                System.setProperty("webdriver.gecko.driver","C:\\Users\\Owner\\GekoDriver\\geckodriver.exe");
            driver = getFirefoxInstance();
        }
        driver.get( "https://www.testandquiz.com/selenium/testing.html" );
        WebElement link = driver.findElement( By.linkText("This is a link") );
        link.click();
        String pageUrlAfterLink = driver.getCurrentUrl();
        String expectedUrl = "https://www.javatpoint.com/";
        Assert.assertEquals( expectedUrl,pageUrlAfterLink );
        Thread.sleep( 1000 );
        //driver.navigate().to( "https://www.testandquiz.com/selenium/testing.html" );
        driver.navigate().back();
        WebElement partiaLink = driver.findElement( By.partialLinkText(" a link") );
        partiaLink.click();
        String pageUrlAfterPartialLink = driver.getCurrentUrl();
        String expectedPartialUrl = "https://www.javatpoint.com/";
        Assert.assertEquals( expectedPartialUrl,pageUrlAfterPartialLink );
        Thread.sleep( 1000 );
        driver.navigate().to( "https://www.testandquiz.com/selenium/testing.html" );
        WebElement textBox = driver.findElement( By.id( "fname" ) );
        textBox.sendKeys( "total" );
        WebElement summitButton = driver.findElement( By.id( "idOfButton" ) );
        summitButton.click();
        Thread.sleep( 1000 );
        WebElement radiomale =driver.findElement( By.id( "male" ) );
        radiomale.isDisplayed();
        radiomale.click();
        Thread.sleep( 1000 );
        WebElement radiofemale =driver.findElement( By.id( "female" ) );
        System.out.println(radiofemale.isDisplayed());
        System.out.println(radiofemale.isSelected());

        radiofemale.click();
        Thread.sleep( 1000 );
        Select dropDoen = new Select( driver.findElement( By.id( "testingDropdown" ) ) );
        dropDoen.selectByVisibleText( "Manual Testing" );
        Thread.sleep( 1000 );
        
    }


    public void closeBrowser(){
        driver.close();
    }

    public static void main(String[] args) throws InterruptedException {
        SampleWebPage sam = new SampleWebPage();
        sam.getWebSite( "firefox" );
        sam.closeBrowser();
    }
}
