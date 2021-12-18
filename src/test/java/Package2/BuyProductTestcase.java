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
	@Test
	public void Usercansearchwithautosuggest() 
	{
		homeobject= new HomePage(driver);
		registerationobject.Registeration("a","a", "a@a.com", "123456");
		Assert.assertEquals("Log out",driver.findElement(By.cssSelector("a.ico-logout")).getText());
		homeobject.Searchbutton();	
		Assert.assertEquals("Samsung Series 9 NP900X4C Premium Ultrabook",driver.findElement(By.cssSelector("a.product-name")).getText()); 
	}

	@Test
	public void Usercanaddproductinthecart() 
	{
		ProductDetailsPage productdetailsobject= new ProductDetailsPage(driver);
		productdetailsobject.AddProductintheCart();
		Assert.assertEquals("The product has been added to your",driver.findElement(By.cssSelector("p.content")).getText()); 	     
	}
	@Test
	public void Confirm() 
	{
		Assert.assertEquals("Shopping cart",driver.findElement(By.cssSelector("p.content")).getText());
		ShoppingCartPage shopingcartobject= new ShoppingCartPage(driver);
		shopingcartobject.Chectout();
	}
}
