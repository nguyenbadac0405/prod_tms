package com.scripts;

import com.frame.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Common;

import java.util.Arrays;
import java.util.List;

public class Genetics extends DriverFactory {
	login login;
	GetDriver link;
	create_new_case_intake new_case_intake;
	new_to_assign to_assign;
	assign_to_approved to_approved;
	approved_to_complete to_complete;
	search_case search;
	log_out logout;
	assign_provider ass;
	ExcelHelpers excel;
	getInfo getinfo;
	approve_to_assign_follow_up to_AFU;
	billing billing;
	FPC_Approved fpc;

	render_name_medicare_ID render;

	create_PSS create_PSS;

	sendback sendback;

	intake intake;

	provider doctor;

	pss pss;

	Section section;
	patientInformation paInfor;
	PCP pcp;
	testRequirement testRes;
	medicalHistory medHis;
	medication medication;
	familyHistory famHis;
	caseDetail caseDetail;
	runAPI API;
	changeStatus changeStatus;
	compliance compliance;

	@Override
	public void setUpforTest() {
		link = new GetDriver(driver);
		login = PageFactory.initElements(driver, login.class);
		new_case_intake = PageFactory.initElements(driver, create_new_case_intake.class);
		to_assign = PageFactory.initElements(driver, new_to_assign.class);
		to_approved = PageFactory.initElements(driver, assign_to_approved.class);
		to_complete = PageFactory.initElements(driver, approved_to_complete.class);
		search = PageFactory.initElements(driver, search_case.class);
		ass = PageFactory.initElements(driver, assign_provider.class);
		logout = PageFactory.initElements(driver, log_out.class);
		excel = new ExcelHelpers();
		getinfo = PageFactory.initElements(driver, getInfo.class);
		to_AFU = PageFactory.initElements(driver, approve_to_assign_follow_up.class);
		billing = PageFactory.initElements(driver, billing.class);
		fpc = PageFactory.initElements(driver, FPC_Approved.class);
		render = PageFactory.initElements(driver, render_name_medicare_ID.class);
		create_PSS = PageFactory.initElements(driver, create_PSS.class);
		sendback = PageFactory.initElements(driver, sendback.class);
		intake = PageFactory.initElements(driver, intake.class);
		doctor = PageFactory.initElements(driver, provider.class);
		pss = PageFactory.initElements(driver, pss.class);
		section = PageFactory.initElements(driver, Section.class);
		paInfor = PageFactory.initElements(driver, patientInformation.class);
		pcp = PageFactory.initElements(driver, PCP.class);
		testRes = PageFactory.initElements(driver, testRequirement.class);
		medHis = PageFactory.initElements(driver, medicalHistory.class);
		medication = PageFactory.initElements(driver, medication.class);
		famHis = PageFactory.initElements(driver, familyHistory.class);
		caseDetail = PageFactory.initElements(driver, caseDetail.class);
		API = PageFactory.initElements(driver, runAPI.class);
		changeStatus = PageFactory.initElements(driver, changeStatus.class);
		compliance = PageFactory.initElements(driver, compliance.class);

	}

	@Test
	public void testEle() throws Exception {
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		String vertical = excel.getCellData("vertical", 1);
		login.URL_TMS();
		login.intake("12345678");
		Common.waitSec(5);

		String id = excel.getCellData("id", 1);
		search.search_from_intake(id);
		Common.waitSec(5);

		section.openSection("Primary Care Provider");
		Common.waitSec(10);
		pcp.intakeSubmit(vertical);

	}
	@Test
	public void MG_PSS_dashboard() throws Exception {
		//login intake
		login.URL_TMS();
		Common.waitSec(5);
		login.intake("12345678");
		Common.waitSec(5);

		login.MG_dashboard();

		Common.waitSec(10);

		login.change_link_to_pss();
		Common.waitSec(10);

		logout.logout();


		login.pss("11111111");
		Common.waitSec(10);

		login.PSS_dashboard();
		Common.waitSec(10);

	}

	@Test
	public void PSS() throws Exception {
		login.URL_ADMIN();
		Common.waitSec(3);
		login.admin();
		Common.waitSec(3);


		for (int i = 200; i < 400; i++) {
			login.change_link_to_admin();
			Common.waitSec(5);
			String email = "testcall" + i + "@yopmail.com";
			String name = "Test call " + i;
			create_PSS.create_PSS(email, name);
		}
	}

