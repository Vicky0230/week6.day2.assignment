package servicenow_selfdef;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import servicenow_hooks.BaseSteps;


public class LoginPage extends BaseSteps{
	@Given("Load URL {string}")
	public void loadURL(String url) {
		driver.get(url);
	}
	
	@When("Move to frame")
	public void moveToFrame() {
		driver.switchTo().frame("gsft_main");
	}
	
	@And("Type username {string}")
	public void typeUsername(String username) {
		driver.findElement(By.id("user_name")).sendKeys(username);
	}
	
	@And("Type password {string}")
	public void typePassword(String pwd) {
		driver.findElement(By.id("user_password")).sendKeys(pwd);
	}
	
	@And("click on Login button")
	public void clickLoginButton() {
		driver.findElement(By.id("sysverb_login")).click();
	}
}