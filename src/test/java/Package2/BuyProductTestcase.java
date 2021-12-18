package Package2;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import Package.HomePage;
import Package.LoginPage;
import Package.ProductDetailsPage;
import Package.Registerationpage;
import Package.ShoppingCartPage;

public class BuyProductTestcase extends TestBase{	
	HomePage homeobject;
	Registerationpage registerationobject;
	LoginPage login;
	CSVReader Reader;
	@Test (priority = 1)
	public void Usercansearchwithautosuggest() 
	{
		homeobject= new HomePage(driver);
		homeobject.openregisterationpage();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName")));
		registerationobject.Registeration("a","a", "a@a.com", "123456");
		Assert.assertEquals("Log out",driver.findElement(By.cssSelector("a.ico-logout")).getText());
		homeobject.Searchbutton();	
		Assert.assertEquals("Samsung Series 9 NP900X4C Premium Ultrabook",driver.findElement(By.cssSelector("a.product-name")).getText()); 
	}

	@Test (priority = 2)
	public void Usercanaddproductinthecart() 
	{
		ProductDetailsPage productdetailsobject= new ProductDetailsPage(driver);
		productdetailsobject.AddProductintheCart();
		Assert.assertEquals("The product has been added to your",driver.findElement(By.cssSelector("p.content")).getText()); 	     
	}
	@Test (priority = 3)
	public void Confirm() 
	{
		Assert.assertEquals("Shopping cart",driver.findElement(By.cssSelector("p.content")).getText());
		ShoppingCartPage shopingcartobject= new ShoppingCartPage(driver);
		shopingcartobject.Chectout();
		shopingcartobject.Chectoutdetails();
		Assert.assertEquals("Categories",driver.findElement(By.xpath("//div[@class='master-wrapper-page']/div[@class='header-menu']/div")).getText());
	}
}
