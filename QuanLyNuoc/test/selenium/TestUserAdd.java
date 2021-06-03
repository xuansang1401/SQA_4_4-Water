/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;

import dao.UsersDAO;
import entity.Users;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Dell
 */
public class TestUserAdd {

    WebDriver driver;

    public void initTest() {
        System.setProperty("webdriver.chrome.driver", "F:\\SQA\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    public void testAddUserBase(String aname, String aemail, String aaddress, String aphone,
            String anumber_water, String atotalMoney) {
        try {
            initTest();
            
            driver.get("http://localhost:8080/QuanLyNuoc/home");
            System.out.println("test: " + driver.toString());
            WebElement addElement = driver.findElement(By.id("btn_add"));
            addElement.click();

            Thread.sleep(500);
            WebElement name = driver.findElement(By.id("aname"));
            System.out.println("test: " + name);
            name.sendKeys(aname);
            Thread.sleep(300);
            System.out.println("test: " + name.toString());

            WebElement email = driver.findElement(By.id("aemail"));
            email.sendKeys(aemail);
            Thread.sleep(300);
            WebElement address = driver.findElement(By.id("aaddress"));
            address.sendKeys(aaddress);
            Thread.sleep(300);

            WebElement phone = driver.findElement(By.id("aphone"));
            phone.sendKeys(aphone);
            Thread.sleep(300);

            WebElement numberWater = driver.findElement(By.id("anumber_water"));
            numberWater.sendKeys(anumber_water);
            Thread.sleep(300);

            WebElement totalMoney = driver.findElement(By.id("atotalMoney"));
            totalMoney.sendKeys(atotalMoney);
            Thread.sleep(500);

            WebElement btnsubmid = driver.findElement(By.id("btn_add_submit"));
            btnsubmid.click();
            Thread.sleep(500);
            
          

        } catch (Exception e) {
            System.out.println("test user: " + e);
            driver.close();
        }
    }

    @Test
    public void testAddUserSucces() {
        try {
            initTest();
            driver.get("http://localhost:8080/QuanLyNuoc/home");
            System.out.println("test: " + driver.toString());
            WebElement addElement = driver.findElement(By.id("btn_add"));
            addElement.click();

            Thread.sleep(500);
            WebElement name = driver.findElement(By.id("aname"));
            System.out.println("test: " + name);
            name.sendKeys("Xuân Sang");
            Thread.sleep(300);
            System.out.println("test: " + name.toString());

            WebElement email = driver.findElement(By.id("aemail"));
            email.sendKeys("xs@gmail.com");
            Thread.sleep(300);
            WebElement address = driver.findElement(By.id("aaddress"));
            address.sendKeys("Hoai Duc");
            Thread.sleep(300);

            WebElement phone = driver.findElement(By.id("aphone"));
            phone.sendKeys("0762021466");
            Thread.sleep(300);

            WebElement numberWater = driver.findElement(By.id("anumber_water"));
            numberWater.sendKeys("101");
            Thread.sleep(300);

            WebElement totalMoney = driver.findElement(By.id("atotalMoney"));
            totalMoney.sendKeys("12000");
            Thread.sleep(500);

            WebElement btnsubmid = driver.findElement(By.id("btn_add_submit"));
            btnsubmid.click();
            Thread.sleep(1000);
            UsersDAO instance = new UsersDAO();
            Users u = instance.getUserIDMax();
            Users u1 = new Users(u.getId(), "Xuân Sang", "xs@gmail.com", "Hoai Duc", "0762021466", 101, 12000);
            assertEquals(u, u1);
            Thread.sleep(1000);
            driver.close();
        } catch (Exception e) {
            System.out.println("test user: " + e);
            driver.close();
        }
    }
    @Test
    public void testAddUserNullName() {
        try {
            testAddUserBase("", "xs@gmail.com", "Hoai Duc", "0762021466", "101", "12000");

            WebElement name = driver.findElement(By.id("aname"));
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
    public void testAddUserNullAddress() {
        try {
            testAddUserBase("Xuan Sang", "xs@gmail.com", "", "0762021466", "101", "12000");

            WebElement add = driver.findElement(By.id("aaddress"));
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
    public void testAddUserNullMail() {
        try {
            testAddUserBase("Xuan Sang", "", "Hoai Duc", "0762021466", "101", "12000");

            WebElement mail = driver.findElement(By.id("aemail"));
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
    public void testAddUserMailVatiable1() {
        try {
            testAddUserBase("Xuan Sang", "xs", "Hoai Duc", "0762021466", "101", "12000");

            WebElement name = driver.findElement(By.id("aemail"));
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
    public void testAddUserMailVatiable2() {
        try {
            testAddUserBase("Xuan Sang", "xs@dd", "Hoai Duc", "0762021466", "101", "12000");

            WebElement name = driver.findElement(By.id("aemail"));
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
    public void testAddUserNullPhone() {
        try {
            testAddUserBase("SSS", "xs@gmail.com", "Hoai Duc", "", "101", "12000");

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
    public void testAddUserPhoneNotNumber() {
        try {
            testAddUserBase("SSS", "xs@gmail.com", "Hoai Duc", "cccc", "101", "12000");

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
    public void testAddUserPhoneSize9() {
        try {
            testAddUserBase("SSS", "xs@gmail.com", "Hoai Duc", "11111", "101", "12000");

            WebElement phone = driver.findElement(By.id("aname"));
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
    public void testAddUserNullNumberWater() {
        try {
            testAddUserBase("ssss", "xs@gmail.com", "Hoai Duc", "0762021466", "", "12000");

            WebElement water = driver.findElement(By.id("anumber_water"));
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
    public void testAddUseNumberWaterNotNumber() {
        try {
            testAddUserBase("ssss", "xs@gmail.com", "Hoai Duc", "0762021466", "", "12000");

            WebElement water = driver.findElement(By.id("anumber_water"));
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
    public void testAddUseTotalMoneyNotNumber() {
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
