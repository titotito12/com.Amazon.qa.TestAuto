import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class GmailJunit {

        private static WebDriver driver;

        // private static WebDriver driver;
       /* public GmailJunit(WebDriver driver)
        {
            this.driver = driver;
        }

        */
       @Before
        public void getChromeInstance()
        {
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Owner\\chromedriver.exe");
            driver = new ChromeDriver(  );

        }
       @Test(expected = ArithmeticException.class)
       public  void testImages(){
            //System.setProperty("webdriver.chrome.driver","C:\\Users\\Owner\\chromedriver.exe");
            //driver = getChromeInstance();

            driver.get( "https://www.google.com/" );

            List<WebElement> linklist = new ArrayList(  );

            linklist = driver.findElements( By.xpath( "//*[@id=\"gbw\"]/div/div/div[1]" ) );


            linklist.size();
            System.out.println(linklist.size());
            WebElement gmaillink=linklist.get( 0 );

            gmaillink.click();


        }
    @Test(expected = ArithmeticException.class)
    public  void testGmail(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Owner\\chromedriver.exe");
        //driver = getChromeInstance();

        driver.get( "https://www.google.com/" );

        List<WebElement> linklist = new ArrayList(  );

        linklist = driver.findElements( By.xpath( "//*[@id=\"gbw\"]/div/div/div[1]" ) );


        linklist.size();
        System.out.println(linklist.size());
        WebElement gmaillink=linklist.get( 1 );

        gmaillink.click();


    }
        @Ignore("this test is not ready")
        @Test
        public void testExecption(){
            int i = 1/0;
            System.out.println(i);
        }
        public static void killDriver(){
           driver.close();
           driver.quit();
        }

    }


