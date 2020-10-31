package Selenium.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends AbstractPage {
    @FindBy( name="oldPassword") private WebElement OldPassword;
    @FindBy( name="password") private WebElement NewPassword;
    @FindBy( name="matchingPassword") private WebElement NewPasswordMatch;
    @FindBy( xpath ="//button[text()='Save']") private WebElement SaveNewPasswordButton;
    @FindBy( className ="text-success") private WebElement Confirmation;
    @FindBy( xpath ="//a[text()='Change Password']") private WebElement ChangePasswordButton;
    WebDriverWait wait = new WebDriverWait(driver, 5);

    public AccountPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AccountPage clickChangePasswordButton() {
        ChangePasswordButton.click();
        return PageFactory.initElements(driver, AccountPage.class);
    }

    public AccountPage fillChangePasswordForm(String OldPassword1, String NewPassword, String MatchingPassword) {
        wait.until(ExpectedConditions.elementToBeClickable(OldPassword));
        this.OldPassword.clear();
        this.OldPassword.sendKeys(OldPassword1);

        this.NewPassword.clear();
        this.NewPassword.sendKeys(NewPassword);

        this.NewPasswordMatch.clear();
        this.NewPasswordMatch.sendKeys(MatchingPassword);
        return PageFactory.initElements(driver, AccountPage.class);
    }

    public AccountPage clickSaveNewPasswordButton() {
        SaveNewPasswordButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(Confirmation));
        return PageFactory.initElements(driver, AccountPage.class);
    }

}