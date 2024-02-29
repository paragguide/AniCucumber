package testcases;

import com.relevantcodes.extentreports.LogStatus;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonPwd 
{
	public static boolean x = false;
	public static boolean login = false;
	
	@Given("uid is valid and pwd displayed")
	public void uid_is_valid_and_pwd_displayed() 
	{
	    if(AmazonUid.uiid == true && AmazonUid.flag == true)
	    {
	    	x = true;
	    }
	}
	@When("i enter password {string}")
	public void i_enter_password(String pw) 
	{
	    if(x == true)
	    {
	    	Hook.pwd.sendKeys(pw);
	    }
	}
	@When("click submit button")
	public void click_submit_button() 
	{
	    Hook.submit.click();
	}
	@Then("i should login")
	public void i_should_login() 
	{
		   try {
	  Hook. test.log(LogStatus.ERROR, Hook.err2.getText());
		   }
		   catch(Exception e)
		   {
			   Hook.test.log(LogStatus.PASS, "Loged in..");
			   login = true;
		   }
		   
		//   Hook.closeBrowser();
	}


}
