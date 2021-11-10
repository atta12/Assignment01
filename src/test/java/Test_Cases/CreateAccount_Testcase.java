package Test_Cases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import BasePackage.Base_Class;
import Pages.Create_new_Account;

public class CreateAccount_Testcase{
	public WebDriver driver;
	Base_Class ObjBase = new Base_Class(this.driver);
	
	
	@BeforeMethod
	public void function()
	{
		this.driver = ObjBase.SetBase();
	}
	
	@Test
	public void test_Home_Page_Appear_Correct() throws Exception
	{
		
		Create_new_Account objSignup= new Create_new_Account(this.driver);
		
		objSignup.Translate_OpenSignup();
		
		String RegisterPageTitle = objSignup.getRegisterTitle();
	    
		Assert.assertEquals(RegisterPageTitle, "Sign Up");
	    	
		objSignup.Create_Account("Ali","Sajid","03132345789","asdfQWER!@34","Female","6","Oct","1999");
		
		objSignup.click_on_account_button();
		objSignup.waitfunction();
		
//		String Success_Message_Link = objSignup.getsuccessTitle();
//	    System.out.print(Success_Message_Link);
//		Assert.assertEquals(Success_Message_Link, "Enter the confirmation code from the text messageEnter the confirmation code from the text message");
	}
	@AfterTest
	public void close_browser()
	{
		driver.close();
	}
}