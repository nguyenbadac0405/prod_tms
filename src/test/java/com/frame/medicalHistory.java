package com.frame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class medicalHistory {
    protected WebDriver driver;

    public medicalHistory(WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(className = "rf-text")
    public WebElement sectionTitle;
    @FindBy(name = "data[patient_personal_history_progress_note_confirm_2_sale]")
    public WebElement ckConfirm;
    @FindBy(css = "button[class='btn btn-primary btn-md patient_personal_history-formio-submit-button']")
    public WebElement btnSave;

    public String getTitle() {
        String title = sectionTitle.getText();
        return title;
    }

    public boolean verifyTitleSection() {
        String expectedTitle = "Test Requirements";
        return getTitle().equals(expectedTitle);
    }

    public void enterText(WebElement fElement, String testText) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOf(fElement)
        ).sendKeys(testText);
    }
    public void clickBtnCheckbox(WebElement btnckElement) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOf(btnckElement)
        ).click();
    }

    public void intakeSubmit() throws Exception {
        clickBtnCheckbox(ckConfirm);
        clickBtnCheckbox(btnSave);
    }


}
