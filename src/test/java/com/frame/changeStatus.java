package com.frame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class changeStatus extends Section {
    protected WebDriver driver;
    @FindBy (xpath = ".//span[text()='Submit']")
    protected WebElement btnSubmit;

    @FindBy (xpath = ".//button[@class='swal-button swal-button--confirm']")
    protected WebElement btnConfirm;

    @FindBy(id = "rec-form-select-collapse-btn")
    protected WebElement fiCaseDetail;



    public changeStatus(WebDriver driver) {
        this.driver = driver;
    }

    public void toNew() {
        clickBtnCheckbox(btnSubmit);
        clickBtnCheckbox(btnConfirm);
    }

    public void toAssigned() {
        clickBtnCheckbox(fiCaseDetail);
        clickBtnCheckbox(btnSubmit);
        clickBtnCheckbox(btnSubmit);
    }
}
