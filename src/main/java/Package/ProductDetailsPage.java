package Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage extends PageBase
{
	WebDriverWait wait = new WebDriverWait(driver,30);

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	public void AddProductintheCart()
	{
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.id("add-to-cart-button-6")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("P.content")));
		driver.findElement(By.linkText("shopping cart")).click();
	}
	

}
