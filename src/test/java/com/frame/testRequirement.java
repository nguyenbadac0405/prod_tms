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

public class testRequirement extends Section {
    protected WebDriver driver;

    public testRequirement(WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(css = "div[class='btn btn-primary btn-md test_requirements-formio-submit-button']")
    public WebElement btnSave;


    public void intakeSubmit() {
        clickBtnCheckbox(btnSave);
    }

}
