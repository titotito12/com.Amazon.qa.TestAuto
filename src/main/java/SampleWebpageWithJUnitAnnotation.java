import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SampleWebpageWithJUnitAnnotation {
    private static WebDriver driver;

    @Before
    public void getFirefoxInstance() {
        System.setProperty( "webdriver.gecko.driver", "C:\\Users\\Owner\\GekoDriver\\geckodriver.exe" );
        driver = new FirefoxDriver();

        //System.setProperty( "webdriver.chrome.driver","C:\\Users\\Owner\\chromedriver.exe" );

    }

    @Test

    public void goToLink() throws InterruptedException {
        // System.setProperty( "webdriver.chrome.driver","C:\\Users\\Owner\\chromedriver.exe" );
        // System.setPr operty( "webdriver.gecko.driver", "C:\\Users\\Owner\\GekoDriver\\geckodriver.exe" );
        driver.get( "https://www.testandquiz.com/selenium/testing.html" );

        WebElement link = driver.findElement( By.linkText( "This is a link" ) );
        link.click();
        // String pageUrlAfterLink = driver.getCurrentUrl();
        // String expectedUrl = "https://www.javatpoint.com/";
        // Assert.assertEquals( expectedUrl, pageUrlAfterLink );
        String pageTitle = driver.getTitle();
        String expectedTitle = "Tutorials List - Javatpoint";
        Assert.assertEquals( pageTitle, expectedTitle );
        Thread.sleep( 1000 );
        //driver.navigate().to( "https://www.testandquiz.com/selenium/testing.html" );
        driver.navigate().back();
        Thread.sleep( 2000 );
    }

    /*@Test
        public void gotoPartialLink() throws InterruptedException {
            WebElement partiaLink = driver.findElement( By.partialLinkText( " a link" ) );
            partiaLink.click();
            String pageUrlAfterPartialLink = driver.getCurrentUrl();
            String expectedPartialUrl = "https://www.javatpoint.com/";
            Assert.assertEquals( expectedPartialUrl, pageUrlAfterPartialLink );
            Thread.sleep( 1000 );
            driver.navigate().to( "https://www.testandquiz.com/selenium/testing.html" );
        }
        */
    //@Ignore
    @Test
    public void textBoxandButton() throws InterruptedException {
        driver.get( "https://www.testandquiz.com/selenium/testing.html" );
        WebElement textBox = driver.findElement( By.xpath( "//*[@id=\"fname\"]" ) );
        textBox.sendKeys( "total" );


        WebElement summitButton = driver.findElement( By.id( "idOfButton" ) );
        summitButton.click();
        Thread.sleep( 1000 );
    }
        @Test
        public void summitButton () throws InterruptedException {
            driver.get( "https://www.testandquiz.com/selenium/testing.html" );

            WebElement radiomale = driver.findElement( By.id( "male" ) );
            radiomale.isDisplayed();
            radiomale.click();
            Thread.sleep( 1000 );
        }

        @Test
        public void enterRadioButton () throws InterruptedException {
            driver.get( "https://www.testandquiz.com/selenium/testing.html" );
            WebElement radiofemale = driver.findElement( By.id( "female" ) );
            System.out.println( radiofemale.isDisplayed() );
            System.out.println( radiofemale.isSelected() );

            radiofemale.click();
            Thread.sleep( 1000 );
        }
        public void selectDropDown () throws InterruptedException {
            driver.get( "https://www.testandquiz.com/selenium/testing.html" );
            Select dropDown = new Select( driver.findElement( By.id( "testingDropdown" ) ) );
            dropDown.selectByVisibleText( "Manual Testing" );
            Thread.sleep( 1000 );

        }
        @After
        public void closeBrowser ()
        {
            driver.close();
        }


    }



