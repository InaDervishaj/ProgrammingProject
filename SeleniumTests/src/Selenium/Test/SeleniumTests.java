
package Selenium.Test;

import Selenium.PageObjects.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


class SeleniumTests extends AbstractWebDriverTest {

    @Test
    public void shouldBeAbleToRegisterAndLogIn(){
        LogIn onLogIn = new LogIn(driver);
        Registration onRegistration= onLogIn
                .navigateToWebApp()
                .clickOnRegister();
        onLogIn = onRegistration
                .fillRegistrationFormWithData("TestUser", "TestPassword", "TestPassword" )
                .clickRegisterButton();
        DashboardPage onDashboardPage1= onLogIn
                .checkIfRegistrationWasSuccessful()
                .fillLogInFormWithData("TestUser", "TestPassword")
                .submitLogIn();
        Assert.assertTrue(onDashboardPage1
                .getConfirmationMessage()
                .contains("Logout"));
        System.out.println("User has successfully registered and logged in as a Developer");
    }

    @Test
    public void shouldBeAbleToChangePasswords(){
        LogIn onLogIn = new LogIn(driver);
        // Fill Log In Form and press button to land on Homepage
        DashboardPage onDashboardPage1= onLogIn
                .navigateToWebApp()
                .fillLogInFormWithData("TestUser", "TestPassword")
                .submitLogIn();
        //From Homepage, click on Account
        AccountPage onAccountPage= onDashboardPage1
                .clickOnAccount();
        //Change password in Account
        HomePage onHomePage= onAccountPage
                //.clickChangePasswordButton()
                .fillChangePasswordForm("TestPassword","TestPassword2", "TestPassword2")
                .clickSaveNewPasswordButton()
                .clickLogOut();
        //Go to Log In Form, fill it out, and submit it ==> DashboardPage
        LogIn onLogInWithNewPass= onHomePage
                .clickOnLogIn();
        DashboardPage onDashboardPage2= onLogInWithNewPass
                .fillLogInFormWithData("TestUser", "TestPassword2")
                .submitLogIn();
        //If Logout button is visible, user is assumed to have logged in successfully
        Assert.assertTrue(onDashboardPage1
                .getConfirmationMessage()
                .contains("Logout"));
        System.out.println("User has successfully logged in with new password");
    }

    @Test
    public void shouldBeAbleToSuggestTasks(){
        LogIn onLogIn = new LogIn(driver);
        // Fill Log In Form and press button to land on Homepage
        DashboardPage onDashboardPage1= onLogIn
                .navigateToWebApp()
                .fillLogInFormWithData("sandra", "1234567890")
                .submitLogIn();
        //From Homepage, select Project from Dropdown
        ProjectOverviewPage onProjectOverviewPage= onDashboardPage1
                .clickOnProjectOverview();
        //Select the HR Project and ask to suggest a task ==> Suggested Task Form
        SuggestedTaskPage onSuggestedTaskPage= onProjectOverviewPage
                .clickToSuggestTask();
        //Fill out the Suggested Task Form and submit it ==> go back to Dashboard
        DashboardPage onDashboardPage= onSuggestedTaskPage
                .submitSuggestTask()
                .clickOnDashboard();
        // On Dashboard, if correctly saved, the suggested Task should be visible on the bottom-left corner
        onDashboardPage.CheckIfSuggestedTaskIsVisible();
        System.out.println("The suggested task has been saved and is waiting for evaluation");
    }

    @Test
    public void shouldBeAbleToFilterTasks(){
        LogIn onLogIn = new LogIn(driver);
        // LogIn
        DashboardPage onDashboardPage1= onLogIn
                .navigateToWebApp()
                .fillLogInFormWithData("sandra", "1234567890")
                .submitLogIn();
        //From Homepage, select Project from Dropdown
        TaskOverviewPage onTaskOverviewPage= onDashboardPage1
                .clickOnTaskOverview();
        onTaskOverviewPage.
                clickToFilterTasksToDone();
        System.out.println("The tasks have been filtered to Done");
    }

    @Test
    public void LogInAsManager(){
        LogIn onLogIn = new LogIn(driver);
        // Fill Log In Form with InitData and press button to land on Homepage
        DashboardPage onDashboardPage1= onLogIn
                .navigateToWebApp()
                .fillLogInFormWithData("sandra", "1234567890")
                .submitLogIn();
        //If Logout button is visible, user is assumed to have logged in successfully
        Assert.assertTrue(onDashboardPage1
                .getConfirmationMessage()
                .contains("Logout"));
        System.out.println("User has successfully registered and logged in as a Manager");
    }
}
