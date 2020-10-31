package Selenium.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SuggestedTaskPage extends AbstractPage {
    @FindBy( id="name") private WebElement GiveSuggestedTaskName;
    @FindBy( id="description") private WebElement GiveSuggestedTaskDescription;
    @FindBy( id="time") private WebElement GiveSuggestedTaskEstimatedTime;
    @FindBy( xpath="//button[text()='Save']") private WebElement SaveSuggestedTaskButton;

    public SuggestedTaskPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public SuggestedTaskPage submitSuggestTask() {
        GiveSuggestedTaskName.sendKeys("This is suggested Task Nr2");
        GiveSuggestedTaskDescription.sendKeys("The purpose of this task is to test the application");
        GiveSuggestedTaskEstimatedTime.sendKeys("3");
        SaveSuggestedTaskButton.click();
        waitForConfirmation();
        return PageFactory.initElements(driver, SuggestedTaskPage.class);
    }
}
