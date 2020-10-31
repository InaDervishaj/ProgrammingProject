package Selenium.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends AbstractPage {
    @FindBy( xpath ="//h5[text()='This is suggested Task Nr2']") private WebElement SuggestedTask;
    @FindBy( xpath="//form/button") private WebElement LogInConfirmation;

    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public DashboardPage CheckIfSuggestedTaskIsVisible() {
        Actions actions = new Actions(driver);
        actions.moveToElement(SuggestedTask).perform();
        SuggestedTask.click();
        System.out.println("The suggested Task has been saved and is waiting for evaluation");
        return PageFactory.initElements(driver, DashboardPage.class);
    }
}



