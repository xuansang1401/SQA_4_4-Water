/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;

import dao.UsersDAO;
import entity.Users;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Dell
 */
public class TestUserEdit {

    WebDriver driver;

    public void initTest() {
        System.setProperty("webdriver.chrome.driver", "F:\\SQA\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    public void testEditUserBase(String id, String aname, String aemail, String aaddress, String aphone,
            String anumber_water, String atotalMoney) {
        try {
            initTest();
            driver.get("http://localhost:8080/QuanLyNuoc/home");

            WebElement addElement = driver.findElement(By.id("bnt_edit" + id));
            addElement.click();
            Thread.sleep(1000);

            WebElement name = driver.findElement(By.id("name_edit"));
            name.clear();
            Thread.sleep(300);
            name.sendKeys(aname);
            Thread.sleep(300);

            WebElement email = driver.findElement(By.id("email_edit"));
            email.clear();
            Thread.sleep(300);
            email.sendKeys(aemail);
            Thread.sleep(300);

            WebElement address = driver.findElement(By.id("address_edit"));
            address.clear();
            Thread.sleep(300);
            address.sendKeys(aaddress);
            Thread.sleep(300);

            WebElement phone = driver.findElement(By.id("phone_edit"));
            phone.clear();
            Thread.sleep(300);
            phone.sendKeys(aphone);
            Thread.sleep(300);

            WebElement numberWater = driver.findElement(By.id("number_edit"));
            numberWater.clear();
            Thread.sleep(300);
            numberWater.sendKeys(anumber_water);
            Thread.sleep(300);

            WebElement totalMoney = driver.findElement(By.id("total_edit"));
            totalMoney.clear();
            Thread.sleep(300);
            totalMoney.sendKeys(atotalMoney);
            Thread.sleep(500);

            WebElement btnSubmid = driver.findElement(By.id("bnt_edit_submit"));
            System.out.println("sang: " + btnSubmid);
            btnSubmid.click();
            Thread.sleep(500);

//            assertEquals(u, u1);
//            Thread.sleep(1000);
//            driver.close();
        } catch (Exception e) {
            System.out.println("test user: " + e);

        }
    }
//
    @Test
    public void testEditUserSub() {
        try {
            testEditUserBase("19","Hoai", "xs@gmail.com", "Hoai Duc", "1402", "101", "1000");

            UsersDAO instance = new UsersDAO();
            Users u = instance.getUserById("19");
            Users u1 = new Users("19","Hoai", "xs@gmail.com", "Hoai Duc", "1402", 101, 1000);
            Thread.sleep(500);
            assertEquals(u, u1);
           
            driver.close();

        } catch (Exception e) {
            System.out.println("test user: " + e);
//            driver.close();
        }
    }

    @Test
    public void testEditUserNullName() {
        try {
            testEditUserBase("19", "", "xs@gmail.com", "Hoai Duc", "1402", "101", "1000");

            WebElement name = driver.findElement(By.id("name_edit"));
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
    public void testEditUserNullAddress() {
        try {
            testEditUserBase("19", "Xuan Sang", "xs@gmail.com", "", "0762021466", "101", "12000");

            WebElement add = driver.findElement(By.id("address_edit"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;", add);

            Thread.sleep(500);
            assertEquals(isRequired, true);
            driver.close();

        } catch (Exception e) {
            System.out.println("test user: " + e);
            driver.close();
        }
    }

    @Test
    public void testEditUserNullMail() {
        try {
            testEditUserBase("19", "Xuan Sang", "", "Hoai Duc", "0762021466", "101", "12000");

            WebElement mail = driver.findElement(By.id("email_edit"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;", mail);

            Thread.sleep(500);
            assertEquals(isRequired, true);
            driver.close();

        } catch (Exception e) {
            System.out.println("test user: " + e);
            driver.close();
        }
    }

//    @Test
    public void testEditUserMailVatiable1() {
        try {
            testEditUserBase("19", "Xuan Sang", "xs", "Hoai Duc", "0762021466", "101", "12000");

            WebElement name = driver.findElement(By.id("email_edit"));
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
    public void testEditUserMailVatiable2() {
        try {
            testEditUserBase("19", "Xuan Sang", "xs@dd", "Hoai Duc", "0762021466", "101", "12000");

            WebElement name = driver.findElement(By.id("email_edit"));
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
    public void testEditUserNullPhone() {
        try {
            testEditUserBase("19", "SSS", "xs@gmail.com", "Hoai Duc", "", "101", "12000");

            WebElement phone = driver.findElement(By.id("phone_edit"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;", phone);

            Thread.sleep(500);
            assertEquals(isRequired, true);
            driver.close();

        } catch (Exception e) {
            System.out.println("test user: " + e);
            driver.close();
        }
    }

    @Test
    public void testEditUserPhoneNotNumber() {
        try {
            testEditUserBase("19", "SSS", "xs@gmail.com", "Hoai Duc", "cccc", "101", "12000");

            WebElement phone = driver.findElement(By.id("aphone"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;", phone);

            Thread.sleep(500);
            assertEquals(isRequired, true);
            driver.close();

        } catch (Exception e) {
            System.out.println("test user: " + e);
            driver.close();
        }
    }

     @Test
    public void testEditUserPhoneSize9() {
        try {
            testEditUserBase("17","SSS", "xs@gmail.com", "Hoai Duc", "11111", "101", "12000");

            WebElement phone = driver.findElement(By.id("phone_edit"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;", phone);

            Thread.sleep(500);
            assertEquals(isRequired, false);
            driver.close();

        } catch (Exception e) {
            System.out.println("test user: " + e);
            driver.close();
        }
    }
    @Test
    public void testEditUserNullNumberWater() {
        try {
            testEditUserBase("19", "ssss", "xs@gmail.com", "Hoai Duc", "0762021466", "", "12000");

            WebElement water = driver.findElement(By.id("number_edit"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;", water);

            Thread.sleep(500);
            assertEquals(isRequired, true);
            driver.close();

        } catch (Exception e) {
            System.out.println("test user: " + e);
            driver.close();
        }
    }

    @Test
    public void testEditUseNumberWaterNotNumber() {
        try {
            testEditUserBase("19", "ssss", "xs@gmail.com", "Hoai Duc", "0762021466", "", "12000");

            WebElement water = driver.findElement(By.id("number_edit"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;", water);

            Thread.sleep(500);
            assertEquals(isRequired, true);
            driver.close();

        } catch (Exception e) {
            System.out.println("test user: " + e);
            driver.close();
        }
    }

    @Test
    public void testEditUseTotalMoneyNotNumber() {
        try {
            // DO chua tinsh dducowj Money
            assertTrue(false);
            driver.close();

        } catch (Exception e) {
            System.out.println("test user: " + e);
            driver.close();
        }
    }

   

}
