package com.frame;

import com.Common;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class pss {
    protected static WebDriver driver;


    //Are you able to make your own medical decisions or does someone else make them for you?
    protected static String medical_decision = "return document.querySelectorAll('[name*=\"compliance_verification_verified_medical_decision_41589\"')";

    //Do you agree to having a telehealth provider bill your insurance?
    protected static String consent_to_bill  = "return document.querySelectorAll('[name*=\"compliance_verification_verified_consent_to_bill_41589\"')";

    //Are you currently in hospice, a nursing home or any other type of care facility?
    protected static String currently_hospice = "return document.querySelectorAll('[name*=\"compliance_verification_verified_currently_hospice\"')";

    //Have you ever had a genetic screening?
    protected static String previously_taken_genetic_test = "return document.querySelectorAll('[name*=\"compliance_verification_verified_patient_previously_taken_genetic_test_41589\"')";

    //Has anyone offered you any money or an incentive for you to take a genetic test?
    protected static String verified_money = "return document.querySelectorAll('[name*=\"compliance_verification_verified_money\"')";

    //Has any sales agent represented themselves as being with Medicare?
    protected static String with_medical = "return document.querySelectorAll('[name*=\"compliance_verification_verified_with_medical\"')";

    //Has patient ever completed any medicare wellness program visit?
    protected static String wellness_completed = "return document.querySelectorAll('[name*=\"compliance_verification_verified_patient_wellness_program\"')";

    // Has patient completed a medicare wellness program visit in the past year?
    protected static String wellness_past = "return document.querySelectorAll('[name*=\"compliance_verification_verified_patient_wellness_program_past\"')";

    //Do you give consent for us to contact you in the future to discuss any additional health services that can benefit you?
    protected static String additional_health = "return document.querySelectorAll('[name*=\"compliance_verification_verified_additional_health\"')";

    //Do you confirm all the above information is true and accurate?
    protected static String confirm_all = "return document.querySelectorAll('[name*=\"compliance_verification_verified_confirm_all\"')";


    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        pss.driver = driver;
    }

    public static String getMedical_decision() {
        return medical_decision;
    }

    public static void setMedical_decision(String medical_decision) {
        pss.medical_decision = medical_decision;
    }

    public static String getConsent_to_bill() {
        return consent_to_bill;
    }

    public static void setConsent_to_bill(String consent_to_bill) {
        pss.consent_to_bill = consent_to_bill;
    }

    public static String getCurrently_hospice() {
        return currently_hospice;
    }

    public static void setCurrently_hospice(String currently_hospice) {
        pss.currently_hospice = currently_hospice;
    }

    public static String getPreviously_taken_genetic_test() {
        return previously_taken_genetic_test;
    }

    public static void setPreviously_taken_genetic_test(String previously_taken_genetic_test) {
        pss.previously_taken_genetic_test = previously_taken_genetic_test;
    }

    public static String getVerified_money() {
        return verified_money;
    }

    public static void setVerified_money(String verified_money) {
        pss.verified_money = verified_money;
    }

    public static String getWith_medical() {
        return with_medical;
    }

    public static void setWith_medical(String with_medical) {
        pss.with_medical = with_medical;
    }

    public static String getWellness_completed() {
        return wellness_completed;
    }

    public static void setWellness_completed(String wellness_completed) {
        pss.wellness_completed = wellness_completed;
    }

    public static String getWellness_past() {
        return wellness_past;
    }

    public static void setWellness_past(String wellness_past) {
        pss.wellness_past = wellness_past;
    }

    public static String getAdditional_health() {
        return additional_health;
    }

    public static void setAdditional_health(String additional_health) {
        pss.additional_health = additional_health;
    }

    public static String getConfirm_all() {
        return confirm_all;
    }

    public static void setConfirm_all(String confirm_all) {
        pss.confirm_all = confirm_all;
    }

    public pss(WebDriver driver) {

        this.driver = driver;
    }


    public void to_pending() {
        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println("---------------------------------New to Assign---------------------------------------");
        System.out.println("Check Compliance");
        driver.findElement(By.name("data[compliance_verification_verified_telehealth_provider]")).click();

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

        driver.findElement(By.name("data[compliance_verification_verified_patient_gender_41589]")).click();
        driver.findElement(By.name("data[compliance_verification_verified_patient_dob_41589]")).click();
        driver.findElement(By.name("data[compliance_verification_verified_patient_state_41589]")).click();
        driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
        Common.waitSec(5);

        //assign
        driver.findElement(By.id("rec-form-select-collapse-btn")).click();
        Common.waitSec(3);

        driver.findElement(By.xpath(".//div[text()='Select ...']")).click();
        Common.waitSec(2);
        action.sendKeys("dac").build().perform();
        action.sendKeys(Keys.ENTER).build().perform();
        action.sendKeys(Keys.ENTER).build().perform();

        Common.waitSec(5);
        driver.findElement(By.xpath(".//span[text()='Assign']")).click();
        Common.waitSec(2);
        action.sendKeys(Keys.ENTER).build().perform();

    }

    public void to_AFU() {
        //to result available
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions action = new Actions(driver);
        driver.findElement(By.xpath("//*[@id=\"patient-dashboard\"]/div[6]/div[4]/div/div[1]/div[6]/div/div/div[1]")).click();
        Common.waitSec(3);
        WebElement chooseFile = driver.findElement(By.xpath(".//input[@type='file']"));
        chooseFile.sendKeys("C:/Users/dac/Downloads/file.pdf");
        Common.waitSec(5);
        //to assign follow up
        driver.findElement(By.xpath(".//div[text()='Select ...']")).click();
        Common.waitSec(1);
        action.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(1);
        driver.findElement(By.xpath(".//button[text()='Upload ']")).click();
        Common.waitSec(10);
        System.out.println("chekc");
        try {
            WebElement button_send = driver.findElement(By.xpath(".//button[@class='btn btn-primary btn-md']"));
            Common.waitSec(3);
            action.moveToElement(button_send).click().build().perform();
        }
        catch (Exception e) {}

        System.out.println("check");
        driver.findElement(By.xpath(".//button[text()='Send & Move']")).click();
        Common.waitSec(3);
//        action.sendKeys(Keys.ENTER).build().perform();
        driver.findElement(By.xpath(".//button[text()='Got it']")).click();
        Common.waitSec(3);

        driver.findElement(By.xpath(".//span[text()='Assign']")).click();
        Common.waitSec(2);
        action.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(3);

//        try {
//            WebElement button_send = driver.findElement(By.xpath(".//button[@class='btn btn-primary btn-md']"));
//            action.moveToElement(button_send).click().build().perform();
//        } catch (Exception e) {
//            driver.findElement(By.xpath(".//button[@class='rf-close-btn']")).click();
//            Common.waitSec(3);
//            driver.findElement(By.xpath(".//button[@class='rf-btn-link']")).click();
//            Common.waitSec(3);
//            driver.findElement(By.xpath(".//button[@class='btn btn-primary btn-md']")).click();
//
//        }
    }

    public void complete() {
        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath(".//span[text()='Close Case']")).click();
        Common.waitSec(3);
        action.sendKeys(Keys.ENTER).build().perform();
    }

    public void cancel_genetics() {

        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println("---------------------------------New to Assign---------------------------------------");
        driver.findElement(By.xpath("//span[text()='Compliance']")).click();
        Common.waitSec(5);

        System.out.println("check compliance");

        driver.findElement(By.name("data[compliance_verification_verified_telehealth_provider]")).click();
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
        if (completed_wellness.get(0).isEnabled()) {
            action.moveToElement(completed_wellness.get(0)).click().build().perform();
        }

        //qs8
        List<WebElement> past_wellness = (List<WebElement>) js.executeScript(wellness_past);
        if (past_wellness.get(0).isEnabled()) {
            action.moveToElement(past_wellness.get(0)).click().build().perform();
        }

        //qs9
        List<WebElement> health_additional = (List<WebElement>) js.executeScript(additional_health);
        action.moveToElement(health_additional.get(1)).click().build().perform();

        //qs10
        List<WebElement> confirm = (List<WebElement>) js.executeScript(confirm_all);
        action.moveToElement(confirm.get(1)).click().build().perform();

        driver.findElement(By.name("data[compliance_verification_verified_patient_gender_41589]")).click();
        driver.findElement(By.name("data[compliance_verification_verified_patient_dob_41589]")).click();
        driver.findElement(By.name("data[compliance_verification_verified_patient_state_41589]")).click();
        System.out.println("check 2");
        Common.waitSec(2);

        driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
        Common.waitSec(10);


        driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[6]/div[2]/div[4]/div[1]/div[2]/button")).click();
        Common.waitSec(3);
        driver.findElement(By.xpath(".//span[text()='Cancel']")).click();
        Common.waitSec(3);
        driver.findElement(By.xpath(".//div[text()='Please select reason to cancel case']")).click();
        Common.waitSec(1);
        action.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(2);
        driver.findElement(By.xpath(".//button[text()='Done']")).click();

    }

    public void assign_RPM() {
        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//span[text()='Compliance']")).click();
        Common.waitSec(5);

        System.out.println("check compliance");

        driver.findElement(By.name("data[compliance_verification_verified_telehealth_provider]")).click();
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
        if (completed_wellness.get(0).isEnabled()) {
            action.moveToElement(completed_wellness.get(0)).click().build().perform();
        }

        //qs8
        List<WebElement> past_wellness = (List<WebElement>) js.executeScript(wellness_past);
        if (past_wellness.get(0).isEnabled()) {
            action.moveToElement(past_wellness.get(0)).click().build().perform();
        }

        //qs9
        List<WebElement> health_additional = (List<WebElement>) js.executeScript(additional_health);
        action.moveToElement(health_additional.get(1)).click().build().perform();

        //qs10
        List<WebElement> confirm = (List<WebElement>) js.executeScript(confirm_all);
        action.moveToElement(confirm.get(1)).click().build().perform();

        driver.findElement(By.name("data[compliance_verification_verified_patient_gender_41589]")).click();
        driver.findElement(By.name("data[compliance_verification_verified_patient_dob_41589]")).click();
        driver.findElement(By.name("data[compliance_verification_verified_patient_state_41589]")).click();
        System.out.println("check 2");
        Common.waitSec(2);
        driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
        Common.waitSec(15);

        driver.findElement(By.xpath(".//button[text()='Got It']")).click();
        Common.waitSec(3);

        //assign
        driver.findElement(By.id("rec-form-select-collapse-btn")).click();
        Common.waitSec(3);

        driver.findElement(By.xpath(".//div[text()='Select ...']")).click();
        Common.waitSec(2);
        action.sendKeys("dac").build().perform();
        action.sendKeys(Keys.ENTER).build().perform();
        action.sendKeys(Keys.ENTER).build().perform();

        Common.waitSec(5);
        driver.findElement(By.xpath(".//span[text()='Assign']")).click();
        Common.waitSec(2);
        action.sendKeys(Keys.ENTER).build().perform();

    }

    public void cancel_RPM() {
        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//span[text()='Compliance']")).click();
        Common.waitSec(5);

        System.out.println("check compliance");

        driver.findElement(By.name("data[compliance_verification_verified_telehealth_provider]")).click();
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
        if (completed_wellness.get(0).isEnabled()) {
            action.moveToElement(completed_wellness.get(0)).click().build().perform();
        }

        //qs8
        List<WebElement> past_wellness = (List<WebElement>) js.executeScript(wellness_past);
        if (past_wellness.get(0).isEnabled()) {
            action.moveToElement(past_wellness.get(0)).click().build().perform();
        }

        //qs9
        List<WebElement> health_additional = (List<WebElement>) js.executeScript(additional_health);
        action.moveToElement(health_additional.get(1)).click().build().perform();

        //qs10
        List<WebElement> confirm = (List<WebElement>) js.executeScript(confirm_all);
        action.moveToElement(confirm.get(1)).click().build().perform();

        driver.findElement(By.name("data[compliance_verification_verified_patient_gender_41589]")).click();
        driver.findElement(By.name("data[compliance_verification_verified_patient_dob_41589]")).click();
        driver.findElement(By.name("data[compliance_verification_verified_patient_state_41589]")).click();
        System.out.println("check 2");
        Common.waitSec(2);
        driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
        Common.waitSec(10);

        driver.findElement(By.xpath(".//button[text()='Got It']")).click();
        Common.waitSec(3);

        //cancel
        driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[6]/div[2]/div[4]/div[1]/div[2]/button")).click();
        Common.waitSec(3);
        driver.findElement(By.xpath(".//span[text()='Cancel']")).click();
        Common.waitSec(3);
        driver.findElement(By.xpath(".//div[text()='Please select reason to cancel case']")).click();
        Common.waitSec(1);
        action.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(2);
        driver.findElement(By.xpath(".//button[text()='Done']")).click();
    }

    public static String get_DOB() {

        Common.waitSec(5);
        WebElement elementToCheck = null;

        try {
            elementToCheck = driver.findElement(By.xpath("//span[text()='Patient Information']"));
        } catch (NoSuchElementException e) {
            System.out.println("Phần tử không tồn tại trên trang web.");
        }

        // Kiểm tra xem phần tử có tồn tại và hiển thị hay không
        if (elementToCheck != null && elementToCheck.isDisplayed()) {
            driver.findElement(By.xpath("//span[text()='Patient Information']")).click();
            Common.waitSec(3);
            WebElement DOB_element = driver.findElement(By.name("data[patient_dob]"));
            String DOB = DOB_element.getAttribute("value");
            return DOB;
        } else {
            return "1";
        }

    }

}
