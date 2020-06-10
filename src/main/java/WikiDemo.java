import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WikiDemo {
    WebDriver driver= null;

    public WebDriver getFirefoxinstance(){
        driver = new FirefoxDriver(  );
        return  driver;

    }
    public WebDriver getChromeDriverinstance(){
        driver = new ChromeDriver(  );
        return  driver;

    }
    public void getWbsite(String  browser){

        if (browser.equalsIgnoreCase( "chrome" )){
            //System.setProperty("webdriver.chrome.driver","C:\\Users\\Owner\\chromedriver.exe");
            //System.setProperty("webdriver.gecko.driver","C:\\Users\\Owner\\GekoDriver\\geckodriver.exe");

            driver= getChromeDriverinstance();


    }
     else{
            System.setProperty("webdriver.gecko.driver","C:\\Users\\Owner\\GekoDriver\\geckodriver.exe");
         driver=getFirefoxinstance();



    }
     driver.get( "https://www.wikipedia.org/ ");
     WebElement searchTextBox = driver.findElement( By.id("searchInput") );
     searchTextBox.isDisplayed();
     searchTextBox.sendKeys( "corona" );
     WebElement searchButton = driver.findElement( By.xpath( "//*[@id=\"search-form\"]/fieldset/button/i" ) );
     searchButton.isDisplayed();
     searchButton.click();

}
public void Teardown(){
        driver.close();
}

    public static void main(String[] args) {
       // System.setProperty("webdriver.chrome.driver","C:\\Users\\Owner\\chromedriver.exe");

        WikiDemo wiki = new WikiDemo();
        wiki.getWbsite( "firefox");
        wiki.Teardown();
    }
}