	@Test
	public void new_case() throws Exception {
		//create new case
//		Actions action = new Actions(driver);
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		String business = excel.getCellData("business", 1);
		String vertical = excel.getCellData("vertical", 1);
		String MG = excel.getCellData("MG", 1);
		String lab = excel.getCellData("lab", 1);
		String type = excel.getCellData("type", 1);
		String first_name = "test " + render.firtname();
		String last_name = render.lastname();
		String DOB = excel.getCellData("DOB", 1);
		String medicare_ID = render.medicare_ID();
//		String zipcode = excel.getCellData("zipcode", 1);
		login.URL_TMS();
		login.intake("12345678");
		Common.waitSec(6);
		intake.create_case_genetics(business, vertical, MG, lab, type, first_name, last_name, DOB, medicare_ID);
		Common.waitSec(30);

	}

	@Test
	public void assign() throws Exception {
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		login.URL_TMS();
		login.pss("11111111");
		Common.waitSec(5);

		String id = excel.getCellData("id", 1);
		search.search_from_intake(id);
		Common.waitSec(5);

		pss.to_pending();
		Common.waitSec(60);
	}

	@Test
	public void to_RTS() throws Exception {
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		login.URL_TMS();
		login.provider("12345678");
		Common.waitSec(15);

		String id = excel.getCellData("id", 1);
		search.search_from_intake(id);
		Common.waitSec(5);


//		String lab = excel.getCellData("lab", 1);
//		String type = excel.getCellData("type", 1);
//		billing.billing();1
		Common.waitSec(10);

		doctor.to_RTS();
		Common.waitSec(3);

	}

	@Test
	public void to_Awaiting_Result() throws Exception {
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		login.URL_TMS();
		login.intake("12345678");
		Common.waitSec(15);

		String id = excel.getCellData("id", 1);
		search.search_from_intake(id);
		Common.waitSec(5);

		intake.to_Awating_Result();
		Common.waitSec(3);

	}

	@Test
	public void to_AFU() throws Exception {
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		login.URL_TMS();
		login.pss("11111111");
		Common.waitSec(5);

		String id = excel.getCellData("id", 1);
		search.search_from_intake(id);
		Common.waitSec(20);

		pss.to_AFU();
		Common.waitSec(5);
	}

	@Test
	public void to_approved3() throws Exception {
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		login.URL_TMS();
		login.provider("12345678");
		Common.waitSec(15);

		String id = excel.getCellData("id", 1);
		search.search_from_intake(id);
		Common.waitSec(5);

		doctor.to_approve3();
		Common.waitSec(5);
	}

	@Test
	public void to_completed() throws Exception {
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		login.URL_TMS();
		login.pss("11111111");
		Common.waitSec(5);

		String id = excel.getCellData("id", 1);
		search.search_from_intake(id);
		Common.waitSec(20);

		pss.complete();
		Common.waitSec(5);
	}

