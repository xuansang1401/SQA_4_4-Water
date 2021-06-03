/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;

import dao.UsersDAO;
import dao.giaNuocCNDAO;
import entity.Users;
import entity.giaNuocCN;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Dell
 */
public class TestWaterEdit {

    WebDriver driver;

    public void initTest() {
        System.setProperty("webdriver.chrome.driver", "F:\\SQA\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    public void testEditWaterBase(String id, String luongNuoc, String donGia, String nam) {
        try {
            initTest();

            driver.get("http://localhost:8080/QuanLyNuoc/giaNuoc");
            System.out.println("test: " + driver.toString());
            WebElement addElement = driver.findElement(By.id("btn_edit_nuoc" + id));
            addElement.click();
            Thread.sleep(500);

            WebElement name = driver.findElement(By.id("luongNuoc_edit"));
            name.clear();
            Thread.sleep(300);
            name.sendKeys(luongNuoc);
            Thread.sleep(300);

            WebElement email = driver.findElement(By.id("dongia_edit"));
            email.clear();
            Thread.sleep(300);
            email.sendKeys(donGia);
            Thread.sleep(300);

            WebElement address = driver.findElement(By.id("namAD_edit"));
            address.clear();
            Thread.sleep(300);
            address.sendKeys(nam);
            Thread.sleep(300);

            WebElement btnsubmid = driver.findElement(By.id("btn_submit_edit"));
            btnsubmid.click();
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("test user: " + e);
            driver.close();
        }
    }

    @Test
    public void testGiaNuocEdit() {
        try {
            initTest();
            driver.get("http://localhost:8080/QuanLyNuoc/giaNuoc");
            String id = "28";
            System.out.println("test: " + driver.toString());
            WebElement addElement = driver.findElement(By.id("btn_edit_nuoc" + id));
            addElement.click();
            Thread.sleep(500);

            WebElement name = driver.findElement(By.id("luongNuoc_edit"));
            String nuovString = name.getAttribute("value");
            Thread.sleep(300);
            System.out.println("test: " + name.toString());

            WebElement email = driver.findElement(By.id("dongia_edit"));
            String gia = email.getAttribute("value");
            Thread.sleep(300);

            WebElement address = driver.findElement(By.id("namAD_edit"));
            String nam = address.getAttribute("value");
            Thread.sleep(300);

            String all = id + nuovString + gia + nam;
            giaNuocCNDAO instance = new giaNuocCNDAO();
            giaNuocCN u = instance.getGiaNuocById(id);

            String aa = u.getId() + u.getLuongNuoc() + u.getDonGia() + u.getNamApdung();
            Thread.sleep(300);
            assertEquals(all, aa);

            driver.close();
        } catch (Exception e) {
            System.out.println("test user: " + e);
            driver.close();
        }
    }

    @Test
    public void testEditWaterSucces() {
        try {
            testEditWaterBase("23","6nguoi/thang", "222", "2020");

            Thread.sleep(200);
            giaNuocCNDAO instance = new giaNuocCNDAO();

            giaNuocCN u = instance.getGiaNuocById("23");
            giaNuocCN u1 = new giaNuocCN(23,"6nguoi/thang", 222, 2020);

            System.out.println("sang: " + u + "; " + u1);
            Thread.sleep(500);
            assertEquals(u1.toString(), u.toString());
            driver.close();
        } catch (Exception e) {
            System.out.println("test user: " + e);
            driver.close();
        }
    }

    @Test
        public void testEditWaterNullLuongNuoc() {
        try {
            testEditWaterBase("23","", "222", "2020");

            WebElement name = driver.findElement(By.id("tv_luong_nuoc"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;", name);

            Thread.sleep(500);
            assertEquals(isRequired, true);
            driver.close();

        } catch (Exception e) {
            System.out.println("test user: " + e);
            driver.close();
        }
    }

    @Test
    public void testEditWaterNullDonGia() {
        try {
            testEditWaterBase("23","6nguoi/thang", "", "2020");
            WebElement name = driver.findElement(By.id("tv_don_gia"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;", name);

            Thread.sleep(500);
            assertEquals(isRequired, true);
            driver.close();

        } catch (Exception e) {
            System.out.println("test user: " + e);
            driver.close();
        }
    }

    @Test
    public void testEditWaterDonGiaNotNumber() {
        try {
             testEditWaterBase("23","6nguoi/thang", "dsdc", "2020");
            WebElement name = driver.findElement(By.id("tv_don_gia"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;", name);

            Thread.sleep(500);
            assertEquals(isRequired, true);
            driver.close();

        } catch (Exception e) {
            System.out.println("test user: " + e);
            driver.close();
        }
    }

    @Test
    public void testEditWaterDonGiaZero() {
        try {
           testEditWaterBase("23","6nguoi/thang", "0", "2020");
            WebElement name = driver.findElement(By.id("tv_don_gia"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;", name);

            Thread.sleep(500);
            assertEquals(isRequired, false);
            driver.close();

        } catch (Exception e) {
            System.out.println("test user: " + e);
            driver.close();
        }
    }

    @Test
    public void testEditWaterNullNam() {
        try {
            testEditWaterBase("23","6nguoi/thang", "222", "");

            WebElement name = driver.findElement(By.id("tv_nam"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;", name);

            Thread.sleep(500);
            assertEquals(isRequired, true);
            driver.close();

        } catch (Exception e) {
            System.out.println("test user: " + e);
            driver.close();
        }
    }

    @Test
    public void testEditWaterNamToDate() {
        try {
            testEditWaterBase("23","6nguoi/thang", "222", "222222");

            WebElement name = driver.findElement(By.id("tv_nam"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;", name);

            Thread.sleep(500);
            assertEquals(isRequired, false);
            driver.close();

        } catch (Exception e) {
            System.out.println("test user: " + e);
            driver.close();
        }
    }

    @Test
    public void testEditWaterNullNamNotNumber() {
        try {
            testEditWaterBase("23","6nguoi/thang", "222", "cscscc");

            WebElement name = driver.findElement(By.id("tv_nam"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;", name);

            Thread.sleep(500);
            assertEquals(isRequired, true);
            driver.close();

        } catch (Exception e) {
            System.out.println("test user: " + e);
            driver.close();
        }
    }
}
