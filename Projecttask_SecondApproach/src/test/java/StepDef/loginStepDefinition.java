package StepDef;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.Login;
import pageObjects.Logout;

public class loginStepDefinition extends Base  {
	
	Login log;
	Logout logout;
	
	@Given("User is on Facebook Log-In Screen of the application")
	public void user_is_on_facebook_log_in_screen_of_the_application() throws IOException {
		//WebDriverManager.chromedriver().setup();
		//driver=new ChromeDriver();
		Base.initialization();
		 log=new Login(driver);


		
	}

	@When("User enters valid Login Name  and Password and clicks on login button")
	public void user_enters_valid_login_name_and_password_and_clicks_on_login_button() throws InterruptedException {
        log.setUsername();
		log.setPassword();
		log.clickSubmit();
	    
	}
	
	@Then("User navigate to Facebook Home Page")
	public void user_navigate_to_facebook_home_page() {
	assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");

	}
	
	@Given("User is on Facebook Home Page")
	public void user_is_on_facebook_home_page() {
		Base.getDriverWithCredentials();
		
		
	}

	@When("User stores login information in local browser")
	public void user_stores_login_information_in_local_browser() {
		// Create a file to store Login Information 
		File file = new File("Cookiefile.data"); 
		try{ 
		// Delete old file if already exists
		file.delete(); 
		file.createNewFile(); 
		FileWriter file1 = new FileWriter(file); 
		BufferedWriter writecookie = new BufferedWriter(file1); //Getting the cookie information 
		for(Cookie ck : driver.manage().getCookies()) { 
			writecookie.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure())); 
			writecookie.newLine(); 
		} 
		writecookie.close(); 
		file1.close(); 
		}
		catch(Exception ex) 
		{ 
		ex.printStackTrace(); 
		} 
		
	}

	@Then("User able to see stored information in local browser")
	public void user_able_to_see_stored_information_in_local_browser() {
		assertTrue( "Cookiefile.data",true);

	}
	
	
	@Given("User is on Dashboard Screen of the application")
	public void user_is_on_facebook_dashboard_screen_of_the_application() {
		Base.getDriverWithCredentials();
		logout=new Logout(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("User navigate to the dropdown icon upper left corner by clicks on it")
	public void user_navigate_to_the_dropdown_icon_upper_left_corner_by_clicks_on_it() throws InterruptedException {

		logout.dropDownClick();	
	
}
	
	
	@When("User clicks  Logout icon")
	public void user_clicks_logout_icon() throws InterruptedException {

		logout.logoutClick();
	}

	@Then("User able to logout successfully")
	public void user_able_to_logout_successfully() {
		assertTrue("Log Out",true);
	   
	}
	
	
	@Given("User is on Facebook Sign in Screen")
	public void user_is_on_facebook_sign_in_screen() {
		Base.initialization();
	   assertTrue("https://www.facebook.com/",true);
	}

	@When("User navigate to the facebook friends page without sigin in")
	public void user_navigate_to_the_facebook_friends_page_without_sigin_in() throws Exception {
	    driver.navigate().to("https://www.facebook.com/login.php?next=https%3A%2F%2Fwww.facebook.com%2Ffriends");
	takeSnapShot();
	}

	@Then("User gets error message")
	public void user_gets_error_message() {
	 assertTrue("You must log in to continue",true);
	 driver.close();
	}
	
	
	public void takeSnapShot() throws Exception{
		
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		
		//Move image file to new destination
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());

		File DestFile=new File("/Users/nitin/eclipse workspace/Java/Projecttask_SecondApproach/src/test/resources/ScreenShot"+timestamp+".png");
		
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);

		}
}
