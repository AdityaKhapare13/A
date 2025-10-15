package SQTA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FIndAllLink {
    static String driverPath = "D:\\New folder (3)\\Eclips Software\\chromedriver-win64\\chromedriver.exe";
    
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", driverPath);
        
        ChromeOptions options = new ChromeOptions();
        // You can add additional Chrome options if needed
        
        WebDriver driver = new ChromeDriver(options);
        String appUrl = "https://www.google.co.in/";
        driver.get(appUrl);

        java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
        for (int i = 0; i < links.size(); i++) {   // Note: Use i = 0 as the starting index
            System.out.println(links.get(i).getText());
        }
        System.out.println("Total No. of Links: " + links.size());
        
        driver.quit();
    }
}
