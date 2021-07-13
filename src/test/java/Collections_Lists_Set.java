import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.openqa.selenium.WebElement;

class Collections_List_Set {
    //    private static final Logger log = LogManager.getLogger(Collections_List_Set.class);
    private WebDriver driver;
    String url = "https://artoftesting.com/sampleSiteForSelenium";

    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.close();//closes the current tab
        driver.quit(); //closes the whole browser
    }

    @Test
    public void collections_Test() {
        driver.get(url);
        List<WebElement> listOfAll_Links_On_The_Page = driver.findElements(By.xpath("//a[@href]"));
        List<String> listOf_textOfEachLink = new ArrayList<>();
        //called a forEach Loop. Will go through the whole Collection, in this case the whole ArrayList.
        for (WebElement eachWebElement : listOfAll_Links_On_The_Page) {
            listOf_textOfEachLink.add(eachWebElement.getText());
        }
        System.out.println("listOf_textOfEachLink = " + listOf_textOfEachLink);
        System.out.println("**************************************************");
//        listOf_textOfEachLink.removeIf(p->p.length()<1);
        for (String eachElementInMyListOfLinkText : listOf_textOfEachLink) {
            if (eachElementInMyListOfLinkText.length() > 1) {
                System.out.println(eachElementInMyListOfLinkText);
            }
        }
        System.out.println("--------------------------------------------------");
        Set<String> setOf_AllUnique_LinkTexts = new TreeSet<>();
        setOf_AllUnique_LinkTexts.addAll(listOf_textOfEachLink);
        for (String eachUniqueLinkText : setOf_AllUnique_LinkTexts) {
            System.out.println(eachUniqueLinkText);
        }
        //ALL Different from eachother
//        String word = "";
//        String word2 = " ";
//        String word3 = null;
        System.out.println("listOfAll_Links_On_The_Page.size() = " + listOfAll_Links_On_The_Page.size());
        System.out.println("setOf_AllUnique_LinkTexts.size() = " + setOf_AllUnique_LinkTexts.size());
        Assert.assertEquals(50, listOfAll_Links_On_The_Page.size());
        System.out.println("TEST 1");
    }
}