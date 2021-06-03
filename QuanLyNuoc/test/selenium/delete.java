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
public class delete {
     WebDriver driver;

    public void initTest() {
        System.setProperty("webdriver.chrome.driver", "F:\\SQA\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

    }

     @Test
    public void testDeleteUser() {
        try {
//         bnt_dele$
            initTest();
            driver.get("http://localhost:8080/QuanLyNuoc/home");

            String id= "21";
            WebElement deElement = driver.findElement(By.id("bnt_dele" + id));
            deElement.click();
            Thread.sleep(500);
            
             WebElement deleteElement = driver.findElement(By.id("btnXoa"));
            deleteElement.click();
            Thread.sleep(2000);
            
            UsersDAO udao=new UsersDAO();
            Users u=udao.getUserById(id);
         
            System.out.println("sc: "+ u);
            assertEquals(u.getId(), null);
            driver.close();
        } catch (Exception e) {
            System.out.println("test user: " + e);
            driver.close();
        }
    }
    
     @Test
    public void testCaneDeleteUser() {
        try {
//         bnt_dele$
            initTest();
            driver.get("http://localhost:8080/QuanLyNuoc/home");

            String id= "1039";
            WebElement deElement = driver.findElement(By.id("bnt_dele" + id));
            deElement.click();
            Thread.sleep(500);
            
             WebElement deleteElement = driver.findElement(By.id("btn_cane_dele"));
            deleteElement.click();
            Thread.sleep(200);
            
            UsersDAO udao=new UsersDAO();
            Users u=udao.getUserById(id);
         
            Thread.sleep(500);
            System.out.println("sc: "+ u);
            assertEquals(u.getId(), id);
        } catch (Exception e) {
            System.out.println("test user: " + e);
            driver.close();
        }
    }
}
