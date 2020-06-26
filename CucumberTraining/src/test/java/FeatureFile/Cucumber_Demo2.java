package FeatureFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Cucumber_Demo2 {
	
	WebDriver d;
	String msg;
	
	@Given("^The login is open$")
	public void the_login_is_open() throws Throwable {
		
	    System.out.println("This is from given");
	    System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver_win32\\chromedriver.exe");
	    d = new ChromeDriver(); 
	    d.get("http://demowebshop.tricentis.com/");
	    
	    d.findElement(By.cssSelector("a[class = 'ico-login']")).click();
	    Thread.sleep(2000);
	    

	}

	@When("^The client provides correct credentials$")
	public void the_client_provides_correct_credentials() throws Throwable {
		
		System.out.println("This is from when");
		d.findElement(By.id("Email")).sendKeys("var123@abc.com");
		d.findElement(By.id("Password")).sendKeys("adithya1");
		d.findElement(By.cssSelector("input[value = 'Log in']")).click();
		Thread.sleep(2000);

	}

	@Then("^The client is logged in$")
	public void the_client_is_logged_in() throws Throwable {
		System.out.println("This is from Then");
		//d.findElement(By.cssSelector("ul[class='nav']"));
		//msg = d.findElement(By.cssSelector("ul.nav")).getText();
		//Assert.assertTrue(msg.contains("Lalitha"));
		//System.out.println("Test is passed");
		d.close();
		
		
	}


}
