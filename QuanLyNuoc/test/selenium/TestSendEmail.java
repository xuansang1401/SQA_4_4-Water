/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;

import dao.UsersDAO;
import entity.Users;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Dell
 */
public class TestSendEmail {

    WebDriver driver;

    public void initTest() {
        System.setProperty("webdriver.chrome.driver", "F:\\SQA\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void testCheckUserEmail() {
        try {
            String id = "37";
            initTest();
            driver.get("http://localhost:8080/QuanLyNuoc/email?id=" + id);
            UsersDAO udao = new UsersDAO();
            Users u = udao.getUserById(id);
            Thread.sleep(500);

            WebElement nameElement = driver.findElement(By.id("inputName"));
            String name = nameElement.getAttribute("value");
            Thread.sleep(300);

            WebElement phoneElement = driver.findElement(By.id("inputPhone"));
            String phone = phoneElement.getAttribute("value");
            Thread.sleep(300);

            WebElement emaElement = driver.findElement(By.id("inputEmail"));
            String email = emaElement.getAttribute("value");
            Thread.sleep(300);
            String web = (name + email + phone).toUpperCase();
            String data = (u.getName() + u.getEmail() + u.getPhone()).toUpperCase();
            System.out.println("test: " + web + ";  " + data);
            assertEquals(web, data);
        } catch (Exception e) {
            System.out.println("test user: " + e);
            driver.close();
        }
    }

    @Test
    public void testSendEmailSub() {
        try {
            String id = "37";
            initTest();
            driver.get("http://localhost:8080/QuanLyNuoc/email?id=" + id);

            WebElement nameElement = driver.findElement(By.id("inputMessage"));
            nameElement.sendKeys("Ngày hôm qua");
            Thread.sleep(300);
            WebElement senElement = driver.findElement(By.id("btn_send"));
            senElement.click();
            Thread.sleep(1000);

            WebElement text = driver.findElement(By.id("textSub"));
            String reString = text.getText();
            System.out.println(reString);
            assertEquals(reString, "You send email success!");
             Thread.sleep(300);
            driver.close();

        } catch (Exception e) {
            System.out.println("test fail: " + e);
            driver.close();
        }
    }
    @Test
    public void testSendEmailÍTextSendNull() {
        try {
            String id = "37";
            initTest();
            driver.get("http://localhost:8080/QuanLyNuoc/email?id=" + id);

            WebElement nameElement = driver.findElement(By.id("inputMessage"));
            nameElement.sendKeys("");
            Thread.sleep(300);
            WebElement senElement = driver.findElement(By.id("btn_send"));
            senElement.click();
            Thread.sleep(1000);

            WebElement text = driver.findElement(By.id("textSub"));
            String reString = text.getText();
            System.out.println(reString);
            assertEquals(reString, "");
             Thread.sleep(300);
            driver.close();

        } catch (Exception e) {
            System.out.println("test fail: " + e);
            driver.close();
        }
    }
}
