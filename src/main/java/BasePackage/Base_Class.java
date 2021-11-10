package BasePackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base_Class {
	String driverPath = "C:\\chromedriver\\chromedriver.exe";
	WebDriver driver;
	public Base_Class(WebDriver driver)
	{
		this.driver=driver;
	}
	public WebDriver SetBase()
	{
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	    return driver;
	}
}