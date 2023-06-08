import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;



public class NewTest {
    private WebDriver driver;
    private WebDriverWait wait;

    public String userName="tomsmith";
    public String userPassword="Tomas123";
    public String findWord="Populyar";
    public String keyWord2="Europa plus";

    // System.out.println(randomString);
    

    @Before
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        this.driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), (Capabilities) options);
        this.driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver, 30);
    }
    //Complex x-pahtes
    private By footerContainLocator = By.xpath("//div[contains(@class, 'footer-container')]");
    private WebElement waitVisibilityAndFindElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }
    @Test
    public void testSuccessLoginsendForumandLogout() {
        //Go this web site and enter this credentials
        CentralPage mainPage = new CentralPage(this.driver);
        mainPage.loggin(userName,userPassword);

        
    }
    @Test
    public void ReadPageTitle() {
        CentralPage mainPage = new CentralPage(this.driver);
        //Verify the title of the website can be readen , then print it 
        String actualTitle=mainPage.pageTitleText();
        System.out.println(actualTitle);
    }
    @Test
    public void StaticPageTest() {
        CentralPage mainPage = new CentralPage(this.driver);
        // Verify the presence and visibility of the logo
        String staticCheckText = mainPage.getBody();
        
        assertTrue(mainPage.checkBodyWord(findWord,staticCheckText));

}
    @Test
    public void ComplexXpathTest() {
        CentralPage mainPage = new CentralPage(this.driver);
        String text = mainPage.getFooter();
        System.out.println(text);
        Boolean wordExists = mainPage.checkBodyWord(keyWord2,text);
        assertTrue(wordExists);
    }

    @After
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}