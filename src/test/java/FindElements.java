import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class FindElements {

        public ChromeDriver driver;
        static final String KEY_SYSTEM_PROPERTY = "webdriver.chrome.driver";
        static final String VALUE_SYSTEM_PROPERTY = "src/test/resources/chromedriver.exe";


        @BeforeClass
        public void setUp() {
            System.setProperty(KEY_SYSTEM_PROPERTY, VALUE_SYSTEM_PROPERTY);
            ChromeOptions chromeOptions = new ChromeOptions();
            //chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
            driver.get("file:///D:/Training/homework18/src/main/java/mypage/mypage.html");
        }

        @Test
        public void findTableTest() {
            List<WebElement> tableHeader = driver.findElements(By.xpath("//tbody/tr[1]/th"));
            for (WebElement element : tableHeader) {
                assertEquals("Company should be shown", "Company", tableHeader.get(0).getText());
                assertEquals("Contact should be shown", "Contact", tableHeader.get(1).getText());
                assertEquals("Country should be shown", "Country", tableHeader.get(2).getText());
            }
        }

        @Test
        public void findInputFieldTest() {
            assertEquals("Search bar is not shown", true, driver.findElement(By.xpath("//div[@class='label']")).isDisplayed());
            }

        @Test
        public void findCheckboxTest() {
            assertEquals("Checkbox is not shown", true, driver.findElement(By.xpath("//div[@class='label-checkbox']")).isDisplayed());
        }

        @Test
        public void findSelectTest() {
            assertEquals("Dropdown is not shown", true, driver.findElement(By.cssSelector("#dropdown")).isDisplayed());
        }

        @Test
        public void findButtonTest() {
            assertEquals("Button is not shown", true, driver.findElement(By.xpath("//button[text()='Search']")).isDisplayed());
        }

        @Test
        public void findImageTest() {
            assertEquals("Image is not shown", true, driver.findElement(By.xpath("//img[contains(@src,'black-email-icon-8.jpg')]")).isDisplayed());
        }

        @Test
        public void findLinkTest() {
            assertEquals("Link is not available", true, driver.findElement(By.cssSelector("div.image>a")).isDisplayed());
        }
        @Test
        public void findParagraphTest() {
            assertEquals("Text is not shown", true, driver.findElement(By.xpath("//p[.='3 - Открыть файл используя Selenium']")).isDisplayed());
        }


            @AfterClass
            public void tearDown () {
                driver.quit();
            }
        }

