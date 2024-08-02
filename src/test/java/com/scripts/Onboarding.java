package com.scripts;

import com.Common;
import com.frame.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Onboarding extends DriverFactory {
    com.frame.login login;
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
        API = PageFactory.initElements(driver1, runAPI.class);

    }

    @Test
    public void complete() throws Exception {
        //create new case
        Actions action = new Actions(driver1);
        excel.setExcelFile("src/test/resources/Onboarding.xlsx", "Sheet1");
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
        login.intake("123456");
        Common.waitSec(6);
        intake.createOnboarding(business, vertical, MG, lab, type, first_name, last_name, DOB, medicare_ID);

        String id = to_assign.find_id();
//        List<String> patientName = to_assign.findName();
//        String patientID = patientName.get(1);
        excel.setCellData(id, 1, 0);
//        excel.setCellData(patientID, 2, 0);
        System.out.println("Case-ID: " + id);
//        System.out.println("Patient-ID: " + patientID);

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
            excel.setCellData("Pass", 8, 3);
        }
        else {
            System.out.println("Status is "+ search.getStatus());
        }

        logout.pss();

        //to RTS

        login.provider("123456");
        Common.waitSec(5);

        Common.waitSec(3);
        search.search_from_intake(id);
        Common.waitSec(5);

        doctor.complete_wellness();
        System.out.println("Waiting time config");
        Common.waitSec(60);
        System.out.println("Done waiting time config");
        Common.waitSec(5);
        logout.provider();
        Common.waitSec(3);
        login.pss("111111");
        Common.waitSec(5);
        search.search_from_intake(id);
        Common.waitSec(5);
        pss.assignProvider();
        Common.waitSec(5);
        logout.pss();
        Common.waitSec(5);
        login.provider("123456");
        Common.waitSec(5);
        search.search_from_intake(id);
        Common.waitSec(5);
        doctor.to_RTS();
        Common.waitSec(5);


        if (search.compareStatus("Ready to send")) {
            System.out.println("Done Approved");
            excel.setCellData("Pass", 10, 3);
        }
        else {
            System.out.println("Status is "+ search.getStatus());
        }

        logout.provider();

        login.pss("111111");
        Common.waitSec(5);
        search.search_from_intake(id);
        Common.waitSec(5);
        pss.completeOnboarding();

        //get result ID
        login.changelinktoletter();
		Common.waitSec(5);
		login.lob();
		Common.waitSec(5);
		login.changelinktoletter();
        Common.waitSec(10);
        String resultID = API.getResultID();
        API.changeStatusResult(resultID);

        login.change_link_to_pss();
        Common.waitSec(5);
        search.searchCounseling(medicare_ID);
        Common.waitSec(3);

        pss.assignProvider();
        Common.waitSec(5);

        logout.pss();
        Common.waitSec(5);
        login.provider("123456");
        Common.waitSec(5);
        search.searchCounseling(medicare_ID);
        Common.waitSec(5);
        doctor.approvedCounseling();
        Common.waitSec(10);

    }

    @Test
    public void test() throws Exception {
        String id = "6TR7FG7RT34";
        login.URL_TMS();
        login.pss("11111111");
        Common.waitSec(5);
        search.searchCounseling(id);
        Common.waitSec(5);
    }

}
