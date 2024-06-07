package com.frame;

import com.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class compliance extends Section {
    protected WebDriver driver;
    public compliance(WebDriver driver) {
        this.driver = driver;
    }

    //COMPLIANCE SECTION

    //Are you able to make your own medical decisions or does someone else make them for you? => qs1
    protected static String medical_decision = "return document.querySelectorAll('[name*=\"compliance_verification_verified_medical_decision_41589\"')";

    //Do you agree to having a telehealth provider bill your insurance? => qs2
    protected static String consent_to_bill  = "return document.querySelectorAll('[name*=\"compliance_verification_verified_consent_to_bill_41589\"')";

    //Are you currently in hospice, a nursing home or any other type of care facility? => qs3
    protected static String currently_hospice = "return document.querySelectorAll('[name*=\"compliance_verification_verified_currently_hospice\"')";

    //Have you ever had a genetic screening? => qs4
    protected static String previously_taken_genetic_test = "return document.querySelectorAll('[name*=\"compliance_verification_verified_patient_previously_taken_genetic_test_41589\"')";

    //Has anyone offered you any money or an incentive for you to take a genetic test? => qs5
    protected static String verified_money = "return document.querySelectorAll('[name*=\"compliance_verification_verified_money\"')";

    //Has any sales agent represented themselves as being with Medicare? => qs6
    protected static String with_medical = "return document.querySelectorAll('[name*=\"compliance_verification_verified_with_medical\"')";

    //Has patient ever completed any medicare wellness program visit? => qs7
    protected static String wellness_completed = "return document.querySelectorAll('[name*=\"compliance_verification_verified_patient_wellness_program\"')";

    // Has patient completed a medicare wellness program visit in the past year? => qs8
    protected static String wellness_past = "return document.querySelectorAll('[name*=\"compliance_verification_verified_patient_wellness_program_past\"')";

    //Do you give consent for us to contact you in the future to discuss any additional health services that can benefit you? => qs9
    protected static String additional_health = "return document.querySelectorAll('[name*=\"compliance_verification_verified_additional_health\"')";

    //Do you confirm all the above information is true and accurate? => qs10
    protected static String confirm_all = "return document.querySelectorAll('[name*=\"compliance_verification_verified_confirm_all\"')";

    @FindBy(name = "data[compliance_verification_verified_telehealth_provider]")
    public WebElement ckTelehealthProvider;
    @FindBy(name = "data[compliance_verification_verified_patient_gender_41589]")
    public WebElement ckVerifyGender;
    @FindBy(name = "data[compliance_verification_verified_patient_dob_41589]")
    public WebElement ckVerifyDob;
    @FindBy(name = "data[compliance_verification_verified_patient_state_41589]")
    public WebElement ckVerifyState;
    @FindBy(name = "data[submit]")
    public WebElement btnSubmit;

    @Override
    public void pssSubmit(String vertical) {
        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println("Check Compliance");
        if (vertical.equals("Genetics")) {
            clickBtnCheckbox(ckTelehealthProvider);

            //qs1
            List<WebElement> medical_decisions = (List<WebElement>) js.executeScript(medical_decision);
            action.moveToElement(medical_decisions.get(1)).click().build().perform();

            //qs2
            List<WebElement> consent_bill = (List<WebElement>) js.executeScript(consent_to_bill);
            action.moveToElement(consent_bill.get(1)).click().build().perform();

            //qs3
            List<WebElement> currently_hopital = (List<WebElement>) js.executeScript(currently_hospice);
            action.moveToElement(currently_hopital.get(1)).click().build().perform();

            //qs4
            List<WebElement> taken_genetics = (List<WebElement>) js.executeScript(previously_taken_genetic_test);
            action.moveToElement(taken_genetics.get(1)).click().build().perform();

            //qs5
            List<WebElement> money = (List<WebElement>) js.executeScript(verified_money);
            action.moveToElement(money.get(1)).click().build().perform();

            //qs6
            List<WebElement> medical = (List<WebElement>) js.executeScript(with_medical);
            action.moveToElement(medical.get(1)).click().build().perform();

            //qs7
            List<WebElement> completed_wellness = (List<WebElement>) js.executeScript(wellness_completed);
            action.moveToElement(completed_wellness.get(0)).click().build().perform();

            //qs8
            List<WebElement> past_wellness = (List<WebElement>) js.executeScript(wellness_past);
            action.moveToElement(past_wellness.get(0)).click().build().perform();

            //qs9
            List<WebElement> health_additional = (List<WebElement>) js.executeScript(additional_health);
            action.moveToElement(health_additional.get(1)).click().build().perform();

            //qs10
            List<WebElement> confirm = (List<WebElement>) js.executeScript(confirm_all);
            action.moveToElement(confirm.get(1)).click().build().perform();

        }
        else {
            //ver for RPM different wellness
            //qs1
            List<WebElement> medical_decisions = (List<WebElement>) js.executeScript(medical_decision);
            action.moveToElement(medical_decisions.get(1)).click().build().perform();

            //qs4
            List<WebElement> taken_genetics = (List<WebElement>) js.executeScript(previously_taken_genetic_test);
            action.moveToElement(taken_genetics.get(1)).click().build().perform();

            //qs7
            List<WebElement> completed_wellness = (List<WebElement>) js.executeScript(wellness_completed);
            if (completed_wellness.get(0).isEnabled()) {
                action.moveToElement(completed_wellness.get(0)).click().build().perform();
            }

            //qs8
            List<WebElement> past_wellness = (List<WebElement>) js.executeScript(wellness_past);
            if (past_wellness.get(0).isEnabled()) {
                action.moveToElement(past_wellness.get(0)).click().build().perform();
            }
        }
        clickBtnCheckbox(ckVerifyGender);
        clickBtnCheckbox(ckVerifyDob);
        clickBtnCheckbox(ckVerifyState);
        clickBtnCheckbox(btnSubmit);


        Common.waitSec(5);
    }


}
