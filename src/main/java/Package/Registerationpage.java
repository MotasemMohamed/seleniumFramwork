package Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registerationpage extends PageBase{

	public Registerationpage(WebDriver driver) {
		super(driver);
	}
	public void Registeration(String Firstname , String Lastname , String Email , String Password)
	{
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName")));
		driver.findElement(By.id("FirstName")).sendKeys(Firstname);
		driver.findElement(By.id("LastName")).sendKeys(Lastname);
		//js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id(Email)));
		//js.executeScript("scrollBy(0,2000)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
		driver.findElement(By.id("Email")).sendKeys(Email);
		driver.findElement(By.id("Password")).sendKeys(Password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(Password);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("register-button")));
		driver.findElement(By.id("register-button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.button-1.register-continue-button")));
		driver.findElement(By.cssSelector("a.button-1.register-continue-button")).click();
	}

}
