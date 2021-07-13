import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.Set;

public class multipleWindows {

    private WebDriver driver;
    String url = "http://the-internet.herokuapp.com/windows";


    @Before
    public void init(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
    }


    @Test
    public void clickingEditingWindowTabs() {
        WebElement windowLink = driver.findElement(By.xpath("//a[text()='Click Here']"));
        //Statement 1 sets a variable before the loop starts (int i = 0).
        //Statement 2 defines the condition for the loop to run (i must be less than 5). If the condition is true, the loop will start over again, if it is false, the loop will end.
        //Statement 3 increases a value (i++) each time the code block in the loop has been exec
        for (int i = 0; i < 5; i++){
            windowLink.click();
        }

        // UPDATE for loop to click

        ArrayList<String> tabs =  new ArrayList<String>(driver.getWindowHandles()); //creating array to get different tabs
        driver.switchTo().window(tabs.get(0));
        driver.close(); //closing original tab

        driver.switchTo().window(tabs.get(1));
        driver.get("http://yahoo.com");
        driver.switchTo().window(tabs.get(2));
        driver.get("http://google.com");
        driver.switchTo().window(tabs.get(3));
        driver.get("http://amazon.com");
        driver.switchTo().window(tabs.get(4));
        driver.get("http://youtube.com");
        driver.switchTo().window(tabs.get(5));
        driver.get("http://etsy.com");

        driver.switchTo().window(tabs.get(2));
        //VERIFY THAT ITS GOOGLE
        String getGoogle = driver.getTitle();
        Assert.assertTrue(getGoogle.contains("Google"));
        System.out.println("Going to Google tab");

        WebElement inputSearch = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        inputSearch.sendKeys("Wooden Spoon" + Keys.ENTER);
        String inputValue = driver.getTitle(); //getting the page title
        Assert.assertTrue(inputValue.contains("Wooden Spoon"));
        System.out.println("Tab name is " + inputValue);

    }
}
