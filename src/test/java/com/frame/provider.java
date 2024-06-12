package com.frame;

import com.Common;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class provider {

    protected static WebDriver driver;

    @FindBy(className = "card-header")
    public List<WebElement> listSectionName;

    // Patient Information
    @FindBy(xpath = ".//span[text()='Patient Information']")
    public WebElement sectPatientInfor;

    @FindBy(name = "data[patient_information_provider_check_shipping]")
    public WebElement ckShippingCheck;

    @FindBy(xpath = ".//span[text()='Submit']")
    public WebElement btnSubmit;

    @FindBy(xpath = ".//button[text()='Save']")
    public WebElement btnSave;

    @FindBy(name = "data[patient_personal_history_progress_note_phmx]")
    public WebElement fPhmx;

    //Medical History
    protected static String medical_history = "return document.querySelectorAll('[name*=\"medical_history_patient_question1\"]')";

    //general health
    protected static String immunizations = "return document.querySelectorAll('[name*=\"screening_questionnaire_vision_imm\"]')";

    //Depression Screening
    protected static String depressionScreening = "return document.querySelectorAll('[name*=\"test_requirements_depression_screening\"]')";
    //Alcohol Screening
    protected static String alcoholScreening = "return document.querySelectorAll('[name*=\"alcohol_screening\"]')";
    //Tobacco Screening
    protected static String tobaccoScreening = "return document.querySelectorAll('[name*=\"tobacco_screening\"]')";
    //Advance Directive
    protected static String advanceDirective = "return document.querySelectorAll('[name*=\"compliance_advance_directive\"]' )";
    //medication
    protected static String medications = "return document.querySelectorAll('[class=\"form-check-input\"]')";


    public void enterText(WebElement fElement, String testText) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOf(fElement)
        ).sendKeys(testText);
    }
    public void clickBtnCheckbox(WebElement btnckElement, String testText) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOf(btnckElement)
        ).sendKeys(testText);
    }




    public provider(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void testEle() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //patient information
        listSectionName.get(4).click();

        try {
            if(ckShippingCheck.isDisplayed()) {
                ckShippingCheck.click();
            }
        }
        catch (Exception e)
        {
            System.out.println("no such element");
        }


        btnSubmit.click();
        btnSave.click();


        //medical history
        listSectionName.get(7).click();

        List<WebElement> history_medical = (List<WebElement>) js.executeScript(medical_history);
        history_medical.get(1).click();

        fPhmx.sendKeys("test");

        btnSubmit.click();


    }
    public void to_RTS() {
        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // patient infor
        System.out.println("Check Patient Information");
        driver.findElement(By.xpath(".//span[text()='Patient Information']")).click();
        Common.waitSec(3);
        driver.findElement(By.name("data[patient_information_provider_check_shipping]")).click();
        Common.waitSec(2);
        driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
        Common.waitSec(3);

        // Medical History
        System.out.println("Check Medical History");
        driver.findElement(By.xpath(".//span[text()='Medical History']")).click();
        Common.waitSec(2);
        driver.findElement(By.name("data[patient_personal_history_progress_note_phmx]")).sendKeys("test");
        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(3);

        // medication
        System.out.println("Check Medications");
        driver.findElement(By.xpath(".//span[text()='Medications']")).click();
        Common.waitSec(3);
        List<WebElement> medication = (List<WebElement>) js.executeScript(medications);
        action.moveToElement(medication.get(2)).click().build().perform();
//        driver.findElement(By.xpath("//*[@id=\"patient-dashboard\"]/div[7]/div[4]/div/div[2]/div/div[3]/div/div[2]/div[4]/label/input")).click();
        driver.findElement(By.xpath(".//button[text()='Save']")).click();
        Common.waitSec(5);

        // Family History
        Actions actions = new Actions(driver);
        System.out.println("Check Family History");
        driver.findElement(By.xpath(".//span[text()='Family History']")).click();
        Common.waitSec(3);
        driver.findElement(By.name("data[family_history_member_1_related_health_issue]")).sendKeys("test");
        driver.findElement(By.xpath("//*[@name='data[family_history_member_confirm_doctor]']")).click();
        driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
        Common.waitSec(3);



        // Diagnosis
        driver.findElement(By.xpath(".//span[text()='Diagnosis']")).click();
        Common.waitSec(3);
        System.out.println("Set Diagnosis");
        driver.findElement(By.xpath(".//div[text()='Z13.79']")).click();
//        driver.findElement(By.xpath(".//div[text()='Z13.89']")).click();
        driver.findElement(By.xpath(".//div[text()='I25.9']")).click();
        driver.findElement(By.xpath(".//button[text()='Save']")).click();
        Common.waitSec(5);

        // review of systems
        System.out.println("Review of Systems");
        driver.findElement(By.xpath(".//span[text()='Review of Systems']")).click();
        Common.waitSec(3);
        driver.findElement(By.name("data[review_of_system_confirm]")).click();
        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(5);
        // assessment & plan
        System.out.println("Set Assessment & Plan");
        driver.findElement(By.name("data[assessment_plan_plan]")).sendKeys("There is all plan that the provider is setting for you.");
        Common.waitSec(2);
        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(3);

        //follow up
        driver.findElement(By.xpath(".//span[text()='Follow-up Consult']")).click();
        Common.waitSec(3);
        driver.findElement(By.name("data[follow_up_consult_confirm]")).click();
        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(10);


        // approved
        driver.findElement(By.xpath(".//span[text()='Approve']")).click();
        Common.waitSec(3);
//        actions.sendKeys(Keys.ENTER).build().perform();
        driver.findElement(By.xpath(".//button[text()='Yes']")).click();
        actions.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(3);


        Common.waitSec(7);

        driver.findElement(By.className("rf-btn-close")).click();
        Common.waitSec(3);
    }

    public void to_approve3() {
        Actions action = new Actions(driver);
        // set assessment & plan
        driver.findElement(By.xpath(".//span[text()='Assessment & Plan']")).click();
        Common.waitSec(2);
        driver.findElement(By.xpath(".//input[@value='Yes']")).click();
        Common.waitSec(1);
        driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
        Common.waitSec(15);
        // approve
        System.out.println("check1");
        driver.findElement(By.xpath(".//span[text()='Complete']")).click();
//        driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[6]/div[2]/div[4]/div[1]/div[3]/button")).click();
        Common.waitSec(3);
        System.out.println("check2");

        driver.findElement(By.xpath(".//button[text()='Yes']")).click();

        action.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(3);

        System.out.println("-------------------------Completed----------------------------");
        Common.waitSec(5);

        driver.findElement(By.className("rf-btn-close")).click();
        Common.waitSec(3);

    }

    public void to_completed() {
        Actions action = new Actions(driver);
        //Patient's Personal History
        driver.findElement(By.xpath(".//span[text()=\"Medical History\"]")).click();
        Common.waitSec(3);
        driver.findElement(By.name("data[patient_personal_history_progress_note_phmx]")).sendKeys("test");
        driver.findElement(By.name("data[patient_personal_history_progress_note_confirm_doctor]")).click();
        Common.waitSec(2);
        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(3);

        driver.findElement(By.name("data[family_history_member_confirm_doctor]")).click();
        Common.waitSec(1);

        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(3);

        //review of systems
        driver.findElement(By.xpath(".//input[@name='data[review_of_system_confirm]']")).click();
        Common.waitSec(2);
        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(3);

        // medication
        System.out.println("Check Medications");
        driver.findElement(By.xpath(".//input[@name='shipped']")).click();
        Common.waitSec(2);
        driver.findElement(By.xpath(".//button[text()='Save']")).click();
        Common.waitSec(5);
        System.out.println("check");

        //diagnosis
        driver.findElement(By.xpath(".//*[text()='Diagnosis']")).click();
        Common.waitSec(3);
        driver.findElement(By.xpath(".//div[text()='M02']")).click();
        driver.findElement(By.xpath(".//div[text()='I25.5']")).click();
        Common.waitSec(1);
        driver.findElement(By.xpath(".//div[text()='G45']")).click();
        driver.findElement(By.xpath(".//div[text()='E08']")).click();
        Common.waitSec(1);


        driver.findElement(By.xpath(".//button[text()='Save']")).click();
        Common.waitSec(3);


        //Assessment & plan
        System.out.println("Set Assessment & Plan");
        driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
        Common.waitSec(3);

        //RPM device
        driver.findElement(By.name("data[vital_blood_pressure]")).click();
        Common.waitSec(2);
        driver.findElement(By.name("data[systolic_upper_high_alert]")).sendKeys("1");
        driver.findElement(By.name("data[systolic_upper_med_alert]")).sendKeys("1");
        driver.findElement(By.name("data[systolic_lower_high_alert]")).sendKeys("1");
        driver.findElement(By.name("data[systolic_lower_med_alert]")).sendKeys("1");
        driver.findElement(By.name("data[systolic_latest]")).sendKeys("1");

        driver.findElement(By.name("data[diastolic_upper_high_alert]")).sendKeys("2");
        driver.findElement(By.name("data[diastolic_upper_med_alert]")).sendKeys("2");
        driver.findElement(By.name("data[diastolic_lower_high_alert]")).sendKeys("2");
        driver.findElement(By.name("data[diastolic_lower_med_alert]")).sendKeys("2");
        driver.findElement(By.name("data[diastolic_latest]")).sendKeys("2");

        driver.findElement(By.name("data[pulse_upper_high_alert]")).sendKeys("3");
        driver.findElement(By.name("data[pulse_upper_med_alert]")).sendKeys("3");
        driver.findElement(By.name("data[pulse_lower_high_alert]")).sendKeys("3");
        driver.findElement(By.name("data[pulse_lower_med_alert]")).sendKeys("3");
        driver.findElement(By.name("data[pulse_latest]")).sendKeys("3");

        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(3);

        //aprrove
        driver.findElement(By.xpath(".//span[text()='Approve']")).click();
        Common.waitSec(3);
        System.out.println("check");
        action.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(3);
    }

    public void denied() {
        try {
            driver.findElement(By.xpath(".//button[text()='Got It']")).click();
            Common.waitSec(3);
        }
        catch (Exception e) {}

        driver.findElement(By.xpath(".//span[text()='Deny']")).click();
        Common.waitSec(2);
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath(".//div[text()='Please select reason to reject case']")).click();
        Common.waitSec(1);
        actions.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(2);

        driver.findElement(By.xpath(".//button[text()='Done']")).click();
        Common.waitSec(3);
        actions.sendKeys(Keys.ENTER).build().perform();

    }

    public void complete_RPM() {
        try {
            driver.findElement(By.xpath(".//button[text()='Got It']")).click();
            Common.waitSec(3);
        }
        catch (Exception e) {}
        Actions action = new Actions(driver);
        //Patient's Personal History
        driver.findElement(By.xpath(".//span[text()='Medical History']")).click();
        Common.waitSec(2);
        driver.findElement(By.name("data[patient_personal_history_progress_note_phmx]")).sendKeys("test");
        driver.findElement(By.name("data[patient_personal_history_progress_note_allergies_side_eff_pshx_confirm_null]")).click();
        driver.findElement(By.name("data[patient_personal_history_progress_note_vitals_confirm_null]")).click();
//        driver.findElement(By.name("data[patient_personal_history_progress_note_allergies_side_eff_pshx_confirm_null]")).click();
        Common.waitSec(2);
        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(3);

        //family history
//        driver.findElement(By.name("data[family_history_member_confirm_doctor_if_null]")).click();
//        Common.waitSec(1);
//
//        driver.findElement(By.name("data[submit]")).click();
//        Common.waitSec(3);

        //review of systems
//        driver.findElement(By.xpath(".//input[@name='data[review_of_system_confirm]']")).click();
        Common.waitSec(2);
//        driver.findElement(By.name("data[submit]")).click();
//        Common.waitSec(3);

        //diagnosis
        driver.findElement(By.xpath(".//*[text()='Diagnosis']")).click();
        Common.waitSec(3);

        driver.findElement(By.xpath(".//div[text()='I129']")).click();
        Common.waitSec(1);
        driver.findElement(By.xpath(".//div[text()='I10']")).click();
        Common.waitSec(1);

        driver.findElement(By.xpath(".//button[text()='Save']")).click();
        Common.waitSec(3);
        // medication
        System.out.println("Check Medications");
        driver.findElement(By.xpath(".//span[text()='Medications']")).click();
        driver.findElement(By.xpath(".//input[@name='shipped']")).click();
        Common.waitSec(2);
        driver.findElement(By.xpath(".//button[text()='Save']")).click();
        Common.waitSec(5);
        System.out.println("check");


        //Assessment & plan
        System.out.println("Set Assessment & Plan");
        Common.waitSec(4);
        driver.findElement(By.xpath(".//span[text()='Assessment & Plan']")).click();
        Common.waitSec(3);
        driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
        Common.waitSec(3);

        //RPM device
        driver.findElement(By.name("data[vital_blood_pressure_1]")).click();
        Common.waitSec(2);
//        driver.findElement(By.name("data[systolic_upper_high_alert]")).sendKeys("1");
//        driver.findElement(By.name("data[systolic_upper_med_alert]")).sendKeys("1");
//        driver.findElement(By.name("data[systolic_lower_high_alert]")).sendKeys("1");
//        driver.findElement(By.name("data[systolic_lower_med_alert]")).sendKeys("1");
//        driver.findElement(By.name("data[systolic_latest]")).sendKeys("1");
//
//        driver.findElement(By.name("data[diastolic_upper_high_alert]")).sendKeys("2");
//        driver.findElement(By.name("data[diastolic_upper_med_alert]")).sendKeys("2");
//        driver.findElement(By.name("data[diastolic_lower_high_alert]")).sendKeys("2");
//        driver.findElement(By.name("data[diastolic_lower_med_alert]")).sendKeys("2");
//        driver.findElement(By.name("data[diastolic_latest]")).sendKeys("2");
//
//        driver.findElement(By.name("data[pulse_upper_high_alert]")).sendKeys("3");
//        driver.findElement(By.name("data[pulse_upper_med_alert]")).sendKeys("3");
//        driver.findElement(By.name("data[pulse_lower_high_alert]")).sendKeys("3");
//        driver.findElement(By.name("data[pulse_lower_med_alert]")).sendKeys("3");
//        driver.findElement(By.name("data[pulse_latest]")).sendKeys("3");

        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(3);

        //aprrove
        driver.findElement(By.xpath(".//span[text()='Approve']")).click();

        Common.waitSec(3);
        System.out.println("check");
        action.sendKeys(Keys.ENTER).build().perform();
//        driver.findElement(By.xpath(".//button[text()='Yes']")).click();
        Common.waitSec(3);

    }

    public void complete_wellness() {
        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Common.waitSec(5);
        WebElement id_wellness = (WebElement) js.executeScript("return document.querySelector('body .rce-mb-15 strong');");
        id_wellness.click();
        Common.waitSec(5);

        //general health
        driver.findElement(By.xpath(".//span[text()='General Health']")).click();
        Common.waitSec(3);
        List<WebElement> listImmunizations = (List<WebElement>) js.executeScript(immunizations);
        action.moveToElement(listImmunizations.get(1)).click().build().perform();
        action.moveToElement(listImmunizations.get(5)).click().build().perform();
        action.moveToElement(listImmunizations.get(9)).click().build().perform();
        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(3);

        //medical history
        driver.findElement(By.xpath(".//span[text()='Medical History']")).click();
        Common.waitSec(3);
        driver.findElement(By.name("data[patient_personal_history_progress_note_phmx]")).sendKeys("test");
        driver.findElement(By.name("data[patient_personal_history_progress_note_allergies_side_eff_pshx_confirm_null]")).click();
        driver.findElement(By.name("data[patient_personal_history_progress_provider_history_confirm_null]")).click();
        driver.findElement(By.name("data[patient_personal_history_progress_note_vitals_confirm_null]")).click();

        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(3);

        //Social hisotry
        driver.findElement(By.xpath(".//span[text()='Social History']")).click();
        Common.waitSec(3);
        driver.findElement(By.name("data[patient_personal_history_progress_note_sochx_confirm]")).click();
        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(3);

        //

        //family history
        driver.findElement(By.xpath(".//span[text()='Family History']")).click();
        driver.findElement(By.name("data[family_history_member_1_related_health_issue]")).sendKeys("test");
		driver.findElement(By.name("data[submit]")).click();
		Common.waitSec(3);

        //Depression Screening
        driver.findElement(By.xpath(".//span[text()='Depression Screening']")).click();
        Common.waitSec(3);
        List<WebElement> PHQ2 = (List<WebElement>) js.executeScript(depressionScreening);
        action.moveToElement(PHQ2.get(1)).click().build().perform();
        action.moveToElement(PHQ2.get(5)).click().build().perform();
        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(3);

        //Alcohol Screening
        driver.findElement(By.xpath(".//span[text()='Alcohol Screening']")).click();
        Common.waitSec(3);
        List<WebElement> preAlcohol = (List<WebElement>) js.executeScript(alcoholScreening);
        action.moveToElement(preAlcohol.get(1)).click().build().perform();
        action.moveToElement(preAlcohol.get(3)).click().build().perform();
        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(3);

        //Tobacco Screening
        driver.findElement(By.xpath(".//span[text()='Tobacco Screening']")).click();
        Common.waitSec(3);
        List<WebElement> preTobacco = (List<WebElement>) js.executeScript(tobaccoScreening);
        action.moveToElement(preTobacco.get(1)).click().build().perform();
        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(3);

        //Advance Directive
        driver.findElement(By.xpath(".//span[text()='Advance Directive']")).click();
        Common.waitSec(3);
        List<WebElement> listAD = (List<WebElement>) js.executeScript(advanceDirective);
        action.moveToElement(listAD.get(1)).click().build().perform();
        action.moveToElement(listAD.get(2)).click().build().perform();
        action.moveToElement(listAD.get(8)).click().build().perform();
        action.moveToElement(listAD.get(10)).click().build().perform();
        action.moveToElement(listAD.get(12)).click().build().perform();
        action.moveToElement(listAD.get(13)).click().sendKeys("test").build().perform();
        action.moveToElement(listAD.get(14)).click().sendKeys("test").build().perform();
        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(3);

        //diagnosis
        driver.findElement(By.xpath(".//span[text()='Diagnosis']")).click();
        Common.waitSec(3);
        driver.findElement(By.xpath(".//div[text()='Z00.00']")).click();
        driver.findElement(By.xpath(".//button[text()='Save']")).click();
        Common.waitSec(3);


        //assessment & plan
        driver.findElement(By.xpath(".//span[text()='Assessment & Plan']")).click();
        Common.waitSec(3);
        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(3);

        //aproved case
        driver.findElement(By.xpath(".//span[text()='Approve']")).click();
        Common.waitSec(3);
        action.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(3);
        driver.findElement(By.xpath(".//button[@class='rce-btn btn-outline btn-main btn-md']")).click();
        Common.waitSec(3);

        driver.findElement(By.xpath(".//div[@class='sp-close']")).click();
    }
}