	@Test
	public void completeGeneticNoWellness() throws Exception {
		//create new case
		Actions action = new Actions(driver);
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		String business = excel.getCellData("business", 1);
		String vertical = excel.getCellData("vertical", 1);
		String MG = excel.getCellData("MG", 2);
		String lab = excel.getCellData("lab", 1);
		String type = excel.getCellData("type", 1);
		String first_name = "test GK " + render.firtname();
		String last_name = render.lastname();
		String DOB = excel.getCellData("DOB", 1);
//		String medicare_ID = render.medicare_ID();
		String medicare_ID = "8TR2FG1QT22";
//		String zipcode = excel.getCellData("zipcode", 1);
		login.URL_TMS();
		login.intake("12345678");
		Common.waitSec(6);
		intake.create_case_genetics(business, vertical, MG, lab, type, first_name, last_name, DOB, medicare_ID);

		String id = to_assign.find_id();
		excel.setCellData(id, 1, 0);
		System.out.println("Case-ID: " + id);

		Common.waitSec(10);
		if (search.compareStatus("Draft") ){
			action.sendKeys(Keys.ENTER).build().perform();
		}
		else {
			System.out.println("It is not Draft");
		}
		if (search.compareStatus("New (Not Yet Called)")) {
			System.out.println("------------------Done new case.-----------------------");
			excel.setCellData("Pass", 6, 3);
			excel.setCellData("Pass", 7, 3);
		}
		else {
			System.out.println("Status is "+ search.getStatus());
		}
		logout.intake();


		//to_assign
		login.pss("11111111");
		Common.waitSec(5);


		search.search_from_intake(id);
		Common.waitSec(5);

		pss.assignNoWellness();
		Common.waitSec(10);

		//input status result

		if (search.compareStatus("Pending (Not Yet Called)") ){
			action.sendKeys(Keys.ENTER).build().perform();
		}
		else {
			System.out.println("It is not Pending");
		}
		if (search.compareStatus("Assigned (Not Yet Called)")) {
			System.out.println("------------------Done Assigned.-----------------------");
			excel.setCellData("Pass", 8, 3);
			excel.setCellData("Pass", 9, 3);
		}
		else {
			System.out.println("Status is "+ search.getStatus());
		}

		logout.pss();

		//to RTS

		login.provider("12345678");
		Common.waitSec(10);

		search.search_from_intake(id);
		Common.waitSec(5);

		doctor.to_RTS();
		Common.waitSec(10);
		if (search.compareStatus("Ready To Send")) {
			System.out.println("Done Approved.");
			excel.setCellData("Pass", 10, 3);
		}
		else {
			System.out.println("Status is "+ search.getStatus());
		}

		logout.provider();


		//to AFU
		login.pss("11111111");
		Common.waitSec(10);

		search.search_from_intake(id);
		Common.waitSec(10);

		pss.to_AFU();
		Common.waitSec(5);

		if (search.compareStatus("Assigned Follow Up")) {
			System.out.println( "Done Upload result.");
			excel.setCellData("Pass", 11, 3);
			excel.setCellData("Pass", 12, 3);
			excel.setCellData("Pass", 13, 3);
		}
		else {
			System.out.println("Status is "+ search.getStatus());
		}

		logout.pss();

		//to Follow up
		login.provider("12345678");
		Common.waitSec(10);

		search.search_from_intake(id);
		Common.waitSec(10);


		doctor.to_approve3();

		Common.waitSec(5);

		if (search.compareStatus("Completed By Provider")) {
			System.out.println( "Done Case.");
			excel.setCellData("Pass", 14, 3);
		}
		else {
			System.out.println("Status is "+ search.getStatus());
		}

	}

	@Test
	public void denied() throws Exception {
		//create new case
		Actions action = new Actions(driver);
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		String business = excel.getCellData("business", 1);
		String vertical = excel.getCellData("vertical", 1);
		String MG = excel.getCellData("MG", 1);
		String lab = excel.getCellData("lab", 1);
		String type = excel.getCellData("type", 1);
		String first_name = "GKIM TEST" + render.firtname();
		String last_name = render.lastname();
		String DOB = excel.getCellData("DOB", 1);
//		String medicare_ID = render.medicare_ID();
		String medicare_ID = "9TK2FG1TT08";
//		String zipcode = excel.getCellData("zipcode", 1);
		login.URL_TMS();
		login.intake("12345678");
		Common.waitSec(5);
		intake.create_case_genetics(business, vertical, MG, lab, type, first_name, last_name, DOB, medicare_ID);


		String id = to_assign.find_id();
		excel.setCellData(id, 1, 0);
		System.out.println("Case-ID: " + id);
		Common.waitSec(10);

		if (search.compareStatus("Draft") ){
			action.sendKeys(Keys.ENTER).build().perform();

		}
		else {
			System.out.println("It is not Draft");
		}
		if (search.compareStatus("New (Not Yet Called)")) {
			System.out.println("Done new case.");
//			excel.setCellData("Pass", 7, 3);
			excel.setCellData("Pass", 17, 3);
		}
		else {
			System.out.println("Status is "+ search.getStatus());
		}
		logout.intake();


		//to_assign
		login.pss("11111111");
		Common.waitSec(5);


		search.search_from_intake(id);
		Common.waitSec(5);

		pss.assignNoWellness();
		Common.waitSec(5);
		if (search.compareStatus("Pending (Not Yet Called)") ){
			action.sendKeys(Keys.ENTER).build().perform();
//			Common.waitSec(10);
		}
		else {
			System.out.println("It is not Pending");
		}
		if (search.compareStatus("Assigned (Not Yet Called)")) {
			System.out.println( "Done Assigned.");
			excel.setCellData("Pass", 18, 3);
			excel.setCellData("Pass", 19, 3);
		}
		else {
			System.out.println("Status is "+ search.getStatus());
		}

		logout.pss();

		//to denied

		login.providerRPM("12345678");
		Common.waitSec(5);

		search.search_from_intake(id);
//		Common.waitSec(5);

		Common.waitSec(10);

		doctor.denied();
		Common.waitSec(10);
		if (search.compareStatus("Denial Approved")) {
			System.out.println( "Done Denied.");
			excel.setCellData("Pass", 20, 3);

		}
		else {
			System.out.println("Status is "+ search.getStatus());
		}
	}

