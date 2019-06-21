package org.C_zentrix.org.C_zentrix;
import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
public class CampaignForm extends MethodClass
{
	public static void cam() throws Exception
	{           
		Logger logger=Logger.getLogger("CampaignForm");
		  PropertyConfigurator.configure("Log4j.properties");
		logger.info("start campaign method");
		        System.out.println("cam method is start");
	            System.out.println("click on call center");
	   			driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/ul[2]/li[3]/a")).click();
	   			System.out.println("click on campaign");   
	   			driver.findElement(By.xpath("//*[@id=\"Campaigns_li_a\"]")).click();
	   			System.out.println("click on add campaign");
	   			driver.findElement(By.name("campaign_add_ui")).click();
      //collect url from excel	
	  		  Hs=Hw.getSheet("Sheet1");
              String cam11 =Hs.getRow(1).getCell(17).getStringCellValue();
	   		  System.out.println(cam11);
	   		  String cam12 =Hs.getRow(1).getCell(18).getStringCellValue();
	   		  System.out.println(cam12);
	   		  int row=Hs.getLastRowNum();
	   		  System.out.println("total row is "+row);
	   	   logger.info("fill Campagn details");
	   			for(int i=1;i<=row;i++)
	   			{    
	   				String user =Hs.getRow(i).getCell(0).getStringCellValue();
	   				String localCell =Hs.getRow(i).getCell(1).getStringCellValue();
	   				String callingDuration =Hs.getRow(i).getCell(2).getStringCellValue();
	   				String  dialtimeOut=Hs.getRow(i).getCell(3).getStringCellValue();
	   				String  campignspriFix=Hs.getRow(i).getCell(4).getStringCellValue();
	   				String channel =Hs.getRow(i).getCell(5).getStringCellValue();
	   				String warningTime =Hs.getRow(i).getCell(6).getStringCellValue();
	   				String wrapupTime =Hs.getRow(i).getCell(7).getStringCellValue();
	   				String  confwrapupTime=Hs.getRow(i).getCell(8).getStringCellValue();
	   				String callorginate =Hs.getRow(i).getCell(9).getStringCellValue();
	   				String  agentfreewarningTime=Hs.getRow(i).getCell(10).getStringCellValue();
	   				String  agentconnet=Hs.getRow(i).getCell(11).getStringCellValue();
	   				String failurelimitofList =Hs.getRow(i).getCell(12).getStringCellValue();
	   				String unreachablelimitofList =Hs.getRow(i).getCell(13).getStringCellValue();
	   				String  setcallerId=Hs.getRow(i).getCell(14).getStringCellValue();
	   				String effectiveSla =Hs.getRow(i).getCell(15).getStringCellValue();
	   				String  threshold=Hs.getRow(i).getCell(16).getStringCellValue();
	   			driver.findElement(By.xpath("//input[@name='campaign_name']")).clear();
	   			driver.findElement(By.xpath("//input[@name='campaign_name']")).sendKeys(user);
	   			if(i==3||i==4)
	   			{
	   			Select sel3=new Select(driver.findElement(By.name("campaign_type")));
 				  sel3.selectByValue("INBOUND");
	   			}
	   			else if(i==5||i==6)
	   			{
	   				Select sel3=new Select(driver.findElement(By.name("campaign_type")));
	 				  sel3.selectByValue("BLENDED");
	   			}
	   			driver.findElement(By.id("local_start_timeId")).clear();
	   			driver.findElement(By.id("local_start_timeId")).sendKeys(localCell);
	   			Select sel2=new Select(driver.findElement(By.name("autodial_level")));
	   				  sel2.selectByValue(cam11);
	   			Select sel1=new Select(driver.findElement(By.name("agentui_timezone")));
	   			sel1.selectByVisibleText(cam12);
	   		  //Select sel3=new Select(driver.findElement(By.name("sipGateway[]")));
		      //sel3.selectByVisibleText("server25");
	   			driver.findElement(By.name("local_end_time")).clear();
	   			driver.findElement(By.name("local_end_time")).sendKeys(callingDuration);
	   			driver.findElement(By.name("dial_time_out")).clear();
	   			driver.findElement(By.name("dial_time_out")).sendKeys(dialtimeOut);
	   			//driver.findElement(By.name("campaign_prefix")).clear();
	   			//driver.findElement(By.name("campaign_prefix")).sendKeys(campignspriFix);
	   			//driver.findElement(By.name("trans_chan_req")).clear();
	   			//driver.findElement(By.name("trans_chan_req")).sendKeys(channel);
	   			driver.findElement(By.name("warningTime")).clear();
	   			driver.findElement(By.name("warningTime")).sendKeys(warningTime);
	   			driver.findElement(By.name("wrapupTime")).clear();
	   			driver.findElement(By.name("wrapupTime")).sendKeys(wrapupTime);
	   			driver.findElement(By.name("confwrapupTime")).clear();
	   			driver.findElement(By.name("confwrapupTime")).sendKeys(confwrapupTime);
	   			driver.findElement(By.name("originateTimeout")).clear();
	   			driver.findElement(By.name("originateTimeout")).sendKeys(callorginate);
	   			driver.findElement(By.name("AgentFreeWarningTime")).clear();
	   			driver.findElement(By.name("AgentFreeWarningTime")).sendKeys(agentfreewarningTime);
	   			driver.findElement(By.name("AgentConnectWarningTime")).clear();
	   			driver.findElement(By.name("AgentConnectWarningTime")).sendKeys(agentconnet);
	   			driver.findElement(By.name("failedList_limit")).clear();
	   			driver.findElement(By.name("failedList_limit")).sendKeys(failurelimitofList);
	   			driver.findElement(By.name("unreachable_limit")).clear();
	   			driver.findElement(By.name("unreachable_limit")).sendKeys(unreachablelimitofList);
	   			driver.findElement(By.name("caller_id")).clear();
	   			driver.findElement(By.name("caller_id")).sendKeys(setcallerId);
	   			driver.findElement(By.name("effective_sla")).clear();
	   			driver.findElement(By.name("effective_sla")).sendKeys(effectiveSla);
	   			driver.findElement(By.name("threshold_time")).clear();
	   			driver.findElement(By.name("threshold_time")).sendKeys(threshold);
	   			JavascriptExecutor jse = (JavascriptExecutor)driver;
	   				               jse.executeScript("window.scrollBy(0,350)", "");
	   			//Thread.sleep(1000);
	   			driver.findElement(By.name("add_campaign")).click();
	   			driver.findElement(By.name("campaign_add_ui")).click();
	   			System.out.println("for loop in campaign method");
	   			}
	   		   logger.info("campaign creation successful");
	   		   //  hw.close();
	   		
	   			driver.findElement(By.xpath("//*[@id=\"Campaigns_li_a\"]")).click();
	   			driver.findElement(By.name("agent_disposition[2481]")).click();
	   			driver.findElement(By.name("add_disp")).click();
	   		    driver.findElement(By.id("cust_disp_0")).clear();
			    driver.findElement(By.id("cust_disp_0")).sendKeys("basic_disp");
			    driver.findElement(By.id("disp_more")).click();
			    driver.findElement(By.id("cust_disp_1")).clear();
			    driver.findElement(By.id("cust_disp_1")).sendKeys("verifier_disp");
			    driver.findElement(By.id("disp_more")).click();
			    driver.findElement(By.id("cust_disp_2")).clear();
			    driver.findElement(By.id("cust_disp_2")).sendKeys("verifier");
			    driver.findElement(By.id("checkbox2_2")).click();
			    driver.findElement(By.id("disp_more")).click();
			    driver.findElement(By.id("cust_disp_3")).clear();
			    driver.findElement(By.id("cust_disp_3")).sendKeys("multiverfier");
			    driver.findElement(By.id("checkbox2_3")).click();
			  //driver.findElement(By.id("delete_btn4")).click();
			    driver.findElement(By.id("agent_cust_save")).click();
			    logger.info("Disp creation successful");
			    closeAlertAndGetItsText(true);
			    driver.findElement(By.id("Campaigns_li_a")).click();
			    logger.info("closed campaign method");
			  System.out.println("cam method is closed");
	   	}


	

	
}
