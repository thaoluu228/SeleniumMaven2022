package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class BaseTest {
    public static WebDriver driver;

    //Start browser
    public static void createBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //open URL
    public static void openURL(String url) {
        driver.get(url);
    }

    //close browser
    public static void closeBrowser() {
        driver.close();
    }

    public static WebElement findElement(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public static void selectItemInDropdown(String parentXpath, String XpathList, String expectedText){
        findElement(parentXpath).click();
        sleep(2000);
        List<WebElement> allItems = driver.findElements(By.xpath(XpathList));
        for (WebElement element : allItems){
            System.out.println("Text = " + element.getText());
            if(element.getText().equals(expectedText)){
                sleep(1000);
                element.click();
                break;
            }
        }
    }

    public static void sleep ( int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