	@Test
	public void cancel() throws Exception {
		//create new case
		Actions action = new Actions(driver);
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		String business = excel.getCellData("business", 1);
		String vertical = excel.getCellData("vertical", 1);
		String MG = excel.getCellData("MG", 1);
		String lab = excel.getCellData("lab", 1);
		String type = excel.getCellData("type", 1);
		String first_name = "GKIM TEST" + render.firtname();
		String last_name = render.lastname();
		String DOB = excel.getCellData("DOB", 1);
//		String medicare_ID = render.medicare_ID();
		String medicare_ID = "9TK2FG1TT08";
//		String zipcode = excel.getCellData("zipcode", 1);
		login.URL_TMS();
		login.intake("12345678");
		Common.waitSec(10);
		intake.create_case_genetics(business, vertical, MG, lab, type, first_name, last_name, DOB, medicare_ID);


		String id = to_assign.find_id();
		excel.setCellData(id, 1, 0);
		System.out.println("Case-ID: " + id);
		Common.waitSec(10);
		if (search.compareStatus("Draft") ){
			action.sendKeys(Keys.ENTER).build().perform();
		}
		else {
			System.out.println("It is not Draft");
		}
		if (search.compareStatus("New (Not Yet Called)")) {
			System.out.println( "Done new case.");
			excel.setCellData("Pass", 24, 3);
			excel.setCellData("Pass", 23, 3);
		}
		else {
			System.out.println("Status is "+ search.getStatus());
		}
		logout.intake();


		//to_assign
		login.pss("11111111");
		Common.waitSec(5);


		search.search_from_intake(id);
		Common.waitSec(5);

		pss.cancel_genetics();

		Common.waitSec(10);
		if (search.compareStatus("Cancelled")) {
			System.out.println( "Done Cancel.");
			excel.setCellData("Pass", 26, 3);
			excel.setCellData("Pass", 25, 3);
		}
		else {
			System.out.println("Status is "+ search.getStatus());
		}

	}

	@Test
	public void check_change_DOB() throws Exception {
		excel.setExcelFile("src/test/resources/case_dob_not_fix_20240124.xlsx", "Sheet1");
		login.URL_TMS();
		login.pss("11111111");
		Common.waitSec(10);
		search.pin();
		Common.waitSec(3);
		for (int i= 1; i<150; i++){
			String id = excel.getCellData("name", i);
			String check = excel.getCellData("state_alias",i);
			if(check.equals("INTAKE-DRAFT") || check.equals("INTAKE-FOR_CORRECTION")){
				excel.setCellData("1", i, 8);
			}
			else {
				search.search(id);
				String DOB = intake.get_DOB();
				excel.setCellData(DOB, i, 8);
			}
		}
	}
	@Test
	public void check_change_DOB_intake() throws Exception {
		excel.setExcelFile("src/test/resources/case_dob_not_fix_20240124.xlsx", "Sheet1");
		login.URL_TMS();
		login.intake("12345678");
		Common.waitSec(10);
		search.pin();
		Common.waitSec(3);
		for (int i= 1; i<140; i++){
			String id = excel.getCellData("name", i);
			String check = excel.getCellData("state_alias",i);
			if(check.equals("INTAKE-DRAFT") || check.equals("INTAKE-FOR_CORRECTION")){
				search.search(id);
				String DOB = intake.get_DOB();
				excel.setCellData(DOB, i, 7);
			}
		}
	}

