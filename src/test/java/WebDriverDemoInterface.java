import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverDemoInterface implements WebDriverDemo {

    WebDriver driver = null;
    public WebDriver getWebPage(){
        driver=new FirefoxDriver(  );
        //driver = new ChromeDriver(  );
        return driver;
    }
    public void getUrlPage() {
        driver = getWebPage();
        driver.get( "https://uk.rs-online.com/" );

    }

    public void Teardown() {
        driver.close();
        //driver.quit();

    }

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","C:\\Users\\Owner\\GekoDriver\\geckodriver.exe");
       // System.setProperty("webdriver.chrome.driver","C:\\Users\\Owner\\chromedriver.exe");

        WebDriverDemoInterface webinter = new WebDriverDemoInterface();
        webinter.getWebPage();
        webinter.getUrlPage();
        webinter.Teardown();
    }
}
