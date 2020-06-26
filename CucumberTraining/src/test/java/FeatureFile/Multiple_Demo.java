package FeatureFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Multiple_Demo {
	
    WebDriver d ;	
    //System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver_win32\\chromedriver.exe");
    //d.get("http://demowebshop.tricentis.com/");
	String msg1;
	String msg2;
	
	@Given("^Adithya is in demo webshop$")
	public void adithya_is_in_demo_webshop() throws Throwable {
		
		System.out.println("This is from given");
	    System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
	    d = new ChromeDriver(); 
	   d.get("http://demowebshop.tricentis.com/");
	    d.findElement(By.linkText("Log in")).click();
	    Thread.sleep(2000);

	}

	@When("^Adithya gives valid \"(.*?)\" \"(.*?)\"$")
	public void adithya_gives_valid(String un, String pwd) throws Throwable {
		
		msg1 = un;
		
		d.findElement(By.id("Email")).sendKeys(un);
		d.findElement(By.id("Password")).sendKeys(pwd);
		d.findElement(By.cssSelector("input[value='Log in']")).click();
		Thread.sleep(2000);

	}

	@Then("^Adithya is able to see homepage$")
	public void adithya_is_able_to_see_homepage() throws Throwable {
		
	msg2 = d.findElement(By.cssSelector("a.account")).getText();
	Assert.assertEquals(msg1, msg2);
	System.out.println("test is passed");
	d.findElement(By.linkText("Log out")).click();
	Thread.sleep(2000);
	}


}
