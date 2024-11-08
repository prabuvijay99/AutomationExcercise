package TestCases;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class commonMethods {
	
	public String fname;
//	public static WebDriver driver;
	public ThreadLocal<WebDriver> driver=new ThreadLocal<>();
	public Properties prop;
	
	public void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}
	public  WebDriver getDriver() {
		return driver.get();
	}
	
	
	@BeforeClass
	@Parameters({"browser"})
	public void preCondition(String br) throws IOException {
		
		
	
		FileInputStream fis=new FileInputStream("./src/main/resources/config.properties");
		prop=new Properties();
		prop.load(fis);
		
		switch(br.toLowerCase()) {
		case "chrome": 
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--headless");
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("disable-save-password-bubble");
			setDriver(new ChromeDriver(options));
			break;
		case "edge":
			EdgeOptions options1 = new EdgeOptions();
			options1.addArguments("--headless");
			options1.addArguments("--disable-notifications");
			options1.addArguments("--disable-popup-blocking");
			setDriver(new EdgeDriver(options1));
			break;
		case "firefox": 
			FirefoxOptions options2 = new FirefoxOptions();
			options2.addArguments("--headless");
			options2.addArguments("--disable-notifications");
			options2.addArguments("--disable-popup-blocking");
			setDriver(new FirefoxDriver(options2));break;
		default: System.out.println("Invalid Browser");return;
		}
			
		
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("appUrl"));
	
		}
	
	
	@AfterClass
	public void postCondition() throws InterruptedException {
		getDriver().quit();

	}
	
	public String RandomUserName() {
		String randomName = RandomStringUtils.randomAlphabetic(6);
		return randomName;

	}

	public String RandomUserMail() {
		String randomemail= RandomStringUtils.randomAlphabetic(5);
		return randomemail+"@gmail.com";

	}

	public String RandomPass() {
		String randomPass = RandomStringUtils.randomAlphanumeric(8);
		return randomPass;

	}
	
	public String takeScreenShot(String testName,Object Instance) {
		
		String timeStamp=new SimpleDateFormat("yyMMddhhmm").format(new Date());
		
		TakesScreenshot ts= (TakesScreenshot) ((commonMethods) Instance).getDriver();
		File source = ts.getScreenshotAs(OutputType.FILE);
		String filePath=System.getProperty("user.dir")+"//screenShots//"+testName+"-"+timeStamp+".png";
		File destination=new File(filePath);
		source.renameTo(destination);
		return filePath;

	}
	
	
	
}
