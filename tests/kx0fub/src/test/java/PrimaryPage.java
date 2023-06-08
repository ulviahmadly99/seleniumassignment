import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Cookie;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
public class PrimaryPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected By bodyLocator =By.tagName("body");
    protected By footerLocator =By.xpath("//div[@class='footer']");
    public PrimaryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }
    
    // Wait until body visible
    protected WebElement waitVisibilityAndFindElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }


    // Check text in body
    public String getBody() {
        WebElement bodyElement = this.waitVisibilityAndFindElement(bodyLocator);
        return bodyElement.getText();
    }

    // Check text of footer
    public String getFooter() {
        WebElement footerElement = this.waitVisibilityAndFindElement(footerLocator);
        return footerElement.getText();
    }

    // Check footer element text
    public Boolean checkWordInFooter(String footerWord) {
        WebElement footerElement = this.waitVisibilityAndFindElement(footerLocator);
        String footerText = footerElement.getText();
        Boolean boolText=footerText.contains(footerWord);
        return boolText;
    }

    // Check page title
    public String pageTitleText() {
        String title = this.driver.getTitle();
        return title;
    }

}