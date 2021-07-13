import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MorePractice {
    @Test
    public void vptHappyPath() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        String vptLink = "https://test.vpt.vidoori.com";
        driver.get(vptLink);

        WebElement inputAccountID = driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]"));
        inputAccountID.click();
        inputAccountID.sendKeys("hp");
        System.out.println("Account ID has been entered");

        WebElement inputUsername = driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]"));
        inputUsername.click();
        inputUsername.sendKeys("helenparka@gmail.com");
        System.out.println("Username has been entered");

        WebElement inputPassword = driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]"));
        inputPassword.click();
        inputPassword.sendKeys("helloWorld1!");
        System.out.println("Password has been entered");

        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"main\"]/app-root/div/div/ng-component/div[1]/div[1]/div/div[4]/div/div[1]/form/button"));
        signInButton.click();
        System.out.println("Clicked Sign In button");

        WebElement projectsTab = driver.findElement(By.xpath("//*[@id=\"mobileMenu\"]/ul/li[2]/a"));
        projectsTab.click();
        System.out.println("Clicked Projects tab");


    }
}
