package FeatureFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MultiScenario {
	
	WebDriver d;
	String msg;
	
	@Given("^Adithya is on TestMe app$")
	public void adithya_is_on_TestMe_app() throws Throwable {
	    System.out.println("This is from given");
	    System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
	    d = new ChromeDriver(); 
	    d.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	    d.findElement(By.linkText("SignIn")).click();
	    Thread.sleep(2000);
	

	}

	@When("^Adithya gives valid login password$")
	public void adithya_gives_valid_login_password() throws Throwable {
		System.out.println("This is from when");
		d.findElement(By.id("userName")).sendKeys("Lalitha");
		d.findElement(By.id("password")).sendKeys("Password123");
		d.findElement(By.name("Login")).click();
		Thread.sleep(2000);

	}

	@Then("^Adithya can see the next page$")
	public void adithya_can_see_the_next_page() throws Throwable {
		System.out.println("This is from Then");
		// d.findElement(By.cssSelector("ul[class='nav']"));
		msg = d.findElement(By.cssSelector("ul.nav")).getText();
		Assert.assertTrue(msg.contains("Lalitha"));
		System.out.println("Test is passed");
		d.close();

	}

	@When("^Adithya gives invalid login password$")
	public void adithya_gives_invalid_login_password() throws Throwable {
		
		System.out.println("This is from when");
		d.findElement(By.id("userName")).sendKeys("Testuser");
		d.findElement(By.id("password")).sendKeys("abcfdjse");
		d.findElement(By.name("Login")).click();
		Thread.sleep(2000);

	}

	@Then("^Adithya can see a error message$")
	public void adithya_can_see_a_error_message() throws Throwable {
		
		System.out.println("This is from Then");
		// d.findElement(By.cssSelector("ul[class='nav']"));
		msg = d.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[6]")).getText();
		Assert.assertTrue(msg.contains("wrong"));
		System.out.println("Please enter valid username and password");
		System.out.println("Test is passed");
		d.close();

	}

	@When("^Adithya clicks on login without any data$")
	public void adithya_clicks_on_login_without_any_data() throws Throwable {
		
		System.out.println("This is from when");
		//d.findElement(By.id("userName")).sendKeys("Lalitha");
		//d.findElement(By.id("password")).sendKeys("Password123");
		d.findElement(By.name("Login")).click();
		Thread.sleep(2000);

	}

	@Then("^Adithya can see another error message$")
	public void adithya_can_see_another_error_message() throws Throwable {
		
		System.out.println("This is from Then");
		// d.findElement(By.cssSelector("ul[class='nav']"));
		msg = d.findElement(By.cssSelector("span[class='help-block form-error']")).getText();
		
		Assert.assertTrue(msg.contains("Please"));
		System.out.println("Please enter username and password");
		System.out.println("Test is passed");
		d.close();

	}


}
