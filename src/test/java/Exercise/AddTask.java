package Exercise;

import common.BaseTest;

public class AddTask extends BaseTest {
    public static void main(String[] args) throws InterruptedException {
        AddTask task = new AddTask();

        //open browser
        task.createBrowser();

        //open url
        task.openURL("https://app.hrsale.com/");

        //login with super admin
        findElement("//input[@id='iusername']").sendKeys("frances.burns");
        findElement("//input[@id='password']").sendKeys("frances.burns");
        findElement("//button[@type='submit']").click();
        sleep(2000);

        //open new task
        findElement("//li[@class='pc-item']//a[@href='https://app.hrsale.com/erp/tasks-grid']").click();
        findElement("//a[normalize-space()='Add Task']").click();

        //add new task
        findElement("//input[@placeholder='Title']").sendKeys("Jennie test");

        findElement("//input[@placeholder='Start Date']").click();
        findElement("//a[normalize-space()='19']").click();
        findElement("//div[@class='dtp animated fadeIn']//button[text()='OK']").click();
        sleep(2000);

        findElement("//input[@placeholder='End Date']").click();
        findElement("(//a[contains(text(),'27')])[2]").click();
        findElement("//div[@class='dtp animated fadeIn']//button[text()='OK']").click();
        sleep(2000);

        findElement("//input[@placeholder='Estimated Hour']").sendKeys("1");
        sleep(2000);

        findElement("//span[@role='combobox']").click();
        sleep(3000);
        findElement("//span[@class='select2-results']/ul[@class='select2-results__options']/li[1]").click();
        sleep(2000);

        findElement("//textarea[@id='summary']").sendKeys("Jennie test");

        driver.switchTo().frame(0);
        findElement("//body").sendKeys("Testing automation test");

        driver.switchTo().defaultContent();
        findElement("//div[@class='card-footer text-right']/button[@type='submit']").click();
        sleep(2000);

        //close browser
        task.closeBrowser();

    }

}
