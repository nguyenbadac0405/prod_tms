package com.frame;

import com.Common;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Factory;

import java.time.Duration;
import java.util.List;

public class pss {
    protected static WebDriver driver;

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

    //CASE DETAIL
    @FindBy(id = "rec-form-select-collapse-btn")
    public WebElement fCaseDetail;

    @FindBy(id = "react-select-14-input")
    public WebElement fSelectProvider;

    @FindBy(xpath = ".//span[text()='Assign']")
    public WebElement btnAssign;

    protected static String btnAssigned = "return document.querySelectorAll('[class*=\"rce-btn btn-minw-120\"]')";

    @FindBy(className = "card-header")
    public WebElement btnResult;

    @FindBy(css = "input[type='file']")
    public WebElement fUploadFile;

    protected static String fleSelectResultStt = "return document.querySelectorAll('[class*=\"sp-select__placeholder\"]')";

    protected static String btnUploadResult = "return document.querySelectorAll('[class=\"rce-btn btn-main\"]')";

    protected static String btnSendResult = "return document.querySelectorAll('[class=\"btn btn-primary btn-md\"]')";

    protected static String btnSendandMove = "return document.querySelectorAll('[class=\"swal-button swal-button--confirm\"]')";

    protected static String btnGotIt = "return document.querySelectorAll('[class=\"swal2-confirm swal2-styled\"]')";

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
        Common.waitSec(2);
        action.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(2);
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

        //ver full same well ness
        //qs2
//        driver.findElement(By.name("data[compliance_verification_verified_telehealth_provider]")).click();
//        List<WebElement> consent_bill = (List<WebElement>) js.executeScript(consent_to_bill);
//        action.moveToElement(consent_bill.get(1)).click().build().perform();
//
//        //qs3
//        List<WebElement> currently_hopital = (List<WebElement>) js.executeScript(currently_hospice);
//        action.moveToElement(currently_hopital.get(1)).click().build().perform();
//
//        //qs5
//        List<WebElement> money = (List<WebElement>) js.executeScript(verified_money);
//        action.moveToElement(money.get(1)).click().build().perform();
//
//        //qs6
//        List<WebElement> medical = (List<WebElement>) js.executeScript(with_medical);
//        action.moveToElement(medical.get(1)).click().build().perform();
//
//        //qs9
//        List<WebElement> health_additional = (List<WebElement>) js.executeScript(additional_health);
//        action.moveToElement(health_additional.get(1)).click().build().perform();
//
//        //qs10
//        List<WebElement> confirm = (List<WebElement>) js.executeScript(confirm_all);
//        action.moveToElement(confirm.get(1)).click().build().perform();

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
        Common.waitSec(2);
        action.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(2);
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

        //ver full same well ness
        //qs2
//        driver.findElement(By.name("data[compliance_verification_verified_telehealth_provider]")).click();
//        List<WebElement> consent_bill = (List<WebElement>) js.executeScript(consent_to_bill);
//        action.moveToElement(consent_bill.get(1)).click().build().perform();
//
//        //qs3
//        List<WebElement> currently_hopital = (List<WebElement>) js.executeScript(currently_hospice);
//        action.moveToElement(currently_hopital.get(1)).click().build().perform();
//
//        //qs5
//        List<WebElement> money = (List<WebElement>) js.executeScript(verified_money);
//        action.moveToElement(money.get(1)).click().build().perform();
//
//        //qs6
//        List<WebElement> medical = (List<WebElement>) js.executeScript(with_medical);
//        action.moveToElement(medical.get(1)).click().build().perform();
//
//        //qs9
//        List<WebElement> health_additional = (List<WebElement>) js.executeScript(additional_health);
//        action.moveToElement(health_additional.get(1)).click().build().perform();
//
//        //qs10
//        List<WebElement> confirm = (List<WebElement>) js.executeScript(confirm_all);
//        action.moveToElement(confirm.get(1)).click().build().perform();

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
