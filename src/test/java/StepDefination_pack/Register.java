package StepDefination_pack;

import java.io.StringBufferInputStream;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Utility_pack.PropertyUtile;
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
		driver.findElement(By.id("input-firstname")).sendKeys(PropertyUtile.getProperty("FirstName"));
	}

	@And("User Enter Valid LastName")
	public void user_enter_valid_last_name() {
		driver.findElement(By.id("input-lastname")).sendKeys(PropertyUtile.getProperty("LastName"));
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
		driver.findElement(By.id("input-password")).sendKeys(PropertyUtile.getProperty("ValidPassword"));
	}

	@And("User Enter valid confirm password")
	public void user_enter_valid_confirm_password() {
		driver.findElement(By.id("input-confirm")).sendKeys(PropertyUtile.getProperty("ValidCnfPass"));
	}

	@And("User cliked on disclimer")
	public void user_cliked_on_disclimer() {
		driver.findElement(By.xpath("//input[@name='agree']")).click();
	}

	@And("User Clicked on Continue")
	public void User_Clicked_on_Continue() {
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}

	@Then("User should register successfully and Navigate to Account success page")
	public void user_should_register_successfully_and_Navigate_to_Account_success_page() {
		driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).isDisplayed();
	}

	@And("User Selected YES for Subscribe Radio button")
	public void user_selected_yes_for_subscribe_radio_button() {
		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
	}

	@And("User Selected NO for Subscribe Radio button")
	public void user_selected_no_for_subscribe_radio_button() {
		driver.findElement(By.xpath("//input[@value='0']")).click();
	}

	@When("User Did not fill any data")
	public void User_Did_not_fill_any_data() {

	}

	@Then("User should get proper validation error on each mandetory field")
	public void User_should_get_proper_validation_error_on_each_mandetory_field() {

		SoftAssert softAssert = new SoftAssert();

		String mainErrorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"))
				.getText();
		softAssert.assertEquals(mainErrorMessage, "Warning: You must agree to the Privacy Policy!");
		String errorForFirstName = driver
				.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]"))
				.getText();
		softAssert.assertEquals(errorForFirstName, "First Name must be between 1 and 32 characters!");

		String errorForlastName = driver
				.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]"))
				.getText();
		softAssert.assertEquals(errorForlastName, "Last Name must be between 1 and 32 characters!");

		String errorForEmail = driver
				.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]"))
				.getText();
		softAssert.assertEquals(errorForEmail, "E-Mail Address does not appear to be valid!");
		String errorForMobile = driver
				.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]"))
				.getText();
		softAssert.assertEquals(errorForMobile, "Telephone must be between 3 and 32 characters!");
		String errorForPasswordString = driver
				.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]"))
				.getText();
		softAssert.assertEquals(errorForPasswordString, "Password must be between 4 and 20 characters!");
		softAssert.assertAll();
	}

	@And("YES is saved on Subscribe or unsubscribe to newsletter page")
	public void YES_is_saved_on_Subscribe_unsubscribe_to_newsletter_page() {
		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Subscribe / unsubscribe to newsletter']")).click();
		boolean isSelected_YESRadio = driver.findElement(By.xpath("//input[@value='1']")).isSelected();

		Assert.assertEquals(isSelected_YESRadio, true);

	}

	@And("NO is saved on Subscribe or unsubscribe to newsletter page")
	public void no_is_saved_on_subscribe_or_unsubscribe_to_newsletter_page() {
		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Subscribe / unsubscribe to newsletter']")).click();
		boolean isSelected_YESRadio = driver.findElement(By.xpath("//input[@value='0']")).isSelected();
		Assert.assertEquals(isSelected_YESRadio, true);
	}

	@And("User Enter Invalid Password")
	public void user_enter_invalid_password() {
		driver.findElement(By.id("input-password")).sendKeys(PropertyUtile.getProperty("InvalidPassword"));
	}

	@And("User Enter Invalid confirm password")
	public void user_enter_invalid_confirm_password() {

		driver.findElement(By.id("input-confirm")).sendKeys(PropertyUtile.getProperty("InvalidCNFpassword"));
	}

	@Then("Registration should not be done and should show valid error messsage for password mismatch")
	public void registration_should_not_be_done_and_should_show_valid_error_message_for_password_mismatch() {
		String errorForpassMissmatchString = driver.findElement(By.xpath("//div[@class='text-danger']")).getText();

		Assert.assertEquals("Password confirmation does not match password!", errorForpassMissmatchString);
	}

	@When("^User Enter Valid details in FirstName (.*)$")
	public void user_enter_valid_details_in_first_name(String firstName) {
		driver.findElement(By.id("input-firstname")).sendKeys(firstName);

	}

	@And("^User Enter Valid LastName(.*)$")
	public void user_enter_valid_last_name(String lastName) {
		driver.findElement(By.id("input-lastname")).sendKeys(lastName);
	}

	@And("^User Enter Valid Email(.*)$")
	public void user_enter_valid_email(String email) {
		driver.findElement(By.id("input-email")).sendKeys(email);
	}

	@And("^User Enter Valid telephone(.*)$")
	public void user_enter_valid_telephone(String telephone) {
		driver.findElement(By.id("input-telephone")).sendKeys(telephone);
	}

	@And("^User Enter Valid Password(.*)$")
	public void user_enter_valid_password(String password) {
		driver.findElement(By.id("input-password")).sendKeys(password);
	}

	@And("^User Enter valid confirm password(.*)$")
	public void user_enter_valid_confirm_password(String confPass) {
		driver.findElement(By.id("input-confirm")).sendKeys(confPass);
	}

	@Then("Registration should not be done and should show error messagae indication Email already exists")
	public void registration_should_not_be_done_and_should_show_error_message_indication_email_already_exists() {
		String Error_EmailExists = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"))
				.getText();
		Assert.assertEquals(Error_EmailExists, "Warning: E-Mail Address is already registered!");
	}
	
	@And("User Enter Valid Invalid Email(.*)")
	public void user_enter_valid_invalid_email(String InvalidEmail) {
	driver.findElement(By.id("input-email")).sendKeys(InvalidEmail);
	}

	@Then("^Registration should not be done and should show error messagae indication Invalid Email(.*)$")
	public void registration_should_not_be_done_and_should_show_error_message_indication_Invalid_Email(String Error_message) {
		SoftAssert softAssert = new SoftAssert();
		String invalidEmailString = driver.findElement(By.id("input-email")).getDomProperty("validationMessage");		
		softAssert.assertEquals(invalidEmailString, Error_message);
		
	}
}
