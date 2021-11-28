package Package2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Demo extends PreTest {
	public Demo(WebDriver driver) {
		super();
	}
	@Test
	public void Essentialtest()
	{   
		//driver = new ChromeDriver();
		driver.findElement(By.cssSelector("a.ico-login")).click();	
	}

}
