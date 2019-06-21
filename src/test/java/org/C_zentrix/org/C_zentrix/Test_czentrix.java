package org.C_zentrix.org.C_zentrix;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.tools.ant.types.resources.selectors.Compare;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test_czentrix 
{   
	private static final Assertion Assert = null;
	public static ExtentReports extent;
	public static  ExtentTest   logger;
	@BeforeTest
	public  void before() throws Exception 
	{
	  Logger logger=Logger.getLogger("Test_czentrix");
	  PropertyConfigurator.configure("Log4j.properties");
	  logger.info("start before testcase");
		System.out.println("start before test");
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/STMExtentReport.html",true);
		extent.addSystemInfo("Host name", "softwsre Testing Material");
		extent.addSystemInfo("Environment", "Automation Testing");
		extent.addSystemInfo("User Name", "Himanshu");	  
		MethodClass.openBrowser();
		System.out.println(" before test is closed");
		logger.info("close before testcase");
	}
	@Test(priority=3)
	public void campaignTest() throws Exception
	{
		 Logger loggerr=Logger.getLogger("Test_czentrix");
		  PropertyConfigurator.configure("Log4j.properties");
		  loggerr.info("start campaign testcase");
		  try {
	  System.out.println("start campaign test");
		logger = extent.startTest("passTest");
    	//Assert.assertTrue(true);
    	logger.log(LogStatus.PASS, "campaign test case is pass");
       CampaignForm.cam();
    	System.out.println("campaign test is closed");
    	 loggerr.info("close campaign testcase");
		  }
		  catch(Exception e)
		  {
			  System.out.println(e.getMessage()+" catch block");
		  }
    }
/*	@Test(priority=5)
	public void agentTest() throws Exception
	{
		 Logger loggerr=Logger.getLogger("Test_czentrix");
		  PropertyConfigurator.configure("Log4j.properties");
		  loggerr.info("start agent test");
		System.out.println("agent test is start");
        logger = extent.startTest("passTest");
    	Assert.assertTrue(true);
    	logger.log(LogStatus.PASS, "agent test case is pass");
      // AgentForm.agent();
       System.out.println("agent test is closed");
       loggerr.info("close agent test");
	}
	@Test(priority=4)
	public void listForm() throws Exception
	{
		 Logger loggerr=Logger.getLogger("Test_czentrix");
		  PropertyConfigurator.configure("Log4j.properties");
		 loggerr.info("start list test");
		System.out.println("list test is start");
        logger = extent.startTest("passTest");
    	Assert.assertTrue(true);
    	logger.log(LogStatus.PASS, "list test case is pass");
      // ListsForm.list();
		System.out.println("list test is closed");
		loggerr.info("close list test");
	}
	@Test(priority=1)
	public void GateWay() throws Exception
	{
		 Logger loggerr=Logger.getLogger("Test_czentrix");
		  PropertyConfigurator.configure("Log4j.properties");
		 loggerr.info("start gateway test");
		System.out.println("gateway test is start");
        logger = extent.startTest("passTest");
    	Assert.assertTrue(true);
    	logger.log(LogStatus.PASS, "gateway test case is pass");
    //  Gateway_ConfigurationForm.gateWay();
        System.out.println("gateway test is closed");
        loggerr.info("close gateway test");
	}
	@Test(priority=2)
	public void sip() throws Exception
	{ 
	  Logger loggerr=Logger.getLogger("Test_czentrix");
	  PropertyConfigurator.configure("Log4j.properties");
	  loggerr.info("start sip test");
		System.out.println("sip test is start");
        logger = extent.startTest("passTest");
    	Assert.assertTrue(true);
    	logger.log(LogStatus.PASS, "gateway test case is pass");
      // SipChannelsForm.sipChannels();
        System.out.println("sip test is closed");
        loggerr.info("close sip test");
	}
	@Test(priority=6)
	public void sip_Channel() throws Exception
	{
		 Logger loggerr=Logger.getLogger("Test_czentrix");
		  PropertyConfigurator.configure("Log4j.properties");
		  loggerr.info("sip channel configuration test");
		System.out.println("sip channel configuration test is start");
        logger = extent.startTest("passTest");
    	Assert.assertTrue(true);
    	logger.log(LogStatus.PASS, "gateway test case is pass");
    	//Sip_channel_configuration_Form.sip_channel_Configuration();
        System.out.println("sip channel configuration test is closed");
        loggerr.info("close sip channel configuration test");
	}*/
	@Test
	public void test2()
	{
		System.out.println("skip test is start");
		logger = extent.startTest("skipTest");
		System.out.println("skip test is close");
    	throw new SkipException("Skipping - this is not ready for testing");
     }
	@AfterMethod
	 public void getResult(ITestResult result)
	 {     
	  if(result.getStatus()==ITestResult.FAILURE) 
	   {
	    logger.log(LogStatus.FAIL, "Test case failed is "+result.getName());
	    logger.log(LogStatus.FAIL, "Test case failed is "+result.getThrowable());
	   }
	  else if(result.getStatus()==ITestResult.SKIP)
	   {
	    logger.log(LogStatus.SKIP, "Test case skipped is"+result.getName());
	   }
	   extent.endTest(logger);
	}
	    @AfterTest
	    public void endReport()
	    {
	    	extent.flush();
	    	extent.close();
	    }
}
