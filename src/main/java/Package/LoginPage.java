package Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends PageBase
{
	WebDriverWait wait = new WebDriverWait(driver,30);

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void Login()	
	{
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.linkText("Log in")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
		driver.findElement(By.id("Email")).sendKeys("motsa@hotmail.com");
		driver.findElement(By.id("Password")).sendKeys("123456");
		//js.executeScript("scrollBy(0,500)");
		driver.findElement(By.cssSelector("button.button-1.login-button")).click();	
	}
	

}
