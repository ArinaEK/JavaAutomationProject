package tests;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
//import utils.Utils;


public class  BaseTest {
	WebDriver driver;

	@BeforeClass
	public void setup()  {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get("https://il.iherb.com/");
		
		//Utils u=new Utils();
		//driver.get(u.readProperty("url"));
		
		//or if method readProperty is static
	/*	driver.get(Utils.readProperty("url"));
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	/*
	 * This method will run after wach test,
	 * it will take screen shot only for tests that failed
	 */
	@AfterMethod
	public void failedTest(ITestResult result) {
	  //check if the test failed
		if (result.getStatus() == ITestResult.FAILURE ){
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File("./ScreenShots/"+result.getName()+".jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//result.getname() method will give you current test case name. 
			//./ScreenShots/ tell you that, in your current directory, create folder ScreenShots. dot represents current directory
		}
	}

	/*@AfterClass
	public void tearnDown() {
		driver.quit();
	}*/
}