package com.frame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class PCP extends Section {
    protected WebDriver driver;

    public PCP(WebDriver driver) {
        this.driver = driver;
    }

    //find button no pcp
    @FindBy(name = "data[pcp_no_pcp_certification]")
    public WebElement btnNoPcp;

    //find button save
    @FindBy(css = "button[class='btn rce-btn mb-3']")
    public WebElement btnSave;

    @Override
    public void intakeSubmit() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            System.out.println(btnNoPcp.getText());
            wait.until(ExpectedConditions.visibilityOf(btnNoPcp));
            System.out.println(btnNoPcp.isDisplayed());
            System.out.println(btnNoPcp.isEnabled());
        }
        catch (Exception e)
        {
            System.out.println("no Elele");
        }

    }


}
