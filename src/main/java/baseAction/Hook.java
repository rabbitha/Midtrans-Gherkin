package baseAction;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Hook {
    public static WebDriver driver = new ChromeDriver();

    //Variable
    public static String accessWeb = "https://demo.midtrans.com/";

    //verify Page
    public static String Box_Midtrans = "(//div[@class='ss-box-inner'])";
    public static String Button_BuyNow = "(//a [@class='btn buy'])";
    public static String Button_SignUp = "(//a [@class='btn btn-signup'])";
    public static String Title_Expected = "Sample Store";


    @BeforeAll
//    @Before
    public static void beforeAfter(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();

        //access website
        driver.get(accessWeb);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //verify page
        String Title_Actual = driver.getTitle();
        System.out.println("Expected Title : " + Title_Expected);
        System.out.println("Actual Title : " + Title_Actual);
        assertEquals(Title_Expected,Title_Actual);
        System.out.println("--- The Title Page is Match ---");

        boolean Box_Midtrans_displayed = driver.findElement(By.xpath(Box_Midtrans)).isDisplayed();
        boolean Button_BuyNow_displayed =driver.findElement(By.xpath(Button_BuyNow)).isDisplayed();
        boolean Box_MidTrans_displayed = driver.findElement(By.xpath(Button_SignUp)).isDisplayed();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        if(Box_Midtrans_displayed && Button_BuyNow_displayed && Box_MidTrans_displayed){
            System.out.println("--- Element on Homepage Displayed ---");
        } else{
            System.out.println("--- Element on Homepage is Not Displayed ---");
        }
        System.out.println("--- Hei, you on homepage! ---");
    }

    @AfterAll
//    @After
//    public static void teardown() {
//        driver.quit();
//    }

}
