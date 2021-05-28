package servicenow_selfdef;


import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import servicenow_hooks.BaseSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class TC001_Create_new_incident extends BaseSteps
{
	String getIncident;
	WebElement searchField;
	WebElement searchIncident;
	Set<String> newWindow;
	List<String> allWindow;
	String secondWindow;
	String text;


	@And("search the Incident in filter")
	public void searchIncident() throws InterruptedException{

		Thread.sleep(5000);
		searchIncident=driver.findElement(By.id("filter"));
		searchIncident.sendKeys("Incident");
		Thread.sleep(1000);
		searchIncident.sendKeys(Keys.ENTER);

	}

	@And("create New Incident")
	public void create_New_Incident() throws InterruptedException{
		
		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);

		driver.findElement(By.id("sysverb_new")).click();

	}

	@And("Get the Incident Number")
	public void getIncident() throws InterruptedException{

		
		
		getIncident=driver.findElement(By.id("incident.number")).getAttribute("attribute_value");
		System.out.println("GetIncident Number :"+getIncident);

	}


	@And("Give the short_description {string}")
	public void shortDescription(String description) throws InterruptedException{

	

		
		driver.findElement(By.id("incident.short_description")).sendKeys(description);

	}

	@And("click Submit Button")
	public void submitButton() throws InterruptedException{

		driver.findElement(By.id("sysverb_insert_bottom")).click();

		Thread.sleep(2000);

	}

	@And("Incident search in the Field {string}")
	public void searchField(String incident) throws InterruptedException{

		searchField=driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchField.sendKeys(incident);
		searchField.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

	}



	@Then("Verify first match")
	public void VerifyFirstMatch() throws InterruptedException{

		searchField=driver.findElement(By.xpath("//input[@placeholder='Search']"));

		text=driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();

		if(text.equals(getIncident))
		{
			System.out.println("Incident Number is Equal");
		}

		Thread.sleep(2000);

		driver.switchTo().defaultContent();

	}





}
