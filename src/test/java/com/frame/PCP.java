package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class PCP extends Section {
    protected WebDriver driver;



    //find button no pcp
    @FindBy(name = "data[pcp_no_pcp_certification]")
    WebElement btnNoPcp;

//    private By btnNoPcp = By.name("data[pcp_no_pcp_certification]");

    //find button save
    @FindBy(css = "button[class='btn rce-btn mb-3']")
    WebElement btnSave;

    public PCP(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    public void intakeSubmit() {
        try {
            btnNoPcp.click();
//            clickBtnCheckbox(btnNoPcp);
            System.out.println("check");
            clickBtnCheckbox(btnSave);
            System.out.println("check");

        }
        catch (Exception e)
        {
            System.out.println("no Elele");
        }

    }


}
