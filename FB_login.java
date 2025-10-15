package SQTA;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FB_login { 
    
    public static void main(String[] args) {
        String driverPath = "D:\\New folder (3)\\Eclips Software\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath); 
        
        ChromeOptions options = new ChromeOptions();
        // (optional) You can add options like headless mode, arguments, etc.

        WebDriver driver = new ChromeDriver(options);
        String appUrl = "https://www.facebook.com/";
        
        // Launch browser and open the application URL
        driver.get(appUrl);
        
        // Maximize the browser window
        driver.manage().window().maximize();
        
        // Store expected title
        String expectedTitle = "Facebook – log in or sign up";
        String actualTitle = driver.getTitle();
        
        // Title verification
        if (expectedTitle.equals(actualTitle)) { 
            System.out.println("Verification Successful - The correct title is displayed."); 
        } else { 
            System.out.println("Verification Failed - An incorrect title is displayed."); 
        }

        // Enter username and password
        WebElement username = driver.findElement(By.id("email")); 
        username.clear(); 
        username.sendKeys("your email id");  
        
        WebElement password = driver.findElement(By.id("pass")); 
        password.clear(); 
        password.sendKeys("your password"); 
        password.sendKeys(Keys.ENTER); 
        
        // Click the login button
        WebElement loginBtn = driver.findElement(By.name("login"));
        loginBtn.click();

        // (Optional) Wait for login to process; 
        // Thread.sleep(5000); // or better: use WebDriverWait with ExpectedConditions
        
        // Close browser and quit driver
        driver.quit(); 
        System.out.println("Test script executed successfully."); 
    } 
}
