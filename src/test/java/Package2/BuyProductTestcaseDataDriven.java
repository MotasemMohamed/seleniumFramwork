package Package2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import Package.HomePage;
import Package.LoginPage;
import Package.ProductDetailsPage;
import Package.Registerationpage;
import Package.ShoppingCartPage;

public class BuyProductTestcaseDataDriven extends TestBase{	
	HomePage homeobject;
	Registerationpage registerationobject;
	LoginPage login;
	CSVReader Reader;
	@Test (priority = 1)
	public void Usercansearchwithautosuggest() throws CsvValidationException, IOException 
	{
		String csvfile=System.getProperty("user.dir")+"/src/test/resources/Data/UserData.csv";
		Reader= new CSVReader(new FileReader(csvfile));
		String [] csvcell;

		while ((csvcell = Reader.readNext())!= null) {

			String firstname= csvcell[0];
			String lastname= csvcell[1];
			String email= csvcell[2];
			String password= csvcell[3];
			homeobject= new HomePage(driver);
			registerationobject = new Registerationpage(driver);
			homeobject.openregisterationpage();
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName")));
			registerationobject.Registeration(firstname,lastname,email,password);
			Assert.assertEquals("Log out",driver.findElement(By.cssSelector("a.ico-logout")).getText());
			homeobject.Searchbutton();	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-name']/h1")));
			Assert.assertEquals("Samsung Series 9 NP900X4C Premium Ultrabook",driver.findElement(By.xpath("//div[@class='product-name']/h1")).getText()); 	
		}
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
