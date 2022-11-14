package Bai8;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class BaiTap extends BaseTest {
    public static void loginCRM(){

        openURL("https://rise.fairsketch.com/signin");
        findElement("//input[@id='email']").clear();
        findElement("//input[@id='email']").sendKeys("admin@demo.com");
        findElement("//input[@id='password']").clear();
        findElement("//input[@id='password']").sendKeys("riseDemo");
        findElement("//button[normalize-space()='Sign in']").click();
    }
    //test login
    public static void enterAddClient(String clientName) {
        findElement("//input[@id='company_name']").sendKeys(clientName);
        findElement("//div[@id='s2id_created_by']").click();
        findElement("//div[@id='select2-drop']//input").sendKeys("Sara Ann", Keys.ENTER);
        driver.findElement(By.id("address")).sendKeys("DHĐT");
        driver.findElement(By.id("city")).sendKeys("Cao Lãnh");
        driver.findElement(By.id("state")).sendKeys("Đồng Tháp");
        driver.findElement(By.id("zip")).sendKeys("81000");
        driver.findElement(By.id("country")).sendKeys("Việt Nam");
        driver.findElement(By.id("phone")).sendKeys("123456789");
        driver.findElement(By.id("website")).sendKeys("https://anhtester.com");

        //scroll mouse to the last element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", findElement("//label[normalize-space()='Disable online payment']"));

        sleep(1000);
        driver.findElement(By.id("vat_number")).sendKeys("1");
        findElement("//div[@id='s2id_group_ids']").click();
        findElement("//div[@id='s2id_group_ids']//input").sendKeys("Gold", Keys.ENTER);
        findElement("//button[@type='submit']").click();
    }

        public static void searchClient(String clientName){
            findElement("//div[@id='client-table_filter']//input").sendKeys(clientName);
            sleep(2000);
            String clientTable = findElement("//table[@id='client-table']//tbody/tr//td[2]").getText();
            System.out.println("Name: " + clientTable);
        }

    public static void main(String[] args) throws Exception {
        createBrowser();

        loginCRM();

        findElement("//span[normalize-space()='Clients']").click();
        findElement("//div[@id='page-content']//a[normalize-space()='Clients']").click();
        findElement("//a[normalize-space()='Add client']").click();

        enterAddClient("Test");
        sleep(1000);
        searchClient("Test");

        closeBrowser();
    }
}