	@Test
	public void newflow() throws Exception {
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		Actions action = new Actions(driver);
		String business = excel.getCellData("business", 1);
		String vertical = excel.getCellData("vertical", 1);
		String MG = excel.getCellData("MG", 1);
		String lab = excel.getCellData("lab", 1);
		String type = excel.getCellData("type", 1);

		//open the dashboard
		login.URL_TMS();
		//login intake
		login.intake("1234567878");
		//create case

		//set up case detail
		caseDetail.createCase(business, vertical, MG, lab, type);

		//input patient information
		paInfor.intakeSubmit(vertical);

		//pcp submit
		section.openSection("Primary Care Provider");
		pcp.intakeSubmit(vertical);

		//medical history submit
		section.openSection("Medical History");
		medHis.intakeSubmit(vertical);

		//medication
		section.openSection("Medication");
		medication.intakeSubmit(vertical);

		//family history submit
		section.openSection("Family History");
		famHis.intakeSubmit(vertical);

		//submit to new
		changeStatus.toNew();
		Common.waitSec(3);

		if (search.compareStatus("Draft") ){
			action.sendKeys(Keys.ENTER).build().perform();
		}
		else {
			System.out.println("It is not Draft");
		}
		if (search.compareStatus("New (Not Yet Called)")) {
			System.out.println("Done new case.");
			excel.setCellData("Pass", 7, 3);
			excel.setCellData("Pass", 8, 3);
		}
		else {
			System.out.println("Status is "+ search.getStatus());
		}

		String caseID = caseDetail.getCaseID();
		excel.setCellData(caseID, 1, 0);

		logout.intake();
		login.pss("1111111111");
		caseDetail.searchbyCaseID(caseID);

		compliance.pssSubmit(vertical);
		changeStatus.toAssigned();

		if (search.compareStatus("Pending (Not Yet Called)") ){
			action.sendKeys(Keys.ENTER).build().perform();
		}
		else {
			System.out.println("It is not Pending");
		}
		if (search.compareStatus("Assigned (Not Yet Called)")) {
			System.out.println("------------------Done Assigned.-----------------------");
			excel.setCellData("Pass", 9, 3);
			excel.setCellData("Pass", 10, 3);
		}
		else {
			System.out.println("Status is "+ search.getStatus());
		}
		logout.pss();
	}

