package org.C_zentrix.org.C_zentrix;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.tools.ant.types.resources.selectors.Compare;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
//import Screenshot.Screen_shot;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
public class MethodClass 
{
    public static int flag=0;
    public static  WebDriver driver;
    public static   FileInputStream f2;
    public static   HSSFWorkbook Hw;
    public static   HSSFSheet Hs;
public static  SoftAssert assertion= new SoftAssert();
	public static void openBrowser() throws IOException 
	{
	  Logger logger=Logger.getLogger("MethodClass");
	  PropertyConfigurator.configure("Log4j.properties");
		//browser open
		System.out.println("browser open method is start");
		System.setProperty("webdriver.gecko.driver", "D:\\himanshu\\firefoxdriver64\\geckodriver.exe");
		//open firefox browser
		System.out.println("open fire fox browser ");
		driver=new FirefoxDriver();
		logger.info("Firefox Opened");
		driver.manage().window().maximize();
		logger.info("window maximize");
		// collect url from excel sheet c-zentrix
		 System.out.println(" collect url from excel sheet");
		f2=new FileInputStream("C:\\Users\\tvt\\eclipse-workspace\\c-zentrix\\TestData\\Czentrix_data.xls");
	    Hw=new HSSFWorkbook(f2);
	    Hs=Hw.getSheet("Sheet3");
		String excel_url=Hs.getRow(1).getCell(0).getStringCellValue();
		System.out.println(excel_url);
		Hw.close();
	    driver.get(excel_url);
		// screen shot method calling
	    logger.info("call screen shot method");
	     //System.out.println("call screen shot method");
		 screen(driver, "Browser start");
		// check assertion
		 logger.info(" check url assertion");
		 System.out.println("check url assertion");
		 String url=excel_url;
		 String Actualurl = driver.getCurrentUrl();
		 Assert.assertEquals(Actualurl, url);
		// System.out.println(Actualurl+"act   1");
		// System.out.println(url+"   url 2");
		 logger.info("fill user name");
		 System.out.println("fill user name and password");
		 String USERNAME=Hs.getRow(1).getCell(1).getStringCellValue();
		 driver.findElement(By.name("uid")).clear();
		 driver.findElement(By.name("uid")).sendKeys(USERNAME);
		 Assert.assertTrue(USERNAME.contains("adminrw"), "user name not match");
		// boolean actResult=Compare.validateElementVisibility(driver,"name","uid");
         String PASSWORD=Hs.getRow(1).getCell(2).getStringCellValue();
         logger.info("fill password");
		 driver.findElement(By.name("pwd")).clear();
		 driver.findElement(By.name("pwd")).sendKeys(PASSWORD);
		 Assert.assertTrue(PASSWORD.contains("rwpass"), "password not match");
		 driver.findElement(By.name("Submit")).click();
         logger.info("login success");

	    //flag for session button
		 flag++;
		 if(flag==1)
		   {	    logger.info("new session is start");
			    driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td[1]/form/table/tbody/tr[7]/td/input[1]")).click();
				System.out.println("your new session is start");
		   }
		  else
		    {
			   logger.info("old session is continue");
		    	driver.findElement(By.name("logout_existing_agent")).click();
		    	System.out.println("your old session is continue");
		    }
		 System.out.println("click on slider button");
 		 driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div/img")).click();
 		String s1=driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/table/tbody/tr/td[2]/div[2]/div[2]")).getText();
 		assertion.assertEquals(s1, "Welcome adminrw");
 		assertion.assertAll();
 		 System.out.println("open browser method  is closed");
 	}
	// ScreenShot method
	public static  void screen(WebDriver driver,String Screenshotname)
	{    
		System.out.println("start screen shot method start");
	  try {
		   TakesScreenshot ts= (TakesScreenshot)driver;
		   File source= ts.getScreenshotAs(OutputType.FILE);
		   FileUtils.copyFile(source, new File("./Screenshot1/"+Screenshotname+".png"));
		  System.out.println("taken");
		  } 
	 catch (Exception e) 
		   {
		    e.printStackTrace();
		    System.out.println("Exception while taking screen shot"+e.getMessage());
		  } 
		System.out.println("close screen shot method");
    }
	// Alert method
	 public static String closeAlertAndGetItsText(boolean acceptNextAlert) throws Exception 
	 {       
			System.out.println(" start alert method ");
         try {
	 	      Alert alert = driver.switchTo().alert();
	 	      String alertText = alert.getText();
	 	      System.out.println(alert.getText());
	 	      if (acceptNextAlert) 
	 	      {
	 	    	Thread.sleep(1000);
	 	        alert.accept();
	 	     } 
	 	      else 
	 	      {
	 	        alert.dismiss();
	 	      }
	 	     return alertText;
	 	    }  
	 finally{
	 	      System.out.println("accepting alert");
	 	      acceptNextAlert = true;
	 			System.out.println("close alert method");
	 		}
	 }
	
}


