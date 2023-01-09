package DriverPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MainDriver {
	public static WebDriver driver;
	String URL = "https://testproject.io/";

	@BeforeTest
	public void setup() {
		WebDriverManager.edgedriver().setup();

		driver = new EdgeDriver();

		driver.manage().window().maximize();

	}

	@AfterTest
	public void TearDownDriver() {
		// driver.close();

	}

}
