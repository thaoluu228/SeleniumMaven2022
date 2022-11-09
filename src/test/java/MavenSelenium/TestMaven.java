package MavenSelenium;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestMaven {
    public static void main(String[] args) throws InterruptedException{

            //Khởi tạo browser với Chrome
            WebDriver driver;
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            //Mở trang login
            driver.get("https://demo.activeitzone.com/ecommerce/login\"");

            //Bắt WebElement Email (object)
            WebElement inputEmail = driver.findElement(By.id("email"));
            inputEmail.sendKeys("admin@example.com");

            System.out.println("Lấy Text của ô Email: " + inputEmail.getText());
            System.out.println("Name ô Email: " + inputEmail.getAttribute("name"));
            System.out.println("Class ô Email: " + inputEmail.getAttribute("class"));

            //Tắt browser
            driver.quit();
        }

    }
