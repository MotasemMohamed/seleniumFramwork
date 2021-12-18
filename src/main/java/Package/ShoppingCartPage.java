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
	}


}
