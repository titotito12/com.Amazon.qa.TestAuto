import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HandleWindowPopUp {

    WebDriver driver = null;

    public WebDriver getWebFirefoxInstance() {
        driver = new FirefoxDriver();
        //driver = new ChromeDriver(  );
        return driver;
    }

    public WebDriver getChromeDriverInstance() {
        // driver = new FirefoxDriver(  );
        driver = new ChromeDriver();
        return driver;
    }

    public void getWebsite(String browser) throws InterruptedException {
        //Typoes of Popup
        //1 Alerts--javascript Pop Up Alert API (accept,dismiss)
        //2 File Upload pop up===Browser button(type--file, sendkeys(path))

        //3 Browser Window Popup --Advertisement pop up (Windowhandles API--getWindowHandles())
        if (browser.equalsIgnoreCase( "chrome" ))


        {// System.setProperty("webdriver.gecko.driver","C:\\Users\\Owner\\GekoDriver\\geckodriver.exe");
          //  System.setProperty("webdriver.chrome.driver","C:\\Users\\Owner\\chromedriver.exe");

            driver = getChromeDriverInstance();


            // driver = getWebDriverInstance();
            //driver.get("https://www.wikipedia.org/");

        }
        else{
            System.setProperty("webdriver.gecko.driver","C:\\Users\\Owner\\GekoDriver\\geckodriver.exe");
            driver = getWebFirefoxInstance();
        }

        driver.get( "http://www.popuptest.com/goodpopups.html" );
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout( 2000, TimeUnit.SECONDS );
        driver.manage().timeouts().implicitlyWait( 2000,TimeUnit.SECONDS );
        driver.findElement( By.xpath( "/html/body/table[2]/tbody/tr/td/font/b/a[2]" ) ).click();
       // WebElement GoodPop3 = driver.findElement( By.xpath( "/html/body/table[2]/tbody/tr/td/font/b/a[3]" ) );
       // GoodPop3.click();
        Thread.sleep( 2000 );
        Set<String> handle =driver.getWindowHandles();
        Iterator<String> it  = handle.iterator();
        String parentWindowId =it.next();
        System.out.println("the parent window is"+ parentWindowId);

        String childWindowId =it.next();
        System.out.println("the child window id"+ childWindowId);
        driver.switchTo().window("childWindowId "  );
        Thread.sleep( 2000 );
        System.out.println("child window popup title" + driver.getTitle());
        driver.close();
        driver.switchTo().window( "parentWindowId" );
        Thread.sleep( 2000 );

        System.out.println(" parent window title " + driver.getTitle());
       // driver.close();

    }

    public static void main(String[] args) throws InterruptedException {
        HandleWindowPopUp hand = new HandleWindowPopUp();
        hand.getWebsite( "firefox" );
        hand.getChromeDriverInstance();
        hand.getWebFirefoxInstance();


    }


}


