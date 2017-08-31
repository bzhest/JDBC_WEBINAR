package db;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by DWork on 31.08.2017.
 */
public class MySimpleTest {
    @Test
    public void test(){
        UsersController user = new UsersController();

        String testEmail = user.create();

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,30);
        driver.get("http://wordpress.ru/wp-login.php?loggedout=true");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user_login")));
        driver.findElement(By.id("user_login")).sendKeys(testEmail);
        driver.findElement(By.id("user_pass")).sendKeys("000");
        driver.findElement(By.id("wp-submit")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("meta-2")));

        Assert.assertTrue(driver.findElement(By.id("meta-2")).getText().contains("WordPress.org"));

        //////


        user.delete(testEmail);
        driver.quit();

        //close
    }
}
