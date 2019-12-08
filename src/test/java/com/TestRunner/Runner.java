package com.TestRunner;
import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
( features=".//Features/NopCommerce.feature",
 glue="com.StepDefinations",
 dryRun=false,
 tags={"@LoginApp"},
 monochrome=true,
 plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"}
)

public class Runner 
{
	@AfterClass
	public static void setup()
	{
	Reporter.loadXMLConfig(new File("E://Nop_CucumberFrmk//ExtendReportConfig.xml"));
	Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
	Reporter.setSystemInfo("User Name", "Sachin");
	Reporter.setSystemInfo("Application Name", "Nop commerce App ");
	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	Reporter.setSystemInfo("Environment", "Production");
	Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	}

}
