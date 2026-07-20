package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop1= new Properties();
	public static Properties locatorprop= new Properties();
	public static FileReader fr;
	public static FileReader locatorfr;
	
	@BeforeTest
	public void setUp() throws IOException {
		if(driver==null) {
			//System.out.println("Base path : "+System.getProperty("user.dir"));
			fr=new FileReader(System.getProperty("user.dir")+"\\src\\main\\resources\\configfiles\\config.properties");
			locatorfr=new FileReader(System.getProperty("user.dir")+"\\src\\main\\resources\\configfiles\\locators.properties");
			prop1.load(fr);
			locatorprop.load(locatorfr);
			
		}
		if(prop1.getProperty("browser").equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get(prop1.getProperty("testurl"));
			driver.manage().window().maximize();
		}
		else if(prop1.getProperty("browser").equalsIgnoreCase("firefox")){
			//WebDriverManager.firefoxdriver().setup();
			WebDriverManager.firefoxdriver().driverVersion("0.34.0").setup();
			driver=new FirefoxDriver();
			driver.get(prop1.getProperty("testurl"));
			driver.manage().window().maximize();
		}
	}
	@AfterTest
	public void tearDown() {
		 if (driver != null) {
		        driver.quit();  // ✅ closes all windows and ends WebDriver session cleanly
		        System.out.println("Browser closed successfully. !!");
		    }
		//driver.close();
		//System.out.println("Browser closed successfully. !!");
	}

}
