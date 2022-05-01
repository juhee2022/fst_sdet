package stepdefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hooks.hooksclass;
import junit.framework.Assert;

public class stepdefinitionclass {
	
	WebDriver driver = hooksclass.driver;
	boolean element;

	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		
		driver.get("http://retailm1.upskills.in/admin");
		driver.manage().window().maximize();		
		System.out.println("User navigated to login page");
	}

	@Given("Enter Username {string} and Password {string}")
	public void enter_Username_and_Password(String string, String string2) {
	    
		driver.findElement(By.id("input-username")).sendKeys(string);
		driver.findElement(By.id("input-password")).sendKeys(string2);
		driver.findElement(By.xpath("//button[text()=' Login']")).click();	
		
	}

	@Then("Admin dashboard is displayed")
	public void admin_dashboard_is_displayed() {

		System.out.println("Admin dashboard is displayed");
	}

	
	@When("Click on Coupons in Marketing menu")
	public void click_on_Coupons_in_Marketing_menu() throws InterruptedException {
	    
	    driver.findElement(By.cssSelector("i.fa.fa-share-alt.fw")).click();
	    driver.findElement(By.linkText("Coupons")).click();
	    Thread.sleep(5000);	        
	    	    
	}

	@Then("Coupon list is displayed")
	public void coupon_list_is_displayed() {
	    
		WebElement AddNewIcon = driver.findElement(By.cssSelector("i.fa.fa-plus"));	
		Assert.assertTrue(AddNewIcon.isDisplayed());
		System.out.println(AddNewIcon);
		
	}

	@Given("User clicks on Add New icon in Coupon list")
	public void user_clicks_on_Add_New_icon_in_Coupon_list() throws InterruptedException {
	    
		driver.findElement(By.cssSelector("i.fa.fa-plus")).click();
		Thread.sleep(5000);		
	}

	@Given("Enter Coupon details and click on Save icon")
	public void enter_Coupon_details_and_click_on_Save_icon() throws InterruptedException {
	    
		driver.findElement(By.id("input-name")).sendKeys("TESTCOUPON2");
		driver.findElement(By.id("input-code")).sendKeys("TCP02");
		driver.findElement(By.id("input-discount")).sendKeys("20");
		driver.findElement(By.id("input-total")).sendKeys("10000");
		driver.findElement(By.xpath("//input[@name='logged' and @value='1']")).click();
		driver.findElement(By.xpath("//input[@name='shipping' and @value='1']")).click();
		driver.findElement(By.cssSelector("i.fa.fa-save")).click();
		Thread.sleep(5000);		
	}

	@Then("Verify newly created Coupon in Coupon list")
	public void verify_newly_created_Coupon_in_Coupon_list() {
		List <WebElement> CouponsList = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
		int i=0;
		while(i<CouponsList.size())
		{
			String CouponName = CouponsList.get(i).getText();
			if(CouponName.equals("TESTCOUPON2"))
			System.out.println("Coupon "+CouponName+" is added successfully");
			i++;			
		}	    
	}
}
