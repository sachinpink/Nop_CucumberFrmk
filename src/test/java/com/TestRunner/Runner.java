package com.TestRunner;
import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
( features={".//Features/Login app Adding and searching customer.feature"},
 glue="com.StepDefinations",
 dryRun=false,
 tags={"@AddCustomer"},
 monochrome=true,
 plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport.html"} //this is for generating extend report
)

public class Runner 
{
	// below code for generating extend report 
	@AfterClass
	public static void setup()
	{
		//location of extend report XML file
	Reporter.loadXMLConfig(new File("E://Nop_CucumberFrmk//ExtendReportConfig.xml")); 
	
	// adding additional info with extent reports 
	Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
	Reporter.setSystemInfo("User Name", "Sachin");
	Reporter.setSystemInfo("Application Name", "Nop commerce App ");
	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	Reporter.setSystemInfo("Environment", "Production");
	Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	}

}
