package servicenow_selfdef;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import servicenow_hooks.BaseSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class TC004_Resolve_Incident extends BaseSteps{

	WebElement searchField;
	WebElement searchIncident;
	Set<String> newWindow;
	List<String> allWindow;
	String secondWindow;
	String text;
	WebElement forTextNum;
	WebElement incidenturgency ;
	WebElement urgencyText ;
	String urgency;
	WebElement incidentstate;
	String state;
	String Priority;
	String state1;
	String Priority1;
	String incidentAssginedgroup ;
	WebElement forName ;
	String incidentAssignedTo;
	String getIncident;
	String state2;


	@And("search Incident")
	public void searchIncident() throws InterruptedException{

		Thread.sleep(5000);
		searchIncident=driver.findElement(By.id("filter"));
		searchIncident.sendKeys("Incident");

	}

	@Then("Resolve Incident")
	public void resolve_Incident() throws InterruptedException{
		driver.findElement(By.xpath("//div[text()='Create New']")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[contains(@class,'btn btn-default')]")).click();
	}


	@And("Incident search in Field {string}")
	public void searchField(String incident) throws InterruptedException{


		forTextNum = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
		new Select(forTextNum).selectByIndex(1);

		searchField=driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchField.sendKeys(incident); 
		//INC0010928
		searchField.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}


	@And("first match")
	public void Verify_First_match() throws InterruptedException{

		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		Thread.sleep(2000);
	}		



	@And("incident state")
	public void incidentstate() throws InterruptedException{


		incidentstate = driver.findElement(By.id("incident.state")); 
		Select state2=new Select(incidentstate);
		state2.selectByIndex(3);
		Thread.sleep(2000);
		WebElement stateText = state2.getFirstSelectedOption();
		state=stateText.getText();
		System.out.println(state);


	}

	@And("Update Resolution Information")
	public void resolution_Information() throws InterruptedException{

		driver.findElement(By.xpath("//span[text()='Resolution Information']")).click();

		WebElement incidentclosecode = driver.findElement(By.id("incident.close_code")); 
		new Select(incidentclosecode).selectByIndex(7);

		driver.findElement(By.id("incident.close_notes")).sendKeys("Updating the resolution state and it's information");


	}



	@And("click UpdateButton")
	public void updateButton() throws InterruptedException{

		driver.findElement(By.id("sysverb_update")).click();

		Thread.sleep(2000);

	}

	

	@Then ("Verify matchFirst")
	public void VerifyFirst_match1() throws InterruptedException{

		state2=driver.findElement(By.xpath("//td[text()='Resolved']")).getText();

		if(state.equals(state2))
		{
			System.out.println("State in Resoved Status");
		}
		else
		{
			System.out.println("State Not Equals");
		}

	}


}

