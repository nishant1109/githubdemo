package FeatureFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MultiScenario2 {
	
	WebDriver d;
	String msg;
	
	@Given("^Adithya is on Demowebshop app$")
	public void adithya_is_on_Demowebshop_app() throws Throwable {
	    System.out.println("This is from given");
	    System.setProperty("webdriver.chrome.driver", "C:\\\\automation\\\\drivers\\\\chromedriver.exe");
	    d = new ChromeDriver(); 
	    d.get("http://demowebshop.tricentis.com/");
	    
	    d.findElement(By.cssSelector("a[class = 'ico-login']")).click();
	    Thread.sleep(2000);

	}

	@When("^Adithya gives valid credentials to Demowebshop$")
	public void adithya_gives_valid_credentials_to_Demowebshop() throws Throwable {
		
		System.out.println("This is from when");
		d.findElement(By.id("Email")).sendKeys("var123@abc.com");
		d.findElement(By.id("Password")).sendKeys("adithya1");
		d.findElement(By.cssSelector("input[value = 'Log in']")).click();
		Thread.sleep(2000);

	}

	@Then("^Adithya can view the next page of Demowebshop$")
	public void adithya_can_view_the_next_page_of_Demowebshop() throws Throwable {
		System.out.println("This is from Then");
		//d.findElement(By.cssSelector("ul[class='nav']"));
		msg = d.findElement(By.cssSelector("a[class='account']")).getText();
		Assert.assertTrue(msg.contains("var123@abc.com"));
		System.out.println("Test is passed");
		d.close();

	}

	@When("^Adithya gives invalid credentials to Demowebshop$")
	public void adithya_gives_invalid_credentials_to_Demowebshop() throws Throwable {
		
		System.out.println("This is from when");
		d.findElement(By.id("Email")).sendKeys("123@xdcs.com");
		d.findElement(By.id("Password")).sendKeys("123456");
		d.findElement(By.cssSelector("input[value = 'Log in']")).click();
		Thread.sleep(2000);

	}

	@Then("^Adithya can get a error message from Demowebshop$")
	public void adithya_can_get_a_error_message_from_Demowebshop() throws Throwable {
		System.out.println("This is from Then");
		msg = d.findElement(By.cssSelector("div[class='validation-summary-errors']")).getText();
		Assert.assertTrue(msg.contains("unsuccessful"));
		System.out.println("Test is passed");
		d.close();
	}



}
