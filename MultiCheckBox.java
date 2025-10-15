package SQTA;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MultiCheckBox {
    static String driverPath = "D:\\\\New folder (3)\\\\Eclips Software\\\\chromedriver-win64\\\\chromedriver.exe";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions options = new ChromeOptions();
        // You can add ChromeOptions if needed

        WebDriver driver = new ChromeDriver(options);
        String appUrl = "http://127.0.0.1:3000/c:/Users/HP/Downloads/multicheckbox.html?serverWindowId=fbb4a210-b405-4019-b3a0-71cf82204215";
        // For local file, uncomment:
        // String appUrl = "file:///D:/Usman/College/503%20pracs/multicheckbox.html";
        driver.get(appUrl);

        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        int checkedCount = 0, uncheckedCount = 0;
        for (int i = 0; i < checkBoxes.size(); i++) {
            System.out.println(i + " checkbox is selected " + checkBoxes.get(i).isSelected());
            if (checkBoxes.get(i).isSelected()) {
                checkedCount++;
            } else {
                uncheckedCount++;
            }
        }
        System.out.println("No. of selected checkbox: " + checkedCount);
        System.out.println("No. of unselected checkbox: " + uncheckedCount);

        driver.quit();
    }
}
