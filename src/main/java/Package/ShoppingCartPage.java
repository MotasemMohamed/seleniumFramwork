package Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends PageBase
{
	WebDriverWait wait = new WebDriverWait(driver,30);
   
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	public void Chectout()
	{
		driver.findElement(By.id("termsofservice")).isSelected();
		driver.findElement(By.id("checkout")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Checkout")));	
	}

	public void Chectoutdetails()
	{
		WebElement country= driver.findElement(By.id("BillingNewAddress_CountryId"));
		dropdownlist(country,0);
		WebElement state= driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
		dropdownlist(state,0);		
	    driver.findElement(By.id("BillingNewAddress_City")).sendKeys("cairo");
	    driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Ahlyclub");
	    driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("123");
	    driver.findElement(By.id("BillingNewAddress.FaxNumber")).sendKeys("12121212");   
	    driver.findElement(By.cssSelector("button.button-1new-address-next-step-button")).click();
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
	    
	}//div[@class='page-title']/h1

}
