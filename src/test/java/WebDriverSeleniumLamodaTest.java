
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSeleniumLamodaTest{
    WebDriver chrome;

    @BeforeMethod(alwaysRun = true)
    public void BrowserSetup(){
        System.setProperty("webdriver.chrome.driver", "D://WebDriver/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        chromeOptions.addArguments("--lang=ru");
        chrome = new ChromeDriver(chromeOptions);
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void SearchItemTest() throws InterruptedException {


       chrome.get("https://www.lamoda.by/men-home/");
       WebElement searchButton = chrome.findElement(By.xpath("//div[@class='button button_blue search__button js-search-button']"));
       searchButton.click();
        WebElement searchInput = chrome.findElement(By.xpath("//input[@class='text-field text-field_large search__input js-search-field']"));
       //WebElement searchInput = chrome.findElement(By.xpath(" /html/body/div[1]/div[3]/div/div/div/div/input"));
       searchInput.click();
       searchInput.sendKeys("SA007AMJONT5");
       searchInput.sendKeys(Keys.ENTER);
        String assertItemTitle = "Ботинки трекинговые OUTward GTX";

        WebElement titleElement = chrome.findElement(By.xpath("//span[@class='product-title__model-name']"));
        Assert.assertEquals(titleElement.getText().getBytes(),assertItemTitle.getBytes());



    }

    @AfterMethod(alwaysRun = true)
    public void BrowserTearDown() {
        chrome.quit();
    }

    }
