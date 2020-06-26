package FeatureFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Cucumber_Demo {
	

	WebDriver d;
	String msg;
	@Given("^User has opened the application$")
	public void user_has_opened_the_application() throws Throwable {
	    System.out.println("This is from given");
	    System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver_win32\\chromedriver.exe");
	    d = new ChromeDriver(); 
	    d.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	    
	    d.findElement(By.linkText("SignIn")).click();
	    Thread.sleep(2000);
	    
	  
	
	}

	@When("^User provides valid username password$")
	public void user_provides_valid_username_password() throws Throwable {
		System.out.println("This is from when");
		d.findElement(By.id("userName")).sendKeys("Lalitha");
		d.findElement(By.id("password")).sendKeys("Password123");
		d.findElement(By.name("Login")).click();
		Thread.sleep(2000);
		
	}

	@Then("^User can see homepage$")
	public void user_can_see_homepage() throws Throwable {
		System.out.println("This is from Then");
		// d.findElement(By.cssSelector("ul[class='nav']"));
		msg = d.findElement(By.cssSelector("ul.nav")).getText();
		Assert.assertTrue(msg.contains("Lalitha"));
		System.out.println("Test is passed");
		d.close();
	}


}
