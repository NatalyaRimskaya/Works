import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class SimpleTest {
    private WebDriver driver;
    private String baseUrl;
    private String searchword = "cute cat";


    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "http://google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testTtdasfguhapsdfuhyoaisduf() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.cssSelector("#lst-ib")).click();
        driver.findElement(By.cssSelector("#lst-ib")).sendKeys(searchword);
        driver.findElement(By.cssSelector("#lst-ib")).submit();
        List<WebElement> myElements = driver.findElements(By.cssSelector(".rc"));
       for (WebElement el : myElements) {
           String[] test = searchword.split("\\s+");
           for (String word : test) {
            assertTrue("Result doesn`t contain search word",el.getText().toLowerCase().contains(word.toLowerCase()));

        }
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.scrollBy(0,1900)", "");
        driver.findElement(By.cssSelector("[aria-label='Page 2" + "']")).click();
        List<WebElement> myElements1 = driver.findElements(By.cssSelector(".rc"));
        for (WebElement el1 : myElements1) {
            String[] testone = searchword.split("\\s+");
            for (String word : testone) {
                assertTrue("Result doesn`t contain search word",el1.getText().toLowerCase().contains(word.toLowerCase()));
            }



    }}

    @After
        public void tearDown() throws Exception {
           driver.quit();
        }

}}


