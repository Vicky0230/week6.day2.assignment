package servicenow_selfdef;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import servicenow_hooks.BaseSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class TC005_Delete_Incident extends BaseSteps{


		String getIncident;
		WebElement searchField;
		WebElement searchIncident;
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
		String state2;
		String noRecordsTo ;


		@And("Incident filter")
		public void searchIncident() throws InterruptedException{

			Thread.sleep(5000);
			searchIncident=driver.findElement(By.id("filter"));
			searchIncident.sendKeys("Incident");

		}

		@Then("Delete Incident")
		public void delete_Incident() throws InterruptedException{

			driver.findElement(By.xpath("//div[text()='Create New']")).click();
			
			driver.switchTo().frame("gsft_main");
			Thread.sleep(2000);

			driver.findElement(By.xpath("//button[contains(@class,'btn btn-default')]")).click();

			Thread.sleep(2000);

		}


		@And("Incident searchField {string}")
		public void searchField(String incident) throws InterruptedException{


			forTextNum = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
			new Select(forTextNum).selectByIndex(1);

			searchField=driver.findElement(By.xpath("//input[@placeholder='Search']"));
			searchField.sendKeys(incident); 
			//INC0010928
			searchField.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
		}


		@And("SelectMatch")
		public void Verify_First_match() throws InterruptedException{

			driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
			Thread.sleep(2000);
		}	
		
		
		
		
		@And("Delete the incident")
		public void Delete_Incident() throws InterruptedException{
			driver.findElement(By.id("sysverb_delete")).click();
			
			driver.findElement(By.id("ok_button")).click();
			
			Thread.sleep(2000);
		}	
		


		@And("VerifyMatch")
		public void VerifyFirst_match1() throws InterruptedException{

			
			noRecordsTo = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();
			
			if(noRecordsTo.equals("No records to display"))
			{
				System.out.println("Deleted Successfully");
			}
			

	}

}
