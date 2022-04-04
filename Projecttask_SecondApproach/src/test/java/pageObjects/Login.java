package pageObjects;
import org.apache.commons.codec.binary.Base64;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static Utilities.propertyReader.*;

public class Login {
	

		WebDriver ldriver;
		String password=decodePassword(getPassword());

		public static String decodePassword(String passWord)  {
			byte[]decodePass= Base64.decodeBase64(passWord);
			return new String(decodePass);

		}

		public Login (WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}

		@FindBy(id="email")
		WebElement txtUserName;

		@FindBy(id="pass")
		WebElement txtPassword;

		@FindBy(name="login")
		WebElement btnlogin;
		
	
		
		public void setUsername()
		{
			
		    txtUserName.sendKeys(getUsername());

		}


		public void setPassword()
		{
			
			txtPassword.sendKeys(password);
		}
		
		public void clickSubmit()
		{
			btnlogin.click();	
		}

		
	

}
