/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;

import dao.giaNuocCNDAO;
import entity.giaNuocCN;
import static org.junit.Assert.assertEquals;
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
public class DeleteWate {

    WebDriver driver;

    public void initTest() {
        System.setProperty("webdriver.chrome.driver", "F:\\SQA\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void testDeleteSub() {

        try {
            initTest();
            driver.get("http://localhost:8080/QuanLyNuoc/giaNuoc");
            String id = "27";
            WebElement delete = driver.findElement(By.id("btn_delewater" + id));
            delete.click();
            Thread.sleep(500);
            WebElement xao = driver.findElement(By.id("btnXoa"));
            xao.click();

            giaNuocCNDAO instance = new giaNuocCNDAO();

            giaNuocCN u = instance.getGiaNuocById(id);
            System.out.println(u);
            Thread.sleep(500);
            assertEquals(u.getId(), 0);

            driver.close();
        } catch (Exception e) {
            System.out.println("test user: " + e);
            driver.close();
        }
    }
    
  
}
