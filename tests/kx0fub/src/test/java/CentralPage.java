import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.Assert.assertTrue;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
class CentralPage extends PrimaryPage {
    private By loginLocator = By.xpath("/html/body/div[3]/div[1]/a[3]");
    private By usernameFieldLocator = By.xpath("//*[@id='login-form']/div[1]/input[1]");
    private By passwordFieldLocator = By.xpath("//*[@id='login-form']/div[1]/input[2]");
    private By loginButtonLocator = By.xpath("//*[@id='login-button']");
    //Message
    private By forumMessageLocator = By.xpath("//*[@id=\"messages_btn\"]");
    private By forumMessageFriendLocator = By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div/div[3]/div/a");
    private By forumMessageSpaceLocator = By.xpath("//*[@id=\"chat\"]");
    private By messagesLocator = By.xpath("//div[@class='chat-container']");
    private By logoutButtonLocatorOpenerLocator = By.xpath("/html/body/div[3]/div[1]/div[2]/div[1]");
    private By logoutButtonLocator = By.xpath("//*[@id='menu-dd-container']/div/a[10]");
    RandomStringGenerator generator = new RandomStringGenerator();
    String randomString = generator.generateString();
    private By searchBarOpenButtonLocator = By.className("search-bar-toggler");
    private By searchBarLocator = By.name("search");
    public CentralPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://replay.az/");
    }
    public void loggin(String userName, String userPassword) {
        WebElement openLogin = waitVisibilityAndFindElement(loginLocator);
        openLogin.click();
        WebElement usernameField = waitVisibilityAndFindElement(usernameFieldLocator);
        usernameField.sendKeys(userName);
        WebElement passwordField = waitVisibilityAndFindElement(passwordFieldLocator);
        passwordField.sendKeys(userPassword);
        WebElement loginButton = waitVisibilityAndFindElement(loginButtonLocator);
        loginButton.click();
        //After succesfull,login check forum select friend and send him message: "Hallo,ich bin Tester"
        WebElement messageButton=waitVisibilityAndFindElement(forumMessageLocator);
        messageButton.click();
        WebElement friendSelectButton=waitVisibilityAndFindElement(forumMessageFriendLocator);
        friendSelectButton.click();
        WebElement sendMessageFriend=waitVisibilityAndFindElement(forumMessageSpaceLocator);
        sendMessageFriend.click();
        sendMessageFriend.sendKeys(randomString);
        sendMessageFriend.sendKeys(Keys.ENTER);
        WebElement seeMessages=waitVisibilityAndFindElement(messagesLocator);
        String allMessages=seeMessages.getText();
        assertTrue(allMessages.contains(randomString));
        // System.out.println(seeMessages.getText());
        //Check log out functionality of web Site
        WebElement FindLogout = waitVisibilityAndFindElement(logoutButtonLocatorOpenerLocator);
        FindLogout.click();
        WebElement TriggerLogout = waitVisibilityAndFindElement(logoutButtonLocator);
        TriggerLogout.click();
    }
    public Boolean checkBodyWord(String keyWord,String textBody) {
        return textBody.contains(keyWord);


    }

}

