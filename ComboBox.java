package SQTA;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class ComboBox {
    static String driverPath = "D:\\New folder (3)\\Eclips Software\\chromedriver-win64\\chromedriver.exe";
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", driverPath);
        
        ChromeOptions options = new ChromeOptions();
        // Add Chrome options if needed

        WebDriver driver = new ChromeDriver(options);
        String appUrl = "http://127.0.0.1:3000/c:/Users/HP/Downloads/combobox.html?serverWindowId=daf6f423-37fc-44cd-8ea6-4a3236fc30acl";
        
        driver.get(appUrl);

        Select oSelect = new Select(driver.findElement(By.id("continents")));
        // Alternatively:
        // Select oSelect = new Select(driver.findElement(By.tagName("select")));

        List<WebElement> oSize = oSelect.getOptions();
        int iListSize = oSize.size();

        for(int i = 0; i < iListSize; i++) {
            String sValue = oSize.get(i).getText();
            System.out.println(sValue);
        }
        System.out.println("Total No. Items in Dropdown: " + iListSize);
        
        driver.quit();
    }
}
