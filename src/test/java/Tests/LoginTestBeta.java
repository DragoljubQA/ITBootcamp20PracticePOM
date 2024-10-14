package Tests;

import Base.BaseTestBeta;
import Pages.HomepagePageBeta;
import Pages.LoginPageBeta;
import Pages.PracticePageBeta;
import Pages.ProfilePageBeta;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestBeta extends BaseTestBeta {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");

        homepagePageBeta = new HomepagePageBeta();
        practicePageBeta = new PracticePageBeta();
        loginPageBeta = new LoginPageBeta();
        profilePageBeta = new ProfilePageBeta();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void userCanLogIn() {
        homepagePageBeta.clickOnPracticeButton();
        practicePageBeta.clickOnTestLoginPageButton();
        loginPageBeta.inputUsername("student");
        loginPageBeta.inputPassword("Password123");
        loginPageBeta.clickOnSubmitButton();
        Assert.assertTrue(profilePageBeta.logOutButton.isDisplayed());
    }

    @Test
    public void userCannotLogInWithInvalidUsername() {
        homepagePageBeta.clickOnPracticeButton();
        practicePageBeta.clickOnTestLoginPageButton();
        loginPageBeta.inputUsername("non student");
        loginPageBeta.inputPassword("Password123");
        loginPageBeta.clickOnSubmitButton();
        Assert.assertTrue(loginPageBeta.submitButton.isDisplayed());
    }

}
