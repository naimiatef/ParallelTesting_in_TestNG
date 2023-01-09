package DemoTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTesting2 {
	WebDriver driver;

	  @BeforeMethod
	  public void setUp() {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	  }

	  @AfterMethod
	  public void tearDown() {
	    driver.quit();
	  }
      
	  //Démarrez un pool de threads, qui contient 3 threads, et exécutez la méthode de test 4 fois.
	   // La méthode sera appelée à partir de plusieurs threads comme spécifié par invocationCount
	  @Test(threadPoolSize = 3, invocationCount = 4)
	  public void test3_BootstrapAlerts() {
	    driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-alert-messages-demo");
	    System.out.println(Thread.currentThread().getId() +
	            ": Bootstrap Alert Message Page");
	  }

	  @Test
	  public void test4_DragDropRangeSlider() {
	    driver.get("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");
	    System.out.println(Thread.currentThread().getId() +
	            ": Drag And Drop Range Slider Page");
	  }
}