	@Test
	public void completeGeneticsWithWellness() throws Exception {
		//create new case
		Actions action = new Actions(driver);
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		String business = excel.getCellData("business", 1);
		String vertical = excel.getCellData("vertical", 1);
		String MG = excel.getCellData("MG", 1);
		String lab = excel.getCellData("lab", 1);
		String type = excel.getCellData("type", 1);
		String first_name = "test GK " + render.firtname();
		String last_name = render.lastname();
		String DOB = excel.getCellData("DOB", 1);
//		String medicare_ID = render.medicare_ID();
		String medicare_ID = "8TR2FG1QT22";
//		String zipcode = excel.getCellData("zipcode", 1);
		login.URL_TMS();
		login.intake("12345678");
		Common.waitSec(6);
		intake.create_case_genetics(business, vertical, MG, lab, type, first_name, last_name, DOB, medicare_ID);

		String id = to_assign.find_id();
		excel.setCellData(id, 1, 0);
		System.out.println("Case-ID: " + id);

		Common.waitSec(10);
		if (search.compareStatus("Draft") ){
			action.sendKeys(Keys.ENTER).build().perform();
		}
		else {
			System.out.println("It is not Draft");
		}
		if (search.compareStatus("New (Not Yet Called)")) {
			System.out.println("------------------Done new case.-----------------------");
			excel.setCellData("Pass", 7, 3);
			excel.setCellData("Pass", 8, 3);
		}
		else {
			System.out.println("Status is "+ search.getStatus());
		}
		logout.intake();


		//to_assign
		login.pss("11111111");
		Common.waitSec(5);


		search.search_from_intake(id);
		Common.waitSec(5);

		pss.to_pending();
		Common.waitSec(10);
		//input status result

		if (search.compareStatus("Pending (Not Yet Called)") ){
			action.sendKeys(Keys.ENTER).build().perform();
		}
		else {
			System.out.println("It is not Pending");
		}
		if (search.compareStatus("Assigned (Not Yet Called)")) {
			System.out.println("------------------Done Assigned.-----------------------");
			excel.setCellData("Pass", 9, 3);
			excel.setCellData("Pass", 10, 3);
		}
		else {
			System.out.println("Status is "+ search.getStatus());
		}
		logout.pss();

		//to RTS

		login.provider("12345678");
		Common.waitSec(10);

		Common.waitSec(3);
		search.search_from_intake(id);
		Common.waitSec(5);

		doctor.complete_wellness();
		System.out.println("Waiting time config");
		Common.waitSec(60);
		System.out.println("Done waiting time config");

		//
		logout.provider();
		login.pss("11111111");
		Common.waitSec(5);

		//assign case again
		search.search_from_intake(id);
		Common.waitSec(5);
		pss.assignProvider();
		Common.waitSec(3);

		logout.pss();
		login.provider("12345678");
		Common.waitSec(5);
		search.search_from_intake(id);
		Common.waitSec(5);
		doctor.to_RTS();
		Common.waitSec(5);
		if (search.compareStatus("Ready To Send")) {
			System.out.println("------------------Done Approved.-----------------------");
			excel.setCellData("Pass", 11, 3);
		}
		else {
			System.out.println("Status is "+ search.getStatus());
		}

		logout.provider();


		//to AFU
		login.pss("11111111");
		Common.waitSec(10);

		search.search_from_intake(id);
		Common.waitSec(10);

		pss.to_AFU();
		Common.waitSec(5);

		if (search.compareStatus("Assigned Follow Up")) {
			System.out.println( "------------------Done Upload result.-----------------------");
			excel.setCellData("Pass", 14, 3);
			excel.setCellData("Pass", 12, 3);
			excel.setCellData("Pass", 13, 3);
		}
		else {
			System.out.println("Status is "+ search.getStatus());
		}

		logout.pss();

		//to Follow up
		login.provider("12345678");
		Common.waitSec(10);

		search.search_from_intake(id);
		Common.waitSec(10);


		doctor.to_approve3();

		Common.waitSec(5);

		if (search.compareStatus("Completed By Provider")) {
			System.out.println( "------------------Done Case.-----------------------");
			excel.setCellData("Pass", 15, 3);
		}
		else {
			System.out.println("Status is "+ search.getStatus());
		}


	}
	@Test
	public void deleteCase() throws Exception {
		Actions action = new Actions(driver);
		login.URL_ADMIN();
		login.admin();

		driver.findElement(By.id("searchbar")).sendKeys("9TK2FG1TT0", Keys.ENTER);
		Common.waitSec(5);
		try {
			driver.findElement(By.xpath("//*[@id=\"changelist-form\"]/div/div[2]/p/a[6]")).clear();
		}
		catch (Exception e) {}
		driver.findElement(By.id("action-toggle")).click();
		Common.waitSec(2);
		driver.findElement(By.name("action")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.DOWN, Keys.ENTER).build().perform();
		Common.waitSec(2);
		driver.findElement(By.name("index")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//*[@value=\"Yes, I’m sure\"]")).click();
		Common.waitSec(10);

	}

	@Test
	public void wellness() throws Exception {
//		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		login.URL_TMS();
		login.provider("12345678");
		Common.waitSec(5);
		search.search_from_intake("CA-2HTPM335");
		doctor.complete_wellness();
	}

	@Test
	public void getID() throws Exception {
		login.lobURL();
		login.lob();
		Common.waitSec(3);
		String fullname = "";
		login.changelinktoletter();
		String resultID = API.getResultID(fullname);
		System.out.println(resultID);
	}

	@Test
	public void completecase() {
		String id = "CA-V65T6WPS";
		login.URL_TMS();
		login.pss("11111111");
		Common.waitSec(3);
		search.search_from_intake(id);
		Common.waitSec(5);
//		pss.to_AFU();
		pss.completeOnboarding();
//		Common.waitSec(5);
//		login.changelinktoletter();
//		Common.waitSec(3);
//		login.lob();
//		Common.waitSec(3);
//		login.changelinktoletter();
//		String resultID = "ltr_1fdb400c5c95d0b7";
//		API.changeStatusResult(resultID);
	}

	@Test
	public void change_state() throws Exception {
		excel.setExcelFile("src/test/resources/UHLA_after.xlsx", "Sheet3");
		for(int i=1; i < 7738; i++)
		{
			String state = excel.getCellData("state_alias", i);
			System.out.println(i);
			System.out.println(state);
			if (state.equals("INTAKE-DRAFT")) {
				excel.setCellData("Draft",i, 4);
			}
			if (state.equals("PRECONSULT-INCOMPLETE")) {
				excel.setCellData("New",i, 4);
			}
			if (state.equals("PRECONSULT-COMPLETED")) {
				excel.setCellData("Pending",i, 4);
			}
			if (state.equals("CONSULT-INITIAL")) {
				excel.setCellData("Assigned",i, 4);
			}
			if (state.equals("FULFILL-READY_SENT_TO_LAB")) {
				excel.setCellData("Ready To Send",i, 4);
			}
			if (state.equals("FULFILL-SENT_TO_LAB")) {
				excel.setCellData("Awaiting Results",i, 4);
			}
			if (state.equals("FULFILL-RESULT_UPLOADED")) {
				excel.setCellData("Result Sending",i, 4);
			}
			if (state.equals("PRECONSULT-COMPLETED_FOLLOW_UP")) {
				excel.setCellData("Pending Results Follow Up",i, 4);
			}
			if (state.equals("CONSULT-INITIAL_FOLLOW_UP")) {
				excel.setCellData("Assigned Follow Up",i, 4);
			}
			if (state.equals("COMPLETED-BY_PROVIDER")) {
				excel.setCellData("Assigned Follow Up",i, 4);
			}
			if (state.equals("CANCELLED")) {
				excel.setCellData("Cancelled",i, 4);
			}
			if (state.equals("FULFILL-FOR_CORRECTION_READY_TO_SEND")) {
				excel.setCellData("For QC Correction",i, 4);
			}
			if (state.equals("INTAKE-FOR_CORRECTION")) {
				excel.setCellData("For Correction",i, 4);
			}
			if (state.equals("CONSULT-FOR_CORRECTION")) {
				excel.setCellData("For Provider Correction",i, 4);
			}
			if (state.equals("INTAKE-FOR_RECONNECTING")) {
				excel.setCellData("For Reconnecting",i, 4);
			}
			if (state.equals("REJECTED_ACCEPTED")) {
				excel.setCellData("Denial Approved",i, 4);
			}
		}
	}

	@Test
	public void checkdata() throws Exception {
		excel.setExcelFile("src/test/resources/RPM.xlsx", "Sheet7");
		for (int i = 1; i < 15000; i++) {
			String state = excel.getCellData("state_alias", i);
			String result = excel.getCellData("results_shiping_status", i);
			String id = excel.getCellData("name", i);
//
			if (result.equals("RECEIVED") && state.equals("COMPLETED-BY_PSS")) {
				excel.setCellData("true",i, 5);
			}

			if (result.equals("RECEIVED")) {
				if (state.equals("COMPLETED-BY_PSS")) {}
				else {
					System.out.println(id);
				}
			}

			if (result.equals("DELIVERING") || result.equals("PRINTING") || result.equals("RETURNING")) {
				if (state.equals("FULFILL-RESULT_UPLOADED")) {
					excel.setCellData("true",i, 5);
				}
			}

//			if (state.equals("FULFILL-RESULT_UPLOADED") || result.equals("")){
//				System.out.println(id);
//			}


		}
	}
	@Test
	public void test() throws Exception {
		excel.setExcelFile("src/test/resources/UHLA_after.xlsx", "Sheet1");
		for (int i = 1; i < 10000; i++) {
//			String state = excel.getCellData("results_shiping_status", i);
			String id = excel.getCellData("name", i);
			String state = excel.getCellData("state_alias", i);
			String result = excel.getCellData("results_shiping_status", i);
			if (result.equals("PRINTING")|| result.equals("DELIVERING")) {
				if (state.equals("FULFILL-SENT_TO_LAB")) {
					System.out.println(id);
				}
			}
		}
	}

	@Test
	public void testpdf() throws Exception {
		login.URL_TMS_STAG();
		login.pss("11111111");
		Common.waitSec(5);
		search.pin();
		Common.waitSec(3);
		List<String> caselist = Arrays.asList("CA-B931VXEL", "CA-QPV6QPQM", "CA-FNJBSFUQ");
		for (int i = 0; i < caselist.size(); i++) {
			search.search_openform(caselist.get(i));
			pss.downloadPDF();
			Common.waitSec(5);
		}
	}

	@Test
	public void login_logout() throws Exception {
		login.URL_TMS();
		login.provider("12345678");
		Common.waitSec(3);
		Common.waitSec(10);
		logout.provider();
		Common.waitSec(30);
	}

	@Test
	public void openWellness() throws Exception {
		login.URL_telehealth();
		login.providerRPM("12345678");
		Common.waitSec(5);
		search.searchWellness("PT-08409700");
		Common.waitSec(5);
		doctor.complete_wellness();

	}



}


