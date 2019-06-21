package org.C_zentrix.org.C_zentrix;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Testcases 
{
	 public WebDriver driver;
	@Test
	public void test()
	{
		System.out.println("maven");
		 System.setProperty("webdriver.chrome.driver", "D:\\himanshu\\chrome_driver32\\chromedriver.exe");
		 driver= new ChromeDriver();
		 driver.manage().window().maximize();
	
		driver.get(" http://192.168.1.57/agentui.php?agent_id=2001&czentrix=1");
		
	}

}
