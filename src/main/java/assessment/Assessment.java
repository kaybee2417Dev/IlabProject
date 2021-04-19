package assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assessment {

    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement element;

    @BeforeTest
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\abks580\\Downloads\\TestDataDashBoard\\Assessment\\src\\main\\java\\libs\\chromedriver.exe");  //for chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void mainTest() throws InterruptedException {

        driver.get("https://now.dstv.com/");

        driver.findElement(By.cssSelector(".Buttons__secondary__2v_lf")).click();

        driver.findElement(By.id("EmailOrMobileNumber")).sendKeys("nondstvprod@mailinator.com");
        driver.findElement(By.id("Password")).sendKeys("123456");

        driver.findElement(By.id("btnSubmit")).click();

        driver.findElement(By.cssSelector(".Buttons__secondary__2v_lf")).click();
        Thread.sleep(200);
        driver.findElement(By.id("EmailOrMobileNumber")).sendKeys("nondstvprod@mailinator.com");
        Thread.sleep(200);
        driver.findElement(By.id("Password")).sendKeys("123456");
        Thread.sleep(200);
        driver.findElement(By.id("btnSubmit")).click();
        Thread.sleep(200);
        driver.findElement(By.cssSelector(".link")).click();

        //  WebElement wait;
        wait = new WebDriverWait(driver,50);

        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/main/section/ul/li[1]/div/div/img")));
        element.click();

        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/header/div/div/div[2]/nav/ul/li[4]/div")));

        String data =  driver.findElement(By.xpath("//*[@id=\"root\"]/header/div/div/div[2]/nav/ul/li[4]/div")).getText();

        Assert.assertEquals(data,"Movies");
        driver.quit();
    }

    @AfterTest
    public void testComplete(){

    }
}
