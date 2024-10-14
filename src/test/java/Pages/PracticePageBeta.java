package Pages;

import Base.BaseTestBeta;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticePageBeta extends BaseTestBeta {

    public PracticePageBeta() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Test Login Page")
    public WebElement testLoginPageButton;

    //----------------------------

    public void clickOnTestLoginPageButton() {
        testLoginPageButton.click();
    }

}
