package StepDefination_pack;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Utility_pack.Reusabledata;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register {
	WebDriver driver;

	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/index.php");

	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Given("User is navigated to Registration page")
	public void user_is_navigated_to_registration_page() {

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
	}

	@When("User Enter Valid details in FirstName")
	public void user_enter_valid_details_in_first_name() {
		driver.findElement(By.id("input-firstname")).sendKeys("Somesh");
	}

	@And("User Enter Valid LastName")
	public void user_enter_valid_last_name() {
		driver.findElement(By.id("input-lastname")).sendKeys("Landge");
	}

	@And("User Enter Valid Email")
	public void user_enter_valid_email() {
		driver.findElement(By.id("input-email")).sendKeys(Reusabledata.Email());
	}

	@When("User Enter Valid telephone")
	public void user_enter_valid_telephone() {
		driver.findElement(By.id("input-telephone")).sendKeys(Reusabledata.Mobile());
	}

	@And("User Enter Valid Password")
	public void user_enter_valid_password() {
		driver.findElement(By.id("input-password")).sendKeys("Test@123");
	}

	@And("User Enter valid confirm password")
	public void user_enter_valid_confirm_password() {
		driver.findElement(By.id("input-confirm")).sendKeys("Test@123");
	}

	@And("User cliked on disclimer")
	public void user_cliked_on_disclimer() {
		driver.findElement(By.xpath("//input[@name='agree']")).click();
	}

	@And("User Clicked on Continue")
	public void User_Clicked_on_Continue()
	{
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}
	
	@Then("User should register successfully and Navigate to Account success page")
	public void user_should_register_successfully_and_Navigate_to_Account_success_page() {
		driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).isDisplayed();
	}

}
