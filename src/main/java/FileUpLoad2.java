import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class FileUpLoad2 {
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
            if (browser.equalsIgnoreCase( "chrome" ))
            {// System.setProperty("webdriver.gecko.driver","C:\\Users\\Owner\\GekoDriver\\geckodriver.exe");
                 System.setProperty("webdriver.chrome.driver","C:\\Users\\Owner\\chromedriver.exe");

                driver = getChromeDriverInstance();


                // driver = getWebDriverInstance();
                //driver.get("https://www.wikipedia.org/");

            } else {
              //  System.setProperty( "webdriver.gecko.driver", "C:\\Users\\Owner\\GekoDriver\\geckodriver.exe" );
                driver = getWebFirefoxInstance();
            }
            driver.get( "https://html.com/input-type-file/" );
            // Type should be present for the Broeser/Attached File/Upload File Buttons
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait( 2000, TimeUnit.SECONDS );
            Thread.sleep( 2000 );
            driver.findElement( By.xpath( "//*[@id=\"fileupload\"]" ) ).sendKeys( "C:\\Adewale\\CandidateCV.doc" );
           // driver.close();


        }

        public static void main(String[] args) throws InterruptedException {

            FileUpLoad2 file  = new FileUpLoad2();
            file.getWebsite( "chrome" );
            file.getChromeDriverInstance();
            file.getWebFirefoxInstance();




        }

    }


