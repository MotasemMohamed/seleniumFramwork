package Package;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
	protected WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public PageBase(WebDriver driver)
	{  
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
}
