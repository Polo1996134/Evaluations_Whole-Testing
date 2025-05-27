
package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;

public class Registration extends BaseTest {

    @Test
    public void testRegistration() {
        // Navigate to the registration page
        driver.get("https://example.com/registration");

        // Fill in the registration form
        driver.findElement(By.name("name")).sendKeys("Sitara");
        driver.findElement(By.name("gender")).click();
        driver.findElement(By.name("dob")).sendKeys("01/01/2001");
        driver.findElement(By.name("email")).sendKeys("sitara@gmail.com");
        driver.findElement(By.name("phone")).sendKeys("1234567890");
        driver.findElement(By.name("password")).sendKeys("Password123");
        driver.findElement(By.name("confirmPassword")).sendKeys("Password123");

        // Submit the form
        driver.findElement(By.id("submit")).click();

        // Wait and verify success message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success")));

        Assert.assertTrue(successMsg.isDisplayed(), "Registration success message should be visible");
        Assert.assertTrue(successMsg.getText().contains("Registration successful"), "Expected text not found in success message.");
    }
}
