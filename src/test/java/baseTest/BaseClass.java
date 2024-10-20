package baseTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.*;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

public static	WebDriver driver;
public Logger logger;
public Properties p;
@BeforeClass(groups= {"Sanity","Regression","Master"})
@Parameters({"os","browser"})
public void setup(String os , String br) throws IOException {
	FileReader file = new FileReader("./src/test/resources/config.properties");
	p = new Properties();
	p.load(file);
	
	logger = LogManager.getLogger(this.getClass());
	
	if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		switch(os.toLowerCase()) {
		case "windows": capabilities.setPlatform(Platform.WIN10); break;
		case "mac" : capabilities.setPlatform(Platform.MAC); break;
		case "linux": capabilities.setPlatform(Platform.LINUX); break;
		default : System.out.println("OS Not Matching...");return;
		
		}
		switch(br.toLowerCase()) {
		case "chrome" : capabilities.setBrowserName("chrome");break;
		case "edge" : capabilities.setBrowserName("MicrosoftEdge");break;
		case "firefox" : capabilities.setBrowserName("firefox");break;
		default : System.out.println("Browser Not Matching...");return;
		
		}
		driver = new RemoteWebDriver(new URL("http://192.168.163.80:4444/wd/hub"),capabilities);
	
	}
	if(p.getProperty("execution_env").equalsIgnoreCase("local")){
		
		switch(br.toLowerCase()) { 
		case "chrome": driver = new ChromeDriver(); break;
		case "edge": driver = new EdgeDriver(); break;
		case "firefox": driver = new FirefoxDriver(); break;
		default : System.out.println("Invalid browser");return;
		}
		
	}
	
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(p.getProperty("URL"));
	driver.manage().window().maximize();
}
@AfterClass(groups= {"Sanity","Regression","Master"})
public void drainout() {
	driver.quit();
}
public String randomalphabet() {
	RandomStringUtils random = new RandomStringUtils();
	String randomalpha = random.randomAlphabetic(5);
	return randomalpha;
}
public String randomnumber() {
	RandomStringUtils random = new RandomStringUtils();
	String randomnumber = random.randomNumeric(10);
	return randomnumber;
}
public String randomalphanumber() {
	RandomStringUtils random = new RandomStringUtils();
	String randomalphnumber = random.randomAlphanumeric(8);
	return randomalphnumber;
}

public String captureScreen(String tname) throws IOException {
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\" +tname+"_"+ timeStamp+".png";
	File targetFile = new File (targetFilePath);
	sourceFile.renameTo(targetFile);
	return targetFilePath;
	
}

}
