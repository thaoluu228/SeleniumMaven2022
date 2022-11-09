package Exercise;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class AddProject extends BaseTest {
    public static void main(String[] args) throws InterruptedException {
        AddProject addProject = new AddProject();

        //open browser
        addProject.createBrowser();

        //open url
        addProject.openURL("https://app.hrsale.com/");

        //login with super admin
        findElement("//button[text()='Super Admin']").click();
        findElement("//button[@type='submit']").click();
        sleep(2000);

        //open new project
        findElement("//li[@class='pc-item']//a[@href='https://app.hrsale.com/erp/projects-grid']").click();
        findElement("//a[normalize-space()='Add Project']").click();

        //add new project
        findElement("//input[@placeholder='Title']").sendKeys("New Project Test");

        findElement("//span[@id='select2-client_id-container']").click();
        findElement("//li[contains(text(),'Cedric Kelly')]").click();
        sleep(2000);

        findElement("//input[@placeholder='Estimated Hour']").sendKeys("2");
        selectItemInDropdown("//span[@class='selection']//span[text()='Highest']","//li[@class='select2-results__option']","Normal");
        sleep(2000);

        findElement("//input[@placeholder='Start Date']").click();
        findElement("//a[normalize-space()='20']").click();
        findElement("//div[@class='dtp animated fadeIn']//button[text()='OK']").click();

        findElement("//input[@placeholder='End Date']").click();
        findElement("(//a[contains(text(),'25')])[2]").click();
        findElement("//div[@class='dtp animated fadeIn']//button[text()='OK']").click();

        findElement("//textarea[@id='summary']").sendKeys("Jennie test");

        selectItemInDropdown("//ul[@class='select2-selection__rendered']", "//li[@class='select2-results__option']", "Alan Butler");
        findElement("//td[@class='k-editable-area']").click();

        findElement("//div[@class='card-footer text-right']/button[@type='submit']").click();
        sleep(2000);

        //close browser
        addProject.closeBrowser();

        
    }
}
