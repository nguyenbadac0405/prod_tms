package com.scripts;

import com.frame.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Common;

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


	@Override
	public void setUpforTest() {
		link = new GetDriver(driver1);
		login = PageFactory.initElements(driver1, login.class);
		new_case_intake = PageFactory.initElements(driver1, create_new_case_intake.class);
		to_assign = PageFactory.initElements(driver1, new_to_assign.class);
		to_approved = PageFactory.initElements(driver1, assign_to_approved.class);
		to_complete = PageFactory.initElements(driver1, approved_to_complete.class);
		search = PageFactory.initElements(driver1, search_case.class);
		ass = PageFactory.initElements(driver1, assign_provider.class);
		logout = PageFactory.initElements(driver1, log_out.class);
		excel = new ExcelHelpers();
		getinfo = PageFactory.initElements(driver1, getInfo.class);
		to_AFU = PageFactory.initElements(driver1, approve_to_assign_follow_up.class);
		billing = PageFactory.initElements(driver1, billing.class);
		fpc = PageFactory.initElements(driver1, FPC_Approved.class);
		render = PageFactory.initElements(driver1, render_name_medicare_ID.class);
		create_PSS = PageFactory.initElements(driver1, create_PSS.class);
		sendback = PageFactory.initElements(driver1, sendback.class);
		intake = PageFactory.initElements(driver1, intake.class);
		doctor = PageFactory.initElements(driver1, provider.class);
		pss = PageFactory.initElements(driver1, pss.class);
		section = PageFactory.initElements(driver1, Section.class);
		paInfor = PageFactory.initElements(driver1, patientInformation.class);
		pcp = PageFactory.initElements(driver1, PCP.class);
		testRes = PageFactory.initElements(driver1, testRequirement.class);
		medHis = PageFactory.initElements(driver1, medicalHistory.class);
		medication = PageFactory.initElements(driver1, medication.class);
		famHis = PageFactory.initElements(driver1, familyHistory.class);
		caseDetail = PageFactory.initElements(driver1, caseDetail.class);

	}

	@Test
	public void testEle() throws Exception {
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		String vertical = excel.getCellData("vertical", 1);
		login.URL_TMS();
		login.intake("123456");
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
		login.intake("123456");
		Common.waitSec(5);

		login.MG_dashboard();

		Common.waitSec(10);

		login.change_link_to_pss();
		Common.waitSec(10);

		logout.logout();


		login.pss("111111");
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
//		Actions action = new Actions(driver1);
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
		login.intake("123456");
		Common.waitSec(6);
		intake.create_case_genetics(business, vertical, MG, lab, type, first_name, last_name, DOB, medicare_ID);
		Common.waitSec(30);

	}

	@Test
	public void assign() throws Exception {
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		login.URL_TMS();
		login.pss("111111");
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
		login.provider("123456");
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
		login.intake("123456");
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
		login.pss("111111");
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
		login.provider("123456");
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
		login.pss("111111");
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
		Actions action = new Actions(driver1);
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
		String medicare_ID = "6TR7FG7RT96";
//		String zipcode = excel.getCellData("zipcode", 1);
		login.URL_TMS();
		login.intake("123456");
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
		login.pss("111111");
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

		login.provider("123456");
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
		login.pss("111111");
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
		login.provider("123456");
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
		Actions action = new Actions(driver1);
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		String business = excel.getCellData("business", 1);
		String vertical = excel.getCellData("vertical", 1);
		String MG = excel.getCellData("MG", 1);
		String lab = excel.getCellData("lab", 1);
		String type = excel.getCellData("type", 1);
		String first_name = "test GK" + render.firtname();
		String last_name = render.lastname();
		String DOB = excel.getCellData("DOB", 1);
//		String medicare_ID = render.medicare_ID();
		String medicare_ID = "6TR7FG7RT92";
//		String zipcode = excel.getCellData("zipcode", 1);
		login.URL_TMS();
		login.intake("123456");
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
		login.pss("111111");
		Common.waitSec(5);


		search.search_from_intake(id);
		Common.waitSec(5);

		pss.to_pending();
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

		login.provider("123456");
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
		Actions action = new Actions(driver1);
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		String business = excel.getCellData("business", 1);
		String vertical = excel.getCellData("vertical", 1);
		String MG = excel.getCellData("MG", 1);
		String lab = excel.getCellData("lab", 1);
		String type = excel.getCellData("type", 1);
		String first_name = "test GK" + render.firtname();
		String last_name = render.lastname();
		String DOB = excel.getCellData("DOB", 1);
//		String medicare_ID = render.medicare_ID();
		String medicare_ID = "6TR7FG7RT93";
//		String zipcode = excel.getCellData("zipcode", 1);
		login.URL_TMS();
		login.intake("123456");
		Common.waitSec(10);
		intake.create_case_genetics(business, vertical, MG, lab, type, first_name, last_name, DOB, medicare_ID);


		String id = to_assign.find_id();
		excel.setCellData(id, 1, 0);
		System.out.println("Case-ID: " + id);
		Common.waitSec(30);
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
		login.pss("111111");
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
		login.pss("111111");
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
		login.intake("123456");
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
		Actions action = new Actions(driver1);
		String business = excel.getCellData("business", 1);
		String vertical = excel.getCellData("vertical", 1);
		String MG = excel.getCellData("MG", 1);
		String lab = excel.getCellData("lab", 1);
		String type = excel.getCellData("type", 1);

		//open the dashboard
		login.URL_TMS();
		//login intake
		login.intake("123456");
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


	}

	@Test
	public void completeGeneticsWithWellness() throws Exception {
		//create new case
		Actions action = new Actions(driver1);
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
		String medicare_ID = "6TR7FG7RT96";
//		String zipcode = excel.getCellData("zipcode", 1);
		login.URL_TMS();
		login.intake("123456");
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
		login.pss("111111");
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

		login.provider("123456");
		Common.waitSec(10);

//		search.pin();
		Common.waitSec(3);
		search.search_from_intake(id);
		Common.waitSec(5);

		doctor.complete_wellness();
		System.out.println("Waiting time config");
		Common.waitSec(60);
		System.out.println("Done waiting time config");

		//
		logout.provider();
		login.pss("111111");
		Common.waitSec(5);

		//assign case again
		search.search_from_intake(id);
		Common.waitSec(5);
		pss.assignProvider();
		Common.waitSec(3);

		logout.pss();
		login.provider("123456");
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
		login.pss("111111");
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
		login.provider("123456");
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
		Actions action = new Actions(driver1);
		login.URL_ADMIN();
		login.admin();

		driver1.findElement(By.id("searchbar")).sendKeys("8TR2FG1QT22", Keys.ENTER);
		Common.waitSec(5);
		driver1.findElement(By.id("action-toggle")).click();
		Common.waitSec(2);
		driver1.findElement(By.name("action")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.DOWN, Keys.ENTER).build().perform();
		Common.waitSec(2);
		driver1.findElement(By.name("index")).click();
		Common.waitSec(2);
		driver1.findElement(By.xpath(".//*[@value=\"Yes, I’m sure\"]")).click();
		Common.waitSec(10);

	}
}


