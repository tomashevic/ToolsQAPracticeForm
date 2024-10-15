package Base;

import Pages.*;
import Tests.SubmitFormTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {

    public static WebDriver driver;
    public HomepagePage homepagePage;
    public SideBarPage sideBarPage;
    public SubmitFormTest submitFormTest;
    public PracticeFormPage practiceFormPage;
    public JavascriptExecutor js;
    public WebDriverWait wait;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
