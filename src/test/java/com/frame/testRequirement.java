package com.frame;

import com.Common;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class testRequirement {
    protected WebDriver driver;

    public testRequirement(WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(css = "div[class='btn btn-primary btn-md test_requirements-formio-submit-button']")
    public WebElement btnSave;

    @FindBy(className = "rf-text")
    public WebElement sectionTitle;

    public void clickBtnCheckbox(WebElement btnckElement) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOf(btnckElement)
        ).click();
    }

    public void enterText(WebElement fElement, String testText) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOf(fElement)
        ).sendKeys(testText);
    }


    public void intakeSubmit() throws Exception {
        clickBtnCheckbox(btnSave);
    }

    public String getTitle() {
        String title = sectionTitle.getText();
        return title;
    }

    public boolean verifyTitleSection() {
        String expectedTitle = "Test Requirements";
        return getTitle().equals(expectedTitle);
    }
}
