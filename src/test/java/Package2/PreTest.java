package Package2;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class PreTest {
	public static WebDriver driver;
	CSVReader Reader;
	//JavascriptExecutor js = (JavascriptExecutor) driver;
		@BeforeTest
	public void Essentialtest()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");	
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.nopcommerce.com/");
	}
	@Test
	public void Registeration() throws CsvValidationException, IOException
	{
		//String csv_file = System.getProperty("usr.dir")+"/Etslat/src/test/java/Package2/UserData.csv";
		String csv_file = "D:/D/Eclips projects/Etslat/src/test/java/Package2/UserData.csv";
		//PageBase PageBaseobject = new PageBase(driver);
		Reader= new CSVReader(new FileReader(csv_file));
		String[] csv_cell ;
		driver.findElement(By.cssSelector("a.ico-register")).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Register")));
		
		while ((csv_cell = Reader.readNext())!= null) {
			String Firstname = csv_cell[0];
			String Lasttname = csv_cell[1];
			String Email = csv_cell[2];
			String Password = csv_cell[3];
			Registeration(Firstname, Lasttname, Email, Password);
		}
		driver.findElement(By.id("register-button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='result']")));
		driver.findElement(By.cssSelector("a.button-1.register-continue-button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.ico-logout")));
		Assert.assertEquals("Log out",driver.findElement(By.xpath("//a[@class='ico-logout']")).getText());  
	}
	public void Registeration(String Firstname , String Lasttname , String Email , String Password)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.findElement(By.id("FirstName")).sendKeys(Firstname);
		driver.findElement(By.id("LastName")).sendKeys(Lasttname);
		//js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id(Email)));
		js.executeScript("scrollBy(0,2000)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
		driver.findElement(By.id("Email")).sendKeys(Email);
		driver.findElement(By.id("Password")).sendKeys(Password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(Password);	
	}
	
	@AfterMethod
	public void screenshot(ITestResult result) throws IOException
	{/*
		if (ITestResult.FAILURE== result.getStatus())
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File ("./Screenshot/"+ result.getName()+".png"));
		}
		*/
	}
	@AfterTest
	public void closetest()
	{
		driver.close();
	}
}