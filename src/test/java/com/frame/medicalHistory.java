package com.frame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class medicalHistory extends Section {
    protected WebDriver driver;

    public medicalHistory(WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(name = "data[patient_personal_history_progress_note_confirm_2_sale]")
    public WebElement ckConfirm;
    @FindBy(css = "button[class='btn btn-primary btn-md patient_personal_history-formio-submit-button']")
    public WebElement btnSave;


    @Override
    public void intakeSubmit(String vetical)  {
        clickBtnCheckbox(ckConfirm);
        clickBtnCheckbox(btnSave);
    }


}
