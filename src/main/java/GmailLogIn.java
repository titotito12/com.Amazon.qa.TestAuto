import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GmailLogIn {
    private static WebDriver driver;

   // private static WebDriver driver;
    public GmailLogIn(WebDriver driver)
    {
        this.driver = driver;
    }
    public static WebDriver getChromeInstance()
    {
        driver = new ChromeDriver(  );
        return driver;
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Owner\\chromedriver.exe");
        driver = getChromeInstance();

        driver.get( "https://www.google.com/" );

         List<WebElement> linklist = new ArrayList(  );

        linklist = driver.findElements( By.xpath( "//*[@id=\"gbw\"]/div/div/div[1]" ) );

        linklist.size();
        System.out.println(linklist.size());
        WebElement gmaillink=linklist.get( 1 );
        gmaillink.click();
        driver.quit();

    }


    }
