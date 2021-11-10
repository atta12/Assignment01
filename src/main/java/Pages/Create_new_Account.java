package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Create_new_Account {
	WebDriver driver;
	By create_new_account = By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[5]/a[1]");
	By titleText = By.xpath("//div[contains(text(),'Sign Up')]");
	By First_name = By.xpath("//body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
	By Surname = By.xpath("//body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]");
	By Mobile_Email = By.xpath("//body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/input[1]");
	By Newpassword = By.xpath("//input[@id='password_step_input']");
	By Day = By.xpath("//select[@id='day']");
	By Month = By.xpath("//select[@id='month']");
	By Year = By.xpath("//select[@id='year']");
	By Gender_F = By.xpath("//label[contains(text(),'Female')]");
	By Gender_M = By.xpath("//label[contains(text(),'Male')]");
	By Gender_C = By.xpath("//label[contains(text(),'Custom')]");
	By Signup_button = By.xpath("//body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[10]/button[1]");
	By Success_message_link = By.xpath( "/html/body/div[1]/section/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a/i");
	
	

	public Create_new_Account(WebDriver driver) {
		this.driver=driver;
	}
	public String getRegisterTitle()
    {
    	return driver.findElement(titleText).getText();
    }
	public void Translate_OpenSignup() {
		//driver.findElement(By.xpath("//a[contains(text(),'English (UK)')]")).click();
		driver.findElement(create_new_account).click();
	}
	public void set_fullname(String fullname)
	{
		driver.findElement(First_name).sendKeys(fullname);
	}
	public void set_surname(String lastname)
	{
		driver.findElement(Surname).sendKeys(lastname);
	}
	public void set_email_phone(String email_phone)
	{
		driver.findElement(Mobile_Email).sendKeys(email_phone);
	}
	public void set_NewPassword(String password)
	{
		driver.findElement(Newpassword).sendKeys(password);
	}
	public void set_Gender(String gender)
	{
		if(gender == "Male")
			driver.findElement(Gender_M).click();
		else if(gender == "Female")
			driver.findElement(Gender_F).click();
		else if(gender == "Custom")
			driver.findElement(Gender_C).click();
	}
	public void set_DOB(String day,String month, String year)
	{
		Select drop_day = new Select(driver.findElement(Day));
		drop_day.selectByVisibleText(day);
		
		Select drop_month = new Select(driver.findElement(Month));
		drop_month.selectByVisibleText(month);
		
		Select drop_year = new Select(driver.findElement(Year));
		drop_year.selectByVisibleText(year);
	}

	public void click_on_account_button()
	{
		driver.findElement(Signup_button).click();
	}
	public void waitfunction() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(this.driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Success_message_link));
	}
//	public String getsuccessTitle()
//    {
//    	return driver.findElement(Success_message_link).getText();
//    }
	public void Create_Account(String Fname, String surname, String email,String Password, String gender, String day,String month,String year) throws Exception
	{
		this.set_fullname(Fname);
		this.set_surname(surname);
		this.set_email_phone(email);
		this.set_NewPassword(Password);
		this.set_DOB(day, month, year);
		this.set_Gender(gender);
	}
}
