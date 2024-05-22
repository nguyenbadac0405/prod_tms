package com.frame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Menu {

    protected WebDriver driver;

    public Menu(WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(className = "card-header")
    public List<WebElement> listSectionName;

    @FindBy(xpath = ".//span[text()='Patient Information']")
    public WebElement sectPatientInfor;
    @FindBy(xpath = ".//span[text()='Medical History']")
    public WebElement sectMedicalHis;
    @FindBy(xpath = ".//span[text()='Family History']")
    public WebElement sectFamilyHis;
    @FindBy(xpath = ".//span[text()='Diagnosis']")
    public WebElement sectDiagnosis;
    @FindBy(xpath = ".//span[text()='Assessment & Plan']")
    public WebElement sectAssPlan;
    @FindBy(xpath = ".//span[text()='Follow-up Consult']")
    public WebElement sectFollowCounsult;

}
