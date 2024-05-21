package com.frame;

import com.Common;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class provider {

    protected static WebDriver driver;


    protected static String medical_history = "document.querySelectorAll('[name*=\"medical_history_patient_question1\"')";

    public provider(WebDriver driver) {
        this.driver = driver;
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
        List<WebElement> history_medical = (List<WebElement>) js.executeScript(medical_history);
        try {
            action.moveToElement(history_medical.get(0)).click().build().perform();
        }
        catch (Exception e) {
            driver.findElement(By.xpath("/html/body/div/div[7]/div[4]/div/div[2]/div/div[3]/div/div/div/div[1]/div[8]/div[1]/div[1]/label/input")).click();
        }
        Common.waitSec(2);
        driver.findElement(By.name("data[medical_history_patient_question2]")).sendKeys("test");
        driver.findElement(By.name("data[medical_history_patient_question3]")).sendKeys("test");
        driver.findElement(By.name("data[patient_personal_history_progress_note_phmx]")).sendKeys("test");
        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(3);

        // medication
        System.out.println("Check Medications");
        driver.findElement(By.xpath(".//span[text()='Medications']")).click();
        Common.waitSec(3);
        driver.findElement(By.xpath("//*[@id=\"patient-dashboard\"]/div[7]/div[4]/div/div[2]/div/div[3]/div/div[2]/div[4]/label/input")).click();
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
        driver.findElement(By.xpath(".//div[text()='Z80.1']")).click();
        driver.findElement(By.xpath(".//div[text()='C44.300']")).click();
        driver.findElement(By.xpath(".//div[text()='Z86.3']")).click();
        driver.findElement(By.xpath(".//button[text()='Save']")).click();
        Common.waitSec(5);

        // review of systems
        System.out.println("Review of Systems");

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

        System.out.println("-------------------------Done Approve----------------------------");
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

        //family history
//        driver.findElement(By.name("data[family_history_member_1_name]")).sendKeys("daddy");
//        Common.waitSec(2);
//        driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
//        Common.waitSec(1);
//        action.sendKeys(Keys.ENTER).build().perform();
//        Common.waitSec(1);
//        driver.findElement(By.xpath(".//input[@value='Male']")).click();
//        Common.waitSec(2);
//
//        driver.findElement(By.name("data[family_history_member_1_related_health_issue]")).sendKeys("test");

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
//        driver.findElement(By.xpath(".//div[text()='I10']")).click();
//        driver.findElement(By.xpath(".//div[text()='Z91.83']")).click();
//        Common.waitSec(1);

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
//        driver.findElement(By.xpath(".//div[text()='M02']")).click();
        driver.findElement(By.xpath(".//div[text()='I129']")).click();
        Common.waitSec(1);
//        driver.findElement(By.xpath(".//div[text()='G45']")).click();
//        driver.findElement(By.xpath(".//div[text()='E08']")).click();
        Common.waitSec(1);
        driver.findElement(By.xpath(".//div[text()='I10']")).click();
//        driver.findElement(By.xpath(".//div[text()='I129']")).click();
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
}
