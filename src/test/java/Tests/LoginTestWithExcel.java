package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestWithExcel extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://practicetestautomation.com/");
    }

    @Test
    public void userCanLogIn() {
        String validUsername = excelReader.getStringData("Sheet1", 1,0);
        String validPassword = excelReader.getStringData("Sheet1", 1, 1);

        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(profilePage.getLogOutButton().isDisplayed());
    }

    @Test
    public void userCannotLogInWithInvalidUsername() {
        for (int i = 1; i <= excelReader.getLastRow("Sheet1"); i++) {
            String invalidUsername = excelReader.getStringData("Sheet1", i,2);
            String validPassword = excelReader.getStringData("Sheet1", 1, 1);

            homepagePage.clickOnPracticeButton();
            practicePage.clickOnTestLoginPageButton();
            loginPage.inputUsername(invalidUsername);
            loginPage.inputPassword(validPassword);
            loginPage.clickOnSubmitButton();
            Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
        }
    }

    @Test
    public void userCannotLogInWithInvalidPassword() {
        for (int i = 1; i <= excelReader.getLastRow("Sheet1"); i++) {
            String validUsername = excelReader.getStringData("Sheet1", 1,0);
            String invalidPassword = excelReader.getStringData("Sheet1", i, 3);

            homepagePage.clickOnPracticeButton();
            practicePage.clickOnTestLoginPageButton();
            loginPage.inputUsername(validUsername);
            loginPage.inputPassword(invalidPassword);
            loginPage.clickOnSubmitButton();
            Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
        }
    }

    @Test
    public void userCannotLogInWithInvalidUsernameAndPassword() {
        for (int i = 1; i <= excelReader.getLastRow("Sheet1"); i++) {
            String invalidUsername = excelReader.getStringData("Sheet1", i,2);
            String invalidPassword = excelReader.getStringData("Sheet1", i, 3);

            homepagePage.clickOnPracticeButton();
            practicePage.clickOnTestLoginPageButton();
            loginPage.inputUsername(invalidUsername);
            loginPage.inputPassword(invalidPassword);
            loginPage.clickOnSubmitButton();
            Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
        }
    }




}
