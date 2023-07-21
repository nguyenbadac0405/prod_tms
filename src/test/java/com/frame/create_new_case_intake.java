package com.frame;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import com.Common;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class create_new_case_intake {
	protected WebDriver driver;
	
	public create_new_case_intake(WebDriver driver) {
		this.driver = driver;
	}

	
	public void Genetics_create_new_case(String business, String vertical, String MG, String type, String lab, String first_name, String last_name, String DOB, String medicare_ID, String zipcode) {
		Actions action = new Actions(driver);
		//draft case
		System.out.println("------------------------------Create NEW case------------------------------------");
		
		Common.waitSec(10);
		WebElement add_case = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[1]/div[1]/div[1]/h2/span"));
		if (add_case.isDisplayed()) {
			add_case.click();
		}

		// create draft
		// set business
		Common.waitSec(5);
		System.out.println("Set Business & Vertical");
		driver.findElement(By.xpath("//*[@id='react-select-5-input']")).sendKeys(business, Keys.ENTER);
		Common.waitSec(2);

		// set medical service
		driver.findElement(By.xpath("//*[@id='react-select-6-input']")).sendKeys(vertical, Keys.ENTER);
		Common.waitSec(2);

		// set MG
		driver.findElement(By.xpath("//*[@id='react-select-8-input']")).sendKeys(MG, Keys.ENTER);
		Common.waitSec(2);

		// set service type
		driver.findElement(By.xpath("//*[@id='react-select-10-input']")).sendKeys(type, Keys.ENTER);
		Common.waitSec(3);

		// set state
		driver.findElement(By.xpath("//*[@id='react-select-11-input']")).sendKeys(lab, Keys.ENTER);
		System.out.println("Done Business and Vertical");
		Common.waitSec(2);

		// info patient
		// name
		System.out.println("Input Information");
		driver.findElement(By.xpath("//*[@name='data[patient_first_name]']")).sendKeys(first_name);
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_last_name]']")).sendKeys(last_name);
		Common.waitSec(1);
		// date of birth.
		driver.findElement(By.xpath("//*[@class='form-group has-feedback formio-component formio-component-datetime formio-component-patient_dob  required']/div[1]/div/input[2]")).sendKeys(DOB);
		Common.waitSec(1);
		// medicare
		driver.findElement(By.xpath("//*[@name='data[patient_no_secondary_insurance]']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@value='Medicare']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@name='data[patient_primary_insurance_id]']")).sendKeys(medicare_ID);
		Common.waitSec(1);
		
		//gender & ethnicity
		driver.findElement(By.xpath("//*[@value='Male']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@value='Asian']")).click();
		Common.waitSec(1);
		
		// height & weight
		driver.findElement(By.xpath("//*[@name='data[patient_height]']")).sendKeys("5.75");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_weight]']")).sendKeys("146");
		Common.waitSec(1);
				
		// zip code & street
		driver.findElement(By.xpath("//*[@name='data[patient_address]']")).sendKeys("q2");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_zip_code]']")).sendKeys(zipcode);
		Common.waitSec(1);
				
		//phone
		driver.findElement(By.xpath("//input[@value='Cell Phone']")).click();
		driver.findElement(By.xpath("//input[@name='data[patient_phone]']")).sendKeys("5864565645");
		Common.waitSec(3);	
					
		// submit
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		System.out.println("-----------------Done draft case------------------");
		System.out.println(lab);
		Common.waitSec(5);
		//draft to new
		
		//TEST TYPE CGX
		if (type.equals("CGX")) {
			//LAB CGX 1
			if (lab.equals("CGX - R&D")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);
				
				//Test requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Medical History
				System.out.println("Check Medical History");
				driver.findElement(By.xpath("//input[@name='data[patient_personal_history_progress_note_confirm_2_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
			}
			
			//LAB 2
			if (lab.equals("CGX - Biogroup")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);
				
				//Test Requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.name("data[test_requirements_checkbox]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medical History
				driver.findElement(By.xpath(".//span[text()='Medical History']")).click();

				Common.waitSec(2);
				System.out.println("Check Medical History");
				driver.findElement((By.name("data[medical_history_patient_cancer1]"))).sendKeys("test");
				driver.findElement(By.name("data[patient_personal_history_progress_note_confirm_2_sale]")).click();
				Common.waitSec(1);
				driver.findElement(By.name("data[submit]")).click();
				Common.waitSec(2);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//span[text()='Family History']")).click();
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.name("data[family_history_member_1_cancer_type]")).sendKeys("test");
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);

				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				driver.findElement(By.name("data[submit]")).click();
				Common.waitSec(3);
			}
			
			//LAB CGX 3
			if (lab.equals("CGX - Brookside")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);

				//Test Requirement
				driver.findElement(By.name("data[test_requirements_breast_cancer]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medical History
				System.out.println("Check Medical History");
				driver.findElement(By.xpath("//input[@name='data[patient_personal_history_progress_note_confirm_2_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
			}

			//LAB CGX 4
			if (lab.equals("CGX_Chromlabs")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);

				//Test Requirement
				driver.findElement(By.name("data[test_requirements_comprehensive_cancer]")).click();
				Common.waitSec(1);
				driver.findElement(By.name("data[test_requirements_lynch_syndrome]")).click();
				Common.waitSec(1);
				driver.findElement(By.name("data[test_requirements_ovarian_cancer]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medical History
				System.out.println("Check Medical History");
				driver.findElement(By.name("data[patient_personal_history_progress_note_confirm_2_sale]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
			}

			//LAB CGX 5
			if (lab.equals("CGX_Home Genetics August 2022")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);

				//Test Requirement
				driver.findElement(By.name("data[test_requirements_44]")).click();
				Common.waitSec(1);
				driver.findElement(By.name("data[test_requirements_pancreatic_cancer]")).click();
				Common.waitSec(1);
				driver.findElement(By.name("data[test_requirements_lynch_cancer]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medical History
				System.out.println("Check Medical History");
				driver.findElement(By.name("data[patient_personal_history_progress_note_confirm_2_sale]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
			}
		}
		
		//LAB CARDIO
		if (lab.equals("Cardio")) {
			// LAB CARDIO 1
			if (type.equals("Cardio - ALIGN")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);
				
				//Test requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.xpath("//input[@name='data[test_requirements_primary_genes_117]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//patient's persional History
				System.out.println("Check Medical History");
				driver.findElement(By.xpath("//input[@name='data[patient_personal_history_progress_note_confirm_2_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
			}	
			//LAB CARDIO 2
			if (type.equals("CARDIO_DIAX")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);
				
				//Test requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.xpath("//input[@value='HEF']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//input[@value='APOE']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//input[@value='FXN']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//patient's persional History
				System.out.println("Check Medical History");
				driver.findElement(By.xpath("//input[@name='data[patient_personal_history_progress_note_confirm_2_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
			}	
			
			//LAB CARDIO 3
			if (type.equals("Cardio - LIMITLESS")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);
				
				//Test requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.xpath("//input[@value='Seq & Del/Dup']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//input[@value='Diagnostic']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//input[@value='Presymptomatic']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//patient's persional History
				System.out.println("Check Medical History");
				driver.findElement(By.xpath("//input[@name='data[patient_personal_history_progress_note_confirm_2_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
			}	
			
			//LAB CARDIO 4
			if (type.equals("Cardio - PRINCIPLE")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);
				
				//Test requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.xpath("//input[@name='data[test_requirements_hereditary_cardio]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//input[@name='data[test_requirements_actionable_cardio]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//input[@name='data[test_requirements_hereditary2_cardio]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//patient's persional History
				System.out.println("Check Medical History");
				driver.findElement(By.xpath("//input[@name='data[patient_personal_history_progress_note_confirm_2_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
			}	
			// LAB CARDIO 5
			if (type.equals("Cardio - PRINCIPLE")) {
				// pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);

				// Test requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.xpath("//input[@name='data[test_requirements_hereditary_cardio]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);

				// patient's persional History
				System.out.println("Patient's persional History");
				driver.findElement(By.xpath("//input[@name='data[patient_personal_history_progress_note_confirm_2_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);

				// Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);

				// Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);

				// Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);

			}
			
		}
		if (type.equals("PGX")) {
			if (lab.equals("PGX_ADVANTA")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);
				
				//Test requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.xpath(".//*[@value='ADRA2A']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//*[@value='CYP1A2']")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//medical History
				System.out.println("Check Medical History");
				driver.findElement(By.xpath("//input[@name='data[patient_personal_history_progress_note_confirm_2_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
			
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
//				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[5]/button")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
//				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
			}
			else {System.out.println("fail pgx");}
		}
		if (type.equals("Pulmonary")) {
			if (lab.equals("Pulmonary AdvaGenix")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);
				
				//Test requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Patient's medical History
				System.out.println("Check Patient's Medical History");
				driver.findElement(By.name("data[patient_personal_history_progress_note_confirm_2_sale]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);

			
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
			}
			
		}
		if (type.equals("Diabetes")) {
			//LAB DIABETES 1
			if (lab.equals("Diabetes - INFINITY")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);
				
				//Test requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.name("data[test_requirements_name]")).click();
				Common.waitSec(1);
				driver.findElement(By.name("data[test_requirements_test_options][]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//medical History
				System.out.println("Check Medical History");
				driver.findElement(By.name("data[patient_personal_history_progress_note_confirm_2_sale]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
			
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
//				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[5]/button")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
			}
			
			//LAB DIABETES 2
			if (lab.equals("DIABETES - ADL")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);
				
				//Test requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.name("data[test_requirements_name]")).click();
				Common.waitSec(1);
				driver.findElement(By.name("data[test_requirements_test_options][]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//medical History
				System.out.println("Check Medical History");
				driver.findElement(By.name("data[patient_personal_history_progress_note_confirm_2_sale]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
			
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
//				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[5]/button")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
			}
		}
		if (type.equals("Immunodeficiency")) {
			if (lab.equals("Immunodeficiency - Biogroup")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);
				
				//Test requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.name("data[test_requirements_checkbox]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Patient's medical History
				System.out.println("Check Patient's Medical History");
				driver.findElement(By.name("data[patient_personal_history_progress_note_confirm_2_sale]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Family History
				driver.findElement(By.xpath(".//span[text()='Family History']")).click();
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//*[@value='Yes']")).click();
				driver.findElement(By.name("data[family_history_member_indications][]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
			}
		}
		
		if (type.equals("NEUROCOGNITIVE")) {
			if (lab.equals("Neurocognitive-Diax")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);
				
				//medical History
				System.out.println("Check Medical History");
				driver.findElement(By.name("data[patient_personal_history_progress_note_confirm_2_sale]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Test requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.name("data[test_requirements_1967]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
//				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[5]/button")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
			}
			
		}
		
		//submit
		driver.findElement(By.xpath(".//div[text()='Submit']")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		System.out.println("------------------------------Done new case.-----------------------------------");
		Common.waitSec(5);

				
	}
	

}
