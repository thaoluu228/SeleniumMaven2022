package Bai8;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MultiCheckbox extends BaseTest {
    public static void main(String[] args) throws Exception {
        createBrowser();
        openURL("https://demo.seleniumeasy.com/basic-checkbox-demo.html");

        List<WebElement> listCheckboxes = driver.findElements(By.xpath("//label[contains(normalize-space(),'Option')]/input"));
        System.out.println("Number of checkboxes: " + listCheckboxes.size());

        //select checkboxes
        for (int i = 1; i <= listCheckboxes.size(); i++) {
            findElement("//label[normalize-space()='Option " + i + "']").click();
        }

        sleep(2000);

        for (int i = 1; i <= listCheckboxes.size(); i++) {
            boolean isSelected = findElement("//label[normalize-space()='Option " + i + "']/input").isSelected();
            System.out.println("CheckboxSelected: " + i + isSelected);
        }

        closeBrowser();

    }
}
