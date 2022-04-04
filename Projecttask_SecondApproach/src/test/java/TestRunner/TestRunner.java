package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.*;



@RunWith(Cucumber.class)
	@CucumberOptions( 
	  features= "/Users/nitin/eclipse workspace/Java/Projecttask_SecondApproach/src/test/resources/Feature",
			   glue = {"StepDef"},
	  plugin = {"pretty","html:target/HtmlReports/report.html",
			  "html:target/cucumber-reports",
			  "junit:target/JUnitReports/report.xml",
			  "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
			  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target"},
	  monochrome = true)
	 

	public class TestRunner {
}
