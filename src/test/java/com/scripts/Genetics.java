package com.scripts;

import com.frame.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Common;

import java.awt.image.ColorModel;
import java.io.PrintStream;

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
	}

	@Test
	public void MG_PSS_dashboard() throws Exception {
		//login intake
		login.URL_intake();
		Common.waitSec(5);
		login.intake("123456");
		Common.waitSec(5);

		login.MG_dashboard();

		Common.waitSec(10);

		login.change_link_to_pss();
		Common.waitSec(10);

		logout.logout();
		Common.waitSec(5);

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
		Actions action = new Actions(driver1);
		excel.setExcelFile("src/test/resources/RPM.xlsx", "Sheet1");
		String business = excel.getCellData("business", 1);
		String vertical = excel.getCellData("vertical", 1);
		String MG = excel.getCellData("MG", 1);
		String lab = excel.getCellData("lab", 1);
		String type = excel.getCellData("type", 1);
		String first_name = "test " + render.firtname();
		String last_name = render.lastname();
		String DOB = excel.getCellData("DOB", 1);
		String medicare_ID = render.medicare_ID();
		String zipcode = excel.getCellData("zipcode", 1);
		login.URL_intake();
		login.intake("123456");
		Common.waitSec(6);
		intake.create_RPM(business, vertical, MG, first_name, last_name, DOB, medicare_ID);
		Common.waitSec(30);

	}

	@Test
	public void assign() throws Exception {
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		login.URL_intake();
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
		login.URL_intake();
		login.provider("123456");
		Common.waitSec(5);

		String id = excel.getCellData("id", 1);
		search.search_from_intake(id);
		Common.waitSec(5);


		String lab = excel.getCellData("lab", 1);
		String type = excel.getCellData("type", 1);
//		billing.billing();
		Common.waitSec(30);

		doctor.to_RTS();
		Common.waitSec(3);

	}

	@Test
	public void to_Awaiting_Result() throws Exception {
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		login.URL_intake();
		login.intake("123456");
		Common.waitSec(5);

		String id = excel.getCellData("id", 1);
		search.search_from_intake(id);
		Common.waitSec(20);

		intake.to_Awating_Result();
		Common.waitSec(3);

	}

	@Test
	public void to_AFU() throws Exception {
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		login.URL_intake();
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
		login.URL_intake();
		login.provider("123456");
		Common.waitSec(5);

		String id = excel.getCellData("id", 1);
		search.search_from_intake(id);
		Common.waitSec(20);

		doctor.to_approve3();
		Common.waitSec(5);
	}

	@Test
	public void to_completed() throws Exception {
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		login.URL_intake();
		login.pss("111111");
		Common.waitSec(5);

		String id = excel.getCellData("id", 1);
		search.search_from_intake(id);
		Common.waitSec(20);

		pss.complete();
		Common.waitSec(5);
	}

	@Test
	public void complete() throws Exception {
		//create new case
		Actions action = new Actions(driver1);
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
		String zipcode = excel.getCellData("zipcode", 1);
		login.URL_intake();
		login.intake("123456");
		Common.waitSec(6);
		intake.create_RPM(business, vertical, MG, first_name, last_name, DOB, medicare_ID);


		String id = to_assign.find_id();
		excel.setCellData(id, 1, 0);
		System.out.println("Case-ID: " + id);
		Common.waitSec(30);
		logout.logout();
		Common.waitSec(30);


		//to_assign
		login.pss("111111");
		Common.waitSec(5);


		search.search_from_intake(id);
		Common.waitSec(5);

		pss.to_pending();
		Common.waitSec(60);

		logout.logout();

		//to RTS

		login.provider("123456");
		Common.waitSec(5);

		search.search_from_intake(id);
		Common.waitSec(5);

		Common.waitSec(30);

		doctor.to_RTS();
		Common.waitSec(3);

		logout.logout();

		//to AWR
		login.intake("123456");
		Common.waitSec(5);

		search.search_from_intake(id);
		Common.waitSec(10);

		intake.to_Awating_Result();
		System.out.println("check");
		Common.waitSec(3);

		logout.logout();

		//to AFU
		login.pss("111111");
		Common.waitSec(5);

		search.search_from_intake(id);
		Common.waitSec(20);

		pss.to_AFU();
		Common.waitSec(5);

		logout.logout();

		//to Follow up
		login.provider("123456");
		Common.waitSec(5);

		search.search_from_intake(id);
		Common.waitSec(20);

		doctor.to_approve3();
		Common.waitSec(5);

		logout.logout();

		//completed
		login.pss("111111");
		Common.waitSec(5);

		search.search_from_intake(id);
		Common.waitSec(20);

		pss.complete();
		Common.waitSec(5);

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
		String first_name = "test " + render.firtname();
		String last_name = render.lastname();
		String DOB = excel.getCellData("DOB", 1);
		String medicare_ID = render.medicare_ID();
		String zipcode = excel.getCellData("zipcode", 1);
		login.URL_intake();
		login.intake("123456");
		Common.waitSec(6);
//		intake.create_case(business, vertical, MG, lab, type, first_name, last_name, DOB, medicare_ID);


		String id = to_assign.find_id();
		excel.setCellData(id, 1, 0);
		System.out.println("Case-ID: " + id);
		Common.waitSec(30);
		logout.logout();
		Common.waitSec(30);


		//to_assign
		login.pss("111111");
		Common.waitSec(5);


		search.search_from_intake(id);
		Common.waitSec(5);

		pss.to_pending();
		Common.waitSec(60);

		logout.logout();

		//to denied

		login.provider("123456");
		Common.waitSec(5);

		search.search_from_intake(id);
		Common.waitSec(5);

		Common.waitSec(30);

		doctor.denied_genetics();
		Common.waitSec(3);
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
		String first_name = "test " + render.firtname();
		String last_name = render.lastname();
		String DOB = excel.getCellData("DOB", 1);
		String medicare_ID = render.medicare_ID();
		String zipcode = excel.getCellData("zipcode", 1);
		login.URL_intake();
		login.intake("123456");
		Common.waitSec(6);
		intake.create_case_genetics(business, vertical, MG, lab, type, first_name, last_name, DOB, medicare_ID);


		String id = to_assign.find_id();
		excel.setCellData(id, 1, 0);
		System.out.println("Case-ID: " + id);
		Common.waitSec(30);
		logout.logout();
		Common.waitSec(30);


		//to_assign
		login.pss("111111");
		Common.waitSec(5);


		search.search_from_intake(id);
		Common.waitSec(5);

		pss.cancel();
		Common.waitSec(10);
	}


}
