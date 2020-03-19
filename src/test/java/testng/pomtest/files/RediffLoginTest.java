package testng.pomtest.files;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pomfiles.DriverInitialization;
import pomfiles.RediffLoginPagePOM;


public class RediffLoginTest {

	@Test
	public void loginCheck() throws InterruptedException, IOException {
		DriverInitialization di=new DriverInitialization();
		WebDriver driver = di.initDriver();
		driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		Thread.sleep(2000);
		RediffLoginPagePOM loginpom = new RediffLoginPagePOM(driver);
		loginpom.emailID().sendKeys("abc.rediff.com");
		//driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("abc");
		loginpom.password().sendKeys("123123");
		Thread.sleep(2000);
		//loginpom.submitBtn().click();				
	}
}
