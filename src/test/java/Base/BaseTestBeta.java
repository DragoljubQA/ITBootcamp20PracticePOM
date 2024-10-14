package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseTestBeta {

    public static WebDriver driver;
    public HomepagePageBeta homepagePageBeta;
    public PracticePageBeta practicePageBeta;
    public LoginPageBeta loginPageBeta;
    public ProfilePageBeta profilePageBeta;

    public ExcelReader excelReader;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        excelReader = new ExcelReader("TestData.xlsx");
    }


}
