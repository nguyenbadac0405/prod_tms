package com.frame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class patientInformation {
    protected WebDriver driver;

    public patientInformation (WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(name = "data[patient_first_name]")
    public WebElement fFirstname;
    @FindBy(name = "data[patient_last_name]")
    public WebElement fLastname;

    @FindBy(name = "data[patient_zip_code]")
    public WebElement fZipcode;

    @FindBy(name = "data[patient_no_secondary_insurance]")
    public WebElement ckNo2ndInsurance;

    @FindBy(xpath = "//*[@value='Medicare']")
    public WebElement ckMedicare;

    @FindBy(name = "data[patient_primary_insurance_id")
    public WebElement fPrimaryInsurance;

    @FindBy(name = "data[submit]")
    public WebElement btnSubmitsect;

    @FindBy(xpath = "//*[@value='Male']")
    public WebElement ckGender;

    @FindBy(xpath = "//*[@value='Asian']")
    public WebElement ckEthnicity;

    @FindBy(name = "data[patient_height")
    public WebElement fHeight;

    @FindBy(name = "data[patient_height_in")
    public WebElement fHeightIn;

    @FindBy(name = "data[patient_weight]")
    public WebElement fWeight;

    @FindBy(name = "data[patient_address]")
    public WebElement fAddress;

    @FindBy(xpath = "//input[@value='Cell Phone']")
    public WebElement ckPhoneType;

    @FindBy(name = "data[patient_phone]")
    public WebElement fPhoneNumber;

    @FindBy(name = "data[patient_shipping_sms]")
    public WebElement ckShippingSms;

    @FindBy(name = "data[patient_shipping_us_postal_service]")
    public WebElement ckShippingAddress;

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
}
