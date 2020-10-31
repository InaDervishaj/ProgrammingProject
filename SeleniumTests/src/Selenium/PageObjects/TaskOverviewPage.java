package Selenium.PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class TaskOverviewPage extends AbstractPage {
    @FindBy( xpath ="//*[@id='dropdownMenuButton']/span/b") private WebElement ClickOnFilterDropDown;
    @FindBy( xpath ="//a[text()='Done']") private WebElement FilterToDone;

    public TaskOverviewPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public TaskOverviewPage clickToFilterTasksToDone() {
        ClickOnFilterDropDown.click();
        FilterToDone.click();
        //Creates list of results on done
        List<WebElement> ResultsOnDone = driver.findElements(By.xpath("//div[text()='Done']"));
        System.out.println(ResultsOnDone);
        //Creates list of all shown elements
        List<WebElement> NumberOfResults = driver.findElements(By.xpath("//div[text()='Done']"));
        System.out.println(NumberOfResults);
        //Checks that all shown elements are on Done
        Assert.assertEquals(NumberOfResults.size(), ResultsOnDone.size());
        return PageFactory.initElements(driver, TaskOverviewPage.class);
    }
}
