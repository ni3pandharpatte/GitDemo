package pomfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffLoginPagePOM {
	WebDriver driver;
	public RediffLoginPagePOM(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		System.out.println("RediffLoginPagePOM Constructor");
	}
	By emailid=By.xpath("//input[@id='login1']");
	By password=By.xpath("//input[@id='password']");
	By submit=By.xpath("//input[@name='proceed']");
	
	public WebElement emailID() {
		return driver.findElement(emailid);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement submitBtn() {
		return driver.findElement(submit);
	}
}
