package com.frame;
import com.Common;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class runAPI {
    protected WebDriver driver;

    public runAPI(WebDriver driver) {
        this.driver = driver;
    }

    public void changeStatusResult(String resultID) {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {
            // URL của API
            String url = "https://dashboard.tms.partners/api/v1/ehealth/outbound-webhook/lob/";

            // Tạo request POST
            HttpPost httpPost = new HttpPost(url);

            // Thêm body cho request (dưới đây là JSON data)
            String jsonInputString = "{\n  \"event_type\": {\n    \"object\": \"event_type\",\n    \"id\": \"letter.delivered\",\n    \"enabled_for_test\": false,\n    \"resource\": \"letters\"\n  },\n  \"reference_id\": \"" +resultID+ "\",\n  \"date_created\": \"2024-06-14T15:28:26.784Z\",\n  \"object\": \"event\"\n}";
            System.out.println(jsonInputString);
            StringEntity stringEntity = new StringEntity(jsonInputString);
            httpPost.setEntity(stringEntity);

            // Thiết lập header cho request (nếu cần)
            httpPost.setHeader("Content-Type", "application/json");

            // Thực thi request
            CloseableHttpResponse response = httpClient.execute(httpPost);

            // Lấy response entity
            HttpEntity entity = response.getEntity();

            // In ra nội dung response
            if (entity != null) {
                System.out.println("check 1");
                System.out.println(EntityUtils.toString(entity));
            }

            // Đóng response
            response.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Đóng httpClient
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getResultID(String patientFullname) {
        try {
            driver.findElement(By.xpath("//button[contains(@class, \"absolute\")]")).click();
        }
        catch (Exception e) {}
        driver.findElement(By.xpath(".//span[text()='Live']")).click();
        Common.waitSec(2);
        driver.findElement(By.xpath(".//td[text()='"+patientFullname.toUpperCase()+"']")).click();
        Common.waitSec(3);
        driver.findElement(By.xpath(".//span[text()=\"Cancel Send\"]")).click();
        Common.waitSec(2);
        driver.findElement(By.xpath(".//span[text()=\"Confirm\"]")).click();
        Common.waitSec(3);

        WebElement result = driver.findElement(By.xpath(".//*[@class=\"ml-auto text-gray-600\"]"));
        String resultID = (String) result.getText();
        System.out.println(resultID);

        return resultID;
    }


}
