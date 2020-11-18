import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import java.util.concurrent.TimeUnit;

public class HelloWebDriver {

    public static void main(String[] args) throws InterruptedException {
        WebDriver chrome = new ChromeDriver();
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        chrome.get("https://www.lamoda.by/men-home/");
        //Thread.sleep(1000);
        WebElement searchButton = chrome.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/div/div[2]"));
        searchButton.click();
        WebElement searchInput = chrome.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/div/input"));
        searchInput.sendKeys("SA007AMJONT5");
        searchInput.sendKeys(Keys.ENTER);




    }



}
