import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class dragDrop {

    private WebDriver driver;
    String url = "https://the-internet.herokuapp.com/drag_and_drop";

    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //wait 10 sec for lage to load
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); //wait 10 sec for elements to be found

        driver.get(url);

    }
    @Test
    public void practice() {

        Actions a1 = new Actions(driver); //comes from selenium and accepts as argument

        WebElement boxA = driver.findElement(By.id("column-a"));
        WebElement boxB = driver.findElement(By.id("column-b"));

        a1.dragAndDrop(boxA, boxB).build().perform();

    }
}
