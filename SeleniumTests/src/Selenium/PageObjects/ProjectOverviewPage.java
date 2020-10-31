package Selenium.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectOverviewPage extends AbstractPage {
    @FindBy( xpath="//button[text()='Amazing HR Strategy']") private WebElement ClickOnProjectHRStrategy;
    @FindBy( xpath="//button[text()='Suggest acceptedTask']") private WebElement ClickOnSuggestTask;


    public ProjectOverviewPage(WebDriver driver) {
            super(driver);
            PageFactory.initElements(driver, this);
    }
    public SuggestedTaskPage clickToSuggestTask() {
        ClickOnProjectHRStrategy.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(ClickOnSuggestTask);
        actions.perform();
        ClickOnSuggestTask.click();
        return PageFactory.initElements(driver, SuggestedTaskPage.class);
    }
}

