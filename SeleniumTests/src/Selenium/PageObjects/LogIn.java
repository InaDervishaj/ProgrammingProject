package Selenium.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogIn extends AbstractPage {
    @FindBy( id="exampleInputUsername") private WebElement LogInPageUsername;
    @FindBy( id="exampleInputPassword") private WebElement LogInPagePassword;
    @FindBy( xpath ="//form/div/div/button[text()='Login']") private WebElement LogInButton;
    @FindBy( xpath ="//a[text()='Sign up']") private WebElement ClickOnSignUp;
    @FindBy( className ="text-success") private WebElement ConfirmRegistration;



    public LogIn(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LogIn checkIfRegistrationWasSuccessful() {
        waitForConfirmation();
        return PageFactory.initElements(driver, LogIn.class);
    }
    public LogIn fillLogInFormWithData(String Username, String Password) {

        this.LogInPageUsername.clear();
        this.LogInPageUsername.sendKeys(Username);

        this.LogInPagePassword.clear();
        this.LogInPagePassword.sendKeys(Password);
        return PageFactory.initElements(driver, LogIn.class);
    }

    public DashboardPage submitLogIn() {
        LogInButton.click();
        return PageFactory.initElements(driver, DashboardPage.class);
    }

    public Registration clickOnRegister() {
        ClickOnSignUp.click();
        return PageFactory.initElements(driver,Registration.class);
    }
}
