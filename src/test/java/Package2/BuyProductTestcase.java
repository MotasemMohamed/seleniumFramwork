package Package2;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		registerationobject = new Registerationpage(driver);
		homeobject.openregisterationpage();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName")));
		registerationobject.Registeration("a","a", "asdcdfhsssdssja@a.com", "123456");
		Assert.assertEquals("Log out",driver.findElement(By.cssSelector("a.ico-logout")).getText());
		homeobject.Searchbutton();	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-name']/h1")));
		Assert.assertEquals("Samsung Series 9 NP900X4C Premium Ultrabook",driver.findElement(By.xpath("//div[@class='product-name']/h1")).getText()); 
	}
	@Test (dependsOnMethods = { "Usercansearchwithautosuggest" },priority = 2)
	public void Usercanaddproductinthecart() 
	{
		ProductDetailsPage productdetailsobject= new ProductDetailsPage(driver);
		productdetailsobject.AddProductintheCart();
		Assert.assertEquals("Shopping cart",driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText()); 	     
	}
	@Test (dependsOnMethods = { "Usercanaddproductinthecart" },priority = 3)
	public void Confirm() throws InterruptedException 
	{
		ShoppingCartPage shopingcartobject= new ShoppingCartPage(driver);
		shopingcartobject.Chectout();	
		Assert.assertEquals("First name:",driver.findElement(By.xpath("(//div[@class='inputs']/label)[1]")).getText());
		shopingcartobject.Chectoutdetails();
		Assert.assertEquals("Computers",driver.findElement(By.xpath("(//ul[@class='top-menu notmobile']/li/a)[1]")).getText());
	}
}
