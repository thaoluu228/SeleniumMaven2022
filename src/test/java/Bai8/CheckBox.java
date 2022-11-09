package Bai8;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckBox extends BaseTest {
    public static void main(String[] args) throws Exception {
        createBrowser();

        openURL("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
        WebElement checkBoxOne = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        boolean checkboxStatus = checkBoxOne.isSelected();
        System.out.println("Checkboxbefore: " + checkboxStatus);

        //select checkbox
        if (checkboxStatus == false) {
            checkBoxOne.click();
        }

        sleep(2000);
        boolean checkboxStatusAfter = checkBoxOne.isSelected();
        System.out.println("Checkboxafter: " +checkboxStatusAfter);

        WebElement message = findElement("//div[@id='txtAge']");
        System.out.println("MessageDisplay: "+ message.isDisplayed());
        System.out.println(message.getText());

        closeBrowser();
    }

}
