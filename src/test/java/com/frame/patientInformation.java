package com.frame;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class patientInformation extends Section {
    protected WebDriver driver;

    public patientInformation (WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(name = "data[patient_first_name]")
    public WebElement fFirstname;
    @FindBy(name = "data[patient_last_name]")
    public WebElement fLastname;
    @FindBy(xpath = ".//input[@class='form-control input active']")
    public WebElement fDOB;
    @FindBy(name = "data[patient_zip_code]")
    public WebElement fZipcode;

    @FindBy(name = "data[patient_no_secondary_insurance]")
    public WebElement ckNo2ndInsurance;

    protected static String Medicare = "return document.querySelectorAll('[name*=\"data[patient_primary_type]\"')";

//    @FindBy(xpath = "//*[@value='Medicare']")
//    public WebElement ckMedicare;

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

    @FindBy(name = "data[patient_home_phone]")
    public WebElement fPatientHomePhone;

    @FindBy(name = "data[patient_shipping_sms]")
    public WebElement ckShippingSms;

    @FindBy(name = "data[patient_shipping_us_postal_service]")
    public WebElement ckShippingAddress;

    @FindBy(xpath = "//*[@value='English']")
    public WebElement ckLanguageEnglish;
    @FindBy(xpath = "//*[@value='French']")
    public WebElement ckLanguageFrench;

    @FindBy(xpath = ".//div[text()='Select your answer']")
    public WebElement fBestTimetoCall;

    @FindBy(xpath = ".//input[@placeholder='Select your answer']")
    public WebElement fMedicalCondition;

    @FindBy(name = "data[patient_ec_full_name_1]")
    public WebElement fEcName1;

    @FindBy(name = "data[patient_ec_phone_number_1]")
    public WebElement fEcPhoneNumber1;

    @FindBy(xpath = ".//div[text()='Select your answer']")
    public WebElement fEcRelation1;

    @FindBy(name = "data[patient_information_provider_check_shipping]")
    public WebElement ckConfirmShipping;


    public void intakeSubmit(String vertical) {

        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        if(vertical.equals("Genetic Testing")) {
            enterText(fFirstname, "firstname" );
            enterText(fLastname, "lastname" );
            enterText(fDOB, "DOB" );
            enterText(fZipcode, "zipcode" );
            clickBtnCheckbox(ckNo2ndInsurance);
            List<WebElement> ckMedicare = (List<WebElement>) js.executeScript(Medicare);
            clickBtnCheckbox(ckMedicare.get(0));
            enterText(fPrimaryInsurance, "medicare");
            clickBtnCheckbox(btnSubmitsect);

            clickBtnCheckbox(ckGender);
            clickBtnCheckbox(ckEthnicity);

            enterText(fHeight, "5.75");
            enterText(fHeightIn, "6");
            enterText(fWeight, "160");

            enterText(fAddress, "210 King Street");
            clickBtnCheckbox(ckPhoneType);
            enterText(fPhoneNumber, "8458094618");
            clickBtnCheckbox(ckShippingSms);
            clickBtnCheckbox(ckShippingAddress);

            clickBtnCheckbox(btnSubmitsect);


        }
        else {
            enterText(fFirstname, "firstname" );
            enterText(fLastname, "lastname" );
            enterText(fDOB, "DOB" );
            enterText(fZipcode, "94107" );
            List<WebElement> ckMedicare = (List<WebElement>) js.executeScript(Medicare);
            clickBtnCheckbox(ckMedicare.get(0));
//            clickBtnCheckbox(ckMedicare);
            clickBtnCheckbox(btnSubmitsect);

            clickBtnCheckbox(ckGender);
            clickBtnCheckbox(ckEthnicity);

            enterText(fAddress, "210 King Street");
            clickBtnCheckbox(ckPhoneType);
            enterText(fPatientHomePhone, "8458094618");
            enterText(fPhoneNumber, "8458094618");

            clickBtnCheckbox(ckLanguageEnglish);
            clickBtnCheckbox(ckLanguageFrench);

            clickBtnCheckbox(fBestTimetoCall);
            keyEnter();

            clickBtnCheckbox(fMedicalCondition);
            keyEnter();

            enterText(fEcName1, "test");
            enterText(fEcPhoneNumber1, "8458094618");

            clickBtnCheckbox(fEcRelation1);
            keyEnter();

            clickBtnCheckbox(btnSubmitsect);

        }
    }
    @Override
    public void providerSubmit(String vertical) {
        clickBtnCheckbox(ckConfirmShipping);
        clickBtnCheckbox(btnSubmitsect);
    }
}
