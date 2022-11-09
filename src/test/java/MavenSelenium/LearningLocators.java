package MavenSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class LearningLocators {
    public static void main(String[] args) {

        //Open Chrome browser
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Open url
        driver.get("https://app.hrsale.com/");

        //Login with super admin
        driver.findElement(By.xpath("//button[text()='Super Admin']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Select projects
        driver.findElement(By.xpath("//ul[@class='pc-navbar']//following::a[@href='https://app.hrsale.com/erp/projects-grid']")).click();

        //add new projects
        driver.findElement(By.xpath("//a[normalize-space()='Add Project']")).click();

        //Verify form

        Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Title']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[@id='select2-client_id-container']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Estimated Hour']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='start_date']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='end_date']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//textarea[@name='summary']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//table[@role='presentation']")).isDisplayed());


        //CLose browser
        driver.quit();
    }
}
