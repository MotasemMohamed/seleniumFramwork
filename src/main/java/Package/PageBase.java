package Package;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	protected WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public PageBase(WebDriver driver)
	{  
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void dropdownlist(WebElement element,int number)
	{  
		Select selectoption= new Select(element);
		selectoption.selectByIndex(number);
	}

	
}
