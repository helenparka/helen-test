import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicBrowserFunctions {

    @Test
    public void testingGoogle() {

        WebDriverManager.chromedriver().setup(); //setting up the chrome driver
        WebDriver driver = new ChromeDriver(); //creating it

        String googleURL = "https://www.google.com/"; //adding the url

        driver.get(googleURL); //getting url
        String currentUrl = driver.getCurrentUrl(); //url to compare to

        Assert.assertTrue(googleURL.equals(currentUrl)); //using boolean
//      Assert.assertEquals(googleURL, currentUrl); //by data type
        System.out.println(googleURL + " is equal to " + currentUrl); //printing message

//        WebElement imagesLink = driver.findElement(By.xpath("//a[text()='Images']")); //creating web element that point to Images link
//        imagesLink.click(); //clicking on link

        WebElement gmailLink = driver.findElement(By.xpath("//a[text()='Gmail']")); // getting the gmail link
        gmailLink.click(); //clicking link

        driver.get(googleURL); //going back to Google

        WebElement inputSearch = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")); //getting search bar

        inputSearch.sendKeys("Hello" + Keys.ENTER); //entering hello
//        inputSearch.sendKeys(Keys.ENTER);// pressing enter

//        driver.close();
    }
    @Test
    public void dropdownTesting() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        String practiceSite = "https://chercher.tech/practice/practice-dropdowns-selenium-webdriver"; //getting url

        driver.get(practiceSite); //going to url

        // selecting products dropdown
        Select dropdown1 = new Select(driver.findElement(By.xpath("//*[@id='first' and @class='col-lg-3']")));
        dropdown1.selectByVisibleText("Google");
        // selecting animal dropdown
        Select dropdown2 = new Select(driver.findElement(By.xpath("//*[@id='animals' and @class='col-lg-3']")));
        dropdown2.selectByVisibleText("Avatar");
        // selecting multiple food dropdown
        Select dropdown3 = new Select(driver.findElement(By.xpath("//*[@id='second' and @class='col-lg-3']")));
        dropdown3.selectByVisibleText("Donut");
        dropdown3.selectByVisibleText("Burger");
        // .selectByVisibleText good for dynamic dropdowns

        // printing out of all choices from products
        List<String> listOfProducts = new ArrayList<>();
        listOfProducts.addAll(Arrays.asList("Bing","Google", "Iphone", "Yahoo"));
        System.out.println(listOfProducts);

    }
    @Test
    public void radioButtons() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        String radioPractice = "https://www.seleniumeasy.com/test/basic-radiobutton-demo.html";
        driver.get(radioPractice);

        //selecting radio button
        WebElement radio1 = driver.findElement(By.xpath("//*[@value=\"Male\" and @name=\"optradio\"]"));
        radio1.click();
        // getting the value fields from above
        String getMale = radio1.getAttribute("value");
        // comparing the value in radiobutton to text "Male"
        Assert.assertTrue(getMale.contains("Male"));
        System.out.println(getMale + " has been selected");

    }
}
