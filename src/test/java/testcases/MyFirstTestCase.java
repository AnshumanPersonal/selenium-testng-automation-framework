package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;


public class MyFirstTestCase extends BaseTest {
    
	@Test
	public void login() throws InterruptedException {
		System.out.println("Validate Login Functionality for zoho.com");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Wait for and click Sign In link
		WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(locatorprop.getProperty("login_SignIn"))));
		signIn.click();
		Thread.sleep(2000); // Wait for 2 seconds to ensure the page has loaded
		// Wait for the email input to be visible and enabled before typing
		WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorprop.getProperty("login_email"))));
		emailInput.clear();
		emailInput.sendKeys(prop1.getProperty("useremail"));
		Thread.sleep(2000); // Wait for 2 seconds to ensure the input is processed
		// Click next and wait for password field
		WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorprop.getProperty("loging_nextButton"))));
		nextBtn.click();
		Thread.sleep(2000); // Wait for 2 seconds to ensure the password field is loaded
		WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorprop.getProperty("login_password"))));
		passwordInput.sendKeys(prop1.getProperty("userpassword"));
		Thread.sleep(2000); // Wait for 2 seconds to ensure the input is processed
		WebElement finalNext = wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorprop.getProperty("loging_nextButton"))));
		finalNext.click();
		Thread.sleep(2000); // Wait for 2 seconds to ensure the login process is completed
	}

}
