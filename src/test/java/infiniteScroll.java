import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class infiniteScroll {

    private WebDriver driver;
    String url = "http://the-internet.herokuapp.com/infinite_scroll";

    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(url);
    }

    @Test
    public void scrollPractice() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // using loop to scroll down 5 more times
        for (int i = 0; i < 6; i++) {
            js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
            System.out.println("Scroll x" + i);
        }

        // creating list for getting paragraphs
        List<String> allParagraphsValues = new ArrayList<String>();
        List<WebElement> allParagraphs = driver.findElements(By.xpath("//div[@class='jscroll-added']"));

        // grabbing each paragraph and getting the text
        for(WebElement ele : allParagraphs) {
            allParagraphsValues.add(ele.getText());
        }
        // printing out all the paragraphs
        System.out.println(allParagraphsValues);

        //scrolling back to the top to the header
        WebElement header = driver.findElement(By.tagName("h3"));
        js.executeScript("arguments[0].scrollIntoView();", header);

        //getting text of header then asserting and printing
        String headerText = header.getText();
        Assert.assertTrue(headerText.contains("Infinite Scroll"));
        System.out.println("Header says " + headerText);


    }


}
