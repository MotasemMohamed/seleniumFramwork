package Package2;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import Package.HomePage;
import Package.LoginPage;
import Package.Registerationpage;

public class BuyProductTestcase extends TestBase{	
	HomePage homeobject;
	Registerationpage registerationobject;
	LoginPage login;
	CSVReader Reader;
	@Test
	public void Buyproductsuccessfully() 
	{
		homeobject= new HomePage(driver);
		login= new LoginPage(driver);
		login.Login();
		Assert.assertEquals("Log out",driver.findElement(By.cssSelector("a.ico-logout")).getText());
		homeobject.Searchbutton();	
		Assert.assertEquals("Samsung Series 9 NP900X4C Premium Ultrabook",driver.findElement(By.cssSelector("a.product-name")).getText()); 
	}
}
