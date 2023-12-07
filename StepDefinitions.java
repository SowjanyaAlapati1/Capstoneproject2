package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepDefinitions {

    WebDriver driver;
    ArrayList<String> tabs;

    @Then("The page title is {string}")
    public void thePageTitleIs(String expectedTitle) {
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @When("User clicks on the {string} link")
    public void userClicksOnTheLink(String linkText) {
        WebElement link = driver.findElement(By.xpath("//h1[normalize-space()='IFRAME']"));
        link.click();
    }

    @Then("User switches to the new tab")
    public void userSwitchesToNewTab() {
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    @Then("User verifies that an image is present")
    public void userVerifiesImagePresent() {
        assertTrue(driver.findElement(By.tagName("img")).isDisplayed());
    }

    @When("User clicks on the right arrow button")
    public void userClicksRightArrowButton() {
        WebElement rightArrow = driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-chevron-right']"));
        rightArrow.click();
    }


    @Then("User verifies that the image has changed")
    public void userVerifiesThatTheImageHasChanged() {
        assertTrue(driver.findElement(By.tagName("img")).isDisplayed());
    }
}
