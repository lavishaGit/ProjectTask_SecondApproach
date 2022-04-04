package pageObjects;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.reactivex.rxjava3.functions.Action;

public class Logout {
	
	WebDriver ldriver;
	

	public Logout(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath ="//div[contains(@role,'button')and contains(@aria-label,'Account')]")
	//@FindBy(xpath ="//div[normalize-space(@class)='j83agx80 l9j0dhe7']")
//@FindBy(xpath ="//div[contains(@class='j83agx80) and contains(@class='l9j0dhe7')]")
//@FindBy(xpath ="//div[contains(@class,'j83agx80') and contains(@role,'button')and contains(@aria-label,'Account')]")
	WebElement dropdown;
	//@FindBy(xpath="//*[@id='mount_0_0_Oq']/div/div[1]/div/div[2]/div[4]/div[2]/div/div[3]/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div/div[4]/div/div[1]/div[2]/div/div/div/div/span")
	@FindBy(xpath="//span[contains(text(),'Log Out')]")
	WebElement logout;
	
	@SuppressWarnings("deprecation")
	public void dropDownClick() throws InterruptedException
	{
		//ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions act=new Actions(ldriver);
	act.moveToElement(dropdown);
	WebDriverWait wait = new WebDriverWait(ldriver,5);
	wait.until(ExpectedConditions.elementToBeClickable(dropdown));
	act.click().build().perform();

	//	dropdown.click();
		//logoutClick();
		
		//act.moveToElement(logout);
		//act.click().perform();
	}
	@SuppressWarnings("deprecation")

	public void logoutClick() throws InterruptedException
	{
		//String ddString=logout.getText();
//System.out.println("this is logout      "+ddString);
Actions act=new Actions(ldriver);
act.moveToElement(logout);
WebDriverWait wait = new WebDriverWait(ldriver,20);
wait.until(ExpectedConditions.elementToBeClickable(logout));
act.click().perform();

//logout.click();
	}

}
