
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
    public void AddingItemsToCartTest() throws InterruptedException {


       chrome.get("https://www.lamoda.by/men-home/");
       WebElement searchButton = chrome.findElement(By.xpath("//div[@class='button button_blue search__button js-search-button']"));
       searchButton.click();
        WebElement searchInput = chrome.findElement(By.xpath("//input[@class='text-field text-field_large search__input js-search-field']"));
       //WebElement searchInput = chrome.findElement(By.xpath(" /html/body/div[1]/div[3]/div/div/div/div/input"));
       searchInput.click();
       searchInput.sendKeys("SA007AMJONT5");
       searchInput.sendKeys(Keys.ENTER);
        WebElement addToCartButton = chrome.findElement(By.xpath("//button[@class]"));
 //      WebElement sizeChoiceCombobox = chrome.findElement(By.xpath("//div[@tabindex='0']"));
        addToCartButton.click();
       WebElement targetSize = chrome.findElement(By.xpath("//*[@id=\"vue-root\"]/div[2]/div[1]/div[2]/div[2]/div/div[3]/div/div[3]/div/div[1]/div/div[2]/div[2]/div[1]"));
       targetSize.click();
       addToCartButton.click();
       WebElement goToCartButton = chrome.findElement(By.xpath("//div[@class='d-modal__bottom']/a"));
       goToCartButton.click();
       List<WebElement> itemsInCart = chrome.findElements(By.xpath("//div[@data-sku='SA007AMJONT5B065']"));
       Assert.assertTrue(itemsInCart.size()>0,"The item has not been added to the cart");



    }

    @AfterMethod(alwaysRun = true)
    public void BrowserTearDown() {
        chrome.quit();
    }

    }
