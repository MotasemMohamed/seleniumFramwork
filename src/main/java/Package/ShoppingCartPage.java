package Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends PageBase
{
	WebDriverWait wait = new WebDriverWait(driver,30);
   
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	public void Chectout()
	{	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));	
		driver.findElement(By.id("termsofservice")).click();
		driver.findElement(By.id("checkout")).click();
	}

	public void Chectoutdetails()
	{
		WebElement country= driver.findElement(By.id("BillingNewAddress_CountryId"));
		Select selectoptioncountry= new Select(country);
		selectoptioncountry.selectByIndex(0);
		WebElement state= driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
		Select selectoptionstate= new Select(state);
		selectoptionstate.selectByIndex(0);
	    driver.findElement(By.id("BillingNewAddress_City")).sendKeys("cairo");
	    driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Ahlyclub");
	    driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("123");
	    driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("12121212");   
	    driver.findElement(By.xpath("(//div[@class='buttons']/button)[5]")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.button-1.shipping-method-next-step-button")));
	    driver.findElement(By.cssSelector("button.button-1.shipping-method-next-step-button")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.button-1.payment-method-next-step-button")));
	    driver.findElement(By.cssSelector("button.button-1.payment-method-next-step-button")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.button-1.payment-info-next-step-button")));
	    driver.findElement(By.cssSelector("button.button-1.payment-info-next-step-button")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.button-1.confirm-order-next-step-button")));
	    driver.findElement(By.cssSelector("button.button-1.confirm-order-next-step-button")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.button-1.order-completed-continue-button")));
	    driver.findElement(By.cssSelector("button.button-1.order-completed-continue-button")).click();  
	}

}
