package com.frame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class medication extends Section {
    protected WebDriver driver;

    public medication (WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"patient-dashboard\"]/div[6]/div[4]/div/div[2]/div/div[3]/div/div[2]/div[4]/label/input")
    public WebElement btnConfirm;

    @FindBy(css = "button[class='btn rce-btn btn-primary btn-md']")
    public WebElement btnSave;

    @Override
    public void intakeSubmit() {
        clickBtnCheckbox(btnConfirm);
        clickBtnCheckbox(btnSave);
    }



}
