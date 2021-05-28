Feature: login to the service-now Application

Background:

	Given Load URL 'https://dev103117.service-now.com'
	When Move to frame
	And Type username 'admin'
	And Type password 'India@123'
	And click on Login button

Scenario: create New Incident

	And search the Incident in filter
	And create New Incident
	And Get the Incident Number
	And Give the short_description 'Automation Testing Basics'
	And click Submit Button
	And Incident search in the Field 'INC0011724'
	Then Verify first match
	
	
Scenario: Update Incident

	And search the Incident in filter1
	And Incident search in the Field 'INC0011724'
	And Select the first match1
	And Update the incident urgency1
	And WebElement incident state1
	And click Update Button1
	Then Verify first match1



Scenario: Assign the incident

	And search filter
	And Assign Incident2
	And search in the Field 'INC0011724'
	And Select first match
	And Select Assignment_group
	And Select Assigned_to
	And Update Button
	Then Verify match
	

	
Scenario: Resolve_incident

	And search Incident
	And Resolve Incident
	And Incident search in Field 'INC0011724'
	And first match
	And incident state
	And Update Resolution Information
	And click UpdateButton
	Then Verify matchFirst

	Scenario: Delete_incident

	And Incident filter
	And Delete Incident
	And Incident searchField 'INC0011724'
	And SelectMatch
	And Delete the incident
	Then VerifyMatch