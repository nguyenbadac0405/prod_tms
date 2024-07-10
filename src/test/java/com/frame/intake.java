package com.frame;

import com.Common;
import org.checkerframework.checker.signature.qual.FieldDescriptor;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class intake {

    protected static WebDriver driver;

    //patient information
    @FindBy(xpath = "//*[@id=\"patient-dashboard\"]/div[6]/div[2]/div/div[2]/div[1]/div[2]/button")
    public WebElement btnCreatecase;

    @FindBy(id = "react-select-9-input")
    public WebElement fBusiness;

    @FindBy(id = "react-select-10-input")
    public WebElement fVertical;

    @FindBy(id = "react-select-15-input")
    public WebElement fMg;

    @FindBy(id = "react-select-12-input")
    public WebElement fTesttype;

    @FindBy(id = "react-select-13-input")
    public WebElement fLab;

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


    //pcp
    @FindBy(xpath = ".//span[text()='Primary Care Provider']")
    public WebElement sectPcp;

    @FindBy(name = "data[pcp_no_pcp_certification]")
    public WebElement btnNoPcp;

    @FindBy(xpath = ".//button[text()='Save']")
    public WebElement btnSave;

//    @FindBy(css = "button[class='btn rce-btn btn-primary btn-md']")
//    public WebElement btnSave;

    //Test Requirements
    @FindBy(xpath = ".//span[text()='Test Requirements']")
    public WebElement sectTestRes;

    @FindBy(name = "data[test_requirements_checkbox]")
    public WebElement ckCgxBioRes;

    //Medical History
    @FindBy(xpath = ".//span[text()='Medical History']")
    public WebElement sectMedicalHis;

    @FindBy(name = "data[medical_history_patient_cancer1]")
    public WebElement fCancerType;

    //family history

    @FindBy(xpath = ".//span[text()='Family History']")
    public WebElement sectFamilyHis;


    @FindBy(name = "data[family_history_member_1_name]")
    public WebElement fNameMember1;

    @FindBy(css = "div[class='form-control ui fluid selection dropdown']")
    public WebElement fRelation1;

    @FindBy(css = "input[value='Male']")
    public WebElement fGender1;

    @FindBy(name = "data[family_history_member_1_cancer_type]")
    public WebElement fCancertype1;

    //medication
    @FindBy(name = "shipped")
    public List<WebElement> ckMedicationConf;

    @FindBy(xpath = ".//span[text()='Submit']")
    public WebElement btnSubmit;



    public intake(WebDriver driver) {
        this.driver = driver;
    }

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


    public void create_case_genetics(String business, String vertical, String MG, String type, String lab, String first_name, String last_name, String DOB, String medicare_ID) {
        try {
            System.out.println(driver.findElement(By.xpath("//*[@id=\"patient-dashboard\"]/div[6]/div[2]/div/div[2]/div[1]/div[2]/button")).isDisplayed());
            driver.findElement(By.xpath("//*[@id=\"patient-dashboard\"]/div[6]/div[2]/div/div[2]/div[1]/div[2]/button")).click();
        }
        catch(Exception e) {
            driver.findElement(By.xpath("//*[@id=\"patient-dashboard\"]/div[6]/div[2]/div/div[2]/div[1]/div[2]/button")).click();
        }

        System.out.println("Set Business & Vertical");
        driver.findElement(By.id("react-select-9-input")).sendKeys(business, Keys.ENTER);
        Common.waitSec(2);
        Actions action = new Actions(driver);
        // set medical service
        driver.findElement(By.id("react-select-10-input")).sendKeys(vertical, Keys.ENTER);
        Common.waitSec(15);

        // set MG
        driver.findElement(By.id("react-select-15-input")).sendKeys(MG, Keys.ENTER);
        Common.waitSec(2);

        // set service type
        Common.waitSec(5);
        driver.findElement(By.id("react-select-12-input")).sendKeys(type, Keys.ENTER);
        Common.waitSec(2);

        // set state
        try {
            if(driver.findElement(By.id("react-select-13-input")).isEnabled()){
                driver.findElement(By.id("react-select-13-input")).sendKeys(lab, Keys.ENTER);
            }
        }
        catch (Exception e) {
            Common.waitSec(2);
            driver.findElement(By.id("react-select-13-input")).sendKeys(lab, Keys.ENTER);
        }

        System.out.println("Done Business and Vertical");
        Common.waitSec(2);

        System.out.println("Input Information");
        driver.findElement(By.name("data[patient_first_name]")).sendKeys(first_name);
        Common.waitSec(1);
        driver.findElement(By.name("data[patient_last_name]")).sendKeys(last_name);
        Common.waitSec(1);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        action.sendKeys(Keys.TAB).build().perform();
        action.sendKeys(DOB).build().perform();



        //zipcode
        driver.findElement(By.name("data[patient_zip_code]")).sendKeys("94107-1233");
        Common.waitSec(1);
        // medicare
        driver.findElement(By.name("data[patient_no_secondary_insurance]")).click();
        Common.waitSec(2);
        driver.findElement(By.xpath("//*[@value='Medicare']")).click();
        Common.waitSec(2);
        driver.findElement(By.name("data[patient_primary_insurance_id]")).sendKeys(medicare_ID);
//        driver.findElement(By.name("data[patient_primary_insurance_id]")).sendKeys("8TR2FG1QT22");
        Common.waitSec(1);


        //submit 1
        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(5);

        //gender & ethnicity
        driver.findElement(By.xpath("//*[@value='Male']")).click();
        Common.waitSec(1);
        driver.findElement(By.xpath("//*[@value='Asian']")).click();
        Common.waitSec(1);

        // height & weight
        driver.findElement(By.name("data[patient_height]")).sendKeys("5.75");
        Common.waitSec(1);
        driver.findElement(By.name("data[patient_height_in]")).sendKeys("5.75");
        Common.waitSec(1);
        driver.findElement(By.name("data[patient_weight]")).sendKeys("146");
        Common.waitSec(1);

        // zip code & street
        driver.findElement(By.name("data[patient_address]")).sendKeys("210 King Street");
        Common.waitSec(1);


        //phone
        driver.findElement(By.xpath("//input[@value='Cell Phone']")).click();
        Common.waitSec(3);
        driver.findElement(By.name("data[patient_phone]")).sendKeys("8458094618");
        Common.waitSec(3);

        //
        driver.findElement(By.name("data[patient_shipping_sms]")).click();
        Common.waitSec(2);
        driver.findElement(By.name("data[patient_shipping_us_postal_service]")).click();
        Common.waitSec(3);


        // submit
        driver.findElement(By.name("data[submit]")).click();

        System.out.println("-----------------Done draft case------------------");
        System.out.println(lab);
        Common.waitSec(15);

        //draft to new
        //pcp
        System.out.println("-------------Draft to new----------------");
        System.out.println("Check PCP");
        try {
            if (driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).isDisplayed()) {
                driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
                Common.waitSec(2);
                driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
                Common.waitSec(2);
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(3);
            }
        }
        catch (Exception e) {}


        //Test Requirement
        System.out.println("Check Test Requirement");
        driver.findElement(By.xpath(".//span[text()='Test Requirements']")).click();
        Common.waitSec(3);
//        driver.findElement(By.name("data[test_requirements_checkbox]")).click();
        driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
        Common.waitSec(3);

        //Medical History
        driver.findElement(By.xpath(".//span[text()='Medical History']")).click();

        Common.waitSec(2);
        System.out.println("Check Medical History");
//        driver.findElement((By.name("data[medical_history_patient_cancer1]"))).sendKeys("test");
        driver.findElement(By.name("data[patient_personal_history_progress_note_confirm_2_sale]")).click();
        Common.waitSec(1);
        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(2);

        //Family History
        driver.findElement(By.xpath(".//span[text()='Family History']")).click();
        System.out.println("Check Family History");
        driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
        Common.waitSec(2);
        driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
        Common.waitSec(1);
        action.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(1);
        driver.findElement(By.xpath(".//input[@value='Male']")).click();
//        driver.findElement(By.name("data[family_history_member_1_cancer_type]")).sendKeys("test");
        driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
        Common.waitSec(1);
        driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
        Common.waitSec(3);


        //Medication
        driver.findElement(By.xpath(".//span[text()='Medications']")).click();
//        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(3);
        System.out.println("Check Medication");
        driver.findElement(By.xpath("//*[@id=\"patient-dashboard\"]/div[6]/div[4]/div/div[2]/div/div[3]/div/div[2]/div[4]/label/input")).click();
        driver.findElement(By.xpath(".//button[text()='Save']")).click();
        Common.waitSec(3);


        //submit
        driver.findElement(By.xpath(".//span[text()='Submit']")).click();
        Common.waitSec(3);
        action.sendKeys(Keys.ENTER).build().perform();

        Common.waitSec(5);
    }

    public void to_Awating_Result() {
        Actions action = new Actions(driver);
        driver.findElement(By.id("rec-form-select-collapse-btn")).click();
        Common.waitSec(3);
        driver.findElement(By.id("shipped-check")).click();
        Common.waitSec(3);
        driver.findElement(By.id("kit-returned-check")).click();
        Common.waitSec(3);
        driver.findElement(By.id("is-completed-check")).click();
        Common.waitSec(3);
        driver.findElement(By.xpath(".//span[text()='Sent to Lab']")).click();
        Common.waitSec(2);
        action.sendKeys(Keys.ENTER).build().perform();

    }

    public void create_RPM(String business, String vertical, String MG, String first_name, String last_name, String DOB, String medicare_ID) {
        driver.findElement(By.xpath("//*[@id=\"patient-dashboard\"]/div[6]/div[2]/div/div[2]/div[1]/div[2]/button")).click();
        System.out.println("Set Business & Vertical");
        driver.findElement(By.id("react-select-9-input")).sendKeys(business, Keys.ENTER);
        Common.waitSec(6);
        Actions action = new Actions(driver);
        // set medical service
        driver.findElement(By.id("react-select-10-input")).sendKeys(vertical, Keys.ENTER);
        Common.waitSec(1);

        // set MG
        driver.findElement(By.id("react-select-15-input")).sendKeys(MG, Keys.ENTER);
        Common.waitSec(12);
        System.out.println(MG);


        System.out.println("Input Information");
        driver.findElement(By.name("data[patient_first_name]")).sendKeys(first_name);
        Common.waitSec(1);
        driver.findElement(By.name("data[patient_last_name]")).sendKeys(last_name);
        Common.waitSec(1);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        action.sendKeys(Keys.TAB).build().perform();
        action.sendKeys(DOB).build().perform();

        // zip code
        driver.findElement(By.name("data[patient_zip_code]")).sendKeys("94107-1231");
        Common.waitSec(1);

        // medicare
        driver.findElement(By.name("data[patient_no_secondary_insurance]")).click();
        Common.waitSec(2);
//        driver.findElement(By.xpath(".//input[@value='Medicare']")).click();
        Common.waitSec(3);
        driver.findElement(By.name("data[patient_primary_insurance_id]")).sendKeys(medicare_ID);
//        driver.findElement(By.name("data[patient_primary_insurance_id]")).sendKeys("8TR2FG1QT22");
        Common.waitSec(1);

        //submit 1
        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(5);

        //gender & ethnicity
//        driver.findElement(By.xpath("//*[@value='Medicare']")).click();
        Common.waitSec(2);
        driver.findElement(By.xpath("//*[@value='Male']")).click();
        Common.waitSec(1);
        driver.findElement(By.xpath("//*[@value='Asian']")).click();
        Common.waitSec(1);

        //address
        driver.findElement(By.name("data[patient_address]")).sendKeys("210 King Street");
        Common.waitSec(1);

        //phone
        driver.findElement(By.xpath(".//*[@value='Cell Phone']")).click();
        Common.waitSec(2);
        driver.findElement(By.name("data[patient_home_phone]")).sendKeys("8458094618");
        Common.waitSec(3);
        driver.findElement(By.name("data[patient_phone]")).sendKeys("8458094618");
        Common.waitSec(3);
//        driver.findElement(By.name("data[phone_number_alternative]")).sendKeys("8458094618");
//        Common.waitSec(3);

        //language
        driver.findElement(By.xpath("//*[@value='English']")).click();
        driver.findElement(By.xpath("//*[@value='French']")).click();
        Common.waitSec(3);

        //best time to call
        driver.findElement(By.xpath(".//div[text()='Select your answer']")).click();
        Common.waitSec(2);
        action.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(3);

        //medical conditions
        driver.findElement(By.xpath(".//input[@placeholder='Select your answer']")).click();
        Common.waitSec(2);
        action.sendKeys(Keys.ENTER).build().perform();

        //Emergency contacts
        driver.findElement(By.name("data[patient_ec_full_name_1]")).sendKeys("dac");
        Common.waitSec(2);
        driver.findElement(By.name("data[patient_ec_phone_number_1]")).sendKeys("8458094618");
        Common.waitSec(2);
        driver.findElement(By.xpath(".//div[text()='Select your answer']")).click();
        Common.waitSec(2);
        action.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(2);



        // submit
        driver.findElement(By.name("data[submit]")).click();
        System.out.println("-----------------Done draft case------------------");
        Common.waitSec(5);

        //draft to new
        //submit
//        driver.findElement(By.xpath(".//span[text()='Submit']")).click();
        Common.waitSec(5);
        action.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(5);
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

    public void createOnboarding(String business, String vertical, String MG, String type, String lab, String first_name, String last_name, String DOB, String medicare_ID) {
        try {
            System.out.println(driver.findElement(By.xpath("//*[@id=\"patient-dashboard\"]/div[6]/div[2]/div/div[2]/div[1]/div[2]/button")).isDisplayed());
            driver.findElement(By.xpath("//*[@id=\"patient-dashboard\"]/div[6]/div[2]/div/div[2]/div[1]/div[2]/button")).click();
        }
        catch(Exception e) {
            driver.findElement(By.xpath("//*[@id=\"patient-dashboard\"]/div[6]/div[2]/div/div[2]/div[1]/div[2]/button")).click();
        }

        System.out.println("Set Business & Vertical");
        driver.findElement(By.id("react-select-9-input")).sendKeys(business, Keys.ENTER);
        Common.waitSec(2);
        Actions action = new Actions(driver);
        // set medical service
        driver.findElement(By.id("react-select-10-input")).sendKeys(vertical, Keys.ENTER);
        Common.waitSec(15);

        // set MG
        driver.findElement(By.id("react-select-15-input")).sendKeys(MG, Keys.ENTER);
        Common.waitSec(2);

        // set service type
        Common.waitSec(5);
        driver.findElement(By.id("react-select-12-input")).sendKeys(type, Keys.ENTER);
        Common.waitSec(2);

        // set state
        try {
            if(driver.findElement(By.id("react-select-13-input")).isEnabled()){
                driver.findElement(By.id("react-select-13-input")).sendKeys(lab, Keys.ENTER);
            }
        }
        catch (Exception e) {
            Common.waitSec(2);
            driver.findElement(By.id("react-select-13-input")).sendKeys(lab, Keys.ENTER);
        }

        System.out.println("Done Business and Vertical");
        Common.waitSec(2);

        System.out.println("Input Information");
        driver.findElement(By.name("data[patient_first_name]")).sendKeys(first_name);
        Common.waitSec(1);
        driver.findElement(By.name("data[patient_last_name]")).sendKeys(last_name);
        Common.waitSec(1);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        action.sendKeys(Keys.TAB).build().perform();
        action.sendKeys(DOB).build().perform();



        //zipcode
        driver.findElement(By.name("data[patient_zip_code]")).sendKeys("94107-1233");
        Common.waitSec(1);
        // medicare
        driver.findElement(By.name("data[patient_no_secondary_insurance]")).click();
        Common.waitSec(2);
        driver.findElement(By.xpath("//*[@value='Medicare']")).click();
        Common.waitSec(2);
        driver.findElement(By.name("data[patient_primary_insurance_id]")).sendKeys(medicare_ID);
//        driver.findElement(By.name("data[patient_primary_insurance_id]")).sendKeys("8TR2FG1QT22");
        Common.waitSec(1);


        //submit 1
        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(5);

        //gender & ethnicity
        driver.findElement(By.xpath("//*[@value='Male']")).click();
        Common.waitSec(1);
        driver.findElement(By.xpath("//*[@value='Asian']")).click();
        Common.waitSec(1);

        // height & weight
        driver.findElement(By.name("data[patient_height]")).sendKeys("5.75");
        Common.waitSec(1);
        driver.findElement(By.name("data[patient_height_in]")).sendKeys("5.75");
        Common.waitSec(1);
        driver.findElement(By.name("data[patient_weight]")).sendKeys("146");
        Common.waitSec(1);

        // zip code & street
        driver.findElement(By.name("data[patient_address]")).sendKeys("210 King Street");
        Common.waitSec(1);


        //phone
        driver.findElement(By.xpath("//input[@value='Cell Phone']")).click();
        Common.waitSec(3);
        driver.findElement(By.name("data[patient_phone]")).sendKeys("8458094618");
        Common.waitSec(3);

        //
        driver.findElement(By.name("data[patient_shipping_sms]")).click();
        Common.waitSec(2);
//        driver.findElement(By.name("data[patient_shipping_us_postal_service]")).click();
//        Common.waitSec(3);


        // submit
        driver.findElement(By.name("data[submit]")).click();
        System.out.println("-----------------Done draft case------------------");
        System.out.println(lab);
        Common.waitSec(5);

        //draft to new
        //pcp
        System.out.println("-------------Draft to new----------------");
        try {
            if (driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).isDisplayed()) {
                driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
                Common.waitSec(2);
                driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
                Common.waitSec(2);
                driver.findElement(By.xpath(".//button[text()='Save']")).click();
                Common.waitSec(3);
            }
        }
        catch (Exception e) {}

        //Test Requirement
        System.out.println("Check Test Requirement");
        driver.findElement(By.xpath(".//span[text()='Test Requirements']")).click();
        Common.waitSec(3);
//        driver.findElement(By.name("data[test_requirements_checkbox]")).click();
        driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
        Common.waitSec(3);

        //Medical History
        driver.findElement(By.xpath(".//span[text()='Medical History']")).click();

        Common.waitSec(2);
        System.out.println("Check Medical History");
//        driver.findElement((By.name("data[medical_history_patient_cancer1]"))).sendKeys("test");
        driver.findElement(By.name("data[patient_personal_history_progress_note_confirm_2_sale]")).click();
        Common.waitSec(1);
        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(2);

        //Family History
        driver.findElement(By.xpath(".//span[text()='Family History']")).click();
        System.out.println("Check Family History");
        driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
        Common.waitSec(2);
        driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
        Common.waitSec(1);
        action.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(1);
        driver.findElement(By.xpath(".//input[@value='Male']")).click();
//        driver.findElement(By.name("data[family_history_member_1_cancer_type]")).sendKeys("test");
        driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
        Common.waitSec(1);
        driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
        Common.waitSec(3);


        //Medication
        driver.findElement(By.xpath(".//span[text()='Medications']")).click();
//        driver.findElement(By.name("data[submit]")).click();
        Common.waitSec(3);
        System.out.println("Check Medication");
        driver.findElement(By.xpath("//*[@id=\"patient-dashboard\"]/div[6]/div[4]/div/div[2]/div/div[3]/div/div[2]/div[4]/label/input")).click();
        driver.findElement(By.xpath(".//button[text()='Save']")).click();
        Common.waitSec(3);


        //submit
        driver.findElement(By.xpath(".//span[text()='Submit']")).click();
        Common.waitSec(3);
        action.sendKeys(Keys.ENTER).build().perform();

        Common.waitSec(5);
    }
}



