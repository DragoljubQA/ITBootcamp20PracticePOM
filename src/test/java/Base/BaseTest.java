package Base;

import Pages.HomepagePage;
import Pages.LoginPage;
import Pages.PracticePage;
import Pages.ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseTest {

    public WebDriver driver;
    public HomepagePage homepagePage;
    public LoginPage loginPage;
    public PracticePage practicePage;
    public ProfilePage profilePage;

    public ExcelReader excelReader;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        excelReader = new ExcelReader("TestData.xlsx");

        homepagePage = new HomepagePage(driver);
        loginPage = new LoginPage(driver);
        practicePage = new PracticePage(driver);
        profilePage = new ProfilePage(driver);

    }



}
