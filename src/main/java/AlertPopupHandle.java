import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertPopupHandle {
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
            System.setProperty( "webdriver.chrome.driver", "C:\\Users\\Owner\\chromedriver.exe" );

            driver = getChromeDriverInstance();


            // driver = getWebDriverInstance();
            //driver.get("https://www.wikipedia.org/");

        } else {
            //  System.setProperty( "webdriver.gecko.driver", "C:\\Users\\Owner\\GekoDriver\\geckodriver.exe" );
            driver = getWebFirefoxInstance();
        }
        driver.get( "https://mail.rediff.com/cgi-bin/login.cgi/" );
    }

    public static void main(String[] args) throws InterruptedException {
        AlertPopupHandle alert = new AlertPopupHandle();
        alert.getWebsite( "chrome" );
        alert.getChromeDriverInstance();
        alert.getWebFirefoxInstance();

            }
}
