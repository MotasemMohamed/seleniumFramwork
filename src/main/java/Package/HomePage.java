package Package;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase
{
	WebDriverWait wait = new WebDriverWait(driver,30);
//Motasem
	@FindBy(css="li.ui-menu-item")
	List<WebElement>productlist;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	//@FindBy(linkText ="Register")
	//WebElement Registerationlink;

	public void openregisterationpage()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Register")));
		driver.findElement(By.linkText("Register")).click();
	}
	public void openLoginpage()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.ico-login")));
		driver.findElement(By.cssSelector("a.ico-login")).click();
	}


	public void Searchbutton()
	{
	//	List<WebElement> productlist= driver.findElement(By.);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("small-searchterms")));
		driver.findElement(By.id("small-searchterms")).sendKeys("samsung");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.ui-menu-item")));
		productlist.get(0).click();
	}

	/*
	public void Brockenlinks()
	{
		List<WebElement> links = driver.findElements(By.tagName("a"));
		// This line will print the number of links and the count of links.
		System.out.println("No of links are "+ links.size());  
		//checking the links fetched.
		for(int i=0;i<links.size();i++)
		{
			WebElement E1= links.get(i);
			String url= E1.getAttribute("href");
			verifyLinks(url);
		}
	}
	 */
	public static void verifyLinks(String linkUrl)
	{
		try
		{
			URL url = new URL(linkUrl);

			//Now we will be creating url connection and getting the response code
			HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			if(httpURLConnect.getResponseCode()>=400)
			{
				System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
			}    

			//Fetching and Printing the response code obtained
			else{
				System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
			}
		}catch (Exception e) {
		}
	}

}
