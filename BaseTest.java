package org.example;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    @Given("User navigates to the website {string}")
    public void userNavigatesToTheWebsite(String url) {
        System.setProperty("webdriver.chrome.driver", "");
        driver = new ChromeDriver();
        driver.get(url);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
