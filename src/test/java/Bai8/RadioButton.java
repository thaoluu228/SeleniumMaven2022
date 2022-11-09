package Bai8;

import common.BaseTest;
import org.openqa.selenium.WebElement;

public class RadioButton extends BaseTest {
    public static void main(String[] args) throws Exception {
        createBrowser();
        openURL("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");

        WebElement radioButton = findElement("//label[normalize-space()='Female']//input[@name='optradio']");
        boolean isFemale = radioButton.isSelected();

        if (isFemale == false) {
            radioButton.click();
        }
        System.out.println(isFemale);

        sleep(2000);

        //group radioButton
        WebElement sexButton = findElement("//div[@class='panel-body']//div//label[@class='radio-inline'][normalize-space()='Male']");
        boolean isSexButton = sexButton.isSelected();

        if (isSexButton == false) {
            sexButton.click();
        }

        sleep(1000);

        WebElement ageButton = findElement("//label[normalize-space()='15 to 50']");
        ageButton.click();
        sleep(1000);

        findElement("//button[normalize-space()='Get values']").click();
        System.out.println(findElement("//p[@class='groupradiobutton']").getText());
        System.out.println(ageButton.getText());
        System.out.println(sexButton.getText());

        closeBrowser();
    }
}
