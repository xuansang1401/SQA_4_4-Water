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
public class TestWaterAdd {

    WebDriver driver;

    public void initTest() {
        System.setProperty("webdriver.chrome.driver", "F:\\SQA\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    public void testAddWaterBase(String luongNuoc, String donGia, String nam) {
        try {
            initTest();

            driver.get("http://localhost:8080/QuanLyNuoc/giaNuoc");
            System.out.println("test: " + driver.toString());
            WebElement addElement = driver.findElement(By.id("btn_add_gia_nuoc"));
            addElement.click();

            Thread.sleep(500);
            WebElement name = driver.findElement(By.id("tv_luong_nuoc"));

            name.sendKeys(luongNuoc);
            Thread.sleep(300);
            System.out.println("test: " + name.toString());

            WebElement email = driver.findElement(By.id("tv_don_gia"));
            email.sendKeys(donGia);
            Thread.sleep(300);

            WebElement address = driver.findElement(By.id("tv_nam"));
            address.sendKeys(nam);
            Thread.sleep(300);

            WebElement btnsubmid = driver.findElement(By.id("btn_add_nuoc_submit"));
            btnsubmid.click();
            Thread.sleep(500);

        } catch (Exception e) {
            System.out.println("test user: " + e);
            driver.close();
        }
    }

    @Test
    public void testAddWaterSucces() {
        try {
            testAddWaterBase("6nguoi", "12000", "2000");

            Thread.sleep(200);
            giaNuocCNDAO instance = new giaNuocCNDAO();

            giaNuocCN u = instance.getGiaNuocIDMax();
            giaNuocCN u1 = new giaNuocCN(u.getId(), "6nguoi", 12000, 2000);

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
    public void testAddWaterNullLuongNuoc() {
        try {
            testAddWaterBase("", "12000", "2000");

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
    public void testAddWaterNullDonGia() {
        try {
            testAddWaterBase("6nguoi", "", "2000");
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
    public void testAddWaterDonGiaNotNumber() {
        try {
            testAddWaterBase("6nguoi", "scs", "100");
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
    public void testAddWaterDonGiaZero() {
        try {
            testAddWaterBase("6nguoi", "0", "100");
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
    public void testAddWaterNullNam() {
        try {
            testAddWaterBase("6nguoi", "12000", "");

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
    public void testAddWaterNamToDate() {
        try {
            testAddWaterBase("6nguoi", "12000", "10000");

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
    public void testAddWaterNullNamNotNumber() {
        try {
            testAddWaterBase("6nguoi", "12000", "sc");

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
