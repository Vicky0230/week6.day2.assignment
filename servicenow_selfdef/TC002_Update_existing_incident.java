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


public class TC002_Update_existing_incident extends BaseSteps{
	
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


	@And("search the Incident in filter1")
	public void searchIncident() throws InterruptedException{

		Thread.sleep(5000);
		searchIncident=driver.findElement(By.id("filter"));
		searchIncident.sendKeys("Incident");
		Thread.sleep(1000);
		searchIncident.sendKeys(Keys.ENTER);

	}


	@And("Incident search in the Field {string}")
	public void searchField(String incident) throws InterruptedException{

		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);
		forTextNum = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
		new Select(forTextNum).selectByIndex(1);

		searchField=driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchField.sendKeys(incident); 
		//INC0010928
		searchField.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@And("Select the first match1")
	public void Verify_First_match() throws InterruptedException{

		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
	}



	@And("Update the incident urgency1")
	public void incidenturgency() throws InterruptedException{

		incidenturgency = driver.findElement(By.id("incident.urgency")); 
		Select urgency2 =new Select(incidenturgency);
		urgency2.selectByIndex(0);
		Thread.sleep(2000);
		urgencyText = urgency2.getFirstSelectedOption();
		urgency=urgencyText.getText();
		System.out.println(urgency);
	}


	@And("WebElement incident state1")
	public void incidentstate() throws InterruptedException{

		incidentstate = driver.findElement(By.id("incident.state")); 
		Select state2=new Select(incidentstate);
		state2.selectByIndex(1);
		Thread.sleep(2000);
		WebElement stateText = state2.getFirstSelectedOption();
		state=stateText.getText();
		System.out.println(state);

	}

	@And("click Update Button1")
	public void updateButton() throws InterruptedException{

		driver.findElement(By.id("sysverb_update_bottom")).click();
		Thread.sleep(2000);
	}


	@Then("Verify first match1")
	public void VerifyFirst_match1() throws InterruptedException{

		Priority=driver.findElement(By.xpath("//td[text()='3 - Moderate']")).getText();
		System.out.println(Priority);

		Priority1=driver.findElement(By.xpath("//td[text()='3 - Moderate']")).getText();

		state1=driver.findElement(By.xpath("//td[text()='In Progress']")).getText();

		if(state.equals(state1))
		{
			System.out.println("State Equals");
		}
		else
		{
			System.out.println("State Not Equals");
		}


		if(Priority.equals(Priority1))
		{
			System.out.println("Priority Equals");
		}
		else
		{
			System.out.println("Priority Not Equals");
		}

		Thread.sleep(2000);

		driver.switchTo().defaultContent();

	}

}
