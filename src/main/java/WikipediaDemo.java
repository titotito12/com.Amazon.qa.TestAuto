import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WikipediaDemo {
        WebDriver driver = null;

        public WebDriver getWebFirefoxInstance(){
            driver = new FirefoxDriver(  );
            //driver = new ChromeDriver(  );
            return driver;
        }
        public WebDriver getChromeDriverInstance(){
            // driver = new FirefoxDriver(  );
            driver = new ChromeDriver(  );
            return driver;
        }
        public void getWebsite(String browser) throws InterruptedException {
            if (browser.equalsIgnoreCase( "chrome" ))
            {
                driver = getChromeDriverInstance();


                // driver = getWebDriverInstance();
                //driver.get("https://www.wikipedia.org/");

            }
            else{
                System.setProperty("webdriver.gecko.driver","C:\\Users\\Owner\\GekoDriver\\geckodriver.exe");

                driver = getWebFirefoxInstance();
            }
            driver.get( "https://www.wikipedia.org/" );


            WebElement inputTextBox = driver.findElement( By.id( "searchInput" ));
            boolean idPresenter =  inputTextBox.isDisplayed();
            System.out.println("---------" + idPresenter);
            //inputTextBox.sendKeys( "Corona Virus" );
            Thread.sleep( 200 );
            WebElement searchTextBox = driver.findElement( By.xpath( "//*[@id=\"search-form\"]/fieldset/button" ) );
            searchTextBox.click();
            driver.findElement(By.xpath("//*[@id=\"ooui-php-1\"]")).sendKeys("Corona virus");
            driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[3]/div[2]/form/div[1]/div/div/div/span/span/button/span[2]")).click();
           // inputTextBox.sendKeys( "Corona Virus" );
            // String expectedBrowserTitle = "Carona Virus disease 2019 - Search results - Wikipedia";
            //String obtainedBrowserTitle = driver.getTitle();
            //Assert.assertEquals(expectedBrowserTitle ,obtainedBrowserTitle );
            // Thread.sleep( 200 );*/

            WebElement searchResultTextBox = driver.findElement( By.id( "ooui-php-1" ) );
            String obtainedText = searchResultTextBox.getText();
            String expectedText = "Corona Virus";
            Assert.assertEquals( expectedText,obtainedText );

        }

        public void Teardown()
        {
            driver.close();
        }

        public static void main(String[] args) throws InterruptedException {
           // System.setProperty("webdriver.gecko.driver","C:\\Users\\Owner\\GekoDriver\\geckodriver.exe");
            //System.setProperty("webdriver.chrome.driver","C:\\Users\\Owner\\ChromeDriver\\chromedriver.exe");



            WikipediaDemo wiki= new WikipediaDemo();
            wiki.getWebsite("Firefox");
            // firstSeleniumWebDriverDemo.Teardown();
        }
    }


