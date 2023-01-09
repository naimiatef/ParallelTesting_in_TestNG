package Locators;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import DriverPackage.MainDriver;

public class LoginPage extends MainDriver {
	// By MainLogin_ID = By.id("tp-signup-action");
	By MainLogin_ID = By.xpath("//a[normalize-space()='Login']");

	By email_ID = By.id("username");

	By password_ID = By.id("password");

	By loginbutton_ID = By.id("tp-sign-in");

	By errormessage_ID = By.id("tp-message-error");
	
	
	
    public WebElement ClickMainLoginButton() {
	return driver.findElement(MainLogin_ID);

	}

	public WebElement Enteremail() {
		Set<String> windowhandles = driver.getWindowHandles();
        Iterator<String>  iterator = windowhandles.iterator();
		String parentwindow= iterator.next();
		String childwindow=iterator.next();
		driver.switchTo().window(childwindow);
		/*
		 * for return a page principal
		 * driver.switchTo().window(parentwindow);	
		 * 
		 */
		
		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 5);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(email_ID));
		//for return a principal page
		
	}
	
	public void Multiplewindows ()
	{
		
	}

	public WebElement Enterpassword() {

		return driver.findElement(password_ID);
	}

	public WebElement ClickLogin_inpopup() {
		return driver.findElement(loginbutton_ID);

	}

	public String ActualErrorMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 7);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(errormessage_ID)).getText();
	}
}
