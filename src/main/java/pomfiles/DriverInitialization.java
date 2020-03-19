package pomfiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverInitialization {
	public WebDriver initDriver() throws IOException {
		WebDriver driver = null;
		
		FileInputStream file=new FileInputStream("C:\\Users\\nitinp\\eclipse-workspace\\MavenJava\\src\\test\\resources\\testData.properties");
		Properties prop=new Properties();
		prop.load(file);
		
		if(prop.getProperty("browser").equalsIgnoreCase("Chrome")) {
			System.out.println("Chrome");
			System.setProperty("webdriver.chrome.driver", "c:\\Users\\nitinp\\Downloads\\chromedriver_win32_1\\chromedriver.exe");
			driver=new ChromeDriver();
		} else if(prop.getProperty("browser").equalsIgnoreCase("ie")) {
			System.out.println("IE");
			System.setProperty("webdriver.ie.driver", "c:\\Users\\nitinp\\Downloads\\IEDriverServer_Win32_3.9.0\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();			
		}
		return driver;
	}
}
