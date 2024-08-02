package com.scripts;

import com.Common;
import com.frame.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class RPM extends DriverFactory {
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

    provider provider;

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
        provider = PageFactory.initElements(driver1, provider.class);
        pss = PageFactory.initElements(driver1, pss.class);
    }


    @Test
    public void RPM_complete() throws Exception {
        excel.setExcelFile("src/test/resources/RPM.xlsx", "Sheet1");
        login.URL_telehealth();
        login.provider("123456");
        Common.waitSec(5);

        String id = excel.getCellData("id", 1);
        search.search_from_intake(id);
        Common.waitSec(5);

        to_complete.complete_wellness();
        Common.waitSec(3);

        billing.billing();
        Common.waitSec(3);
        to_complete.RPM_complete();
        Common.waitSec(3);

    }

    @Test
    public void RPM_cancel() throws Exception {
        Actions action = new Actions(driver1);
        excel.setExcelFile("src/test/resources/RPM.xlsx", "Sheet1");
        String business = excel.getCellData("business", 1);
        String vertical = excel.getCellData("vertical", 1);
        String MG = excel.getCellData("MG", 1);
        String lab = excel.getCellData("lab", 1);
        String type = excel.getCellData("type", 1);
//		String first_name = excel.getCellData("first_name", 1);
        String first_name = render.firtname();
//		String last_name = excel.getCellData("last_name", 1);
        String last_name = render.lastname();
        String DOB = excel.getCellData("DOB", 1);
//		String medicare_ID = excel.getCellData("medicare_ID", 1);
        String medicare_ID = render.medicare_ID();
        String zipcode = excel.getCellData("zipcode", 1);

        login.URL_telehealth();

        login.intake("123456");
        Common.waitSec(6);
        new_case_intake.RPM_create_new_case(business, vertical, MG, lab, type, first_name, last_name, DOB, medicare_ID, zipcode);
        Common.waitSec(3);

        String id = to_assign.find_id();
        excel.setCellData(id, 1, 0);
        System.out.println("Case-ID: " + id);

        logout.logout();
        login.pss("111111");
        Common.waitSec(5);

        search.search_from_intake(id);
        Common.waitSec(3);

        to_assign.RPM();
        Common.waitSec(5);

        logout.logout();
        login.provider("123456");
        Common.waitSec(3);

        search.search_from_intake(id);

        to_complete.complete_wellness();
        Common.waitSec(3);
        to_assign.RPM_cancel();

        Common.waitSec(5);

    }

    @Test
    public void RPM_denied() throws Exception {
        Actions action = new Actions(driver1);
        excel.setExcelFile("src/test/resources/RPM.xlsx", "Sheet1");
        String business = excel.getCellData("business", 1);
        String vertical = excel.getCellData("vertical", 1);
        String MG = excel.getCellData("MG", 1);
        String lab = excel.getCellData("lab", 1);
        String type = excel.getCellData("type", 1);
//		String first_name = excel.getCellData("first_name", 1);
        String first_name = render.firtname();
//		String last_name = excel.getCellData("last_name", 1);
        String last_name = render.lastname();
        String DOB = excel.getCellData("DOB", 1);
//		String medicare_ID = excel.getCellData("medicare_ID", 1);
        String medicare_ID = render.medicare_ID();
        String zipcode = excel.getCellData("zipcode", 1);

        login.URL_telehealth();

        login.intake("123456");
        Common.waitSec(6);
        new_case_intake.RPM_create_new_case(business, vertical, MG, lab, type, first_name, last_name, DOB, medicare_ID, zipcode);
        Common.waitSec(3);

        String id = to_assign.find_id();
        excel.setCellData(id, 1, 0);
        System.out.println("Case-ID: " + id);

        logout.logout();
        login.pss("111111");
        Common.waitSec(5);

        search.search_from_intake(id);
        Common.waitSec(3);

        to_assign.RPM();
        Common.waitSec(5);

        logout.logout();
        login.provider("123456");
        Common.waitSec(3);

        search.search_from_intake(id);

        to_complete.complete_wellness();
        Common.waitSec(3);

//        billing.billing();
        Common.waitSec(3);

        to_approved.RPM_denied();
        Common.waitSec(3);

    }

    @Test
    public void RPM() throws Exception {
        Actions action = new Actions(driver1);
        excel.setExcelFile("src/test/resources/RPM.xlsx", "Sheet1");
        String business = excel.getCellData("business", 1);
        String vertical = excel.getCellData("vertical", 1);
        String MG = excel.getCellData("MG", 1);
        String lab = excel.getCellData("lab", 1);
        String type = excel.getCellData("type", 1);
//		String first_name = excel.getCellData("first_name", 1);
        String first_name = render.firtname();
//		String last_name = excel.getCellData("last_name", 1);
        String last_name = render.lastname();
        String DOB = excel.getCellData("DOB", 1);
//		String medicare_ID = excel.getCellData("medicare_ID", 1);
        String medicare_ID = render.medicare_ID();
        String zipcode = excel.getCellData("zipcode", 1);

        login.URL_telehealth();

        login.intake("123456");
        Common.waitSec(6);
        new_case_intake.RPM_create_new_case(business, vertical, MG, lab, type, first_name, last_name, DOB, medicare_ID, zipcode);
        Common.waitSec(3);

        String id = to_assign.find_id();
        excel.setCellData(id, 1, 0);
        System.out.println("Case-ID: " + id);

        logout.logout();
        login.pss("111111");
        Common.waitSec(5);

        search.search_from_intake(id);
        Common.waitSec(3);

        to_assign.RPM();
        Common.waitSec(5);

        logout.logout();
        login.provider("123456");
        Common.waitSec(3);

        search.search_from_intake(id);

        to_complete.complete_wellness();
        Common.waitSec(3);

//        billing.billing();
        Common.waitSec(3);

        to_complete.RPM_complete();
        Common.waitSec(3);
    }

    @Test
    public void create_case() throws Exception {
        excel.setExcelFile("src/test/resources/RPM.xlsx", "Sheet1");
        String business = excel.getCellData("business", 1);
        String vertical = excel.getCellData("vertical", 1);

        String MG = excel.getCellData("MG", 1);
        String first_name = "test " + render.firtname();

        String last_name = render.lastname();
        String DOB = excel.getCellData("DOB", 1);
        String medicare_ID = render.medicare_ID();

        login.URL_telehealth();

        login.intake("123456");
        Common.waitSec(6);
        intake.create_RPM(business, vertical, MG, first_name, last_name, DOB, medicare_ID);
        Common.waitSec(30);
    }

    @Test
    public void assigned() throws Exception {
        excel.setExcelFile("src/test/resources/RPM.xlsx", "Sheet1");
        login.URL_telehealth();
        login.pss("111111");
        Common.waitSec(10);

        String id = excel.getCellData("id", 1);
        search.search_from_intake(id);
        Common.waitSec(11);

        pss.assign_RPM();
        Common.waitSec(10);


    }

    @Test
    public void to_complete() throws Exception {
        excel.setExcelFile("src/test/resources/RPM.xlsx", "Sheet1");
        login.URL_telehealth();
        login.provider("123456");
        Common.waitSec(15);

        String id = excel.getCellData("id", 1);
        search.search_from_intake(id);
        Common.waitSec(5);

        provider.complete_RPM();
        Common.waitSec(10);


    }

    @Test
    public void complete() throws Exception {
        excel.setExcelFile("src/test/resources/RPM.xlsx", "Sheet1");
        String business = excel.getCellData("business", 1);
        String vertical = excel.getCellData("vertical", 1);

        String MG = excel.getCellData("MG", 1);
        String first_name = "GK test " + render.firtname();

        String last_name = render.lastname();
        String DOB = excel.getCellData("DOB", 1);
//        String medicare_ID = render.medicare_ID();
        String medicare_ID = "6TR7FG7RT98";

        login.URL_TMS();

        login.intake("123456");
        Common.waitSec(6);
        intake.create_RPM(business, vertical, MG, first_name, last_name, DOB, medicare_ID);
        String id = to_assign.find_id();
        Common.waitSec(10);

        logout.intake();

        login.pss("111111");
        Common.waitSec(10);

        search.search_from_intake(id);
        Common.waitSec(11);

        pss.assign_RPM();
        Common.waitSec(10);

        logout.pss();
        Common.waitSec(10);

        login.provider("123456");
        Common.waitSec(10);

        search.search_from_intake(id);
        Common.waitSec(5);

        provider.complete_RPM();
        Common.waitSec(10);

    }

    @Test
    public void denied() throws Exception {
        excel.setExcelFile("src/test/resources/RPM.xlsx", "Sheet1");
        String business = excel.getCellData("business", 1);
        String vertical = excel.getCellData("vertical", 1);

        String MG = excel.getCellData("MG", 1);
        String first_name = "test " + render.firtname();

        String last_name = render.lastname();
        String DOB = excel.getCellData("DOB", 1);
//        String medicare_ID = render.medicare_ID();
        String medicare_ID = "6TR7FG7RT95";

        login.URL_telehealth();

        login.intake("123456");
        Common.waitSec(6);
        intake.create_RPM(business, vertical, MG, first_name, last_name, DOB, medicare_ID);
        String id = to_assign.find_id();
        Common.waitSec(10);

        logout.intake();

        login.pss("111111");
        Common.waitSec(10);

        search.search_from_intake(id);
        Common.waitSec(11);

        pss.assign_RPM();
        Common.waitSec(10);

        logout.pss();
        Common.waitSec(10);

        login.provider("123456");
        Common.waitSec(10);

        search.search_from_intake(id);
        Common.waitSec(5);

        provider.denied();
        Common.waitSec(10);

    }

    @Test
    public void cancel() throws Exception {
        excel.setExcelFile("src/test/resources/RPM.xlsx", "Sheet1");
        String business = excel.getCellData("business", 1);
        String vertical = excel.getCellData("vertical", 1);

        String MG = excel.getCellData("MG", 1);
        String first_name = "test " + render.firtname();

        String last_name = render.lastname();
        String DOB = excel.getCellData("DOB", 1);
//        String medicare_ID = render.medicare_ID();
        String medicare_ID = "6TR7FG7RT96";

        login.URL_telehealth();

        login.intake("123456");
        Common.waitSec(6);
        intake.create_RPM(business, vertical, MG, first_name, last_name, DOB, medicare_ID);
        String id = to_assign.find_id();
        Common.waitSec(10);

        logout.intake();

        login.pss("111111");
        Common.waitSec(10);

        search.search_from_intake(id);
        Common.waitSec(11);

        pss.cancel_RPM();
        Common.waitSec(10);
    }



}
