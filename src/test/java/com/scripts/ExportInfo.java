package com.scripts;

import com.frame.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ExportInfo extends DriverFactory {
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
		
	}
	
	@Test
	public void exportInfo() throws Exception {
		String[] info = getinfo.get_Info_MDR();
		excel.setCellData(info[0], 1, 2);
		excel.setCellData(info[1], 1, 3);
		excel.setCellData(info[2], 1, 4);
		excel.setCellData(info[3], 1, 5);
		excel.setCellData(info[4], 1, 6);
		excel.setCellData(info[5], 1, 7);
		excel.setCellData(info[6], 1, 8);
	}
}
