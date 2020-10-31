package Selenium.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class AbstractWebDriverTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp(){
        String path = new File("src/Selenium/Driver/chromedriver-4").getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
    }

    @AfterEach
    public void shutDown(){ driver.close();
    driver.quit();
    }
}