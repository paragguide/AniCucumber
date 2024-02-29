package testcases;

import java.util.Iterator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonProduct //extends Hook
{   
	public boolean x = false;
	   /*
	@Given("I browse to {string} and get url {string}")
	public void i_browse_to_and_get_url(String browser, String url) 
	{
	   openBrowser(browser,url);
	}*/
	
	@Given("you are logged in")
	public void you_are_logged_in()
	{
		if(AmazonPwd.login == true)
		{
			x = true;
		}
	}
	
	@When("^i search product (.*) with price (.*)")
	public void i_search_product_with_price(String product,int price) 
	{
		Hook.test.log(LogStatus.INFO, product+" - "+price);
		if(x == true)
		{
			Hook.searchbox.clear();
	   Hook.searchbox.sendKeys(product+" in range "+price);
	   Actions a = new Actions(Hook.driver);
	   a.sendKeys(Keys.ENTER).perform();
		}
	}
	@Then("result comes")
	public void result_comes() 
	{
	  Iterator <WebElement> it =  Hook.searchresult.iterator();
	    while(it.hasNext())
	    {
	    	WebElement e = it.next();
	    	String productlink = e.getText();
	    	System.out.println(productlink);
	    }
	    
	   Hook.closeBrowser();
	}

}
