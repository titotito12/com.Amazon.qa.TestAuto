import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class FrameHandling {
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
        if (browser.equalsIgnoreCase( "chrome" )) {// System.setProperty("webdriver.gecko.driver","C:\\Users\\Owner\\GekoDriver\\geckodriver.exe");
            //System.setProperty( "webdriver.chrome.driver", "C:\\Users\\Owner\\chromedriver.exe" );

            driver = getChromeDriverInstance();


            // driver = getWebDriverInstance();
            //driver.get("https://www.wikipedia.org/");

        } else {
             System.setProperty( "webdriver.gecko.driver", "C:\\Users\\Owner\\GekoDriver\\geckodriver.exe" );
            driver = getWebFirefoxInstance();
        }driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout( 2000, TimeUnit.SECONDS );
        driver.manage().timeouts().implicitlyWait( 2000,TimeUnit.SECONDS );
        driver.get( "https://ui.freecrm.com/" );
        Thread.sleep( 2000 );
        driver.findElement( By.name( "email" ) ).sendKeys( "titoadeade@gmail.com" );
        driver.findElement( By.name( "password" ) ).sendKeys( "Titotito1257" );
        Thread.sleep( 2000 );
        driver.findElement( By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]") ).click();
        Thread.sleep( 2000 );
        // No such element is error msg for frame
        driver.switchTo().frame( "" );
        driver.findElement( By.xpath( "/html/body/div[1]/div/div[1]/a[3]/span" ) ).click();
    }

    public static void main(String[] args) throws InterruptedException {
        FrameHandling fra = new FrameHandling();
        fra.getWebsite( "firefox" );
        fra.getChromeDriverInstance();
        fra.getWebFirefoxInstance();
    }
}
