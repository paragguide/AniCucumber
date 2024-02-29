package testcases;

import org.junit.Assert;

import com.relevantcodes.extentreports.LogStatus;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonUid extends Hook
{
   public static boolean uiid = false;
   public static boolean flag = false;
   
	@Given("I open browser {string} and enter url {string}")
	public void i_open_browser_and_enter_url(String browser, String url) 
	{
	   openBrowser(browser,url);
	}
	@Given("i click on sign in")
	public void i_click_on_sign_in() 
	{
		signin.click();
	}
	@When("I enter userid {string}")
	public void i_enter_userid(String userid) 
	{
		uid.sendKeys(userid);
	}
	@When("click continue button")
	public void click_continue_button() 
	{
		ctnbtn.click();
	}
	@Then("I validate userid")
	public void i_validate_userid() 
	{
		   try {
		test.log(LogStatus.ERROR, err1.getText());
		   }
		   catch(Exception e)
		   {
			   test.log(LogStatus.INFO, "uid is valid");
			   uiid = true;
		   }
	}
	@Then("check password textbox comes")
	public void check_password_textbox_comes() 
	{
		
	   if( uiid == true && pwd.isDisplayed())
	   {
		   flag = true;
		   test.log(LogStatus.PASS, "Pwd txt box displayed");
	   }
	   else
	   {
		   test.log(LogStatus.FAIL, "Pwd txt box not displayed");
		   flag = false;
		   Assert.fail();
	   }
	}


}
