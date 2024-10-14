package Pages;

import Base.BaseTestBeta;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePageBeta extends BaseTestBeta {

    public ProfilePageBeta() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Log out")
    public WebElement logOutButton;

    //---------------------

    public void clickOnLogOutButton() {
        logOutButton.click();
    }


}
