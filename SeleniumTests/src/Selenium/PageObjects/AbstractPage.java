package Selenium.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

    public class AbstractPage {
        @FindBy( xpath="//a[text()='Account']") public WebElement AccountButton;
        @FindBy( xpath="//form/button") public WebElement LogInConfirmation;
        @FindBy( id="dropdownMenuButton") public WebElement clickToOpenDropDownMenu;
        @FindBy( xpath="//a[text()='Dashboard']") public WebElement ChooseDashboardFromDropDown;
        @FindBy( xpath="//a[text()='Projects']") public WebElement ChooseProjectsFromDropDown;
        @FindBy( xpath="//a[text()='Tasks']") public WebElement ChooseTasksFromDropDown;
        @FindBy( xpath="//button[text()='Logout']") public WebElement LogOutButton;
        @FindBy( className ="text-success") private WebElement Confirmation;
        protected WebDriver driver;


        public AbstractPage(WebDriver driver) {
            this.driver = driver;
        }

        public LogIn navigateToWebApp() {
            driver.navigate().to("http://localhost:8080");
            driver.manage().window().maximize();
            return PageFactory.initElements(driver,LogIn.class);
        }

        //HEADER Options
        //Click Dashboard
        public DashboardPage clickOnDashboard() {
            clickToOpenDropDownMenu.click();
            ChooseDashboardFromDropDown.click();
            return new DashboardPage(driver);
        }
    //Click ProjectOverview
    public ProjectOverviewPage clickOnProjectOverview() {
        clickToOpenDropDownMenu.click();
        ChooseProjectsFromDropDown.click();
        return new ProjectOverviewPage(driver);
    }
    //ClickTaskOverview
    public TaskOverviewPage clickOnTaskOverview() {
        clickToOpenDropDownMenu.click();
        ChooseTasksFromDropDown.click();
        return new TaskOverviewPage(driver);
    }

    public AccountPage clickOnAccount() {
        AccountButton.click();
        return PageFactory.initElements(driver, AccountPage.class);
    }

    public HomePage clickLogOut() {
        LogOutButton.click();
        return new HomePage(driver);
    }

    public String getConfirmationMessage() {
        return LogInConfirmation.getText();
    }

    public void waitForConfirmation() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(Confirmation));
    }


}
