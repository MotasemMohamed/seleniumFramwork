package Package2;

import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import Package.HomePage;
import Package.Registerationpage;

public class RegisterationTestcase extends TestBase{
	HomePage homeobject;
	Registerationpage registerationobject;
	CSVReader Reader;
	@Test
	public void userregisterationsuccessfully() throws CsvValidationException, IOException
	{
		homeobject= new HomePage(driver);
		registerationobject = new Registerationpage(driver);
		String csv_file = "D:/D/Eclips projects/Etslat/src/test/resources/Data/UserData.csv";
		Reader= new CSVReader(new FileReader(csv_file));
		String[] csv_cell ;

	while ((csv_cell = Reader.readNext())!= null) {	
		String Firstname = csv_cell[0];
		String Lasttname = csv_cell[1];
		String Email = csv_cell[2];
		String Password = csv_cell[3];
		homeobject.openregisterationpage();
		registerationobject.Registeration(Firstname, Lasttname, Email, Password);
	}
	}
}
