package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//pom class 1
public class KiteLogin1Page
{
	//step1: declaration
	@FindBy(xpath="//input[@id='userid']") private WebElement UN;  		//private WebElement UN=driver.findElement(By.xpath(""));
	@FindBy(xpath="//input[@id='password']") private	WebElement PWD;  //private WebElement PWD=driver.findElement(By.xpath(""));
	@FindBy(xpath="//button[text()='Login ']") private WebElement loginBtn; //private WebElement LoginBtn=driver.findElement(By.xpath(""));
	
	
	//step2: initialization
	public	KiteLogin1Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step3: usage
	
	//enter un
	public void inpKiteLogin1PageUsername(String username) 
	{
		UN.sendKeys(username);
	}
		
	//enter pwd
	public void inpKiteLogin1PagePassword(String password)
	{
		PWD.sendKeys(password);
	}
	
	//click on login btn
	public void clickKiteLogin1PageLoginBtn()
	{
		loginBtn.click();
	}
	
}
