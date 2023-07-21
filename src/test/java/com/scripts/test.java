package com.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Common;
import com.frame.CreateExcelfile;
import com.frame.GetDriver;
import com.frame.create_new_case_intake;
import com.frame.login;

public class test {
	login login;
	create_new_case_intake new_case;
	WebDriver driver;
	GetDriver link;
	CreateExcelfile excel;

	
	@Test
	public void test1() {
		excel = PageFactory.initElements(driver, CreateExcelfile.class);
		excel.excel();
	}
}
