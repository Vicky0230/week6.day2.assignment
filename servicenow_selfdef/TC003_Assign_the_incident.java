package servicenow_selfdef;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import servicenow_hooks.BaseSteps;
import io.cucumber.java.en.And;

public class TC003_Assign_the_incident extends BaseSteps{

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


	@And("search filter")
	public void searchIncidentFilter() throws InterruptedException{

		Thread.sleep(5000);
		searchIncident=driver.findElement(By.id("filter"));
		searchIncident.sendKeys("Incident");

	}
	
	@And("Assign Incident2")
	public void resolve_Incident() throws InterruptedException{

		driver.findElement(By.xpath("//div[text()='Create New']")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[contains(@class,'btn btn-default')]")).click();
	}
	
	@And("search in the Field {string}")
	public void searchFieldFilter(String incident) throws InterruptedException{

		forTextNum = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
		new Select(forTextNum).selectByIndex(1);

		searchField=driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchField.sendKeys(incident); 
		//INC0010928
		searchField.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	
	@And("Select first match")
	public void Verify_First_matchFilter() throws InterruptedException{

		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		Thread.sleep(2000);
	}		

	@And("Select Assignment_group")
	public void assignment_groupFilter() throws InterruptedException{

		driver.findElement(By.xpath("//button[@data-for='sys_display.incident.assignment_group']//span[1]")).click();
		Thread.sleep(2000);

		newWindow=driver.getWindowHandles();
		allWindow=new ArrayList<String>(newWindow);

		secondWindow=allWindow.get(1);

		driver.switchTo().window(secondWindow);

		forName = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		forName.sendKeys("software");
		Thread.sleep(2000);
		forName.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//a[@sys_id='8a4dde73c6112278017a6a4baf547aa7']")).click();	

		driver.switchTo().window(allWindow.get(0));	

		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);
	}	

	@And("Select Assigned_to")
	public void assigned_toFilter() throws InterruptedException{


		driver.findElement(By.xpath("//button[@data-for='sys_display.incident.assigned_to']//span[1]")).click();

		Thread.sleep(2000);

		newWindow=driver.getWindowHandles();
		allWindow=new ArrayList<String>(newWindow);

		secondWindow=allWindow.get(1);
		driver.switchTo().window(secondWindow);

		Thread.sleep(2000);

		driver.findElement(By.linkText("ITIL User")).click();
		driver.switchTo().window(allWindow.get(0));	
		Thread.sleep(2000);

		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);
	}	
	
	@And("Update Button")
	public void updateButtonFilter() throws InterruptedException{

		driver.findElement(By.id("sysverb_update")).click();
		Thread.sleep(2000);
	}

	@And("Verify match")
	public void VerifyFirst_matchFilter() throws InterruptedException{

		incidentAssginedgroup = driver.findElement(By.linkText("Software")).getText();
		System.out.println(incidentAssginedgroup);

		incidentAssignedTo = driver.findElement(By.linkText("ITIL User")).getText();
		System.out.println(incidentAssignedTo);

		driver.switchTo().defaultContent();

	}

}
