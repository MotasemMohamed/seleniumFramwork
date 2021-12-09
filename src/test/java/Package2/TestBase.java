package Package2;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestBase {
	public  static WebDriver driver;

	@BeforeTest
	public void Essentialtest()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/Drivers/chromedriver.exe");	
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.nopcommerce.com/");
	}

	@AfterMethod
	public void screenshot() throws IOException
	{
		Screenshot s= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(s.getImage(),"PNG",new File(System.getProperty("user.dir")+"/Screenshot1/particularElementScreenshot.PNG"));
	}
	@AfterTest
	public void closetest()
	{
		driver.quit();
	}
}
