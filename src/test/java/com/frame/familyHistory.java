package com.frame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class familyHistory extends Section {
    protected WebDriver driver;

    public familyHistory (WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(name = "data[family_history_member_1_name]")
    public WebElement fNameMember1;

    @FindBy(css = "div[class='form-control ui fluid selection dropdown']")
    public WebElement fRelation1;

    @FindBy(css = "input[value='Male']")
    public WebElement fGender1;

    @FindBy(name = "data[family_history_member_confirm_sale]")
    public WebElement btnConfirm;

    @FindBy(name = "data[submit]")
    public WebElement btnSave;

    @Override
    public void intakeSubmit() {
        enterText(fNameMember1, "test");
        clickBtnCheckbox(fRelation1);keyEnter();
        clickBtnCheckbox(fGender1);
        clickBtnCheckbox(btnConfirm);
        clickBtnCheckbox(btnSave);
    }
}
