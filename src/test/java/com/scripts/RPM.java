package com.scripts;

import com.Common;
import com.frame.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class RPM extends DriverFactory {
    private static final Logger log = LoggerFactory.getLogger(RPM.class);
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
        provider = PageFactory.initElements(driver, provider.class);
        pss = PageFactory.initElements(driver, pss.class);
    }


    @Test
    public void RPM_complete() throws Exception {
        excel.setExcelFile("src/test/resources/RPM.xlsx", "Sheet1");
        login.URL_telehealth();
        login.provider("12345678");
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
        Actions action = new Actions(driver);
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

        login.intake("12345678");
        Common.waitSec(6);
        new_case_intake.RPM_create_new_case(business, vertical, MG, lab, type, first_name, last_name, DOB, medicare_ID, zipcode);
        Common.waitSec(3);

        String id = to_assign.find_id();
        excel.setCellData(id, 1, 0);
        System.out.println("Case-ID: " + id);

        logout.logout();
        login.pss("11111111");
        Common.waitSec(5);

        search.search_from_intake(id);
        Common.waitSec(3);

        to_assign.RPM();
        Common.waitSec(5);

        logout.logout();
        login.provider("12345678");
        Common.waitSec(3);

        search.search_from_intake(id);

        to_complete.complete_wellness();
        Common.waitSec(3);
        to_assign.RPM_cancel();

        Common.waitSec(5);

    }

    @Test
    public void RPM_denied() throws Exception {
        Actions action = new Actions(driver);
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

        login.intake("12345678");
        Common.waitSec(6);
        new_case_intake.RPM_create_new_case(business, vertical, MG, lab, type, first_name, last_name, DOB, medicare_ID, zipcode);
        Common.waitSec(3);

        String id = to_assign.find_id();
        excel.setCellData(id, 1, 0);
        System.out.println("Case-ID: " + id);

        logout.logout();
        login.pss("11111111");
        Common.waitSec(5);

        search.search_from_intake(id);
        Common.waitSec(3);

        to_assign.RPM();
        Common.waitSec(5);

        logout.logout();
        login.provider("12345678");
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
        Actions action = new Actions(driver);
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

        login.intake("12345678");
        Common.waitSec(6);
        new_case_intake.RPM_create_new_case(business, vertical, MG, lab, type, first_name, last_name, DOB, medicare_ID, zipcode);
        Common.waitSec(3);

        String id = to_assign.find_id();
        excel.setCellData(id, 1, 0);
        System.out.println("Case-ID: " + id);

        logout.logout();
        login.pss("11111111");
        Common.waitSec(5);

        search.search_from_intake(id);
        Common.waitSec(3);

        to_assign.RPM();
        Common.waitSec(5);

        logout.logout();
        login.provider("12345678");
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

        login.intake("12345678");
        Common.waitSec(6);
        intake.create_RPM(business, vertical, MG, first_name, last_name, DOB, medicare_ID);
        Common.waitSec(30);
    }

    @Test
    public void assigned() throws Exception {
        excel.setExcelFile("src/test/resources/RPM.xlsx", "Sheet1");
        login.URL_telehealth();
        login.pss("11111111");
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
        login.provider("12345678");
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
        String first_name = "GKIM TEST " + render.firtname();

        String last_name = render.lastname();
        String DOB = excel.getCellData("DOB", 1);
//        String medicare_ID = render.medicare_ID();
        String medicare_ID = "8TR2FG1QT22";

        login.URL_NEW_PROD();

        login.intake("12345678");
        Common.waitSec(6);
        intake.create_RPM(business, vertical, MG, first_name, last_name, DOB, medicare_ID);
        String id = to_assign.find_id();
        Common.waitSec(10);

        logout.intake();

        login.pss("11111111");
        Common.waitSec(10);

        search.search_from_intake(id);
        Common.waitSec(11);

        pss.assign_RPM();
        Common.waitSec(10);

        logout.pss();
        Common.waitSec(5);

        login.providerRPM("12345678");
        Common.waitSec(5);

        search.searchWellness(medicare_ID);
        Common.waitSec(5);


        provider.complete_wellnessRPM();
        Common.waitSec(5);

        logout.provider();
        login.providerRPM("12345678");
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
        String first_name = "GKIM TEST" + render.firtname();

        String last_name = render.lastname();
        String DOB = excel.getCellData("DOB", 1);
//        String medicare_ID = render.medicare_ID();
        String medicare_ID = "8TR2FG1QT22";

        login.URL_NEW_PROD();

        login.intake("12345678");
        Common.waitSec(6);
        intake.create_RPM(business, vertical, MG, first_name, last_name, DOB, medicare_ID);
        String id = to_assign.find_id();
        Common.waitSec(10);

        logout.intake();

        login.pss("11111111");
        Common.waitSec(10);

        search.search_from_intake(id);
        Common.waitSec(11);

        pss.assign_RPM();
        Common.waitSec(10);

        logout.pss();
        Common.waitSec(10);

        login.providerRPM("12345678");
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
        String first_name = "GKIM TEST " + render.firtname();

        String last_name = render.lastname();
        String DOB = excel.getCellData("DOB", 1);
//        String medicare_ID = render.medicare_ID();
        String medicare_ID = "8TR2FG1QT22";

        login.URL_NEW_PROD();

        login.intake("12345678");
        Common.waitSec(6);
        intake.create_RPM(business, vertical, MG, first_name, last_name, DOB, medicare_ID);
        String id = to_assign.find_id();
        Common.waitSec(10);

        logout.intake();

        login.pss("11111111");
        Common.waitSec(10);

        search.search_from_intake(id);
        Common.waitSec(11);

        pss.cancel_RPM();
        Common.waitSec(10);
    }

    @Test
    public void deleteCaseRPM() throws Exception {
        Actions action = new Actions(driver);
        login.URL_ADMIN();
        login.admin();

        driver.findElement(By.id("searchbar")).sendKeys("8TR2FG1QT2", Keys.ENTER);
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
    public void searchcaseRPM() throws Exception {
        Actions action = new Actions(driver);
        String medicare_ID = "PT-27027914";
        login.URL_NEW_PROD();
        login.provider("12345678");
        Common.waitSec(5);

        search.searchWellness(medicare_ID);
        Common.waitSec(3);

        provider.complete_wellness();
        Common.waitSec(3);

    }


}
