package Selenium.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration extends AbstractPage {
    @FindBy( id="registerUsername") private WebElement RegistrationPageUsername;
    @FindBy( id="registerPassword") private WebElement RegistrationPagePassword;
    @FindBy( id="matchingPassword") private WebElement RegistrationPageMatchingPassword;
    @FindBy( xpath ="//button[text()='Register']") private WebElement RegistrationButton;

    public Registration (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public Registration fillRegistrationFormWithData(String Username, String Password, String MatchingPassword) {
        this.RegistrationPageUsername.clear();
        this.RegistrationPageUsername.sendKeys(Username);

        this.RegistrationPagePassword.clear();
        this.RegistrationPagePassword.sendKeys(Password);

        this.RegistrationPageMatchingPassword.clear();
        this.RegistrationPageMatchingPassword.sendKeys(MatchingPassword);

        return PageFactory.initElements(driver, Registration.class);
    }
    public LogIn clickRegisterButton() {
        RegistrationButton.click();
        return new LogIn(driver);
    }
}
