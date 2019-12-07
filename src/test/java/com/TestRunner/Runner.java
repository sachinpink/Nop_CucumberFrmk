package com.TestRunner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
( features=".//Features/NopCommerce.feature",
 glue="com.StepDefinations",
 dryRun=false,
 tags={"@searchCust"},
 monochrome=true
)

public class Runner 
{

}
